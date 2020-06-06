package com.hpi.PageActions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.concurrent.ThreadLocalRandom;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.google.common.base.Function;
import com.hpi.Utility.BrowserSelection;
import com.hpi.Utility.CommonActions;
import com.hpi.Utility.DBQuery;

public class PageElements_Methods {

	ExtentTest logger;
	private WebDriver driver;
	CommonActions commonMethod;
	PageElements_Methods pem;
	public DBQuery dbquery;
	public String inputdatapath = System.getProperty("user.home") + File.separator + "workspace" + File.separator
			+ "Service_Center" + File.separator + "inputdata.properties";
	public String casenotespath = System.getProperty("user.home") + File.separator + "workspace" + File.separator
			+ "Service_Center" + File.separator + "casenotes.txt";
	public FileInputStream fis;
	public Properties prop;

	public PageElements_Methods(WebDriver driver) throws Throwable {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		dbquery = new DBQuery();
	}

	// #########........SignIn Page Locators.........###############

	@FindBy(xpath = "//button[@id='btn-signin']")
	public WebElement SignInButton;
	@FindBy(xpath = "//div[@class='posb--decorated-input']/input")
	public WebElement role;
	@FindBy(xpath = "//a[contains(text(),'Home')]")
	public WebElement homebtn;
	@FindBy(xpath = "//div[normalize-space(text())='PWP Test Customer']")
	public WebElement PWPTestCustomer;

	@FindBy(xpath = "//div[@class='posb--scroll-container']//div[@class='posb--name']")
	public WebElement application_name;

	// ########...........Login Page Locator.........###############

	@FindBy(xpath = "//input[@id='username']")
	public WebElement usernametextfield;
	@FindBy(xpath = "//button[@id='next_button']")
	public WebElement nextButton;
	@FindBy(xpath = "//input[@id='password']")
	public WebElement passwordtextfield;
	@FindBy(xpath = "//button[@class='vn-button vn-button--critical vn-button--expanded']")
	public WebElement nextbutton;
	@FindBy(xpath = "//div[@id='posb-user-panel']")
	public WebElement userIcon;
	@FindBy(xpath = "//div[@class='posb--header']//div[contains(text(),'Home')]")
	public WebElement home;
	@FindBy(xpath = "//div[@class='printos-label']")
	public WebElement printOSlebel;
	@FindBy(xpath = "//button[@id='btn-activate-device']")
	public WebElement activatebutton;

	// ###########............Device List Page Locator..........################
	@FindBy(xpath = "//h1[contains(text(),'Home')]")
	public WebElement homebutton;
	@FindBy(xpath = "//div[@id='posb-user-panel']/div[@class='posb--icon']")
	public WebElement usericon;
	@FindBy(xpath = "//div[starts-with(@class,'posb--input-decorator')]")
	public WebElement userselection;
	@FindBy(xpath = "//div[contains(text(),'Velkom')]")
	public WebElement Velkom;
	@FindBy(xpath = "//div[contains(text(),'Hindustan Bangalore')]")
	public WebElement hindustan_bangalore;

	@FindBy(xpath = "//div[@class='gbu-switcher-container-item']")
	public WebElement devicelist;
	@FindBy(xpath = "//div[@class='ng-star-inserted']/ancestor::div[contains(@class,'ng-trigger-translateTab')]")
	public WebElement dashboarddevice_list;
	@FindBy(xpath = "//h1[contains(text(),'Dashboard')]")
	public WebElement dashboard;
	@FindBy(xpath = "//div[@id='posb-app-switcher']")
	public WebElement appswitcher;
	@FindBy(xpath = "//div[contains(text(),'Service Center')]")
	public WebElement servicecentre;
	@FindBy(xpath = "//div[@class='posb--apps-container']//div[12]//div[@class='posb--name' and text()='Service Center']")
	public WebElement service_center;

	// ########............Support Dashboard Page.........########
	@FindBy(xpath = "//span[contains(text(),'Support Cases')]")
	public WebElement supportcasetext;
	@FindBy(xpath = "//div[contains(text(),'Devices')]")
	public WebElement devicetab;
	@FindBy(xpath = "//div[@class='cases-card-container']")
	public WebElement supportCasedashboard;
	@FindBy(xpath = "//h1[normalize-space(text())='Support Cases']")
	public WebElement supportcase;

	// ########.......New Case creation........########
	@FindBy(xpath = "//span[contains(text(),'NEW CASE')]")
	public WebElement newCasebutton;
	@FindBy(xpath = "//div[text()='HP']")
	public WebElement directHPchannel;
	@FindBy(xpath = "//div[text()='Channel Partner']")
	public WebElement indirectChannelPartner;
	@FindBy(css = "button.full-field-length.line-height-24.mat-raised-button.mat-primary")
	public WebElement savebutton;
	@FindBy(xpath = "//input[@placeholder='Subject']")
	public WebElement subjecttextfield;
	@FindBy(xpath = "//textarea[@placeholder='Description']")
	public WebElement desciptiontextfield;
	@FindBy(xpath = "//div[@class='mat-checkbox-background']")
	public WebElement keepMeInformedcheckbox;
	@FindBy(css = "button.margin-left-20.mat-raised-button.mat-primary")
	public WebElement submitbutton;
	@FindBy(css = "button.mat-button.mat-primary")
	public WebElement cancelbutton;
	@FindBy(css = "button.mat-raised-button.mat-primary:nth-of-type(1)")
	public WebElement attachmentbutton;
	@FindBy(xpath = "//div[starts-with(@id,'cdk-overlay')]//p")
	public WebElement confirmationpopUppara;
	@FindBy(xpath = "//h2[starts-with(@id,'mat-dialog-title')]")
	public WebElement popUpheading;
	@FindBy(xpath = "//div[@class='cdk-global-overlay-wrapper']/div[starts-with(@id,'cdk-overlay')]")
	public WebElement confirmationpopUp;

	@FindBy(xpath = "//div[starts-with(@id,'cdk-overlay')]")
	public WebElement casecreatedconfirmationPopup;
	@FindBy(xpath = "//div[starts-with(@id,'cdk-overlay')]")
	public WebElement errorOccuredpop;
	@FindBy(xpath = "//div[starts-with(@id,'cdk-overlay')]//p")
	public WebElement errorOccuredmessage;
	@FindBy(css = "button.mat-raised-button.mat-primary.ng-star-inserted")
	public WebElement errorOKButton;
	@FindBy(css = "button.mat-raised-button.mat-primary.ng-star-inserted")
	public WebElement confirmationOKbutton;
	@FindBy(xpath = "//div[@class='device-image-alignment']//div[4]/span")
	public WebElement pressimageWithSerialNumber;
	@FindBy(css = "button.mat-raised-button.mat-primary.ng-star-inserted")
	public WebElement errorpopOKbtn;
	@FindBy(xpath = "//span[contains(text(),'The service for this device will be delivered by HP.')]")
	public WebElement hpservicemessage;
	@FindBy(css = "div.dashboard-container-item.ng-star-inserted")
	public List<WebElement> deviceList;
	@FindBy(xpath = "//div[text()='HP']/ancestor::*[contains(@class,'mat-button-toggle mat-button-toggle-checked')]")
	public WebElement HpEnabled;
	@FindBy(xpath = "//div[@class='mat-button-toggle-label-content' and text()='Channel Partner']")
	public WebElement indirectchannel;
	@FindBy(xpath = "//div[@class='mat-select-arrow']")
	public WebElement selectchannelarrow;
	@FindBy(xpath = "//span[contains(text(),'PrintOS-Reseller-1')]")
	public WebElement channeloption;
	@FindBy(xpath = "//span[text()='The service for this device will be delivered by PrintOS-Reseller-1. The request will be sent to them.']")
	public WebElement servicechannelmessage;

	@FindBy(xpath = "//div[@class='device-image-alignment']/div[1]/span")
	public WebElement totalpressCount;

	@FindBy(xpath = "//div[@class='button-wrapper']//button//i[@class='fa fa-angle-right']")
	public WebElement rightarrowbutton;
	@FindBy(xpath = "//div[@class='cdk-overlay-pane']")
	public WebElement dialogbox;
	@FindBy(xpath = "//div[@class='full-field-length ng-star-inserted']")
	public WebElement support_type;
	@FindBy(xpath="//div[@class='ng-star-inserted']/div[@fxlayout='row']/child::span")
	public WebElement message;

	// ##########........Retrieve Case.........#############
	@FindBy(xpath = "//div[@class='quick-search-input']/input")
	public WebElement quickFilter;
	@FindBy(xpath = "//div[@class='ag-body-container']/div[@role='row' and @row-index='0']/div[@col-id='caseId']")
	public WebElement case_id;
	@FindBy(xpath = "//div[@class='gbu-switcher-container-item']")
	List<WebElement> pressfamily;
	@FindBy(css = "div.container.ng-star-inserted>h1")
	public WebElement casedetail;
	@FindBy(xpath = "//div[@class='mat-tab-labels']/div[2]")
	public WebElement file_notes;
	@FindBy(xpath = "//div[@class='container ng-star-inserted']/h1")
	public WebElement caseheader;

	// ############.........Update Case.........##########
	@FindBy(css = "i.fa.fa-sticky-note")
	public WebElement add_note;
	@FindBy(css = "i.fa.fa-paperclip")
	WebElement attach_file;
	@FindBy(xpath = "//div[starts-with(@id,'cdk-overlay')]")
	public WebElement add_note_popup;
	@FindBy(xpath = "//div[starts-with(@id,'cdk-overlay')]//form//span[contains(text(),'Note should not exceed 5000 characters ')]")
	public WebElement notesmessage;
	@FindBy(xpath = "//mat-dialog-container//div/textarea")
	public WebElement enter_note;
	@FindBy(xpath = "//span[normalize-space(text())='Add']")
	public WebElement add_note_btn;
	@FindBy(xpath = "//span[normalize-space(text())='Cancel']")
	public WebElement cancel_note_btn;
	@FindAll({ @FindBy(xpath = "//div[starts-with(@id,'cdk-overla')]"), @FindBy(css = "div.cdk-overlay-pane") })
	public WebElement add_note_confirmation_popup;

	@FindAll({ @FindBy(css = "button.mat-raised-button.mat-primary.ng-star-inserted"),
			@FindBy(xpath = "//button[normalize-space(text())='OK']") })
	public WebElement add_note_confirmation_popup_OkBtn;

	@FindBy(xpath = "//div[starts-with(@id,'cdk-overla')]//h2")
	public WebElement addnote_pop_message;

