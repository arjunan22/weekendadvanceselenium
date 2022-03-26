package com.Skillrary.GenericLib;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public static Connection con;
	public FileUtilies fileutilies=new FileUtilies();
	public static ExtentReports reports;
	public static ExtentHtmlReporter htmlreport;
	public static ExtentTest test;
	public WebDriverUtiles driverutilies=new WebDriverUtiles();
	
	@BeforeSuite
	public void configBS() throws SQLException {
	System.out.println("connected to database");
	con=FileUtilies.getdataBase();
	 
	htmlreport=new ExtentHtmlReporter(AutoConstant.reportPath);
	htmlreport.config().setDocumentTitle("SkillraryReport");
	htmlreport.config().setTheme(Theme.DARK);
	 
	reports=new ExtentReports();
	reports.attachReporter(htmlreport);
	
	
	
	}
	
	@BeforeMethod
	public void openApp() throws FileNotFoundException, IOException {
WebDriverManager.chromedriver().setup();
driver=new ChromeDriver();
driver.manage().window().maximize();
driver.get(fileutilies.getDataPropertyfile("url"));
driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void closeApp(ITestResult res) {
//		int status = res.getStatus();
//		String name = res.getName();
//		if(status==ITestResult.FAILURE) {
//			test.log(Status.FAIL,res.getName()+"Test case failed");
//			test.log(Status.FAIL,res.getThrowable()+"Test case Failed exception");
//			
//		}
//		else if(status==ITestResult.SUCCESS){
//			test.log(Status.PASS,res.getName()+"Test case are passed");
//		}
//		else if(status==ITestResult.SKIP){
//			test.log(Status.SKIP,res.getName()+"Test case are skipped");
//		}
//		{
		driver.quit();
	}
		
		@AfterSuite
		public void configAS() throws SQLException {
			htmlreport.flush();
			reports.flush();
			FileUtilies.closedb();
			System.out.println("Database is closed");
			
		}

}
