package com.vtiger.stepdefinitions;

import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.vtiger.pages.HeaderPage;
import com.vtiger.pages.HomePage;
import com.vtiger.pages.LeadPage;
import com.vtiger.pages.LoginPage;

public class pageobjectmanager  {
	
	public static WebDriver driver;
	public static Properties prop;
	public static Map<String,Map<String,String>> td;
	public static Map<String,Map<String,String>> apitd;
	
	public  static ExtentHtmlReporter htmlReporter;
	public  static ExtentReports extent;
	public  static ExtentTest logger;
	public static String TCName = "";
	
	public  LoginPage lp;
	public  LeadPage ldp;
	public  HeaderPage hdp;
	public  HomePage hp;
	
	
	public void getPageObject()
	{
		if(lp==null)
			lp = new LoginPage(driver,logger);
		if(ldp==null)
			ldp = new LeadPage(driver,logger);
		if(hdp==null)
			hdp = new HeaderPage(driver,logger);
		if(hp==null)
			hp = new HomePage(driver,logger);
		
	}
	
	

}
