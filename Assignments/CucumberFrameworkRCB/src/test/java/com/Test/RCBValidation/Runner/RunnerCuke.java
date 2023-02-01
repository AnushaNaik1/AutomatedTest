package com.Test.RCBValidation.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
public class RunnerCuke {

	@CucumberOptions(features = { "src/test/resources/features" },plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, glue = "com.Test.RCBValidation.Steps")
	public class RunCuke extends AbstractTestNGCucumberTests {

	}

}
