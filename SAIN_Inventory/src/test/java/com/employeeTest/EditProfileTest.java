package com.employeeTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.baseTest.BaseClass;
import com.generic.webdriverUtility.UtilityClassObject;
import com.objectRepository.EditProfilePage;
import com.objectRepository.HomePage;

public class EditProfileTest extends BaseClass {

	@Test(groups = {"RegressionTest"})
	public void editProfileContact() throws Throwable {

		UtilityClassObject.getTest().log(Status.INFO,"Fetching data from excel");
		String PASSWORD = f.getDataFromPropertyFile("u_password");
		String E_CONTACT = e.getDataFromExcel("Profile", 1, 2);
		String E_GENDER = e.getDataFromExcel("Profile", 1, 3);

		UtilityClassObject.getTest().log(Status.INFO,"navigate to edit profile page");
		HomePage hp = new HomePage(driver);
		hp.navigateToEditProfile();

		UtilityClassObject.getTest().log(Status.INFO,"edit profile contact");
		EditProfilePage epp = new EditProfilePage(driver);
		epp.editContact(E_GENDER, PASSWORD, E_CONTACT);
		
		UtilityClassObject.getTest().log(Status.INFO,"navigate to edit profile page");
		hp.navigateToEditProfile();

		UtilityClassObject.getTest().log(Status.INFO,"verify contact");
		String e_contact = epp.getContactFld().getAttribute("value");
		Thread.sleep(2000);
		epp.getCloseBtn().click();
		
		Assert.assertEquals(e_contact, E_CONTACT);		
	}
}
