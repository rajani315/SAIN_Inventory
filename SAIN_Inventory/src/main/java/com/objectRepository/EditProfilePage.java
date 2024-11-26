package com.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.webdriverUtility.WebDriverUtility;

public class EditProfilePage {

	WebDriverUtility w = new WebDriverUtility();
	WebDriver driver;

	/**
	 * Initialize the objects of product page
	 * 
	 * @param driver
	 */
	public EditProfilePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver, this);
	}

	@FindBy(xpath = "(//div[contains(text(),'Gender')]/following-sibling::div/select[@name=\"gender\"])[1]")
	private WebElement genderDropDown;
	
	@FindBy(name = "password")
	private WebElement passwordFld;

	@FindBy(xpath = "//input[@placeholder='Contact #' and @name='phone']")
	private WebElement contactFld;

	@FindBy(xpath = "(//button[contains(.,'Save')])[4]")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//h5[text()='Edit User Info']/following-sibling::button")
	private WebElement closeBtn;

	public WebElement getCloseBtn() {
		return closeBtn;
	}

	public WebElement getContactFld() {
		return contactFld;
	}

	public void selectGender(String gender) {
		w.select(genderDropDown, gender);
	}

	public void editContact(String gender, String password, String contact) throws Throwable {
		selectGender(gender);
		Thread.sleep(2000);
		passwordFld.sendKeys(password);
		contactFld.clear();
		contactFld.sendKeys(contact);
		w.scrollToElementAndClickJS(driver, saveBtn);
		Thread.sleep(2000);
		w.switchToAlertAndAccept(driver);
	}

}
