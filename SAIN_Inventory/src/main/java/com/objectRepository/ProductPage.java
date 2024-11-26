package com.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.webdriverUtility.WebDriverUtility;

public class ProductPage {
	
	WebDriver driver;
	
	/**
	 * Initialize the objects of product page
	 * 
	 * @param driver
	 */
	public ProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver, this);
	}
	
	@FindBy(xpath = "//h4/a")
	private WebElement addProductBtn;
		
	public WebElement getAddProductBtn() {
		return addProductBtn;
	}

	@FindBy(css = "[name='dataTable_length']")
	private WebElement dataTable_length;
	
	@FindBy(css = "[type=\"search\"]")
	private WebElement searchTxtFld;
	
	public WebElement getSearchTxtFld() {
		return searchTxtFld;
	}
	
	@FindBy(xpath  = "//a[contains(.,\"Details\")]")
	private WebElement detailsLink;
	
	public WebElement getDetailsLink() {
		return detailsLink;
	}
	
	@FindBy(xpath  = "//a[contains(.,\"...\")]")
	private WebElement threeDotLink;
	
	public WebElement getThreeDotLink() {
		return threeDotLink;
	}
	
	@FindBy(xpath  = "//a[contains(.,\"Edit\")]")
	private WebElement editLink;
	
	public WebElement getEditLink() {
		return editLink;
	}
	
	public void setTableLenght(String length) {
		WebDriverUtility w= new WebDriverUtility();
		w.select(dataTable_length, length);
	}
	
}
