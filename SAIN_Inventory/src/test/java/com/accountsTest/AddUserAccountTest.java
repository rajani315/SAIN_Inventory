package com.accountsTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.baseTest.BaseClass;
import com.generic.webdriverUtility.UtilityClassObject;
import com.objectRepository.AccountsPage;
import com.objectRepository.AddUserAccountPage;
import com.objectRepository.HomePage;

public class AddUserAccountTest extends BaseClass{

	@Test(groups = {"SmokeTest","RegressionTest"})
	public void addUserAccount() throws Throwable {
		
		UtilityClassObject.getTest().log(Status.INFO,"Fetching data from excel");
		String EMPLOYEE = e.getDataFromExcel("Accounts", 1, 2);
		String USERNAME = e.getDataFromExcel("Accounts", 1, 3)+j.getRandomNum();
		String PASSWORD = e.getDataFromExcel("Accounts", 1, 4);

		UtilityClassObject.getTest().log(Status.INFO,"navigate to accounts");
		HomePage hp=new HomePage(driver);
		hp.getAccountsLink().click();
		
		UtilityClassObject.getTest().log(Status.INFO,"click on add account");
		AccountsPage ap=new AccountsPage(driver);
		ap.getAddUserAccountBtn().click();
		
		UtilityClassObject.getTest().log(Status.INFO,"enter details and save account");
		AddUserAccountPage auap=new AddUserAccountPage(driver);
		auap.addUserAccount(EMPLOYEE, USERNAME, PASSWORD);
		
		UtilityClassObject.getTest().log(Status.INFO,"verify account");
		String username = driver.findElement(By.xpath("//td[contains(text(),'"+USERNAME+"')]")).getText();
		Assert.assertEquals(username, USERNAME);		
	}
}
