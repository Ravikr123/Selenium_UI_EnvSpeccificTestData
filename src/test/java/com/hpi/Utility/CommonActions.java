package com.hpi.Utility;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.google.common.base.Function;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CommonActions {
	
	ExtentTest logger;
	
	private static WebDriver driver;
	public CommonActions(WebDriver driver){
		this.driver= driver;
	}
	
	//method to click on element
	public static void click(WebElement element){
		element.click();
	}
	
	public static String getTitle(WebDriver driver){
		return driver.getTitle();
	}
	
	//#######....method to select value from dropdown....########
	public static void selectUsingVisibleText(WebElement element, String visibletext, ExtentTest logger)
	{
		Select select = new Select(element);
		logger.log(LogStatus.INFO, "Selecting the Text from press family and option is :- " +visibletext);
		select.deselectByVisibleText(visibletext);	
	}
	
	//#####.....explicit wait for element to be visible.....#####
	public static void waitForElementVisibility(WebDriver driver, WebElement element, long timeOutInSeconds){
		WebDriverWait wait = new WebDriverWait(driver,timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	//#####.....explicit wait for group element to be visible.....#####
	public static void waitForgroupOfElementVisibility(WebDriver driver,By locator,long timeOutInSeconds)
	{
		WebDriverWait wait = new WebDriverWait(driver,timeOutInSeconds);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		
	}
	
	//#####....explicit wait for element to be clickable....####
	public static void waitForElementClickable(WebDriver driver, WebElement element, long timeOutInSeconds){
		WebDriverWait wait = new WebDriverWait(driver,timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	//handel Confirmation pop up of case creation
	public static void pollingWait(WebDriver driver,final WebElement e)
	{
		// Waiting max 10 min for an element 
		// for its presence once every 2 seconds.
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		     .withTimeout(600, TimeUnit.SECONDS)
		     .pollingEvery(2, TimeUnit.SECONDS)
		     .ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>()
		{
			WebElement ele;
		    public WebElement apply(WebDriver driver)
		    {
		    	if(e.isDisplayed())
		    	{
		    	  ele =e;
		    	}
		       return ele;
		    }
		});
		
	}
	
	
	public static WebElement getWebElement(String value)
	{
		String loactorvalue = "//*[contains(text(),"+value+")]";
		WebElement element = driver.findElement(By.xpath(loactorvalue));
		return element;
	}
	

	
	//########......validation method.......#########
	public static void verifyText(String s1, String s2,String s3){
		System.out.println("Verifying the text"+s1+"with"+s2);
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(s1, s2, s3);
		softassert.assertAll();
	}
	
	public static void veriyTrue(boolean condition,String Message){
		SoftAssert softassert = new SoftAssert();
		softassert.assertTrue(condition, Message);
	}
	
	//####....JavascriptExecutor Helper Utility....#####
	public static void clickElementByJS(WebDriver driver, WebElement element){
		
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();", element);
		
	}
	
	public static void refreshBrowserByJS(WebDriver driver){
		
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("history.go(0)");
	}
	
	public static void scrollPageDown(WebDriver driver){
		
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)"); 
	}
	
	public static void scrollIntoView(WebDriver driver, WebElement element){
		
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public static int randomAction(List<WebElement> element){
		
		Random random = new Random();
		int count = element.size();
		int i=0;
		 i=random.nextInt(count);
		System.out.println(i);
		return i;
	}
}
