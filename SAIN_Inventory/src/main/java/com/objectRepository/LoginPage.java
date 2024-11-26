package com.objectRepository;

/**
 * Contains Objects and business logics of Login Page
 * @author Rajani
 * 
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.webdriverUtility.WebDriverUtility;

public class LoginPage {
	
	WebDriver driver;
	
	/**
	 * Initialize the objects of login page
	 * @param driver
	 */
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(css = "[name='user']")
	private WebElement usernameTxtField;
	
	@FindBy(name = "password")
	private WebElement passwordTxtField;
	
	@FindBy(name = "btnlogin")
	private WebElement loginBtn;
	
	/**
	 * login to the application
	 * @param URL
	 * @param username
	 * @param password
	 * @throws InterruptedException 
	 */
	public void loginToApp(String URL, String username, String password) throws InterruptedException {
		WebDriverUtility w=new WebDriverUtility();
		w.maximizeBrowser(driver);
		w.waitForPageToLoad(driver);
		driver.get(URL);
		usernameTxtField.sendKeys(username);
		passwordTxtField.sendKeys(password);
		loginBtn.click();
		Thread.sleep(2000);
		w.switchToAlertAndAccept(driver);
		
	}
}
