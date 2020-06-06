package com.hpi.Utility;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserSelection {
	
	private static WebDriver driver = null;
	public static String driverpath = System.getProperty("user.home")+File.separator+"workspace"+File.separator+"Service_Center"+File.separator+"Drivers"+File.separator+"chromedriver.exe";
	
	
	public  static WebDriver getBrowser(String browserName)
	{
		if(browserName.equalsIgnoreCase("chrome")){
			
			System.setProperty("webdriver.chrome.driver",driverpath);
		    driver = new ChromeDriver();	
		}

		else if(browserName.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public static void openUrl(String appurl){
		driver.get(appurl);
	}
}
