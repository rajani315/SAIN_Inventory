package com.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.webdriverUtility.WebDriverUtility;

public class AddUserAccountPage {

	WebDriver driver;

	/**
	 * Initialize the objects of Add User Account Page
	 * 
	 * @param driver
	 */
	public AddUserAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "empid")
	private WebElement employeeDropDown;
	
	@FindBy(xpath = "//select[@name='empid']/parent::div/following-sibling::div/input[@name='username']")
	private WebElement usernameTxtFld;
	
	@FindBy(xpath = "//select[@name='empid']/parent::div/following-sibling::div/input[@name='password']")
	private WebElement passwordTxtFld;
			
	@FindBy(xpath = "(//button[contains(.,'Save')])[5]")
	private WebElement saveBtn;
	
	public void addUserAccount(String employee, String username, String password) throws InterruptedException {
		WebDriverUtility w=new WebDriverUtility();
		w.select(employeeDropDown, employee);
		Thread.sleep(2000);
		usernameTxtFld.sendKeys(username);
		Thread.sleep(2000);
		passwordTxtFld.sendKeys(password);
		saveBtn.click();
	}
	
	
}
