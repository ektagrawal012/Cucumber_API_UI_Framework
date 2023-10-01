package com.vtiger.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.vtiger.common.CommonActions;

public class LoginPage extends CommonActions {	
	
	
	public LoginPage(WebDriver driver,ExtentTest logger)
	{
		super(driver,logger);
		PageFactory.initElements(driver, this);
				
	}
	
	//String username = "user_name";
	//By username = By.name("user_name");
	
	@FindBy(name="user_name")
	WebElement tb_username;
	
	@FindBy(name="user_password")
	WebElement tb_userpassword;
	
	@FindBy(name="Login")
	WebElement btn_login;
	
	@FindBy(xpath="//img[@src='include/images/vtiger-crm.gif']")
	WebElement img_logo;
	
	@FindBy(xpath="//*[contains(text(),'You must specify a valid username and password.')]")
	WebElement msg_error;
	
	
	
	
	
	public void login(String userid, String pwd)
	{
		entervalue(tb_username, userid,userid+" has been entered into Username field");
		entervalue(tb_userpassword, pwd,"Password has been entered into password fields");
		clickelement(btn_login,"Login button clicked");
	}
	
	public void verifyLogo()
	{
		elementexist(img_logo,"Logo displayed on login page");
	}
	public void verifyErrorMsg()
	{
		elementexist(msg_error,"error message validated successfully");
	}
	

}
