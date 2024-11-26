package com.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.webdriverUtility.WebDriverUtility;

public class InventoryPage {
	
	WebDriver driver;

	/**
	 * Initialize the objects of home page
	 * 
	 * @param driver
	 */
	public InventoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[name='dataTable_length']")
	private WebElement dataTable_length;
	
	@FindBy(css = "[type=\"search\"]")
	private WebElement searchTxtFld;
	
	public WebElement getSearchTxtFld() {
		return searchTxtFld;
	}

	public void setTableLenght(String length) {
		WebDriverUtility w= new WebDriverUtility();
		w.select(dataTable_length, length);
	}

}
