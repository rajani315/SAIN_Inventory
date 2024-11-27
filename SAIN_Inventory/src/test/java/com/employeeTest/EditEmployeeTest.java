package com.employeeTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.baseTest.BaseClass;
import com.generic.webdriverUtility.UtilityClassObject;
import com.objectRepository.EditEmployeePage;
import com.objectRepository.EmployeePage;
import com.objectRepository.HomePage;

public class EditEmployeeTest extends BaseClass{
	
	@Test(groups = {"RegressionTest"})
	public void editEmployeeContact() throws Throwable {
		
		UtilityClassObject.getTest().log(Status.INFO,"Fetching data from excel");
		String EMPLOYEE_NAME = e.getDataFromExcel("Employee", 1, 2);
		String EMPLOYEE_CONTACT = e.getDataFromExcel("Employee", 1, 3);
		String EMPLOYEE_GENDER = e.getDataFromExcel("Employee", 1, 4);

		UtilityClassObject.getTest().log(Status.INFO,"navigate to employee page");
		HomePage hp=new HomePage(driver);
		hp.getEmployeeLink().click();
		
		UtilityClassObject.getTest().log(Status.INFO,"search the employee and navigate to edit employee page");
		EmployeePage ep=new EmployeePage(driver);
		ep.getSearchTxtFld().sendKeys(EMPLOYEE_NAME);
		ep.getThreeDotLink().click();
		ep.getEditLink().click();
		
		UtilityClassObject.getTest().log(Status.INFO,"edit employee contact");
		EditEmployeePage eep=new EditEmployeePage(driver);
		eep.editContact(EMPLOYEE_GENDER, EMPLOYEE_CONTACT);
		
		UtilityClassObject.getTest().log(Status.INFO,"search the employee");
		ep.getSearchTxtFld().sendKeys(EMPLOYEE_NAME);
		ep.getDetailsLink().click();
		
		UtilityClassObject.getTest().log(Status.INFO,"verify the contact");
		String e_contact = driver.findElement(By.xpath("//h5[contains(.,'5588996541')]")).getText();
		boolean status = e_contact.contains(EMPLOYEE_CONTACT);
		Assert.assertEquals(status, true);
	}
}
