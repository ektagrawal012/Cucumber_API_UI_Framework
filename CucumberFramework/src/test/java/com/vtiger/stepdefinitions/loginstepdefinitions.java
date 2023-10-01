package com.vtiger.stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vtiger.pages.HomePage;
import com.vtiger.pages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class loginstepdefinitions extends BaseTest {
	
	@Before
	public void getScanerioName(Scenario scenario) throws Exception
	{
		initiation();
		TCName = scenario.getName();
		logger = extent.createTest(TCName);
	}
	
	@After
	public void savereport()
	{
		extent.flush();
		
		
	}
	
	@AfterAll
	public static void tierdown()
	{
		if(driver!=null)
		closeApp();
	}
	
	
	@Given("user should be on login page")
	public void user_should_be_on_login_page() throws Exception {
		if(driver==null)
		{
		launchApp();
		}
		getPageObject();
	}
	@When("user enters valid credentials and click on login button")
	public void user_enters_valid_credentials_and_click_on_login_button() {
	  
	   lp.login(td.get(TCName).get("Userid"), td.get(TCName).get("password"));
	}
	@Then("user should be navigated to home page")
	public void user_should_be_navigated_to_home_page() {
	    
	    hp.verifyLogout();
		
	}
	
	@Then("click on logout")
	public void click_logout() {
	    
	    hp.clickLogout();
		
	}
	
	@When("user enters Invalid credentials and click on login button")
	public void user_enters_Invalid_credentials_and_click_on_login_button() {
		
		lp.login(td.get(TCName).get("Userid"), td.get(TCName).get("password"));
	}
	@Then("user can see error message on login page")
	public void errormsg() {
		
		lp.verifyErrorMsg();	
	}



}
