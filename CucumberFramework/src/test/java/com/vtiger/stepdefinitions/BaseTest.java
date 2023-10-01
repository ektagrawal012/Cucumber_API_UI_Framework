package com.vtiger.stepdefinitions;

import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest extends pageobjectmanager {
	
	
	
	
	
	public void initiation() throws Exception
	{
		if(prop==null)
		prop = readproperties();
		if(td==null)
		td = getData(System.getProperty("user.dir")+"/src/test/resources/TestData/Data.xlsx","Sheet1");
		apitd = getData(System.getProperty("user.dir")+"/src/test/resources/TestData/Data.xlsx","API_Data");
	
		if(extent==null)
		createExtentReport();
	}
	
	
	
	public void launchApp()
	{
		if(prop.getProperty("Browser").equals("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else if(prop.getProperty("Browser").equals("firefox"))
		{
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		}
		else if(prop.getProperty("Browser").equals("edge"))
		{
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		}
		driver.get("http://localhost:100");
		driver.manage().window().maximize();
		int time = Integer.parseInt(prop.getProperty("GlobalTimeOut"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));		
		
	}
	
	
	public static void closeApp()
	{
		driver.quit();
	}
	
	
	public void createExtentReport()
	{
		Date d = new Date();
		DateFormat ft = new SimpleDateFormat("ddMMyyyyhhmmss");
		String fileName = ft.format(d);
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/src/test/java/com/vtiger/reports/ExtentReport"+fileName+".html");
    	// Create an object of Extent Reports
		extent = new ExtentReports();  
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "Automation Test Hub");
		    	extent.setSystemInfo("Environment", "Test");
		extent.setSystemInfo("User Name", "Rajesh U");
		htmlReporter.config().setDocumentTitle("Title of the Report Comes here "); 
		            // Name of the report
		htmlReporter.config().setReportName("Name of the Report Comes here "); 
		            // Dark Theme
		htmlReporter.config().setTheme(Theme.STANDARD); 		
		
	}
	
	
	
	
	
	public Map<String,Map<String,String>> getData(String file, String sheet) throws Exception
	{
		Fillo fillo=new Fillo();
		Connection connection=fillo.getConnection(file);
		String strQuery="Select * from "+sheet;
		Recordset recordset=connection.executeQuery(strQuery);
		List<String> collist = recordset.getFieldNames();
		Map<String,Map<String,String>> data = new  LinkedHashMap<String,Map<String,String>>();
		while(recordset.next()){
			Map<String,String> rowdata = new LinkedHashMap<String,String>();
			for(int i=0;i<collist.size();i++)
			{
				String fieldsName = collist.get(i);
				String colValue = recordset.getField(fieldsName);
				rowdata.put(fieldsName, colValue);
			}
			data.put(recordset.getField(collist.get(0)), rowdata);
		System.out.println();
		}
		 
		recordset.close();
		connection.close();
		
		return data;
	}
	
	public Properties readproperties()
	{
		Properties prop = null;
		try
		{
		 prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Config/Setting.properties");
		prop.load(fis);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return prop;
		
	}

}