	@FindBy(css = "i.fa.fa-refresh")
	public WebElement refresh_btn;
	@FindBy(xpath = "//ul[@class='case-notes-container ng-star-inserted']/li[1]")
	public WebElement hpcustomercare;
	@FindBy(xpath = "//ul[@class='case-notes-container ng-star-inserted']/li[1]/ul/li/pre")
	public WebElement updated_note_direct;

	@FindBy(xpath = "//a[contains(text(),'maven.PNG')]")
	public WebElement pngattachments;

	@FindBy(xpath = "//ul[@class='case-notes-container ng-star-inserted']/li[2]//ul/li/p[2]/a")
	public WebElement indirectpngattachments;

	@FindBy(xpath = "//a[contains(text(),'java_tutorial.pdf')]")
	public WebElement pdfattachments;

	@FindBy(xpath = "//a[contains(text(),'Control_Tower.docx')]")
	public WebElement docattachments;

	@FindBy(xpath = "//span[normalize-space(text())='DONE']")
	public WebElement update_case_done_Btn;

	// #######......Retrieve case notes......#########
	@FindBy(xpath = "//ul[@class='case-notes-container ng-star-inserted']/li")
	public List<WebElement> notes_attachments;

	// #####........Silpa locators......#########

	// case list page
	@FindBy(xpath = "//div[@class='ag-body-container']/div[1]")
	List<WebElement> firstCase;
	@FindBy(xpath = "//div[@class='ag-body-container']/div[1]/div[@col-id='caseId']")
	WebElement caseId;
	@FindBy(xpath = "//div[@class='ag-body-container']/div[1]/div[@col-id='pressBU']")
	WebElement serialNumber;
	// retrieve case page- get caseId and get serial number
	@FindBy(xpath = "//div[@class='case-detail-container ng-star-inserted']/div[1]/p[4]")
	WebElement retrieveCaseId;
	@FindBy(xpath = "//div[@class='case-detail-container ng-star-inserted']/div[2]/p[6]")
	WebElement serialNum;
	// Files & Notes tab
	@FindBy(id = "mat-tab-label-1-1")
	WebElement tab2;
	// Choose device
	@FindBy(xpath = "//img[@src='assets/images/HP-Latex-Printers.png']")
	WebElement device;
	// Case card
	@FindBy(xpath = "//div[@class='cases-card-container-header']")
	WebElement caseCard;
	// case existance
	@FindBy(xpath = "//*[@id='borderLayout_eGridPanel']/div[1]/div/div[4]")
	List<WebElement> caseList;
	@FindBy(xpath = "//div[@class='quick-search-extra']")
	WebElement searchResultTitle;

	// #############.........Shilpa Method..........##########
	public void readAllCasesToList(ExtentTest logger) throws InterruptedException {
		CommonActions.waitForElementVisibility(driver, device, 60);
		highLighterMethod(driver, device);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", device);
		CommonActions.pollingWait(driver, caseCard);
		Thread.sleep(2000);
		caseCard.click();
		driver.switchTo().activeElement();
		if (caseList.size() > 0) {
			logger.log(LogStatus.PASS, "Support Cases are present");

		} else {
			logger.log(LogStatus.FAIL, "Support cases do not exist");
		}

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(searchResultTitle));// (missingItemList).get(0)));
		String resultHeader = searchResultTitle.getText();
		String resultCount = resultHeader.replaceAll("[^0-9]", "");
		int matchingMissingItemCount = Integer.parseInt(resultCount);// missingItemList.size();

		List<String> caseItems = new ArrayList<String>();

