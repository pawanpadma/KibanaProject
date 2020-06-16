package com.selenium.kibana.kibanaproject;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
@Listeners({ TestListner.class })
public class AppTest {
	@Test(description = "test 1")
	public void test1() {
		Assert.assertTrue(false);
	}

	@Test(description = "test 2")
	public void test2() {
		Assert.assertTrue(false);
	}

	@Test(description = "test 3")
	public void test3() {
		Assert.assertTrue(false);
	}

	@Test(description = "test 4",dependsOnMethods= {"test3"})
	public void test4() {

	}

	@Test(description = "test 5")
	public void test5() {

	}
}
