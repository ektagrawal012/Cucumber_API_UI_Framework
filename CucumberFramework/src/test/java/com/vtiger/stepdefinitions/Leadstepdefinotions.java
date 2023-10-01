package com.vtiger.stepdefinitions;

import com.vtiger.pages.HomePage;
import com.vtiger.pages.LeadPage;
import com.vtiger.pages.LoginPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Leadstepdefinotions extends BaseTest {
	
	@When("user clicks on new lead link")
	public void clicknewlead() {
		getPageObject();
		ldp.clickNewLead();
	  
	}
	@Then("user puts mandatory values within lead form and click on save button")
	public void createlead() {
		
		ldp.createLeadwithMandatoryFields(td.get(TCName).get("Lname"), td.get(TCName).get("Company"));
		
	}
	
	@Then("lead should created successfully")
	public void checkleadcreation() {
		
		ldp.verifyLeadCreation(td.get(TCName).get("Lname"), td.get(TCName).get("Company"));
	}

}
