package com.hpi.Utility;

import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseTest {
	
	public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;
    
    
    
   public BaseTest(){
    	
    }
    
    @BeforeSuite
    public void setUp()
    {
    	extent = new ExtentReports(System.getProperty("user.dir") +"/ExtentReport/MyExtentReport.html",true);
    }
	
}
