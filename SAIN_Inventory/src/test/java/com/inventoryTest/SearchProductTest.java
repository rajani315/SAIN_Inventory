package com.inventoryTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.baseTest.BaseClass;
import com.generic.webdriverUtility.UtilityClassObject;
import com.objectRepository.HomePage;
import com.objectRepository.InventoryPage;

public class SearchProductTest extends BaseClass {

	@Test(groups = {"RegressionTest"})
	public void searchProductByCode() throws Throwable {

		UtilityClassObject.getTest().log(Status.INFO,"Fetching data from excel");
		String P_CODE = e.getDataFromExcel("Inventory", 1, 2);

		UtilityClassObject.getTest().log(Status.INFO,"navigate to inventory page");
		HomePage hp = new HomePage(driver);
		hp.getInventoryLink().click();

		UtilityClassObject.getTest().log(Status.INFO,"search the product");
		InventoryPage ip = new InventoryPage(driver);
		ip.getSearchTxtFld().sendKeys(P_CODE);

		String p_code = driver.findElement(By.xpath("//tbody/tr[@role='row']/td[@class=\"sorting_1\"]")).getText();

		UtilityClassObject.getTest().log(Status.INFO,"verify the product");
		Assert.assertEquals(P_CODE, p_code);
	}
}
