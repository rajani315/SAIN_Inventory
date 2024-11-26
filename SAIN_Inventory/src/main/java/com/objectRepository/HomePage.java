package com.objectRepository;

/**
 * Contains objects and business logics of Home page
 * @author Rajani
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	/**
	 * Initialize the objects of home page
	 * 
	 * @param driver
	 */
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[href=\"pos.php\"]")
	private WebElement pointOfSaleLink;
	
	@FindBy(id = "userDropdown")
	private WebElement profileDropDown;

	@FindBy(xpath = "//a[contains(.,'Settings')]")
	private WebElement settingsLink;
	
	@FindBy(xpath = "//a[contains(.,'Logout') and @class='dropdown-item']")
	private WebElement logoutLink;

	@FindBy(xpath = "(//a[text()='Logout'])[1]")
	private WebElement popupLogoutLink;
	
	@FindBy(xpath = "//a/span[text()='Employee']")
	private WebElement employeeLink;
			
	@FindBy(xpath = "//a/span[text()='Product']")
	private WebElement productLink;
	
	@FindBy(xpath = "//a/span[text()='Inventory']")
	private WebElement inventoryLink;
	
	@FindBy(xpath = "//a/span[text()='Accounts']")
	private WebElement accountsLink;

	public WebElement getEmployeeLink() {
		return employeeLink;
	}
	
	public WebElement getProductLink() {
		return productLink;
	}

	public WebElement getInventoryLink() {
		return inventoryLink;
	}

	public WebElement getAccountsLink() {
		return accountsLink;
	}

	public WebElement getPointOfSaleLink() {
		return pointOfSaleLink;
	}

	/**
	 * Logout from the application
	 */
	public void logoutFromApp() {
		profileDropDown.click();
		logoutLink.click();
		popupLogoutLink.click();
	}
	
	public void navigateToEditProfile() {
		profileDropDown.click();
		settingsLink.click();
	}

}
