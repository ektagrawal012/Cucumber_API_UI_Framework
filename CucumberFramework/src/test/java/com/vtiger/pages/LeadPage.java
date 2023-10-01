package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.common.CommonActions;

public class LeadPage extends HeaderPage {
	

	
	public LeadPage(WebDriver driver,ExtentTest logger)
	{
		super(driver,logger);		
		PageFactory.initElements(driver, this);
				
	}
	

	
	@FindBy(name="lastname")
	WebElement tb_lastname;
	
	@FindBy(name="company")
	WebElement tb_company;
	
	@FindBy(name="button")
	WebElement btn_button;
	
	@FindBy(xpath="//*[text()='Last Name:']/following::td[1]")
	WebElement lbl_LastName;
	
	@FindBy(xpath="//*[text()='Company:']/following::td[1]")
	WebElement lbl_Company;
	
	public void createLeadwithMandatoryFields(String lname, String comp)
	{
	     entervalue(tb_lastname, lname, lname+" has been entered into lastname field");
	     entervalue(tb_company, comp, comp+" has been entered into company field");
	     clickelement(btn_button, "Save button clicked");
	}
	
	public void verifyLeadCreation(String lname, String comp)
	{
		GetTextValidate(lbl_LastName, lname, "Text "+lname+" validated against label lastname");
		GetTextValidate(lbl_Company, comp, "Text "+comp+" validated against label company");
	}
	
}
