package com.newsvalidator.testrunner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/newsvalidator/features", glue = { "com/newsvalidator/module/stepdefinitions", "com/newsvalidator/driver" }, plugin = { "pretty",
		"html:target/cucumber-reports.html" })
public class TestRunner {
}