		for (int i = 0; i < matchingMissingItemCount; i++) {

			String searchedItemXpath = "(//*[@id='borderLayout_eGridPanel']/div[1]/div/div[4]//div[@row-index='" + i
					+ "']//div[@col-id='caseId'])";
			List<WebElement> searchedItem = driver.findElements(By.xpath(searchedItemXpath));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchedItem.get(0));
			for (WebElement match : searchedItem) {
				caseItems.add(match.getText());
				System.out.println("Caseid added to the list is :" + match.getText());
			}
			logger.log(LogStatus.INFO, "Total Support Cases present are :" + caseItems.size());
			System.out.println("total list :" + caseItems.size());

		}
		System.out.println("final list size :" + caseItems.size());
		chooseRandomCaseId(caseItems, logger);
	}

	// silpa method
	public String chooseRandomCaseId(List<String> caseItems, ExtentTest logger) throws InterruptedException {

		Random r = new Random();
		int randomValue = r.nextInt(caseItems.size());
		System.out.println("Random row_index is :" + randomValue);
		Thread.sleep(2000);
		String choosed = caseItems.get(randomValue);
		logger.log(LogStatus.PASS, "Random Support case selected is : " + choosed);
		int caseIdlength = String.valueOf(choosed).length();
		System.out.println("Random case id leangth is :" + caseIdlength);
		if (caseIdlength == 10) {
			logger.log(LogStatus.PASS, "The Random Support case selected is a Direct Case");
			Thread.sleep(2000);
			// searchWithCaseId(choosed);
			// retrieveCaseIdAndSerialNum(logger);
		}

		else {
			logger.log(LogStatus.PASS, "The Random Support Case selected is a Indirect Case");
			Thread.sleep(2000);
			// searchWithCaseId(choosed);
			// retrieveCaseIdAndSerialNum(logger);
		}
		return choosed;
	}

	// silpa method
	public void searchWithCaseId(String choosed) throws InterruptedException {
		WebElement quickSearch = driver.findElement(By.xpath(
				"/html/body/div[1]/app-root/div/app-cases/div/sutk-custom-grid/sutk-quick-search-header/div[1]/input"));
		CommonActions.waitForElementVisibility(driver, quickSearch, 60);
		highLighterMethod(driver, quickSearch);
		quickSearch.sendKeys(choosed);
		Thread.sleep(2000);

	}

	// silpa method
	public void retrieveCaseIdAndSerialNum(ExtentTest logger) throws InterruptedException {
		String actualCaseNum = caseId.getText();
		String str = serialNumber.getText();
		String actualSerialNum = str.substring(6, 16);
		if (caseId.isDisplayed()) {
			logger.log(LogStatus.PASS, "Searched the selected Support Case successfully");
			caseId.click();
			CommonActions.waitForElementVisibility(driver, casedetail, 60);
			String expectedcaseId = retrieveCaseId.getText();
			CommonActions.waitForElementVisibility(driver, retrieveCaseId, 60);
			CommonActions.verifyText(actualCaseNum, expectedcaseId, "CaseId is same ");
			String expectedserialNum = serialNum.getText();
			CommonActions.verifyText(actualSerialNum, expectedserialNum, "Serial number is same");
			Thread.sleep(1000);
		} else {
			logger.log(LogStatus.INFO, "Unable to search the case");
		}

	}

	// silpa method
	public void verifyAttachmentInFilesPage() {
		this.tab2.click();
		if (driver.findElements(By.xpath("//p[@class='case-note-content-img']/a")).size() > 0)

			logger.log(LogStatus.PASS, "attachment found");
		else
			logger.log(LogStatus.PASS, "attachment not found");

	}

	// silpa method
	public void highLighterMethod(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
	}

	// #######.......method to login......############
	public void signIn(String un, String pass, ExtentTest logger) {
		CommonActions.pollingWait(driver, SignInButton);
		this.SignInButton.click();
		CommonActions.waitForElementVisibility(driver, usernametextfield, 60);
		this.usernametextfield.sendKeys(un);
		this.nextButton.click();
		CommonActions.waitForElementVisibility(driver, passwordtextfield, 60);
		this.passwordtextfield.sendKeys(pass);
		this.nextbutton.click();
		CommonActions.pollingWait(driver, home);
		if (home.isDisplayed()) {
			logger.log(LogStatus.PASS,
					"Sign in successfully and Login Credentials are:-" + "UserName: " + un + "  Password: " + pass);
		} else {
			logger.log(LogStatus.FAIL, "Unable to Sign In");
			Assert.fail("Unable to Sign In");
		}

	}

	// method to select service center from app switcher
	public void scApplicationSelection(String environment, String application, String account, ExtentTest logger)
			throws InterruptedException {
		if (environment.equalsIgnoreCase("Stage")) {
			CommonActions.pollingWait(driver, usericon);
			usericon.click();
			userselection.click();
			Thread.sleep(3000);
			// Velkom.click();

			String accountname = "//div[contains(text(),'" + account + "')]";
			WebElement accname = driver.findElement(By.xpath(accountname));
			CommonActions.waitForElementVisibility(driver, accname, 60);
			List<WebElement> accountlist = driver.findElements(
					By.xpath("//div[@class='posb--scroll-container']//div[starts-with(@class,'posb--entry')]"));
			int accountlistsize = accountlist.size();
			for (int j = 0; j < accountlistsize; j++) {
				WebElement ele2 = accountlist.get(j);
				CommonActions.scrollIntoView(driver, ele2);
				String accnameUI = accountlist.get(j).getText();
				if (accnameUI.equalsIgnoreCase(account)) {
					Thread.sleep(2000);
					accountlist.get(j).click();
					Thread.sleep(2000);
					break;
				}
			}

			CommonActions.waitForElementVisibility(driver, appswitcher, 60);
			appswitcher.click();
			String appname = "//div[@class='posb--scroll-container']//div[@class='posb--name' and text()='"
					+ application + "']";
			WebElement applicationName = driver.findElement(By.xpath(appname));
			CommonActions.pollingWait(driver, applicationName);
			List<WebElement> allapplicationName = driver
					.findElements(By.xpath("//div[@class='posb--scroll-container']//div[@class='posb--name']"));
			int totalapplication = allapplicationName.size();
			for (int i = 0; i < totalapplication; i++) {
				WebElement ele = allapplicationName.get(i);
				CommonActions.scrollIntoView(driver, ele);
				String appnameUI = allapplicationName.get(i).getText();
				if (appnameUI.equalsIgnoreCase(application)) {
					allapplicationName.get(i).click();
					Thread.sleep(1000);
					break;
				}
			}
			Thread.sleep(1000);
			System.out.println("clicked on Service Centre");
			CommonActions.waitForElementVisibility(driver, servicecentre, 60);
			if (servicecentre.isDisplayed()) {
				logger.log(LogStatus.PASS, "Selected Service Centre application from appswitcher");
			} else {
				logger.log(LogStatus.FAIL, "Unable to select the service centre application from appswitcher");
				Assert.fail("Unable to select the service centre application from appswitcher");
			}
		} else if (environment.equalsIgnoreCase("Daily")) {
			CommonActions.pollingWait(driver, usericon);
			usericon.click();
			userselection.click();
			Thread.sleep(1000);
			hindustan_bangalore.click();
			CommonActions.waitForElementVisibility(driver, appswitcher, 60);
			appswitcher.click();

			String appname1 = "//div[@class='posb--scroll-container']//div[@class='posb--name' and text()='"
					+ application + "']";
			WebElement applicationName1 = driver.findElement(By.xpath(appname1));
			CommonActions.pollingWait(driver, applicationName1);
			List<WebElement> allapplicationName2 = driver
					.findElements(By.xpath("//div[@class='posb--scroll-container']//div[@class='posb--name']"));
			int totalapplication = allapplicationName2.size();
			for (int i = 0; i < totalapplication; i++) {
				WebElement ele = allapplicationName2.get(i);
				CommonActions.scrollIntoView(driver, ele);
				String appnameUI = allapplicationName2.get(i).getText();
				if (appnameUI.equalsIgnoreCase(application)) {
					allapplicationName2.get(i).click();
					break;
				}
			}
			System.out.println("clicked on Service Centre");
			CommonActions.waitForElementVisibility(driver, servicecentre, 60);
			Thread.sleep(1000);

			if (servicecentre.isDisplayed()) {
				logger.log(LogStatus.PASS, "Selected Service Centre application from appswitcher");
			} else {
				logger.log(LogStatus.FAIL, "Unable to select service centre application from appswitcher");
				Assert.fail("Unable to select service centre application from appswitcher");
			}
		} else if (environment.equalsIgnoreCase("Prod")) {

			CommonActions.pollingWait(driver, usericon);
			usericon.click();
			userselection.click();
			Thread.sleep(2000);
			role.click();
			role.clear();
			role.sendKeys("PWP Test Customer");
			Thread.sleep(1000);
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ENTER);
			action.build();
			action.perform();
			Thread.sleep(5000);
			CommonActions.pollingWait(driver, appswitcher);
			appswitcher.click();

			String appname = "//div[@class='posb--scroll-container']//div[@class='posb--name' and text()='"
					+ application + "']";
			WebElement applicationName = driver.findElement(By.xpath(appname));
			CommonActions.pollingWait(driver, applicationName);
			List<WebElement> allapplicationName = driver
					.findElements(By.xpath("//div[@class='posb--scroll-container']//div[@class='posb--name']"));
			int totalapplication = allapplicationName.size();
			for (int i = 0; i < totalapplication; i++) {
				WebElement ele = allapplicationName.get(i);
				CommonActions.scrollIntoView(driver, ele);
				String appnameUI = allapplicationName.get(i).getText();
				if (appnameUI.equalsIgnoreCase(application)) {
					allapplicationName.get(i).click();
					break;
				}
			}

			CommonActions.pollingWait(driver, homebtn);
			if (homebtn.isDisplayed()) {
				logger.log(LogStatus.PASS, "Selected Service Centre application from appswitcher");
			} else {
				logger.log(LogStatus.FAIL, "Unable to select service centre application from appswitcher");
				Assert.fail("Unable to select service centre application from appswitcher");
			}

		}

	}

	public void selectPressFamily(String environment, String pressFamily, ExtentTest logger)
			throws InterruptedException {
		Thread.sleep(1000);
		CommonActions.pollingWait(driver, homebutton);
		if (environment.equalsIgnoreCase("Daily")) {
			List<WebElement> allpressoption = driver
					.findElements(By.xpath("//select[@class='ng-star-inserted']//option"));
			System.out.println(allpressoption.size());
			for (int i = 0; i <= allpressoption.size(); i++) {
				String pressNameUI = allpressoption.get(i).getText();
				System.out.println(pressNameUI);
				if (pressNameUI.equalsIgnoreCase(pressFamily)) {
					Thread.sleep(1000);
					allpressoption.get(i).click();
					break;
				}
			}
			CommonActions.pollingWait(driver, homebutton);
			if (homebutton.isDisplayed()) {
				logger.log(LogStatus.PASS, "Selected the provided press family in Excel Sheet:" + pressFamily);
			} else {
				logger.log(LogStatus.FAIL, "Unable to select the provided Press Family in excel sheet." + pressFamily
						+ "Please provide Correct Press Family Name");
				Assert.fail("Unable to select the provided Press Family in excel sheet.");
			}
		} else if (environment.equalsIgnoreCase("Stage")) {
			List<WebElement> allpressoption = driver
					.findElements(By.xpath("//select[@class='ng-star-inserted']//option"));
			System.out.println(allpressoption.size());
			for (int i = 0; i <= allpressoption.size(); i++) {
				String pressNameUI = allpressoption.get(i).getText();
				System.out.println(pressNameUI);
				if (pressNameUI.equalsIgnoreCase(pressFamily)) {
					Thread.sleep(1000);
					allpressoption.get(i).click();
					break;
				}
			}
			CommonActions.pollingWait(driver, homebutton);
			if (homebutton.isDisplayed()) {
				logger.log(LogStatus.PASS, "Selected the provided press family in Excel Sheet:" + pressFamily);
			} else {
				logger.log(LogStatus.FAIL, "Unable to select the provided Press Family in excel sheet." + pressFamily
						+ "Please provide Correct Press Family Name");
				Assert.fail("Unable to select the provided Press Family in excel sheet.");
			}
		}

	}



	// method to click on Device Tab
	public void clickOnDevicetab() {
		CommonActions.pollingWait(driver, devicetab);
		CommonActions.click(devicetab);
	}

	// method to select any press based on serial Number we give in excel sheet
	public String selectPressSerialNumber(String serialNumber, ExtentTest logger) throws InterruptedException {
		String serialNumber1 = null;
		clickOnDevicetab();
		CommonActions.pollingWait(driver, dashboarddevice_list);
		Thread.sleep(1000);
		List<WebElement> deviceListSerialNumber = driver.findElements(By.xpath(
				"//div[@class='mat-tab-body-content ng-trigger ng-trigger-translateTab']//child::div[@class='device-card-container-content-label']/child::span[2]"));
		for (int i = 0; i < deviceListSerialNumber.size(); i++) {
			String devicepressNameUI = deviceListSerialNumber.get(i).getText();
			System.out.println("device name UI " + devicepressNameUI);
			String trimmedPressNameUI = devicepressNameUI.substring(5);
			System.out.println("Trimmed serial number:" + trimmedPressNameUI);
			if (trimmedPressNameUI.equalsIgnoreCase(serialNumber)) {
				Thread.sleep(2000);
				serialNumber1 = serialNumber;
				deviceListSerialNumber.get(i).click();

				System.out.println("Clicked on serial Number:" + deviceListSerialNumber);

				break;
			}
		}
		CommonActions.waitForElementVisibility(driver, supportcase, 60);
		if (supportcase.isDisplayed()) {
			logger.log(LogStatus.PASS, "Selected the provided Press Serial Number in Excel sheet:" + serialNumber
					+ "and landed on Support Case List Page");
		} else {
			logger.log(LogStatus.FAIL, "Unable to select the provided Press Serial Number." + serialNumber
					+ "Please provide correct serial Number in Excel Sheet");
			Assert.fail("Please Provide Correct Serial Number in excel sheet");
		}

		return serialNumber1;
	}

	
	//method to create Direct and Indirect case with multiple attachments
		public void createCaseWith_MultipleAttachments(String execution, String SerialNum, String randomsub,String randomdesc, ExtentTest logger) throws Throwable 
		{
			CommonActions.pollingWait(driver, newCasebutton);
			newCasebutton.click();
			CommonActions.pollingWait(driver, pressimageWithSerialNumber);
			String totalpress = totalpressCount.getText();
			String trimmedtotalpressCount = totalpress.substring(5);
			int count = Integer.parseInt(trimmedtotalpressCount);
			for (int i = 1; i <= count; i++) 
			{
				String SN = pressimageWithSerialNumber.getText();
				if (SN.contains(SerialNum)) {
					logger.log(LogStatus.PASS, "Landed on Case Creation Page and Serial Number provided is matched");
					break;
				}

				else {
					rightarrowbutton.click();
					CommonActions.waitForElementVisibility(driver, dialogbox, 60);
					if (dialogbox.isDisplayed()) {
						driver.findElement(By.xpath("//div[@class='cdk-overlay-pane']//button[contains(text(),'OK')]"))
								.click();
					}
					
				}
			}
			
			if (execution.equalsIgnoreCase("Direct")) 
			{
				CommonActions.waitForElementClickable(driver, directHPchannel, 60);
				Thread.sleep(2000);
				if (directHPchannel.isDisplayed()){
					CommonActions.clickElementByJS(driver, directHPchannel);
				}
				Thread.sleep(2000);
				CommonActions.waitForElementClickable(driver, savebutton, 60);
				if (savebutton.isEnabled()) {
					CommonActions.scrollPageDown(driver);
					CommonActions.clickElementByJS(driver, savebutton);
				}
				Thread.sleep(2000);
				CommonActions.clickElementByJS(driver, subjecttextfield);
				subjecttextfield.sendKeys(randomsub);
				CommonActions.clickElementByJS(driver, desciptiontextfield);
				desciptiontextfield.sendKeys(randomdesc);
				CommonActions.waitForElementClickable(driver, keepMeInformedcheckbox, 60);
				CommonActions.clickElementByJS(driver, keepMeInformedcheckbox);
				CommonActions.waitForElementClickable(driver, attachmentbutton, 60);
				attachmentbutton.click();
				Thread.sleep(3000);
				//first attachment
				String directfileloc = System.getProperty("user.home") + File.separator + "workspace" + File.separator
						+ "Service_Center" + File.separator + "FileUpload2.exe";
				String pdffile = System.getProperty("user.home") + File.separator + "workspace" + File.separator
						+ "Service_Center" + File.separator + "AutoIt_File" + File.separator + "java_tutorial.pdf";
				Runtime.getRuntime().exec(directfileloc + " " + pdffile);
				Thread.sleep(3000);

				// second attachment
				CommonActions.waitForElementClickable(driver, attachmentbutton, 60);
				attachmentbutton.click();
				Thread.sleep(1000);
				String docfile = System.getProperty("user.home") + File.separator + "workspace" + File.separator
						+ "Service_Center" + File.separator + "AutoIt_File" + File.separator + "Control_Tower.docx";
				Runtime.getRuntime().exec(directfileloc + " " + docfile);
				Thread.sleep(3000);

				// third attachment
				CommonActions.waitForElementClickable(driver, attachmentbutton, 60);
				attachmentbutton.click();
				Thread.sleep(1000);
				String pngfile = System.getProperty("user.home") + File.separator + "workspace" + File.separator
						+ "Service_Center" + File.separator + "AutoIt_File" + File.separator + "maven.PNG";
				Runtime.getRuntime().exec(directfileloc + " " + pngfile);
				Thread.sleep(2000);
				CommonActions.waitForElementClickable(driver, submitbutton, 60);
				if (submitbutton.isEnabled()) {
					submitbutton.click();
				}
				CommonActions.pollingWait(driver, confirmationpopUp);
				String directcasepopupheader = popUpheading.getText();
				if (directcasepopupheader.contains("Case Request Submitted Successfully.")) {
					logger.log(LogStatus.PASS, "Direct Case created successfully with subject: " + randomsub
							+ " and description: " + randomdesc);
				}else {
					logger.log(LogStatus.FAIL,
							"Unable to create Direct Case with Subject: " + randomsub + "and Description" + randomdesc);
					Assert.fail("Unable to create a Direct Case");
				}

			} else if (execution.equalsIgnoreCase("Indirect"))
			{

				CommonActions.waitForElementClickable(driver, indirectchannel, 60);
				Thread.sleep(2000);
				if (indirectchannel.isDisplayed()) {
					CommonActions.clickElementByJS(driver, indirectchannel);
				}
				Thread.sleep(2000);
				CommonActions.clickElementByJS(driver, selectchannelarrow);

				// getting the list from dropdown
				List<WebElement> channelpartners = driver.findElements(
						By.xpath("//div[@class='mat-select-content ng-trigger ng-trigger-fadeInContent']//mat-option"));
				int size = channelpartners.size();
				int randomNumber = ThreadLocalRandom.current().nextInt(0, size);
				channelpartners.get(randomNumber).click();
				Thread.sleep(2000);
				CommonActions.waitForElementClickable(driver, savebutton, 60);
				if (savebutton.isEnabled()) {
					CommonActions.clickElementByJS(driver, savebutton);
				}
				Thread.sleep(1000);
				CommonActions.clickElementByJS(driver, subjecttextfield);
				subjecttextfield.sendKeys(randomsub);
				CommonActions.clickElementByJS(driver, desciptiontextfield);
				desciptiontextfield.sendKeys(randomdesc);
				CommonActions.waitForElementClickable(driver, attachmentbutton, 60);
				attachmentbutton.click();
				Thread.sleep(3000);
				// first attachment
				String indiectfileloc = System.getProperty("user.home") + File.separator + "workspace" + File.separator
						+ "Service_Center" + File.separator + "IndirectCaseFileUpload.exe";
				String png_file = System.getProperty("user.home") + File.separator + "workspace" + File.separator
						+ "Service_Center" + File.separator + "AutoIt_File" + File.separator + "maven.PNG";
				Thread.sleep(2000);
				Runtime.getRuntime().exec(indiectfileloc + " " + png_file);
				Thread.sleep(1000);
				CommonActions.waitForElementClickable(driver, submitbutton, 60);
				if (submitbutton.isEnabled()) {
					submitbutton.click();
				}

				CommonActions.pollingWait(driver, confirmationpopUp);
				String indirectcasepopupheader1 = popUpheading.getText();
				if (indirectcasepopupheader1.contains("Case created")) {
					//confirmationOKbutton.click();
					logger.log(LogStatus.PASS, "Indirect Case created successfully with subject: " + randomsub
							+ " and description " + randomdesc);
				}
				else {
					logger.log(LogStatus.FAIL, "Indirect Unable to create a case with subject: " + randomsub
							+ "and description " + randomdesc);
					Assert.fail("Unable to create a Indirect case");
				}
			}
		}

	// create case with pdf attachments
	public void createCaseWith_Pdf_Attachment(String execution, String SerialNum, String randomsub, String randomdesc,
			ExtentTest logger) throws Throwable 
	{
		CommonActions.pollingWait(driver, newCasebutton);
		newCasebutton.click();
		CommonActions.pollingWait(driver, pressimageWithSerialNumber);

		String totalpress = totalpressCount.getText();
		String trimmedtotalpressCount = totalpress.substring(5);
		int count = Integer.parseInt(trimmedtotalpressCount);

		for (int i = 1; i <= count; i++) 
		{
			String SN = pressimageWithSerialNumber.getText();
			if (SN.contains(SerialNum)) {
				logger.log(LogStatus.PASS, "Landed on Case Creation Page and Serial Number provided is matched");
				break;
			}

			else {
				rightarrowbutton.click();
				CommonActions.waitForElementVisibility(driver, dialogbox, 60);
				if (dialogbox.isDisplayed()) {
					driver.findElement(By.xpath("//div[@class='cdk-overlay-pane']//button[contains(text(),'OK')]"))
							.click();
				}
				// write code to handel "Service Centre currently do not allow
				// to create support case
			}
		}

		if (execution.equalsIgnoreCase("Direct"))
		{
			CommonActions.waitForElementClickable(driver, directHPchannel, 60);
			Thread.sleep(2000);
			if (directHPchannel.isDisplayed()) {
				CommonActions.clickElementByJS(driver, directHPchannel);
			}
			Thread.sleep(2000);
			CommonActions.waitForElementClickable(driver, savebutton, 60);
			if (savebutton.isEnabled()) {
				CommonActions.scrollPageDown(driver);
				CommonActions.clickElementByJS(driver, savebutton);
			}
			Thread.sleep(1000);
			CommonActions.clickElementByJS(driver, subjecttextfield);
			subjecttextfield.sendKeys(randomsub);
			CommonActions.clickElementByJS(driver, desciptiontextfield);
			desciptiontextfield.sendKeys(randomdesc);
			CommonActions.waitForElementClickable(driver, keepMeInformedcheckbox, 60);
			CommonActions.clickElementByJS(driver, keepMeInformedcheckbox);
			CommonActions.waitForElementClickable(driver, attachmentbutton, 60);
			attachmentbutton.click();
			Thread.sleep(3000);
			
			//pdf attachments
			String directfileloc = System.getProperty("user.home") + File.separator + "workspace" + File.separator
					+ "Service_Center" + File.separator + "FileUpload2.exe";
			String pdffile = System.getProperty("user.home") + File.separator + "workspace" + File.separator
					+ "Service_Center" + File.separator + "AutoIt_File" + File.separator + "java_tutorial.pdf";
			Runtime.getRuntime().exec(directfileloc + " " + pdffile);
			Thread.sleep(2000);
			CommonActions.waitForElementClickable(driver, submitbutton, 60);
			if (submitbutton.isEnabled()) {
				submitbutton.click();
			}
			CommonActions.pollingWait(driver, confirmationpopUp);
			String directcasepopupheader = popUpheading.getText();
			if (directcasepopupheader.contains("Case Request Submitted Successfully.")) {
				logger.log(LogStatus.PASS, "Direct Case created successfully with subject: " + randomsub
						+ " and description: " + randomdesc);
			} else {
				logger.log(LogStatus.FAIL,
						"Unable to create Direct Case with Subject: " + randomsub + "and Description" + randomdesc);
				Assert.fail("Unable to create a direct case");
			}

		} else if (execution.equalsIgnoreCase("Indirect"))
		{

			CommonActions.waitForElementClickable(driver, indirectchannel, 60);
			Thread.sleep(2000);
			if (indirectchannel.isDisplayed()) {
				CommonActions.clickElementByJS(driver, indirectchannel);
			}
			Thread.sleep(2000);
			CommonActions.clickElementByJS(driver, selectchannelarrow);

			// getting the list of channel partner from dropdown
			List<WebElement> channelpartners = driver.findElements(
					By.xpath("//div[@class='mat-select-content ng-trigger ng-trigger-fadeInContent']//mat-option"));
			int size = channelpartners.size();
			int randomNumber = ThreadLocalRandom.current().nextInt(0, size);
			channelpartners.get(randomNumber).click();
			Thread.sleep(2000);
			CommonActions.waitForElementClickable(driver, savebutton, 60);
			if (savebutton.isEnabled()) {
				CommonActions.clickElementByJS(driver, savebutton);
			}
			Thread.sleep(1000);
			CommonActions.clickElementByJS(driver, subjecttextfield);
			subjecttextfield.sendKeys(randomsub);
			CommonActions.clickElementByJS(driver, desciptiontextfield);
			desciptiontextfield.sendKeys(randomdesc);
			CommonActions.waitForElementClickable(driver, attachmentbutton, 60);
			attachmentbutton.click();
			Thread.sleep(3000);
			// first attachment
			String directfileloc = System.getProperty("user.home") + File.separator + "workspace" + File.separator
					+ "Service_Center" + File.separator + "FileUpload2.exe";
			String pdffile = System.getProperty("user.home") + File.separator + "workspace" + File.separator
					+ "Service_Center" + File.separator + "AutoIt_File" + File.separator + "java_tutorial.pdf";
			Runtime.getRuntime().exec(directfileloc + " " + pdffile);
			Thread.sleep(2000);
			CommonActions.waitForElementClickable(driver, submitbutton, 60);
			if (submitbutton.isEnabled()) {
				submitbutton.click();
			}

			CommonActions.pollingWait(driver, confirmationpopUp);
			String indirectcasepopupheader1 = popUpheading.getText();
			if (indirectcasepopupheader1.contains("Case created")) {
				logger.log(LogStatus.PASS, "Indirect Case created successfully with subject: " + randomsub
						+ " and description " + randomdesc);
			} else {
				logger.log(LogStatus.FAIL, "Indirect Unable to create a case with subject: " + randomsub
						+ "and description " + randomdesc);
				Assert.fail("Unable to create a indirect case");
			}

		}
		
	}
	
	
	// create case with jpeg attachments
	public void createCaseWith_jpeg_Attachment(String execution,String SerialNum, String randomsub, String randomdesc, ExtentTest logger)
			throws Throwable 
	{
		CommonActions.pollingWait(driver, newCasebutton);
		newCasebutton.click();
		CommonActions.pollingWait(driver, pressimageWithSerialNumber);
		
		
		
		String totalpress = totalpressCount.getText();
		String trimmedtotalpressCount = totalpress.substring(5);
		int count = Integer.parseInt(trimmedtotalpressCount);

		for (int i = 1; i <= count; i++) 
		{
			String SN = pressimageWithSerialNumber.getText();
			if (SN.contains(SerialNum)) {
				logger.log(LogStatus.PASS, "Landed on Case Creation Page and Serial Number provided is matched");
				break;
			}

			else {
				rightarrowbutton.click();
				CommonActions.waitForElementVisibility(driver, dialogbox, 60);
				if (dialogbox.isDisplayed()) {
					driver.findElement(By.xpath("//div[@class='cdk-overlay-pane']//button[contains(text(),'OK')]"))
							.click();
				}
				// write code to handel "Service Centre currently do not allow
				// to create support case
			}
		}
		
		
		if (execution.equalsIgnoreCase("Direct")) 
		{
			
			CommonActions.waitForElementClickable(driver, directHPchannel, 60);
			Thread.sleep(2000);
			if (directHPchannel.isDisplayed()) {
				CommonActions.clickElementByJS(driver, directHPchannel);
			}
			Thread.sleep(2000);
			CommonActions.waitForElementClickable(driver, savebutton, 60);
			if (savebutton.isEnabled()) {
				CommonActions.scrollPageDown(driver);
				CommonActions.clickElementByJS(driver, savebutton);
			}
			Thread.sleep(1000);
			CommonActions.clickElementByJS(driver, subjecttextfield);
			subjecttextfield.sendKeys(randomsub);
			CommonActions.clickElementByJS(driver, desciptiontextfield);
			desciptiontextfield.sendKeys(randomdesc);
			CommonActions.waitForElementClickable(driver, keepMeInformedcheckbox, 60);
			CommonActions.clickElementByJS(driver, keepMeInformedcheckbox);
			CommonActions.waitForElementClickable(driver, attachmentbutton, 60);
			attachmentbutton.click();
			Thread.sleep(3000);
			String directfileloc = System.getProperty("user.home") + File.separator + "workspace" + File.separator
					+ "Service_Center" + File.separator + "FileUpload2.exe";
			String jpgfile = System.getProperty("user.home") + File.separator + "workspace" + File.separator
					+ "Service_Center" + File.separator + "AutoIt_File" + File.separator + "poppy_flower_nature.jpg";
			Runtime.getRuntime().exec(directfileloc + " " + jpgfile);
			Thread.sleep(2000);
			CommonActions.waitForElementClickable(driver, submitbutton, 60);
			if (submitbutton.isEnabled()) {
				submitbutton.click();
			}
			CommonActions.pollingWait(driver, confirmationpopUp);
			String directcasepopupheader = popUpheading.getText();
			if (directcasepopupheader.contains("Case Request Submitted Successfully.")) {
				logger.log(LogStatus.PASS, "Direct Case created successfully with subject: " + randomsub
						+ " and description: " + randomdesc);
			} else {
				logger.log(LogStatus.FAIL,
						"Unable to create Direct Case with Subject: " + randomsub + "and Description" + randomdesc);
				Assert.fail("Unable to create a direct case");
			}

		} else if (execution.equalsIgnoreCase("Indirect"))
		{

			CommonActions.waitForElementClickable(driver, indirectchannel, 60);
			Thread.sleep(2000);
			if (indirectchannel.isDisplayed()) {
				CommonActions.clickElementByJS(driver, indirectchannel);
			}
			Thread.sleep(2000);
			CommonActions.clickElementByJS(driver, selectchannelarrow);

			// getting the list of channel partner from dropdown
			List<WebElement> channelpartners = driver.findElements(
					By.xpath("//div[@class='mat-select-content ng-trigger ng-trigger-fadeInContent']//mat-option"));
			int size = channelpartners.size();
			int randomNumber = ThreadLocalRandom.current().nextInt(0, size);
			channelpartners.get(randomNumber).click();
			// channeloption.click();
			Thread.sleep(2000);
			CommonActions.waitForElementClickable(driver, savebutton, 60);
			if (savebutton.isEnabled()) {
				CommonActions.clickElementByJS(driver, savebutton);
			}
			Thread.sleep(1000);
			CommonActions.clickElementByJS(driver, subjecttextfield);
			subjecttextfield.sendKeys(randomsub);
			CommonActions.clickElementByJS(driver, desciptiontextfield);
			desciptiontextfield.sendKeys(randomdesc);
			CommonActions.waitForElementClickable(driver, attachmentbutton, 60);
			attachmentbutton.click();
			Thread.sleep(3000);
			// first attachment
			String directfileloc = System.getProperty("user.home") + File.separator + "workspace" + File.separator
					+ "Service_Center" + File.separator + "FileUpload2.exe";
			String jpgfile = System.getProperty("user.home") + File.separator + "workspace" + File.separator
					+ "Service_Center" + File.separator + "AutoIt_File" + File.separator + "poppy_flower_nature.jpg";
			Runtime.getRuntime().exec(directfileloc + " " + jpgfile);
			Thread.sleep(2000);
			CommonActions.waitForElementClickable(driver, submitbutton, 60);
			if (submitbutton.isEnabled()) {
				submitbutton.click();
			}

			CommonActions.pollingWait(driver, confirmationpopUp);
			String indirectcasepopupheader1 = popUpheading.getText();
			if (indirectcasepopupheader1.contains("Case created")) {
				logger.log(LogStatus.PASS, "Indirect Case created successfully with subject: " + randomsub
						+ " and description " + randomdesc);
			} else {
				logger.log(LogStatus.FAIL, "Indirect Unable to create a case with subject: " + randomsub
						+ "and description " + randomdesc);
				Assert.fail("Unable to create a indirect case");
			}

		}


	}
	
	
	// create case with text attachments
	public void createCaseWith_text_Attachment(String execution, String SerialNum,String randomsub, String randomdesc, ExtentTest logger)
			throws Throwable {
		CommonActions.pollingWait(driver, newCasebutton);
		newCasebutton.click();
		CommonActions.pollingWait(driver, pressimageWithSerialNumber);
		
		
		
		String totalpress = totalpressCount.getText();
		String trimmedtotalpressCount = totalpress.substring(5);
		int count = Integer.parseInt(trimmedtotalpressCount);

		for (int i = 1; i <= count; i++) 
		{
			String SN = pressimageWithSerialNumber.getText();
			if (SN.contains(SerialNum)) {
				logger.log(LogStatus.PASS, "Landed on Case Creation Page and Serial Number provided is matched");
				break;
			}

			else {
				rightarrowbutton.click();
				CommonActions.waitForElementVisibility(driver, dialogbox, 60);
				if (dialogbox.isDisplayed()) {
					driver.findElement(By.xpath("//div[@class='cdk-overlay-pane']//button[contains(text(),'OK')]"))
							.click();
				}
				// write code to handel "Service Centre currently do not allow
				// to create support case
			}
		}
		
		if (execution.equalsIgnoreCase("Direct"))
		{
			
			CommonActions.waitForElementClickable(driver, directHPchannel, 60);
			Thread.sleep(2000);
			if (directHPchannel.isDisplayed()) {
				CommonActions.clickElementByJS(driver, directHPchannel);
			}
			Thread.sleep(2000);
			CommonActions.waitForElementClickable(driver, savebutton, 60);
			if (savebutton.isEnabled()) {
				CommonActions.scrollPageDown(driver);
				CommonActions.clickElementByJS(driver, savebutton);
			}
			Thread.sleep(1000);
			CommonActions.clickElementByJS(driver, subjecttextfield);
			subjecttextfield.sendKeys(randomsub);
			CommonActions.clickElementByJS(driver, desciptiontextfield);
			desciptiontextfield.sendKeys(randomdesc);
			CommonActions.waitForElementClickable(driver, keepMeInformedcheckbox, 60);
			CommonActions.clickElementByJS(driver, keepMeInformedcheckbox);
			CommonActions.waitForElementClickable(driver, attachmentbutton, 60);
			attachmentbutton.click();
			Thread.sleep(3000);
			String directfileloc = System.getProperty("user.home") + File.separator + "workspace" + File.separator
					+ "Service_Center" + File.separator + "FileUpload2.exe";
			String textfile = System.getProperty("user.home") + File.separator + "workspace" + File.separator
					+ "Service_Center" + File.separator + "AutoIt_File" + File.separator +"Follow_up.txt";
			Runtime.getRuntime().exec(directfileloc + " " + textfile);
			Thread.sleep(2000);
			CommonActions.waitForElementClickable(driver, submitbutton, 60);
			if (submitbutton.isEnabled()) {
				Thread.sleep(2000);
				submitbutton.click();
			}
			CommonActions.pollingWait(driver, confirmationpopUp);
			String directcasepopupheader = popUpheading.getText();
			if (directcasepopupheader.contains("Case Request Submitted Successfully.")) {
				logger.log(LogStatus.PASS, "Direct Case created successfully with subject: " + randomsub
						+ " and description: " + randomdesc);
			} else {
				logger.log(LogStatus.FAIL,
						"Unable to create Direct Case with Subject: " + randomsub + "and Description" + randomdesc);
				Assert.fail("Unable to create a direct case");
			}

		} else if (execution.equalsIgnoreCase("Indirect")) {

			CommonActions.waitForElementClickable(driver, indirectchannel, 60);
			Thread.sleep(2000);
			if (indirectchannel.isDisplayed()) {
				CommonActions.clickElementByJS(driver, indirectchannel);
			}
			Thread.sleep(2000);
			CommonActions.clickElementByJS(driver, selectchannelarrow);

			// selecting random data from dropdown and performing actions
			List<WebElement> channelpartners = driver.findElements(
					By.xpath("//div[@class='mat-select-content ng-trigger ng-trigger-fadeInContent']//mat-option"));
			int size = channelpartners.size();
			int randomNumber = ThreadLocalRandom.current().nextInt(0, size);
			channelpartners.get(randomNumber).click();
			// channeloption.click();
			Thread.sleep(2000);
			CommonActions.waitForElementClickable(driver, savebutton, 60);
			if (savebutton.isEnabled()) {
				CommonActions.clickElementByJS(driver, savebutton);
			}
			Thread.sleep(1000);
			CommonActions.clickElementByJS(driver, subjecttextfield);
			subjecttextfield.sendKeys(randomsub);
			CommonActions.clickElementByJS(driver, desciptiontextfield);
			desciptiontextfield.sendKeys(randomdesc);
			CommonActions.waitForElementClickable(driver, attachmentbutton, 60);
			attachmentbutton.click();
			Thread.sleep(3000);
			// first attachment
			String directfileloc = System.getProperty("user.home") + File.separator + "workspace" + File.separator
					+ "Service_Center" + File.separator + "FileUpload2.exe";
			String textfile = System.getProperty("user.home") + File.separator + "workspace" + File.separator
					+ "Service_Center" + File.separator + "AutoIt_File" + File.separator + "maven.PNG";
			Runtime.getRuntime().exec(directfileloc + " " + textfile);
			Thread.sleep(2000);
			CommonActions.waitForElementClickable(driver, submitbutton, 60);
			if (submitbutton.isEnabled()) {
				Thread.sleep(2000);
				submitbutton.click();
			}

			CommonActions.pollingWait(driver, confirmationpopUp);
			String indirectcasepopupheader1 = popUpheading.getText();
			if (indirectcasepopupheader1.contains("Case created")) {
				logger.log(LogStatus.PASS, "Indirect Case created successfully with subject: " + randomsub
						+ " and description " + randomdesc);
			} else {
				logger.log(LogStatus.FAIL, "Indirect Unable to create a case with subject: " + randomsub
						+ "and description " + randomdesc);
				Assert.fail("Unable to create a indirect case");
			}

		}

	}
	
	
	
	// create case with attachments of size 3MB
	public void createCaseWith_3MB_FileAttachment(String execution,String SerialNum, String randomsub, String randomdesc,
			ExtentTest logger) throws Throwable {
		CommonActions.pollingWait(driver, newCasebutton);
		newCasebutton.click();
		CommonActions.pollingWait(driver, pressimageWithSerialNumber);
		String totalpress = totalpressCount.getText();
		String trimmedtotalpressCount = totalpress.substring(5);
		int count = Integer.parseInt(trimmedtotalpressCount);

		for (int i = 1; i <= count; i++) 
		{
			String SN = pressimageWithSerialNumber.getText();
			if (SN.contains(SerialNum)) {
				logger.log(LogStatus.PASS, "Landed on Case Creation Page and Serial Number provided is matched");
				break;
			}

			else {
				rightarrowbutton.click();
				CommonActions.waitForElementVisibility(driver, dialogbox, 60);
				if (dialogbox.isDisplayed()) {
					driver.findElement(By.xpath("//div[@class='cdk-overlay-pane']//button[contains(text(),'OK')]"))
							.click();
				}
				// write code to handel "Service Centre currently do not allow
				// to create support case
			}
		}
		
		if (execution.equalsIgnoreCase("Direct")) 
		{
			
			CommonActions.waitForElementClickable(driver, directHPchannel, 60);
			Thread.sleep(2000);
			if (directHPchannel.isDisplayed()) {
				CommonActions.clickElementByJS(driver, directHPchannel);
			}
			Thread.sleep(2000);
			CommonActions.waitForElementClickable(driver, savebutton, 60);
			if (savebutton.isEnabled()) {
				CommonActions.scrollPageDown(driver);
				CommonActions.clickElementByJS(driver, savebutton);
			}
			Thread.sleep(1000);
			CommonActions.clickElementByJS(driver, subjecttextfield);
			subjecttextfield.sendKeys(randomsub);
			CommonActions.clickElementByJS(driver, desciptiontextfield);
			desciptiontextfield.sendKeys(randomdesc);
			CommonActions.waitForElementClickable(driver, keepMeInformedcheckbox, 60);
			CommonActions.clickElementByJS(driver, keepMeInformedcheckbox);
			CommonActions.waitForElementClickable(driver, attachmentbutton, 60);
			attachmentbutton.click();
			Thread.sleep(3000);
			String directfileloc = System.getProperty("user.home") + File.separator + "workspace" + File.separator
					+ "Service_Center" + File.separator + "FileUpload2.exe";
			String pdffile = System.getProperty("user.home") + File.separator + "workspace" + File.separator
					+ "Service_Center" + File.separator + "AutoIt_File" + File.separator + "USA_latest.pdf";
			Runtime.getRuntime().exec(directfileloc + " " + pdffile);
			Thread.sleep(2000);
			CommonActions.pollingWait(driver, confirmationpopUp);
			String directcasepopupheader = popUpheading.getText();
			
			if (directcasepopupheader.contains("File Size Error")) {
				errorpopOKbtn.click();
				logger.log(LogStatus.PASS, "Unable to upload a file of size more than 3MB. Please upload file of size less than 3MB.");
			} else {
				logger.log(LogStatus.FAIL,
						"Please upload file of size less than 3MB");
				Assert.fail("Please upload file of size less than 3MB");
			}

		} else if (execution.equalsIgnoreCase("Indirect")) 
		{

			CommonActions.waitForElementClickable(driver, indirectchannel, 60);
			Thread.sleep(2000);
			if (indirectchannel.isDisplayed()) {
				CommonActions.clickElementByJS(driver, indirectchannel);
			}
			Thread.sleep(2000);
			CommonActions.clickElementByJS(driver, selectchannelarrow);

			// getting the list of channel partner from dropdown
			List<WebElement> channelpartners = driver.findElements(
					By.xpath("//div[@class='mat-select-content ng-trigger ng-trigger-fadeInContent']//mat-option"));
			int size = channelpartners.size();
			int randomNumber = ThreadLocalRandom.current().nextInt(0, size);
			channelpartners.get(randomNumber).click();
			// channeloption.click();
			Thread.sleep(2000);
			CommonActions.waitForElementClickable(driver, savebutton, 60);
			if (savebutton.isEnabled()) {
				CommonActions.clickElementByJS(driver, savebutton);
			}
			Thread.sleep(1000);
			CommonActions.clickElementByJS(driver, subjecttextfield);
			subjecttextfield.sendKeys(randomsub);
			CommonActions.clickElementByJS(driver, desciptiontextfield);
			desciptiontextfield.sendKeys(randomdesc);
			CommonActions.waitForElementClickable(driver, attachmentbutton, 60);
			attachmentbutton.click();
			Thread.sleep(3000);
			// first attachment
			String directfileloc = System.getProperty("user.home") + File.separator + "workspace" + File.separator
					+ "Service_Center" + File.separator + "FileUpload2.exe";
			String pdffile = System.getProperty("user.home") + File.separator + "workspace" + File.separator
					+ "Service_Center" + File.separator + "AutoIt_File" + File.separator + "USA_latest.pdf";
			Runtime.getRuntime().exec(directfileloc + " " + pdffile);
			Thread.sleep(2000);
			
			CommonActions.pollingWait(driver, confirmationpopUp);
			String indirectcasepopupheader1 = popUpheading.getText();
			if (indirectcasepopupheader1.contains("File Size Error")) {
				errorpopOKbtn.click();
				logger.log(LogStatus.PASS, "Unable to upload a file of size more than 3MB. Please upload file of size less than 3MB.");
			} else {
				logger.log(LogStatus.FAIL, "Please upload file of size less than 3MB");
				Assert.fail("Please upload file of size less than 3MB");
			}

		}
	}
	
	// retrieve case with multiple attachments
	public void retrievCaseWith_MultipleAttachments(String execution, String sub1, String desc1, ExtentTest logger)
			throws Throwable {
		if (execution.equalsIgnoreCase("Direct")) {
			String message = popmessage();
			if (message.contains("Case Request Submitted Successfully.")) {
				handelDirectCasecreationpopUp();
				String Case_Id = dbquery.getnewCaseID(sub1, desc1, logger);
				System.out.println("Case ID passed is :" + Case_Id);
				Thread.sleep(3000);
				CommonActions.pollingWait(driver, quickFilter);
				CommonActions.waitForElementClickable(driver, quickFilter, 60);
				CommonActions.clickElementByJS(driver, quickFilter);
				quickFilter.sendKeys(Case_Id);
				Thread.sleep(1000);
				driver.navigate().refresh();
				Thread.sleep(3000);
				CommonActions.pollingWait(driver, quickFilter);
				CommonActions.waitForElementClickable(driver, quickFilter, 60);
				CommonActions.clickElementByJS(driver, quickFilter);
				quickFilter.sendKeys(Case_Id);
				Thread.sleep(2000);
				if (case_id.isDisplayed()) {
					Actions actions = new Actions(driver);
					actions.moveToElement(case_id);
					Thread.sleep(1000);
					actions.click();
					actions.build().perform();
				}
				CommonActions.waitForElementVisibility(driver, casedetail, 60);
				String directcaseidnumber = casedetail.getText();
				if (directcaseidnumber.contains(Case_Id)) {
					logger.log(LogStatus.PASS, "Case retrieved successfully and caseId is: " + Case_Id);
				} else {
					logger.log(LogStatus.FAIL, "Unable to retrieve a case");
					Assert.fail("Unable to retrieve a case");
				}
			} else if (message.contains("Error Occurred")) {
				handelerrorpopUp();
			}

		}

		else if (execution.equalsIgnoreCase("Indirect")) {

			String message2 = popmessage();
			if (message2.contains("Case created")) {
				String result = handelIndirectCasecreationpopUp();
				CommonActions.pollingWait(driver, quickFilter);
				CommonActions.waitForElementClickable(driver, quickFilter, 60);
				CommonActions.clickElementByJS(driver, quickFilter);
				quickFilter.sendKeys(result);
				Thread.sleep(2000);
				if (case_id.isDisplayed()) {
					// Point point = case_id.getLocation();
					// int x_offset = point.getX();
					// int y_offset = point.getY();
					Actions actions = new Actions(driver);
					// actions.moveToElement(caseid);
					actions.moveToElement(case_id);
					Thread.sleep(1000);
					actions.click().build().perform();

				}

				CommonActions.waitForElementVisibility(driver, casedetail, 60);
				String indirectcaseidnumber = casedetail.getText();
				if (indirectcaseidnumber.contains(result)) {
					logger.log(LogStatus.PASS, "Case retrieved successfully and caseId is: " + result);
				} else {
					logger.log(LogStatus.FAIL, "Unable to retrieve case");
					Assert.fail("Unable to retrieve case");
				}
			} else if (message2.contains("Error Occurred")) {
				handelerrorpopUp();
			}

		}

	}

	// retrieve case with pdf attachment
	public void retrieveCaseWith_Pdf_Attachment(String execution, String sub1, String desc1, ExtentTest logger)
			throws Throwable {
		if (execution.equalsIgnoreCase("Direct")) {
			String message = popmessage();
			if (message.contains("Case Request Submitted Successfully.")) {
				handelDirectCasecreationpopUp();
				String Case_Id = dbquery.getnewCaseID(sub1, desc1, logger);
				System.out.println("Case ID passed is :" + Case_Id);
				Thread.sleep(3000);
				CommonActions.pollingWait(driver, quickFilter);
				CommonActions.waitForElementClickable(driver, quickFilter, 60);
				CommonActions.clickElementByJS(driver, quickFilter);
				quickFilter.sendKeys(Case_Id);
				Thread.sleep(1000);
				driver.navigate().refresh();
				Thread.sleep(3000);
				CommonActions.pollingWait(driver, quickFilter);
				CommonActions.waitForElementClickable(driver, quickFilter, 60);
				CommonActions.clickElementByJS(driver, quickFilter);
				quickFilter.sendKeys(Case_Id);
				Thread.sleep(1000);
				if (case_id.isDisplayed()) {
					Actions actions = new Actions(driver);
					actions.moveToElement(case_id);

					Thread.sleep(1000);
					actions.click();
					actions.build().perform();
				}
				CommonActions.waitForElementVisibility(driver, casedetail, 60);
				String directcaseidnumber = casedetail.getText();
				if (directcaseidnumber.contains(Case_Id)) {
					logger.log(LogStatus.PASS, "Case retrieved successfully and caseId is: " + Case_Id);
				} else {
					logger.log(LogStatus.FAIL, "Unable to retrieve case");
				}
			} else if (message.contains("Error Occurred")) {
				handelerrorpopUp();
			}

		}

		else if (execution.equalsIgnoreCase("Indirect")) {

			String message2 = popmessage();
			if (message2.contains("Case created")) {
				String result = handelIndirectCasecreationpopUp();
				CommonActions.pollingWait(driver, quickFilter);
				CommonActions.waitForElementClickable(driver, quickFilter, 60);
				CommonActions.clickElementByJS(driver, quickFilter);
				quickFilter.sendKeys(result);
				if (case_id.isDisplayed()) {
					Actions actions = new Actions(driver);
					actions.moveToElement(case_id);
					Thread.sleep(1000);
					actions.click();
					actions.build().perform();
				}
				CommonActions.waitForElementVisibility(driver, casedetail, 60);
				String indirectcaseidnumber = casedetail.getText();
				if (indirectcaseidnumber.contains(result)) {
					logger.log(LogStatus.PASS, "Case retrieved successfully and caseId is: " + result);
				} else {
					logger.log(LogStatus.FAIL, "Unable to retrieve a case");
				}
			} else if (message2.contains("Error Occurred")) {
				handelerrorpopUp();
			}

		}
	}


	// retrieve case with jpeg attachment
	public void retrieveCaseWith_jpeg_Attachment(String execution, String sub1, String desc1, ExtentTest logger)
			throws Throwable {
		if (execution.equalsIgnoreCase("Direct")) {
			String message = popmessage();
			if (message.contains("Case Request Submitted Successfully.")) {
				handelDirectCasecreationpopUp();
				String Case_Id = dbquery.getnewCaseID(sub1, desc1, logger);
				System.out.println("Case ID passed is :" + Case_Id);
				Thread.sleep(3000);
				CommonActions.pollingWait(driver, quickFilter);
				CommonActions.waitForElementClickable(driver, quickFilter, 60);
				CommonActions.clickElementByJS(driver, quickFilter);
				quickFilter.sendKeys(Case_Id);
				Thread.sleep(1000);
				driver.navigate().refresh();
				Thread.sleep(3000);
				CommonActions.pollingWait(driver, quickFilter);
				CommonActions.waitForElementClickable(driver, quickFilter, 60);
				CommonActions.clickElementByJS(driver, quickFilter);
				quickFilter.sendKeys(Case_Id);
				Thread.sleep(1000);
				if (case_id.isDisplayed()) {
					Actions actions = new Actions(driver);
					actions.moveToElement(case_id);
					Thread.sleep(1000);
					actions.click();
					actions.build().perform();
				}

				CommonActions.pollingWait(driver, casedetail);
				String directcaseidnumber = casedetail.getText();
				if (directcaseidnumber.contains(Case_Id)) {
					logger.log(LogStatus.PASS, "Case retrieved successfully and caseId is: " + Case_Id);
				} else {
					logger.log(LogStatus.FAIL, "Unable to retrieve a case");
					Assert.fail("Unable to retrieve a case");
				}
			} else if (message.contains("Error Occurred")) {
				handelerrorpopUp();
			}

		}

		else if (execution.equalsIgnoreCase("Indirect")) {

			String message2 = popmessage();
			if (message2.contains("Case created")) {
				String result = handelIndirectCasecreationpopUp();
				CommonActions.pollingWait(driver, quickFilter);
				CommonActions.waitForElementClickable(driver, quickFilter, 60);
				CommonActions.clickElementByJS(driver, quickFilter);
				quickFilter.sendKeys(result);
				if (case_id.isDisplayed()) {
					Actions actions = new Actions(driver);
					actions.moveToElement(case_id);
					Thread.sleep(1000);
					actions.click();
					actions.build().perform();
				}

				CommonActions.pollingWait(driver, casedetail);
				String indirectcaseidnumber = casedetail.getText();
				if (indirectcaseidnumber.contains(result)) {
					logger.log(LogStatus.PASS, "Case retrieved successfully and caseId is: " + result);
				} else {
					logger.log(LogStatus.FAIL, "Unable to retrieve a case");
					Assert.fail("Unable to retrieve a case");
				}
			} else if (message2.contains("Error Occurred")) {
				handelerrorpopUp();
			}

		}
	}



	// retrieve case with text attachment
	public void retrieveCaseWith_text_Attachment(String execution, String sub1, String desc1, ExtentTest logger)
			throws Throwable {
		if (execution.equalsIgnoreCase("Direct")) {
			String message = popmessage();
			if (message.contains("Case Request Submitted Successfully.")) {
				handelDirectCasecreationpopUp();
				String Case_Id = dbquery.getnewCaseID(sub1, desc1, logger);
				System.out.println("Case ID passed is :" + Case_Id);
				Thread.sleep(3000);
				CommonActions.pollingWait(driver, quickFilter);
				CommonActions.waitForElementClickable(driver, quickFilter, 60);
				CommonActions.clickElementByJS(driver, quickFilter);
				quickFilter.sendKeys(Case_Id);
				Thread.sleep(1000);
				driver.navigate().refresh();
				Thread.sleep(3000);
				CommonActions.pollingWait(driver, quickFilter);
				CommonActions.waitForElementClickable(driver, quickFilter, 60);
				CommonActions.clickElementByJS(driver, quickFilter);
				quickFilter.sendKeys(Case_Id);
				Thread.sleep(1000);
				if (case_id.isDisplayed()) {
					Actions actions = new Actions(driver);
					actions.moveToElement(case_id);
					Thread.sleep(1000);
					actions.click();
					actions.build().perform();
				}

				CommonActions.pollingWait(driver, casedetail);
				String directcaseidnumber = casedetail.getText();
				if (directcaseidnumber.contains(Case_Id)) {
					logger.log(LogStatus.PASS, "Case retrieved successfully and caseId is: " + Case_Id);
				} else {
					logger.log(LogStatus.FAIL, "Unable to retrieve a case");
					Assert.fail("Unable to retrieve a case");
				}
			} else if (message.contains("Error Occurred")) {
				handelerrorpopUp();
			}

		}

		else if (execution.equalsIgnoreCase("Indirect")) {

			String message2 = popmessage();
			if (message2.contains("Case created")) {
				String result = handelIndirectCasecreationpopUp();
				CommonActions.pollingWait(driver, quickFilter);
				CommonActions.waitForElementClickable(driver, quickFilter, 60);
				CommonActions.clickElementByJS(driver, quickFilter);
				quickFilter.sendKeys(result);
				if (case_id.isDisplayed()) {
					Actions actions = new Actions(driver);
					actions.moveToElement(case_id);
					Thread.sleep(1000);
					actions.click();
					actions.build().perform();
				}

				CommonActions.pollingWait(driver, casedetail);
				String indirectcaseidnumber = casedetail.getText();
				if (indirectcaseidnumber.contains(result)) {
					logger.log(LogStatus.PASS, "Case retrieved successfully and caseId is: " + result);
				} else {
					logger.log(LogStatus.FAIL, "Unale to retrieve a case");
					Assert.fail("Unale to retrieve a case");
				}
			} else if (message2.contains("Error Occurred")) {
				handelerrorpopUp();
			}

		}
	}



	public String popmessage() {
		String msg = null;
		CommonActions.pollingWait(driver, confirmationpopUp);
		if (confirmationpopUp.isDisplayed()) {
			msg = popUpheading.getText();
		}
		return msg;
	}

	public void handelDirectCasecreationpopUp() throws InterruptedException {
		String directcasepopupheading = null;
		CommonActions.pollingWait(driver, confirmationpopUp);
		if (confirmationpopUp.isDisplayed()) {
			Thread.sleep(1000);
			directcasepopupheading = popUpheading.getText();
			if (directcasepopupheading.contains("Case Request Submitted Successfully.")) {
				String text1 = confirmationpopUppara.getText();
				System.out.println(text1);
				confirmationOKbutton.click();
			}
		}
	}

	public String handelIndirectCasecreationpopUp() throws InterruptedException {
		String trimmedCaseId = "";
		String Id = "";
		CommonActions.pollingWait(driver, confirmationpopUp);
		if (confirmationpopUp.isDisplayed()) {
			Thread.sleep(1000);
			String indirectcasepopupheader = popUpheading.getText();
			if (indirectcasepopupheader.contains("Case created")) {
				String text2 = confirmationpopUppara.getText();
				System.out.println(text2);
				trimmedCaseId = text2.substring(73);
				System.out.println(trimmedCaseId);
				Id = trimmedCaseId;
				confirmationOKbutton.click();
			}
		}
		return Id;
	}

	public void handelerrorpopUp() throws InterruptedException {
		CommonActions.pollingWait(driver, confirmationpopUp);
		if (confirmationpopUp.isDisplayed()) {
			Thread.sleep(1000);
			String directcasepopupheading = popUpheading.getText();
			if (directcasepopupheading.contains("Error Occurred")) {
				String text3 = confirmationpopUppara.getText();
				System.out.println(text3);
				confirmationOKbutton.click();
				Assert.fail("Case is not created.Getting error occured pop up");
			}
		}
	}

	public void addcaseNotes(String addnotes, ExtentTest logger) throws Throwable {
		Thread.sleep(1000);
		CommonActions.pollingWait(driver, file_notes);
		file_notes.click();
		CommonActions.pollingWait(driver, add_note);
		CommonActions.waitForElementClickable(driver, add_note, 60);
		Thread.sleep(1000);
		add_note.click();
		CommonActions.waitForElementVisibility(driver, add_note_popup, 60);
		if (add_note_popup.isDisplayed()) {
			CommonActions.clickElementByJS(driver, enter_note);
			enter_note.sendKeys(addnotes);
			Thread.sleep(1000);
			if (add_note_btn.isEnabled()) {
				Thread.sleep(1000);
				add_note_btn.click();
			}
		}
		CommonActions.pollingWait(driver, add_note_confirmation_popup);
		Thread.sleep(1000);
		if (add_note_confirmation_popup.isDisplayed()) {
			String addnotepop_message = addnote_pop_message.getText();
			if (addnotepop_message.contains("Update Case Error")) {
				logger.log(LogStatus.FAIL, "There was an error in updating the case");
				CommonActions.clickElementByJS(driver, add_note_confirmation_popup_OkBtn);
				Assert.fail();
			} else {
				Thread.sleep(1000);
				logger.log(LogStatus.PASS, "Case updated successfully and added case note is: " + addnotes);
				CommonActions.clickElementByJS(driver, add_note_confirmation_popup_OkBtn);
			}

		} else {
			logger.log(LogStatus.FAIL, "Add Note Confirmation pop up is not displayed");
			Assert.fail();
		}

		// add code to attach more file here//
		driver.navigate().refresh();

	}

	public void notes_exceedingWord_limit(String addnotes, ExtentTest logger) throws Throwable {
		Thread.sleep(1000);
		CommonActions.pollingWait(driver, file_notes);
		file_notes.click();
		CommonActions.pollingWait(driver, add_note);
		CommonActions.waitForElementClickable(driver, add_note, 60);
		Thread.sleep(1000);
		add_note.click();
		CommonActions.waitForElementVisibility(driver, add_note_popup, 60);
		if (add_note_popup.isDisplayed()) {
			CommonActions.clickElementByJS(driver, enter_note);
			enter_note.sendKeys(addnotes);
			// String message = notesmessage.getText();
			if (notesmessage.isDisplayed())
			// if (message.contains("Note should not exceed 5000 characters"))
			{
				logger.log(LogStatus.PASS, "Notes  accepting only 5000 characters");
				Thread.sleep(1000);
				cancel_note_btn.click();
			} else {
				logger.log(LogStatus.FAIL, "Notes should accept only 5000 characters");
				Thread.sleep(1000);
				cancel_note_btn.click();
			}
		}

	}

	public void retrieveNotesAndAttachments(String execution, ExtentTest logger) throws InterruptedException {
		ExtentTest ExtentTest;
		if (execution.equalsIgnoreCase("Direct")) {
			CommonActions.waitForElementVisibility(driver, file_notes, 60);
			if (file_notes.isDisplayed()) {
				file_notes.click();
			}
			Thread.sleep(1000);
			int count = 4;
			int mexretrycount = 1;
			CommonActions.waitForElementVisibility(driver, refresh_btn, 60);
			refresh_btn.click();
			Thread.sleep(2000);
			List<WebElement> eles = driver
					.findElements(By.xpath("//ul[@class='case-notes-container ng-star-inserted']/li"));
			while (!(eles.size() == count)) {
				eles.removeAll(eles);
				CommonActions.pollingWait(driver, refresh_btn);
				refresh_btn.click();
				Thread.sleep(15000);
				eles = driver.findElements(By.xpath("//ul[@class='case-notes-container ng-star-inserted']/li"));
				mexretrycount++;
				if (mexretrycount == 17) {
					logger.log(LogStatus.FAIL, "Case Notes is not retrieved within 10 minutes");
					break;
				}
			}
			CommonActions.pollingWait(driver, pngattachments);
			if (pngattachments.isDisplayed()) {
				logger.log(LogStatus.PASS, "Case Note and Attachments are present");
			} else {
				logger.log(LogStatus.FAIL, "Attachments are not present");
				Assert.fail();
			}
			CommonActions.pollingWait(driver, pdfattachments);
			pdfattachments.click();
			Thread.sleep(5000);
			validate_Downloaded_File("java_tutorial", ".pdf", logger);
			delete_Downloaded_file("java_tutorial", ".pdf", logger);
			Thread.sleep(2000);
			docattachments.click();
			Thread.sleep(5000);
			validate_Downloaded_File("Control_Tower", ".docx", logger);
			delete_Downloaded_file("Control_Tower", ".docx", logger);
			Thread.sleep(2000);
			pngattachments.click();
			Thread.sleep(5000);
			validate_Downloaded_File("maven", ".PNG", logger);
			delete_Downloaded_file("maven", ".PNG", logger);
			Thread.sleep(2000);
			CommonActions.waitForElementClickable(driver, update_case_done_Btn, 60);
			update_case_done_Btn.click();

		}

		if (execution.equalsIgnoreCase("Indirect")) {

			CommonActions.waitForElementVisibility(driver, file_notes, 60);
			if (file_notes.isDisplayed()) {
				file_notes.click();
			}
			Thread.sleep(1000);
			int count = 2;
			int maxretrycount = 1;
			CommonActions.waitForElementVisibility(driver, refresh_btn, 60);
			refresh_btn.click();
			Thread.sleep(2000);
			List<WebElement> eles = driver
					.findElements(By.xpath("//ul[@class='case-notes-container ng-star-inserted']/li"));
			while (!(eles.size() == count)) {
				eles.removeAll(eles);
				CommonActions.pollingWait(driver, refresh_btn);
				refresh_btn.click();
				Thread.sleep(13000);
				eles = driver.findElements(By.xpath("//ul[@class='case-notes-container ng-star-inserted']/li"));
				maxretrycount++;
				if (maxretrycount == 12) {
					logger.log(LogStatus.FAIL, "Case Notes is not retrieved within 10 minutes");
					break;
				}
			}
			CommonActions.pollingWait(driver, indirectpngattachments);
			if (indirectpngattachments.isDisplayed()) {
				logger.log(LogStatus.PASS, "Case Note and Case Attachments are present");
			} else {
				logger.log(LogStatus.FAIL, "Attachments are not present");
				Assert.fail();
			}
			Thread.sleep(1000);
			CommonActions.pollingWait(driver, indirectpngattachments);
			indirectpngattachments.click();
			Thread.sleep(6000);
			validate_Downloaded_File("maven", ".PNG", logger);
			delete_Downloaded_file("maven", ".PNG", logger);
			Thread.sleep(2000);
			CommonActions.clickElementByJS(driver, update_case_done_Btn);

		}

	}

	// method to validate the downloaded file
	public void validate_Downloaded_File(String filename, String extension, ExtentTest logger)
			throws InterruptedException {
		String homepath = System.getProperty("user.home");
		String completefilename = homepath + File.separator + "Downloads" + File.separator + filename + extension;
		File file = new File(completefilename);
		if (file.exists()) {
			logger.log(LogStatus.PASS, "File Downloaded successfully is :" + filename + extension);
		} else {
			logger.log(LogStatus.FAIL, "Unable to Download the file: " + filename + extension);
		}
	}

	// method to delete the downloaded file
	public void delete_Downloaded_file(String filename, String extension, ExtentTest logger) {
		String homepath = System.getProperty("user.home");
		String completefilename = homepath + File.separator + "Downloads" + File.separator + filename + extension;
		System.out.println(completefilename);
		File file = new File(completefilename);
		if (file.exists()) {
			System.out.println("file exist");
			file.delete();
			logger.log(LogStatus.PASS, "Deleted the file successfully: " + filename + extension);
		} else {
			logger.log(LogStatus.FAIL, "FIle do not exist");
		}
	}

	// ####....validation method....####
	public void validationswithXpath(WebElement elementXpathToBeValidated, String Message, ExtentTest logger) {
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(elementXpathToBeValidated.isDisplayed(), true);
		if (elementXpathToBeValidated.isDisplayed()) {
			logger.log(LogStatus.PASS, Message + " is successful");
			Reporter.log(Message + " is successful");
		} else {
			logger.log(LogStatus.FAIL, Message + " is not successful");
			Reporter.log(Message + " is not successful");
		}
		softAssert.assertAll();
	}

	// method to get the character from property file
	public ArrayList<String> getPropertyArray(String propertyfilekey) throws IOException {

		ArrayList<String> valueList = new ArrayList<String>();
		fis = new FileInputStream(inputdatapath);
		prop = new Properties();
		prop.load(fis);
		String inputdata = prop.getProperty(propertyfilekey);
		if (inputdata != null) {
			StringTokenizer st = new StringTokenizer(inputdata, ",");
			while (st.hasMoreTokens())
				valueList.add(st.nextToken().trim());
		}
		return valueList;
	}

	// method to get 5000 character case notes
	public String getCaseNoteData() throws IOException {
		FileReader filereader = new FileReader(casenotespath);
		BufferedReader bufferedreader = new BufferedReader(filereader);
		String notetext = "";
		String line = bufferedreader.readLine();
		while (line != null) {
			notetext += line;
			line = bufferedreader.readLine();
		}
		return notetext;
	}

	// method to get the subject
	public String getSubject(String subkey) throws Throwable {
		pem = new PageElements_Methods(driver);
		ArrayList<String> subject = pem.getPropertyArray(subkey);
		Random random = new Random();
		int a1 = random.nextInt(subject.size());
		int a2 = random.nextInt(subject.size());
		int a3 = random.nextInt(subject.size());
		int a4 = random.nextInt(subject.size());
		String randomsubjectfield = (subject.get(a1) + subject.get(a2) + subject.get(a3) + subject.get(a4));
		System.out.println(randomsubjectfield);
		return randomsubjectfield;

	}

	// method to get the descrition
	public String getDescription(String desckey) throws IOException {
		ArrayList<String> description = pem.getPropertyArray(desckey);
		Random random = new Random();
		int b1 = random.nextInt(description.size());
		int b2 = random.nextInt(description.size());
		int b3 = random.nextInt(description.size());
		int b4 = random.nextInt(description.size());
		String randomdescriptionfield = (description.get(b1) + description.get(b2) + description.get(b3)
				+ description.get(b4));
		System.out.println(randomdescriptionfield);
		return randomdescriptionfield;

	}

	// method to get the notes
	public String getNotes(String noteskey) throws IOException {
		ArrayList<String> description = pem.getPropertyArray(noteskey);
		Random random = new Random();
		int c1 = random.nextInt(description.size());
		int c2 = random.nextInt(description.size());
		int c3 = random.nextInt(description.size());
		int c4 = random.nextInt(description.size());
		String randomnotesfield = (description.get(c1) + description.get(c2) + description.get(c3)
				+ description.get(c4));
		System.out.println(randomnotesfield);
		return randomnotesfield;
	}

}
