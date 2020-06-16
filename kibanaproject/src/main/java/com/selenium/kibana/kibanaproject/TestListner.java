package com.selenium.kibana.kibanaproject;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

public class TestListner implements ITestListener, IReporter {

	private PojoClass testStatus;
	private int TotalPassed=0;
	private int TotalFailed=0;
	private int TotalSkipped=0;
	private int TotalTestCases=0;

	public void onTestStart(ITestResult iTestResult) {
		this.testStatus = new PojoClass();
	}

	public void onTestSuccess(ITestResult iTestResult) {
		this.sendStatus(iTestResult, "PASS");
	}

	public void onTestFailure(ITestResult iTestResult) {
		this.sendStatus(iTestResult, "FAIL");
	}

	public void onTestSkipped(ITestResult iTestResult) {
		this.sendStatus(iTestResult, "SKIPPED");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		// skip
	}

	public void onStart(ITestContext iTestContext) {
		String suiteName = iTestContext.getCurrentXmlTest().getName();
		System.out.println("suite name is " + suiteName);

	}

	@Override
	public void onFinish(ITestContext context) {
		//sendTestSummary();
		
		
	}

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		// Iterating over each suite included in the test
		for (ISuite suite : suites) {
			// Following code gets the suite name
			String suiteName = suite.getName();
			// Getting the results for the said suite
			Map<String, ISuiteResult> suiteResults = suite.getResults();
			for (ISuiteResult sr : suiteResults.values()) {
				ITestContext tc = sr.getTestContext();
				System.out.println(
						"Passed tests for suite '" + suiteName + "' is:" + tc.getPassedTests().getAllResults().size());
				System.out.println(
						"Failed tests for suite '" + suiteName + "' is:" + tc.getFailedTests().getAllResults().size());
				System.out.println("Skipped tests for suite '" + suiteName + "' is:"
						+ tc.getSkippedTests().getAllResults().size());
				TotalPassed = tc.getPassedTests().getAllResults().size();
				TotalFailed = tc.getFailedTests().getAllResults().size();
				TotalSkipped = tc.getSkippedTests().getAllResults().size();
				TotalTestCases=TotalFailed+TotalPassed+TotalSkipped;
				sendTestSummary(TotalPassed,TotalFailed,TotalSkipped,TotalTestCases);

			}
		}

	}

	private void sendStatus(ITestResult iTestResult, String status) {
		this.testStatus.setTestClass(iTestResult.getTestClass().getName());
		this.testStatus.setDescription(iTestResult.getMethod().getDescription());
		this.testStatus.setStatus(status);
		this.testStatus.setExecutionDate(LocalDateTime.now().toString());
		ResultToElasticSearch.sendTestResultDetailed(this.testStatus);
	}
	
	private void sendTestSummary(int TotalPassed ,int TotalFailed, int TotalSkipped,int TotalTestCases) {
		this.testStatus.setTotalPassed(TotalPassed);
		this.testStatus.setTotalFailed(TotalFailed);
		this.testStatus.setTotalSkipped(TotalSkipped);
		this.testStatus.setTotalTestCases(TotalTestCases);
		System.out.println("total  "+TotalPassed +" "+TotalFailed + "   "+TotalSkipped + "   "+TotalTestCases);
		ResultToElasticSearch.sendTestSummary(this.testStatus);
	}

}
