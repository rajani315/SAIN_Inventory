package com.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.webdriverUtility.WebDriverUtility;

public class EditEmployeePage {
	
	WebDriverUtility w=new WebDriverUtility();
	WebDriver driver;
	
	/**
	 * Initialize the objects of product page
	 * 
	 * @param driver
	 */
	public EditEmployeePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver, this);
	}

	@FindBy(xpath = "(//div[contains(text(),'Gender')]/following-sibling::div/select[@name=\"gender\"])[1]")
	private WebElement genderDropDown;
	
	@FindBy(xpath = "//input[@placeholder='Phone Number' and @name='phone']")
	private WebElement contactFld;
	
	@FindBy(xpath = "//button[contains(.,'Update')]")
	private WebElement updateBtn;
	
	public void selectGender(String gender) {
		w.select(genderDropDown, gender);
	}
	
	public void editContact(String gender,String contact) throws Throwable {
		selectGender(gender);
		contactFld.clear();
		contactFld.sendKeys(contact);
		w.scrollToElementAndClickJS(driver, updateBtn);
		Thread.sleep(2000);
		w.switchToAlertAndAccept(driver);
	}

}
