package com.bankguru.customer;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.bankguru.commons.Register;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.DeleteCustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import reportConfigs.ExtentTestManager;

public class Delete_Customer extends BaseTest {
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private DeleteCustomerPageObject deleteCustomerPage;

	WebDriver driver;
	private String browserName;

	@Parameters({ "envName", "envServer", "osName", "osVersion", "browser" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("dev") String envServer, @Optional("Windows") String osName, @Optional("10") String osVersion, @Optional("chrome") String browserName) {
		driver = getBrowserDriver(envName, envServer, osName, osVersion, browserName);
		this.browserName = browserName;
		driver.get(GlobalConstants.USER_ADMIN_URL);
		loginPage = PageGeneratorManager.getLoginPagePO(driver);

		loginPage.enterToUserIDTextBox(Register.userId);
		loginPage.enterToPasswordTextBox(Register.password);
		loginPage.clickToLoginButton();

		homePage = PageGeneratorManager.getHomePagePO(driver);
		Assert.assertEquals(homePage.getMessageLoginSuccess(), "Welcome To Manager's Page of Guru99 Bank");

		homePage.openPageAtSizeBarByName("Delete Customer");
		deleteCustomerPage = PageGeneratorManager.getDeleteCustomerPO(driver);
	}

	@Test
	public void Delete_01_Empty_CustomerID(Method method) {
		ExtentTestManager.startTest(method.getName(), browserName + "- Delete customer with empty customerID");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Delete customer - Step 01: Enter to empty customer id to textbox");
		deleteCustomerPage.enterToCustomerID("");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Delete customer - Step 02: Click to submit button");
		deleteCustomerPage.clickToSubmitButton();

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Delete customer - Step 03: Verify error message at customerID textbox");
		Assert.assertEquals(deleteCustomerPage.getErrorMessageAtCustomerID(), "Customer ID is required");
	}

	@Test
	public void Delete_02_CustomerID_Have_Characters(Method method) {
		ExtentTestManager.startTest(method.getName(), browserName + "- Delete customer with customerID have characters");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Delete customer - Step 01: Enter to customer hava characters is '1234H' id to textbox");
		deleteCustomerPage.enterToCustomerID("1234H");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Delete customer - Step 02: Click to submit button");
		deleteCustomerPage.clickToSubmitButton();

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Delete customer - Step 03: Verify error message at customerID textbox");
		Assert.assertEquals(deleteCustomerPage.getErrorMessageAtCustomerID(), "Characters are not allowed");
	}

	@Test
	public void Delete_03_CustomerID_Have_Special_Characters(Method method) {
		ExtentTestManager.startTest(method.getName(), browserName + "- Delete customer with customerID hava special characters");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Delete customer - Step 01: Enter to customer hava special characters is '1234@' id to textbox");
		deleteCustomerPage.enterToCustomerID("1234@");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Delete customer - Step 02: Click to submit button");
		deleteCustomerPage.clickToSubmitButton();

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Delete customer - Step 03: Verify error message at customerID textbox");
		Assert.assertEquals(deleteCustomerPage.getErrorMessageAtCustomerID(), "Special characters are not allowed");
	}

	@Test
	public void Delete_04_Customer_Have_Blank_Space(Method method) {
		ExtentTestManager.startTest(method.getName(), browserName + "- Delete customer with customerID hava blank space");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Delete customer - Step 01: Enter to customer hava blank space is '1234 5' id to textbox");
		deleteCustomerPage.enterToCustomerID("1234 5");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Delete customer - Step 02: Click to submit button");
		deleteCustomerPage.clickToSubmitButton();

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Delete customer - Step 03: Verify error message at customerID textbox");
		Assert.assertEquals(deleteCustomerPage.getErrorMessageAtCustomerID(), "Characters are not allowed");
	}

	@Test
	public void Delete_05_Success(Method method) {
		ExtentTestManager.startTest(method.getName(), browserName + "- Delete customer with customerID valid");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Delete customer - Step 01: Enter to customer valid is '" + New_Customer_02.customerID + "' id to textbox");
		deleteCustomerPage.enterToCustomerID(New_Customer_02.customerID);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Delete customer - Step 02: Click to submit button");
		deleteCustomerPage.clickToSubmitButton();
		Assert.assertEquals(deleteCustomerPage.getTextInAlert(), "Do you really want to delete this Customer?");
		deleteCustomerPage.acceptDeleteAlert();

		Assert.assertEquals(deleteCustomerPage.getTextInAlert(), "Customer does not Exist!!!");
		deleteCustomerPage.acceptDeleteAlert();

	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
}
