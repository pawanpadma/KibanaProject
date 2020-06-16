package com.selenium.kibana.kibanaproject;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PojoClass {

	@JsonProperty("testCaseClass")
	private String testCaseClass;

	@JsonProperty("TestCaseDescription")
	private String TestCaseDescription;

	@JsonProperty("TestCaseStatus")
	private String TestCaseStatus;

	@JsonProperty("TestExecutionTime")
	private String TestExecutionTime;
	
	@JsonProperty("TotalPassed")
	private int TotalPassed;
	
	@JsonProperty("TotalFailed")
	private int TotalFailed;
	
	@JsonProperty("TotalSkipped")
	private int TotalSkipped;
	
	@JsonProperty("TotalTestCases")
	private int TotalTestCases;

	public void setDescription(String description) {
		this.TestCaseDescription = description;
	}

	public void setExecutionDate(String executionTime) {
		this.TestExecutionTime = executionTime;
	}

	public void setStatus(String status) {
		this.TestCaseStatus = status;
	}
	
	public void setTestClass(String testClass) {
		this.testCaseClass = testClass;
	}

	public void setTotalPassed(int TotalPassed) {
		this.TotalPassed = TotalPassed;
	}
	
	public void setTotalFailed(int TotalFailed) {
		this.TotalFailed = TotalFailed;
	}
	
	public void setTotalSkipped(int TotalSkipped) {
		this.TotalSkipped = TotalSkipped;
	}
	
	public void setTotalTestCases(int TotalTestCases) {
		this.TotalTestCases = TotalTestCases;
	}
	
	
	
	

}
