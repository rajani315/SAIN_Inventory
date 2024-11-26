package com.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.webdriverUtility.WebDriverUtility;

public class AddProductPage {

	WebDriver driver;

	// h4/a
	public AddProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "prodcode")
	private WebElement prodCode;

	@FindBy(name = "name")
	private WebElement prodName;

	@FindBy(tagName = "textarea")
	private WebElement prodDesc;

	@FindBy(name = "quantity")
	private WebElement prodQuantity;

	@FindBy(name = "onhand")
	private WebElement prodOnHand;

	@FindBy(name = "price")
	private WebElement prodPrice;

	@FindBy(name = "category")
	private WebElement prodCategory;

	@FindBy(name = "supplier")
	private WebElement prodSupplier;

	@FindBy(name = "datestock")
	private WebElement prodDateStockIn;

	@FindBy(xpath = "(//button[contains(.,'Save')])[5]")
	private WebElement saveBtn;

	public void addProduct(String P_CODE,String P_NAME,String P_DESC,String P_QTY,String P_ONHAND,
			String P_PRICE,String P_CATEGORY,String P_SUPPLIER, String dateStockIn) throws InterruptedException {
		
		WebDriverUtility w= new WebDriverUtility();
			
		prodCode.sendKeys(P_CODE);
		Thread.sleep(2000);
		prodName.sendKeys(P_NAME);
		Thread.sleep(2000);

		prodDesc.sendKeys(P_DESC);
		prodQuantity.sendKeys(P_QTY);
		prodOnHand.sendKeys(P_ONHAND);
		prodPrice.sendKeys(P_PRICE);
		w.select(prodCategory, P_CATEGORY);
		w.select(prodSupplier, P_SUPPLIER);
		w.sendKeysUsingAction(driver, prodDateStockIn, dateStockIn);
		saveBtn.click();
	}
}
