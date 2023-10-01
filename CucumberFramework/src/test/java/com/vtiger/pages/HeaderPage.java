package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.common.CommonActions;

public class HeaderPage extends CommonActions {
	
	public HeaderPage(WebDriver driver,ExtentTest logger)
	{
		super(driver,logger);
		PageFactory.initElements(driver, this);
		
	}
	

	
	@FindBy(linkText="Logout")
	WebElement lnk_logout;
	
	@FindBy(linkText="New Lead")
	WebElement lnk_NewLead;
	
	@FindBy(linkText="Leads")
	WebElement lnk_Leads;
	
	@FindBy(linkText="New Account")
	WebElement lnk_NewAccount;
	
	public void clickNewAccount()
	{
		clickelement(lnk_NewAccount,"New Account link clicked");
	}
	
	public void clickNewLead()
	{
		clickelement(lnk_NewLead,"New Lead link clicked");
	}
	
	public void clickLeads()
	{
		clickelement(lnk_Leads,"Leads link clicked");
	}
	
	public void verifyLogout()
	{
		elementexist(lnk_logout,"Logout link exist on home page");
	}
	
	public void clickLogout()
	{
		clickelement(lnk_logout,"Logout link clicked");
	}

}
