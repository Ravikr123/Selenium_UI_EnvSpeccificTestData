package com.hpi.TestScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hpi.PageActions.PageElements_Methods;
import com.hpi.Utility.BrowserSelection;
import com.hpi.Utility.CaptureScreenShots;
import com.hpi.Utility.CommonActions;
import com.hpi.Utility.ExcelReader;
import com.hpi.Utility.ExtentManager;
import com.hpi.Utility.SendFileEmail;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Verify_ServiceCenter_AutomationFlow {

	private static final String browser = null;

	ExtentReports extent;
	ExtentTest logger;
	private WebDriver driver;
	PageElements_Methods pem;
	String reportPath = null;
	String env = null;
	String testResult = null;
	String toAddress = null;

	@Parameters({ "browser", "appurl" })
	@BeforeMethod(alwaysRun = true)
	public void init(@Optional("Chrome") String browserName,@Optional("https://daily.gsbprint.net/pwi-sc/#/") String appurl) throws Throwable {
		driver = BrowserSelection.getBrowser(browserName);
	}

	@BeforeTest
	public void startReport() throws Throwable {
		reportPath = ExtentManager.htmlReportPath();
		extent = ExtentManager.Instance();
	}

	@Test(priority = 1,dataProvider = "ExcelTestData", dataProviderClass = ExcelReader.class,enabled=true)
	public void verifyServiceCenterAutomationFlow_DirectFlow(String... data) throws Throwable {
		pem = new PageElements_Methods(driver);
		String testResult = "Failed";
		try {

			BrowserSelection.openUrl(data[0]);
			if (data[0].contains("daily")){
				env = "Daily";
				System.out.println(env);
			} else if (data[0].contains("stg")){
				env = "Stage";
			} else {
				env = "RC";
			}

			logger = extent.startTest("verifyServiceCenterAutomationFlow_DirectFlow",
					"This test case verifies Direct Service Centre Flow.");
			CommonActions.pollingWait(driver, pem.printOSlebel);
			pem.validationswithXpath(pem.printOSlebel, "Home Page", logger);

			pem.signIn(data[2], data[3], logger);
			Thread.sleep(3000);
			pem.scApplicationSelection(data[6],"Service Center",  "Velkom",logger);
			pem.selectPressFamily(data[6],data[1], logger);
			String providedSerialNumber = pem.selectPressSerialNumber(data[4], logger);
			String createcasesub = pem.getSubject("SubjectNameArray");
			String createcasedesc = pem.getDescription("DescriptionNameArray");
			Thread.sleep(2000);
			pem.createCaseWith_MultipleAttachments(data[5],providedSerialNumber, createcasesub, createcasedesc, logger);
			pem.retrievCaseWith_MultipleAttachments(data[5], createcasesub, createcasedesc, logger);
			String addnote = pem.getNotes("AddNotesArray");
			pem.addcaseNotes(addnote, logger);
			pem.retrieveNotesAndAttachments(data[5], logger);

			testResult = "Pass";
		} catch (Throwable e) {
			CaptureScreenShots capturescreenshotutility = new CaptureScreenShots(driver);
			capturescreenshotutility.captureScreenshot(driver, "FailPage");
			logger.log(LogStatus.FAIL, "Test Case Failed is verifyServiceCenterAutomationFlow_DirectFlow");
			throw e;
		} finally {

		}
	}
	

	@Test(priority = 2,dataProvider = "ExcelTestData", dataProviderClass = ExcelReader.class, enabled = true)
	public void verifyServiceCenterAutomationFlow_InDirectFlow(String... data) throws Throwable {
		pem = new PageElements_Methods(driver);
		testResult = "Failed";
		try {

			BrowserSelection.openUrl(data[0]);
			
			if (data[0].contains("daily")) {
				env = "Daily";
				System.out.println(env);
			} else if (data[0].contains("stg")) {
				env = "Stage";
			} else {
				env = "RC";
			}
			logger = extent.startTest("verifyServiceCenterAutomationFlow_InDirectFlow","This test case verifies Indirect Service Centre Flow.");

			pem.signIn(data[2], data[3], logger);
			Thread.sleep(2000);
		    pem.scApplicationSelection(data[6],"Service Center", "Velkom",logger);

		    pem.selectPressFamily(data[6],data[1], logger);

		    String providedSerialNumber = pem.selectPressSerialNumber(data[4], logger);
			String createcasesub = pem.getSubject("SubjectNameArray");
		    String createcasedesc = pem.getDescription("DescriptionNameArray");
		    Thread.sleep(2000);
			pem.createCaseWith_MultipleAttachments(data[5],providedSerialNumber, createcasesub, createcasedesc, logger);
			pem.retrievCaseWith_MultipleAttachments(data[5], createcasesub, createcasedesc, logger);
			String addnote = pem.getNotes("AddNotesArray");
			pem.addcaseNotes(addnote, logger);
			pem.retrieveNotesAndAttachments(data[5], logger);

			testResult = "Pass";
		} catch (Throwable e) {
			CaptureScreenShots capturescreenshotutility = new CaptureScreenShots(driver);
			capturescreenshotutility.captureScreenshot(driver, "FailPage");
			logger.log(LogStatus.FAIL, "Test Case Failed is verifyServiceCenterAutomationFlow_InDirectFlow");
			throw e;
		} finally {

		}

	}
	
	
	@Test(priority = 3,dataProvider = "ExcelTestData", dataProviderClass = ExcelReader.class, enabled = true)
	public void verifyServiceCenter_CreateCaseWith_3MBAttachment_Direct(String... data) throws Throwable 
	{
		
		pem = new PageElements_Methods(driver);
		String testResult = "Failed";
		try{

			BrowserSelection.openUrl(data[0]);
			if (data[0].contains("daily")) {
				env = "Daily";
				System.out.println(env);
			} else if (data[0].contains("stg")) {
				env = "Stage";
			} else {
				env = "RC";
			}

			logger = extent.startTest("verifyServiceCenter_CreateCaseWith_3MBAttachment_Direct",
					"This test case verifies Direct case creation with 3 MB attachment.");
			CommonActions.pollingWait(driver, pem.printOSlebel);
			pem.validationswithXpath(pem.printOSlebel, "Home Page", logger);
			pem.signIn(data[2], data[3], logger);
			Thread.sleep(3000);
			pem.scApplicationSelection(data[6],"Service Center", "Velkom", logger);
			Thread.sleep(2000);
			pem.selectPressFamily(data[6],data[1], logger);
			
			String providedSerialNumber = pem.selectPressSerialNumber(data[4], logger);
			
			String createcasesub = pem.getSubject("SubjectNameArray");
			String createcasedesc = pem.getDescription("DescriptionNameArray");
			pem.createCaseWith_3MB_FileAttachment(data[5],providedSerialNumber, createcasesub, createcasedesc, logger);
			
			testResult = "Pass";
		}catch (Throwable e){
			CaptureScreenShots capturescreenshotutility = new CaptureScreenShots(driver);
			capturescreenshotutility.captureScreenshot(driver, "FailPage");
			logger.log(LogStatus.FAIL, "Test Case Failed is verifyServiceCenter_CreateCaseWith_3MBAttachment_Direct");
			throw e;
		}finally{
			
		}
	}
	
	
	@Test(priority = 4,dataProvider = "ExcelTestData", dataProviderClass = ExcelReader.class, enabled = true)
	public void verifyServiceCenter_CreateCaseWith_3MB_Attachment_InDirect(String... data) throws Throwable
	{
		pem = new PageElements_Methods(driver);
		testResult = "Failed";
		try {

			BrowserSelection.openUrl(data[0]);
			
			if (data[0].contains("daily")) {
				env = "Daily";
				System.out.println(env);
			} else if (data[0].contains("stg")) {
				env = "Stage";
			} else {
				env = "RC";
			}
			logger = extent.startTest("verifyServiceCenter_CreateCaseWith_3MB_Attachment_InDirect","This test case verifies Indirect case creation with 3MB attachment.");

			pem.signIn(data[2], data[3], logger);
			Thread.sleep(2000);
			pem.scApplicationSelection(data[6],"Service Center",  "Velkom",logger);

			pem.selectPressFamily(data[6],data[1], logger);

			String providedSerialNumber = pem.selectPressSerialNumber(data[4], logger);
			String createcasesub = pem.getSubject("SubjectNameArray");
			String createcasedesc = pem.getDescription("DescriptionNameArray");
			Thread.sleep(2000);
			pem.createCaseWith_3MB_FileAttachment(data[5],providedSerialNumber, createcasesub, createcasedesc, logger);
			
			testResult = "Pass";
		} catch (Throwable e) {
			CaptureScreenShots capturescreenshotutility = new CaptureScreenShots(driver);
			capturescreenshotutility.captureScreenshot(driver, "FailPage");
			logger.log(LogStatus.FAIL, "Test Case Failed is verifyServiceCenter_CreateCaseWith_3MB_Attachment_InDirect");
			throw e;
		} finally {

		}
	}
	
	@Test(priority = 5,dataProvider = "ExcelTestData", dataProviderClass = ExcelReader.class, enabled = true)
	public void verifyServiceCenter_CreateCaseWith_jpegAttachment_Direct(String... data) throws Throwable 
	{
		pem = new PageElements_Methods(driver);
		String testResult = "Failed";
		try{

			BrowserSelection.openUrl(data[0]);
			if (data[0].contains("daily")) {
				env = "Daily";
				System.out.println(env);
			} else if (data[0].contains("stg")) {
				env = "Stage";
			} else {
				env = "RC";
			}

			logger = extent.startTest("verifyServiceCenter_CreateCaseWith_jpegAttachment_Direct",
					"This test case verifies Direct case creation with jpeg attachment.");
			CommonActions.pollingWait(driver, pem.printOSlebel);
			pem.validationswithXpath(pem.printOSlebel, "Home Page", logger);

			pem.signIn(data[2], data[3], logger);
			Thread.sleep(2000);
			pem.scApplicationSelection(data[6],"Service Center", "Velkom", logger);
			pem.selectPressFamily(data[6],data[1], logger);
			String providedSerialNumber = pem.selectPressSerialNumber(data[4], logger);
			String createcasesub = pem.getSubject("SubjectNameArray");
			String createcasedesc = pem.getDescription("DescriptionNameArray");
			pem.createCaseWith_jpeg_Attachment(data[5],providedSerialNumber, createcasesub, createcasedesc, logger);
			pem.retrieveCaseWith_jpeg_Attachment(data[5], createcasesub, createcasedesc, logger);
			testResult = "Pass";
		}catch (Throwable e){
			CaptureScreenShots capturescreenshotutility = new CaptureScreenShots(driver);
			capturescreenshotutility.captureScreenshot(driver, "FailPage");
			logger.log(LogStatus.FAIL, "Test Case Failed is verifyServiceCenter_CreateCaseWith_jpegAttachment_Direct");
			throw e;
		}finally{
			
		}
	}
	
	
	@Test(priority = 6,dataProvider = "ExcelTestData", dataProviderClass = ExcelReader.class, enabled = true)
	public void verifyServiceCenter_CreateCaseWith_jpegAttachment_InDirect(String... data) throws Throwable
	{
		
		pem = new PageElements_Methods(driver);
		testResult = "Failed";
		try {

			BrowserSelection.openUrl(data[0]);
			
			if (data[0].contains("daily")) {
				env = "Daily";
				System.out.println(env);
			} else if (data[0].contains("stg")) {
				env = "Stage";
			} else {
				env = "RC";
			}
			logger = extent.startTest("verifyServiceCenter_CreateCaseWith_jpegAttachment_InDirect","This test case verifies Indirect case creation with jpeg attachment.");

			pem.signIn(data[2], data[3], logger);
			Thread.sleep(2000);
			pem.scApplicationSelection(data[6],"Service Center",  "Velkom",logger);

			pem.selectPressFamily(data[6],data[1], logger);

			String providedSerialNumber = pem.selectPressSerialNumber(data[4], logger);
			String createcasesub = pem.getSubject("SubjectNameArray");
			String createcasedesc = pem.getDescription("DescriptionNameArray");

			pem.createCaseWith_jpeg_Attachment(data[5],providedSerialNumber, createcasesub, createcasedesc, logger);
			pem.retrieveCaseWith_jpeg_Attachment(data[5], createcasesub, createcasedesc, logger);
			
			testResult = "Pass";
		} catch (Throwable e) {
			CaptureScreenShots capturescreenshotutility = new CaptureScreenShots(driver);
			capturescreenshotutility.captureScreenshot(driver, "FailPage");
			logger.log(LogStatus.FAIL, "Test Case Failed is verifyServiceCenter_CreateCaseWith_jpegAttachment_InDirect");
			throw e;
		} finally {

		}
	}
	
	@Test(priority = 7,dataProvider = "ExcelTestData", dataProviderClass = ExcelReader.class, enabled = true)
	public void verifyServiceCenter_CreateCaseWith_pdfAttachment_Direct(String... data) throws Throwable 
	{
		pem = new PageElements_Methods(driver);
		String testResult = "Failed";
		try{

			BrowserSelection.openUrl(data[0]);
			if (data[0].contains("daily")) {
				env = "Daily";
				System.out.println(env);
			} else if (data[0].contains("stg")) {
				env = "Stage";
			} else {
				env = "RC";
			}

			logger = extent.startTest("verifyServiceCenter_CreateCaseWith_pdfAttachment_Direct",
					"This test case verifies Direct case creation with pdf attachment.");
			CommonActions.pollingWait(driver, pem.printOSlebel);
			pem.validationswithXpath(pem.printOSlebel, "Home Page", logger);

			pem.signIn(data[2], data[3], logger);
			Thread.sleep(2000);
			pem.scApplicationSelection(data[6],"Service Center", "Velkom", logger);
			pem.selectPressFamily(data[6],data[1], logger);
			String providedSerialNumber = pem.selectPressSerialNumber(data[4], logger);
			String createcasesub = pem.getSubject("SubjectNameArray");
			String createcasedesc = pem.getDescription("DescriptionNameArray");
			pem.createCaseWith_Pdf_Attachment(data[5],providedSerialNumber, createcasesub, createcasedesc, logger);
			pem.retrieveCaseWith_Pdf_Attachment(data[5], createcasesub, createcasedesc, logger);
			testResult = "Pass";
		}catch (Throwable e) {
			CaptureScreenShots capturescreenshotutility = new CaptureScreenShots(driver);
			capturescreenshotutility.captureScreenshot(driver, "FailPage");
			logger.log(LogStatus.FAIL, "Test Case Failed is verifyServiceCenter_CreateCaseWith_pdfAttachment_Direct");
			throw e;
			
		}finally{
			
		}
	}
	
	@Test(priority = 8,dataProvider = "ExcelTestData", dataProviderClass = ExcelReader.class, enabled = true)
	public void verifyServiceCenter_CreateCaseWith_pdfAttachment_InDirect(String... data) throws Throwable
	{
		pem = new PageElements_Methods(driver);
		testResult = "Failed";
		try {

			BrowserSelection.openUrl(data[0]);
			
			if (data[0].contains("daily")) {
				env = "Daily";
				System.out.println(env);
			} else if (data[0].contains("stg")) {
				env = "Stage";
			} else {
				env = "RC";
			}
			logger = extent.startTest("verifyServiceCenter_CreateCaseWith_pdfAttachment_InDirect","This test case verifies Indirect case creation with pdf attachment.");

			pem.signIn(data[2], data[3], logger);
			Thread.sleep(2000);
			pem.scApplicationSelection(data[6],"Service Center", "Velkom", logger);

			pem.selectPressFamily(data[6],data[1], logger);

			String providedSerialNumber = pem.selectPressSerialNumber(data[4], logger);
			String createcasesub = pem.getSubject("SubjectNameArray");
			String createcasedesc = pem.getDescription("DescriptionNameArray");

			pem.createCaseWith_Pdf_Attachment(data[5],providedSerialNumber, createcasesub, createcasedesc, logger);
			pem.retrieveCaseWith_Pdf_Attachment(data[5], createcasesub, createcasedesc, logger);
			
			testResult = "Pass";
		} catch (Throwable e) {
			CaptureScreenShots capturescreenshotutility = new CaptureScreenShots(driver);
			capturescreenshotutility.captureScreenshot(driver, "FailPage");
			logger.log(LogStatus.FAIL, "Test Case Failed is verifyServiceCenter_CreateCaseWith_pdfAttachment_InDirect");
			throw e;
		} finally {

		}
	}
	
	@Test(priority = 9,dataProvider = "ExcelTestData", dataProviderClass = ExcelReader.class, enabled = true)
	public void verifyServiceCenter_CreateCaseWith_textAttachment_Direct(String... data) throws Throwable
	{
		pem = new PageElements_Methods(driver);
		String testResult = "Failed";
		try{

			BrowserSelection.openUrl(data[0]);
			if (data[0].contains("daily")) {
				env = "Daily";
				System.out.println(env);
			} else if (data[0].contains("stg")) {
				env = "Stage";
			} else {
				env = "RC";
			}

			logger = extent.startTest("verifyServiceCenter_CreateCaseWith_textAttachment_Direct",
					"This test case verifies Direct case creation with text attachment.");
			CommonActions.pollingWait(driver, pem.printOSlebel);
			pem.validationswithXpath(pem.printOSlebel, "Home Page", logger);

			pem.signIn(data[2], data[3], logger);
			Thread.sleep(2000);
			pem.scApplicationSelection(data[6],"Service Center", "Velkom", logger);
			pem.selectPressFamily(data[6],data[1], logger);
			String providedSerialNumber = pem.selectPressSerialNumber(data[4], logger);
			String createcasesub = pem.getSubject("SubjectNameArray");
			String createcasedesc = pem.getDescription("DescriptionNameArray");
			pem.createCaseWith_text_Attachment(data[5],providedSerialNumber, createcasesub, createcasedesc, logger);
			pem.retrieveCaseWith_text_Attachment(data[5], createcasesub, createcasedesc, logger);
			testResult = "Pass";
		}catch (Throwable e) {
			CaptureScreenShots capturescreenshotutility = new CaptureScreenShots(driver);
			capturescreenshotutility.captureScreenshot(driver, "FailPage");
			logger.log(LogStatus.FAIL, "Test Case Failed is verifyServiceCenter_CreateCaseWith_textAttachment_Direct");
			throw e;
			
		}finally{
			
		}
	}
	
	@Test(priority = 10,dataProvider = "ExcelTestData", dataProviderClass = ExcelReader.class, enabled = true)
	public void verifyServiceCenter_CreateCaseWith_textAttachment_InDirect(String... data) throws Throwable
	{
		pem = new PageElements_Methods(driver);
		testResult = "Failed";
		try {

			BrowserSelection.openUrl(data[0]);
			
			if (data[0].contains("daily")) {
				env = "Daily";
				System.out.println(env);
			} else if (data[0].contains("stg")) {
				env = "Stage";
			} else {
				env = "RC";
			}
			logger = extent.startTest("verifyServiceCenter_CreateCaseWith_textAttachment_InDirect","This test case verifies Indirect case creation with text attachment.");

			pem.signIn(data[2], data[3], logger);
			Thread.sleep(2000);
			pem.scApplicationSelection(data[6],"Service Center",  "Velkom",logger);

			pem.selectPressFamily(data[6],data[1], logger);

			String providedSerialNumber = pem.selectPressSerialNumber(data[4], logger);
			String createcasesub = pem.getSubject("SubjectNameArray");
			String createcasedesc = pem.getDescription("DescriptionNameArray");

			pem.createCaseWith_text_Attachment(data[5],providedSerialNumber, createcasesub, createcasedesc, logger);
			pem.retrieveCaseWith_text_Attachment(data[5], createcasesub, createcasedesc, logger);
			
			testResult = "Pass";
		} catch (Throwable e) {
			CaptureScreenShots capturescreenshotutility = new CaptureScreenShots(driver);
			capturescreenshotutility.captureScreenshot(driver, "FailPage");
			logger.log(LogStatus.FAIL, "Test Case Failed is verifyServiceCenter_CreateCaseWith_textAttachment_InDirect");
			throw e;
		} finally {

		}
	}
	
	
	
	@Test(priority = 11,dataProvider = "ExcelTestData", dataProviderClass = ExcelReader.class, enabled = true)
	public void verifyServiceCenter_CaseNotesTextLimitation_Direct(String... data) throws Throwable
	{
		pem = new PageElements_Methods(driver);
		testResult = "Failed";
		try {

			BrowserSelection.openUrl(data[0]);
			
			if (data[0].contains("daily")) {
				env = "Daily";
				System.out.println(env);
			} else if (data[0].contains("stg")) {
				env = "Stage";
			} else {
				env = "RC";
			}
			logger = extent.startTest("verifyServiceCenter_CaseNotesTextLimitation_Direct","This test case verifies Case Notes text character limitation.");

			pem.signIn(data[2], data[3], logger);
			Thread.sleep(2000);
			pem.scApplicationSelection(data[6],"Service Center", "Velkom", logger);

			pem.selectPressFamily(data[6],data[1], logger);

			String providedSerialNumber = pem.selectPressSerialNumber(data[4], logger);
			String createcasesub = pem.getSubject("SubjectNameArray");
			String createcasedesc = pem.getDescription("DescriptionNameArray");

			pem.createCaseWith_text_Attachment(data[5],providedSerialNumber, createcasesub, createcasedesc, logger);
			pem.retrieveCaseWith_text_Attachment(data[5], createcasesub, createcasedesc, logger);
			String notex_text = pem.getCaseNoteData();
			pem.notes_exceedingWord_limit(notex_text, logger);
			testResult = "Pass";
		} catch (Throwable e) {
			CaptureScreenShots capturescreenshotutility = new CaptureScreenShots(driver);
			capturescreenshotutility.captureScreenshot(driver, "FailPage");
			logger.log(LogStatus.FAIL, "Test Case Failed is verifyServiceCenter_CaseNotesTextLimitation_Direct");
			throw e;
		} finally {

		}
	}
	
	
	@Test(priority = 12,dataProvider = "ExcelTestData", dataProviderClass = ExcelReader.class, enabled = true)
	public void verifyServiceCenter_CaseNotesTextLimitation_InDirect(String... data) throws Throwable
	{
		pem = new PageElements_Methods(driver);
		testResult = "Failed";
		try {

			BrowserSelection.openUrl(data[0]);
			
			if (data[0].contains("daily")) {
				env = "Daily";
				System.out.println(env);
			} else if (data[0].contains("stg")) {
				env = "Stage";
			} else {
				env = "RC";
			}
			logger = extent.startTest("verifyServiceCenter_CaseNotesTextLimitation_InDirect","This test case verifies Case Notes text character limitation.");

			pem.signIn(data[2], data[3], logger);
			Thread.sleep(2000);
			pem.scApplicationSelection(data[6],"Service Center", "Velkom", logger);

			pem.selectPressFamily(data[6],data[1], logger);

			String providedSerialNumber = pem.selectPressSerialNumber(data[4], logger);
			String createcasesub = pem.getSubject("SubjectNameArray");
			String createcasedesc = pem.getDescription("DescriptionNameArray");

			pem.createCaseWith_text_Attachment(data[5],providedSerialNumber, createcasesub, createcasedesc, logger);
			pem.retrieveCaseWith_text_Attachment(data[5], createcasesub, createcasedesc, logger);
			String notex_text = pem.getCaseNoteData();
			pem.notes_exceedingWord_limit(notex_text, logger);
			testResult = "Pass";
		} catch (Throwable e) {
			CaptureScreenShots capturescreenshotutility = new CaptureScreenShots(driver);
			capturescreenshotutility.captureScreenshot(driver, "FailPage");
			logger.log(LogStatus.FAIL, "Test Case Failed is verifyServiceCenter_CaseNotesTextLimitation_InDirect");
			throw e;
		} finally {
			//int row = Integer.parseInt(data[6]);
			//ExcelReader.WriteToExcel(testResult, row, 9);
		}
	}
	
	@AfterMethod
	public void getResult(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE)
		{
			logger.log(LogStatus.FAIL, "Test Case Failed reason is :-   " + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP)
		{
			logger.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
			logger.log(LogStatus.FAIL, "Test Case Skipped reason is :-   " + result.getThrowable());
		}
		extent.endTest(logger);
		extent.flush();
		driver.close();
	}

	@AfterTest
	public void endReport() throws InterruptedException 
	{
		if(testResult.equalsIgnoreCase("Pass"))
		{
			SendFileEmail sendMail = new SendFileEmail();
			Thread.sleep(2000);
			sendMail.sendMailWithAttachmentNew(reportPath,env,"gssit-printos-support-team@hp.com,GSS_PrintOS_India@hp.com");
		}
		else if(testResult.equalsIgnoreCase("Failed")){
			SendFileEmail sendMail = new SendFileEmail();
			Thread.sleep(2000);
			sendMail.sendMailWithAttachmentNew(reportPath,env,"gssit-printos-support-team@hp.com,GSS_PrintOS_India@hp.com");
		}
		driver.quit();
	}
}
