package com.hpi.Utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentManager {
	
	static DateFormat dateFormat;
	static String destDir;
	
	
	
		public static ExtentReports Instance()
		{
		    ExtentReports extent;
		    ExtentTest loggers;
			dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
			String date1=new SimpleDateFormat("dd-MMM-YYYY").format(Calendar.getInstance().getTime());
			String folder = "RunReport -"+date1;
			File file = new File(System.getProperty("user.home")+File.separatorChar+"workspace"+File.separatorChar+"Service_Center"+File.separatorChar+"Reports"+File.separator+folder);
			
			if (!file.exists()){
				if (file.mkdir()){
					//APP_LOGS.info("Directory is created!");
				} else {
					//APP_LOGS.info("Failed to create directory!");
				}
			}
			
			String destDir1 = System.getProperty("user.home")+File.separatorChar+"workspace"+File.separatorChar+"Service_Center"+File.separatorChar+"Reports"+File.separator+folder;
			String destFile = "ExtentReport"+"-"+dateFormat.format(new Date()) + ".html";
			String Path = destDir1 +File.separator + destFile;
			extent = new ExtentReports(Path, true);
			extent.addSystemInfo("Host Name","Testing");
		 
			return extent;
		}
		
		
		public static String htmlReportPath()
		{
			dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");

			String date1=new SimpleDateFormat("dd-MMM-YYYY").format(Calendar.getInstance().getTime());
			String folder = "RunReport -"+date1;
			File file = new File(System.getProperty("user.home")+File.separatorChar+"workspace"+File.separatorChar+"Service_Center"+File.separatorChar+"Reports"+File.separator+folder);

			String destDir1 = System.getProperty("user.home")+File.separatorChar+"workspace"+File.separatorChar+"Service_Center"+File.separatorChar+"Reports"+File.separator+folder;
			String destFile = "ExtentReport"+"-"+dateFormat.format(new Date()) + ".html";
			String Path = destDir1 + File.separator + destFile;
			return Path;
		}
		public static String CaptureScreen(WebDriver driver, String ImagesPath)
		{
		    TakesScreenshot oScn = (TakesScreenshot) driver;
		    File oScnShot = oScn.getScreenshotAs(OutputType.FILE);
		    File oDest = new File(ImagesPath+".jpg");
		    try 
		    {
		      FileUtils.copyFile(oScnShot, oDest);
		    } catch (IOException e)
		    {
		    	System.out.println(e.getMessage());
		    }
		    return ImagesPath+".jpg";
		}
		
		

}
