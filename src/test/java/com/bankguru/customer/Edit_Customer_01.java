package com.bankguru.customer;

import java.lang.reflect.Method;

import org.openqa.selenium.Keys;
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
import pageObjects.EditCustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import reportConfigs.ExtentTestManager;

public class Edit_Customer_01 extends BaseTest {
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private EditCustomerPageObject editCustomerPage;

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

		homePage.openPageAtSizeBarByName("Edit Customer");
		editCustomerPage = PageGeneratorManager.getEditCustomerPO(driver);
	}

	@Test
	public void Edit_Customer_01_Empty_CustomerID(Method method) {
		ExtentTestManager.startTest(method.getName(), browserName + "- Edit customer with empty customerID");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 01: Enter to empty customer id to textbox");
		editCustomerPage.enterToCustomerID("");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 02: Click to submit button");
		editCustomerPage.clickToSubmitButton();

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 03: Verify error message at customerID textbox");
		Assert.assertEquals(editCustomerPage.getErrorMessageAtCustomerID(), "Customer ID is required");
	}

	@Test
	public void Edit_Customer_02_CustomerID_Has_Characters(Method method) {
		editCustomerPage.refreshToPage();
		ExtentTestManager.startTest(method.getName(), browserName + "- Edit customer with customerID has character");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 01: Enter customerID is '123kh' to textbox");
		editCustomerPage.enterToCustomerID("123kh");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 02: Click to submit button");
		editCustomerPage.clickToSubmitButton();

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 03: Verify error message at customerID textbox");
		Assert.assertEquals(editCustomerPage.getErrorMessageAtCustomerID(), "Characters are not allowed");
	}

	@Test
	public void Edit_Customer_03_CustomerID_Has_Special_Characters(Method method) {
		editCustomerPage.refreshToPage();
		ExtentTestManager.startTest(method.getName(), browserName + "- Edit customer with customerID has special character");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 01: Enter customerID is '123kh@' to textbox");
		editCustomerPage.enterToCustomerID("123kh@");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 02: Click to submit button");
		editCustomerPage.clickToSubmitButton();

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 03: Verify error message at customerID textbox");
		Assert.assertEquals(editCustomerPage.getErrorMessageAtCustomerID(), "Special characters are not allowed");
	}

	@Test
	public void Edit_Customer_04_CustomerID_Valid(Method method) {
		editCustomerPage.refreshToPage();
		ExtentTestManager.startTest(method.getName(), browserName + "- Edit customer with customerID valid");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 01: Enter customerID is '" + New_Customer_02.customerID + "' to textbox");
		editCustomerPage.enterToCustomerID(New_Customer_02.customerID);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 02: Click to submit button");
		editCustomerPage.clickToSubmitButton();

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 03: Verify error message at customerID textbox");
		Assert.assertEquals(editCustomerPage.getTitleEditCustomer(), "Edit Customer");
	}

	@Test
	public void Edit_Customer_05_Empty_Address(Method method) {
		ExtentTestManager.startTest(method.getName(), browserName + "- Edit customer with Address empty");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 01: Enter address empty to textbox");
		editCustomerPage.enterToAddressTextBox("");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 02: Press Tab and move next field");
		editCustomerPage.pressingByKey(Keys.TAB);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 03: Verify error message at address");
		Assert.assertEquals(editCustomerPage.getErrorMessageAtAddressTextBox(), "Address Field must not be blank");

	}

	@Test
	public void Edit_Customer_05_Empty_City(Method method) {
		editCustomerPage.refreshToPage();

		ExtentTestManager.startTest(method.getName(), browserName + "- Edit customer with City empty");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 01: Enter city empty to textbox");
		editCustomerPage.enterToCityTextBox("");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 02: Press Tab and move next field");
		editCustomerPage.pressingByKey(Keys.TAB);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 03: Verify error message at city");
		Assert.assertEquals(editCustomerPage.getErrorMessageAtCityTextBox(), "City Field must not be blank");

	}

	@Test
	public void Edit_Customer_06_City_Is_Numeric(Method method) {
		editCustomerPage.refreshToPage();

		ExtentTestManager.startTest(method.getName(), browserName + "- Edit customer with City is numeric");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 01: Enter city is 'city 123' to textbox");
		editCustomerPage.enterToCityTextBox("city 123");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 02: Press Tab and move next field");
		editCustomerPage.pressingByKey(Keys.TAB);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 03: Verify error message at city");
		Assert.assertEquals(editCustomerPage.getErrorMessageAtCityTextBox(), "Numbers are not allowed");

	}

	@Test
	public void Edit_Customer_07_City_Has_Special_Characters(Method method) {
		editCustomerPage.refreshToPage();

		ExtentTestManager.startTest(method.getName(), browserName + "- Edit customer with City has special characters");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 01: Enter city is 'city@' to textbox");
		editCustomerPage.enterToCityTextBox("city@");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 02: Press Tab and move next field");
		editCustomerPage.pressingByKey(Keys.TAB);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 03: Verify error message at city");
		Assert.assertEquals(editCustomerPage.getErrorMessageAtCityTextBox(), "Special characters are not allowed");

	}

	@Test
	public void Edit_Customer_08_Empty_State(Method method) {
		editCustomerPage.refreshToPage();

		ExtentTestManager.startTest(method.getName(), browserName + "- Edit customer with state empty");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 01: Enter state empty to textbox");
		editCustomerPage.enterToStateTextBox("");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 02: Press Tab and move next field");
		editCustomerPage.pressingByKey(Keys.TAB);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 03: Verify error message at state");
		Assert.assertEquals(editCustomerPage.getErrorMessageAtStateTextBox(), "State must not be blank");

	}

	@Test
	public void Edit_Customer_09_State_Is_Numeric(Method method) {
		editCustomerPage.refreshToPage();

		ExtentTestManager.startTest(method.getName(), browserName + "- Edit customer with state is numeric");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 01: Enter state is '123123' to textbox");
		editCustomerPage.enterToStateTextBox("123123");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 02: Press Tab and move next field");
		editCustomerPage.pressingByKey(Keys.TAB);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 03: Verify error message at state");
		Assert.assertEquals(editCustomerPage.getErrorMessageAtStateTextBox(), "Numbers are not allowed");

	}

	@Test
	public void Edit_Customer_10_State_Has_Special_Characters(Method method) {
		editCustomerPage.refreshToPage();

		ExtentTestManager.startTest(method.getName(), browserName + "- Edit customer with state has special characters");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 01: Enter state is 'Pass@' to textbox");
		editCustomerPage.enterToStateTextBox("Pass@");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 02: Press Tab and move next field");
		editCustomerPage.pressingByKey(Keys.TAB);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 03: Verify error message at state");
		Assert.assertEquals(editCustomerPage.getErrorMessageAtStateTextBox(), "Special characters are not allowed");

	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

}
