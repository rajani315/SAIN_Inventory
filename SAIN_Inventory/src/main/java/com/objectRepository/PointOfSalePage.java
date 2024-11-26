package com.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.webdriverUtility.WebDriverUtility;

public class PointOfSalePage {
	
	WebDriver driver;

	/**
	 * Initialize the objects of home page
	 * 
	 * @param driver
	 */
	public PointOfSalePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Keyboard']")
	private WebElement keyboardCategory;
	
	@FindBy(name = "customer")
	private WebElement selectCustomer;
	
	@FindBy(xpath = "//h6[contains(.,'Total')]/parent::div/following-sibling::div//input[@name='total']")
	private WebElement total;

	@FindBy(xpath = "//h3[contains(.,'GRAND TOTAL')]/following-sibling::h3")
	private WebElement grandTotal;
	
	@FindBy(xpath = "//button[text()='SUBMIT']")
	private WebElement submitBtn;
	
	@FindBy(xpath = "//h3[contains(.,'GRAND TOTAL')]/parent::div/parent::div/parent::div/preceding-sibling::div/button")
	private WebElement closeSummary;
	
	public WebElement getCloseSummary() {
		return closeSummary;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getTotal() {
		return total;
	}
	
	public WebElement getGrandTotal() {
		return grandTotal;
	}
	
	public WebElement getKeyboardCategory() {
		return keyboardCategory;
	}
	
	
	public void clickOnCategory(String category) {
		if(category.equals(keyboardCategory.getText())){
			keyboardCategory.click();
		}
	}
	
	public void selectCustomer(String customer) {
		WebDriverUtility w= new WebDriverUtility();
		w.select(selectCustomer, customer);
	}
	
	

}
