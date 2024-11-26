package com.pointOfSaleTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.baseTest.BaseClass;
import com.generic.webdriverUtility.UtilityClassObject;
import com.objectRepository.HomePage;
import com.objectRepository.PointOfSalePage;

public class SubmitProductsTest extends BaseClass {

	@Test
	public void submitProductsTest() throws Throwable {

		UtilityClassObject.getTest().log(Status.INFO, "Fetching data from excel");
		String CUSTOMER = e.getDataFromExcel("PointOfSale", 1, 5);
		String P_CATEGORY = e.getDataFromExcel("PointOfSale", 1, 4);
		String P_QUANTITY = e.getDataFromExcel("PointOfSale", 1, 3);
		String P_NAME = e.getDataFromExcel("PointOfSale", 1, 2);

		UtilityClassObject.getTest().log(Status.INFO, "navigate to point of sale page");
		HomePage hp = new HomePage(driver);
		hp.getPointOfSaleLink().click();

		UtilityClassObject.getTest().log(Status.INFO, "click on product category");
		PointOfSalePage posp = new PointOfSalePage(driver);
		posp.clickOnCategory(P_CATEGORY);

		UtilityClassObject.getTest().log(Status.INFO, "enter the quantity");
		WebElement p_qty = driver
				.findElement(By.xpath("//h6[text()='" + P_NAME + "']/following-sibling::input[@name='quantity']"));
		p_qty.clear();
		p_qty.sendKeys(P_QUANTITY);

		UtilityClassObject.getTest().log(Status.INFO, "click on add");
		driver.findElement(By.xpath("//h6[text()='" + P_NAME + "']/following-sibling::input[@name='addpos']")).click();

		UtilityClassObject.getTest().log(Status.INFO, "select customer");
		posp.selectCustomer(CUSTOMER);

		UtilityClassObject.getTest().log(Status.INFO, "Fetch total amount");
		String total = posp.getTotal().getAttribute("value");

		UtilityClassObject.getTest().log(Status.INFO, "click on submit");
		w.scrollToElementAndClickJS(driver, posp.getSubmitBtn());

		Thread.sleep(3000);

		UtilityClassObject.getTest().log(Status.INFO, "Fetch grand total amount");
		String grandTotal = posp.getGrandTotal().getText();
		posp.getCloseSummary().click();
		
		UtilityClassObject.getTest().log(Status.INFO, "verify total and grandtotal");
		boolean status = grandTotal.contains(total);
		Assert.assertEquals(true, status);

	}
}
