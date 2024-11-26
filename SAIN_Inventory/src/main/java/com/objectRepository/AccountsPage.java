package com.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsPage {

	WebDriver driver;

	/**
	 * Initialize the objects of Accounts Page
	 * 
	 * @param driver
	 */
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h4[contains(text(),'User')]/a")
	private WebElement addUserAccountBtn;

	public WebElement getAddUserAccountBtn() {
		return addUserAccountBtn;
	}
	
}
