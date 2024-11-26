package com.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditProductPage {
	

	WebDriver driver;
	
	/**
	 * Initialize the objects of edit product page
	 * 
	 * @param driver
	 */
	public EditProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver, this);
	}
	
	@FindBy(name = "prodcode")
	private WebElement prodCode;

	@FindBy(name = "prodname")
	private WebElement prodName;

	@FindBy(tagName = "textarea")
	private WebElement prodDesc;
	
	@FindBy(name = "price")
	private WebElement prodPrice;

	public WebElement getProdCode() {
		return prodCode;
	}

	public WebElement getProdName() {
		return prodName;
	}

	public WebElement getProdDesc() {
		return prodDesc;
	}

	public WebElement getProdPrice() {
		return prodPrice;
	}

	
}
