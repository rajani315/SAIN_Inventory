package com.baseTest;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.generic.databaseUtility.DatabaseUtility;
import com.generic.fileUtility.ExcelUtility;
import com.generic.fileUtility.FileUtility;
import com.generic.webdriverUtility.JavaUtility;
import com.generic.webdriverUtility.UtilityClassObject;
import com.generic.webdriverUtility.WebDriverUtility;
import com.objectRepository.HomePage;
import com.objectRepository.LoginPage;

/**
 * Contains implementation of configuration annotations for the test scripts
 * 
 * @author Rajani
 */

public class BaseClass {

	// Object initialization
	public FileUtility f = new FileUtility();
	public ExcelUtility e = new ExcelUtility();
	public WebDriverUtility w = new WebDriverUtility();
	public JavaUtility j = new JavaUtility();
	public DatabaseUtility d = new DatabaseUtility();
	public SoftAssert softAssert = new SoftAssert();

	public WebDriver driver = null;
	public static WebDriver sdriver = null;

	@BeforeSuite
	public void configBeforeSuite() {

		d.getDBConnection();
		Reporter.log("---Connected to Database---",true);
	}

	@AfterSuite
	public void configAfterSuite() throws Throwable {

		d.closeDBConnection();
		Reporter.log("---Closed Database Connection---",true);
	}

	@Parameters("browser")
	@BeforeClass
	public void configBeforeClass(@Optional("Chrome") String BROWSER) throws Throwable {

//		String browser = System.getProperty(BROWSER, f.getDataFromPropertyFile("browser"));
		driver = w.launchBrowser(BROWSER);
		sdriver = driver;
		UtilityClassObject.setDriver(driver);
		driver = UtilityClassObject.getDriver();
		Reporter.log("---" + BROWSER + " Browser Launched---",true);
	}

	@AfterClass
	public void configAfterClass() {

		driver.quit();
		Reporter.log("---Browser Closed---",true);
	}

	@Parameters({ "username", "password" })
	@BeforeMethod(groups = { "smokeTest", "regressionTest" })
	public void configBeforeMethod(String username, String password) throws Throwable {

		String URL = f.getDataFromPropertyFile("url");

		LoginPage l = new LoginPage(driver);
		l.loginToApp(URL, username, password);
		Reporter.log("---Logged-in to App---",true);
	}

	@AfterMethod(groups = { "smokeTest", "regressionTest" })
	public void configAfterMethod() {

		HomePage hp = new HomePage(driver);
		hp.logoutFromApp();
		Reporter.log("---Logged-out from App---",true);
	}
}
