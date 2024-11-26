package com.productTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.baseTest.BaseClass;
import com.generic.webdriverUtility.UtilityClassObject;
import com.objectRepository.AddProductPage;
import com.objectRepository.EditProductPage;
import com.objectRepository.HomePage;
import com.objectRepository.ProductPage;

public class AddProductTest extends BaseClass {

	@Test
	public void addProductTest() throws Throwable {

		UtilityClassObject.getTest().log(Status.INFO,"fetching data from excel");
		String P_CODE = e.getDataFromExcel("Product", 1, 2) + j.getRandomNum();
		String P_NAME = e.getDataFromExcel("Product", 1, 3);
		String P_DESC = e.getDataFromExcel("Product", 1, 4);
		String P_QTY = e.getDataFromExcel("Product", 1, 5);
		String P_ONHAND = e.getDataFromExcel("Product", 1, 6);
		String P_PRICE = e.getDataFromExcel("Product", 1, 7);
		String P_CATEGORY = e.getDataFromExcel("Product", 1, 8);
		String P_SUPPLIER = e.getDataFromExcel("Product", 1, 9);
		String dateStockIn = j.getSystemDateInddMMyyyy();

		UtilityClassObject.getTest().log(Status.INFO,"navigate to product page");
		HomePage hp = new HomePage(driver);
		hp.getProductLink().click();

		UtilityClassObject.getTest().log(Status.INFO,"navigate to add product page");
		ProductPage pp = new ProductPage(driver);
		pp.getAddProductBtn().click();

		UtilityClassObject.getTest().log(Status.INFO,"enter product details and click on save");
		AddProductPage app = new AddProductPage(driver);
		app.addProduct(P_CODE, P_NAME, P_DESC, P_QTY, P_ONHAND, P_PRICE, P_CATEGORY, P_SUPPLIER, dateStockIn);

		pp.setTableLenght("50");

		UtilityClassObject.getTest().log(Status.INFO,"verify product details");
		String code = driver.findElement(By.xpath("//td[text()='" + P_CODE + "']")).getText();
		String name = driver.findElement(By.xpath("//td[text()='" + code + "']/following-sibling::td")).getText();
		String price = driver.findElement(By.xpath("//td[text()='" + name + "']/following-sibling::td")).getText();
		String category = driver.findElement(By.xpath("//td[text()='" + price + "']/following-sibling::td")).getText();

		Assert.assertEquals(code, P_CODE);
		Assert.assertEquals(name, P_NAME);
		Assert.assertEquals(price, P_PRICE);
		Assert.assertEquals(category, P_CATEGORY);
	}

	@Test
	public void addProductAndVerifyInEditTest() throws Throwable {

		UtilityClassObject.getTest().log(Status.INFO,"fetching data from the excel file");
		String P_CODE = e.getDataFromExcel("Product", 4, 2) + j.getRandomNum();
		String P_NAME = e.getDataFromExcel("Product", 4, 3);
		String P_DESC = e.getDataFromExcel("Product", 4, 4);
		String P_QTY = e.getDataFromExcel("Product", 4, 5);
		String P_ONHAND = e.getDataFromExcel("Product", 4, 6);
		String P_PRICE = e.getDataFromExcel("Product", 4, 7);
		String P_CATEGORY = e.getDataFromExcel("Product", 4, 8);
		String P_SUPPLIER = e.getDataFromExcel("Product", 4, 9);
		String dateStockIn = j.getSystemDateInddMMyyyy();

		UtilityClassObject.getTest().log(Status.INFO,"navigate to products page");
		HomePage hp = new HomePage(driver);
		hp.getProductLink().click();

		UtilityClassObject.getTest().log(Status.INFO,"navigate to add product page");
		ProductPage pp = new ProductPage(driver);
		pp.getAddProductBtn().click();

		UtilityClassObject.getTest().log(Status.INFO,"enter product details and click on save");
		AddProductPage app = new AddProductPage(driver);
		app.addProduct(P_CODE, P_NAME, P_DESC, P_QTY, P_ONHAND, P_PRICE, P_CATEGORY, P_SUPPLIER, dateStockIn);

		pp.setTableLenght("50");

		pp.getSearchTxtFld().sendKeys(P_CODE);
		
		UtilityClassObject.getTest().log(Status.INFO,"navigate to edit products page");
		pp.getThreeDotLink().click();
		pp.getEditLink().click();

		UtilityClassObject.getTest().log(Status.INFO,"verify product details");
		EditProductPage epp = new EditProductPage(driver);
		String ep_code = epp.getProdCode().getAttribute("value");
		String ep_name = epp.getProdName().getAttribute("value");
		String ep_price = epp.getProdPrice().getAttribute("value");
		String ep_desc = epp.getProdDesc().getText();

		Assert.assertEquals(ep_code, P_CODE);
		Assert.assertEquals(ep_name, P_NAME);
		Assert.assertEquals(ep_price, P_PRICE);
		Assert.assertEquals(ep_desc, P_DESC);
	}
}
