package com.hpi.Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenShots {
	
	
	private static WebDriver driver;
	
	public CaptureScreenShots(WebDriver driver){
		this.driver=driver;
	}
	
	//capture screenshot using selenium webDriver
	public static void captureScreenshot(WebDriver driver, String filename) throws IOException{
		File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Calendar calendar = Calendar.getInstance(); //will return Calendar class object
		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy_hh_ss");
		FileUtils.copyFile(srcfile, new File(System.getProperty("user.home")+File.separator+"workspace"+File.separator+"Service_Center"+File.separator+"ScreenShots"+File.separator+filename+"_"+dateformat.format(calendar.getTime())+".png"));
	}
}
