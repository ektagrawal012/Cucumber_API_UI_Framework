package com.vtiger.runner;

import org.junit.runner.RunWith;

import com.vtiger.stepdefinitions.BaseTest;

import io.cucumber.java.AfterAll;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Features",
		glue="com.vtiger.stepdefinitions",
		plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
				"junit:target/cucumber-reports/Cucumber.xml",
				"html:target/cucumber-reports.html"},
		tags = "@Postccall"
		//,dryRun = true
		
		
		
		
		
		
		)




public class TestRunner {
	
	
	

}
