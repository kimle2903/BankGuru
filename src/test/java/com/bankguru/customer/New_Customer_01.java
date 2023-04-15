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
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewCustomerPageObject;
import reportConfigs.ExtentTestManager;

public class New_Customer_01 extends BaseTest {
	WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private NewCustomerPageObject newCustomerPage;
	private String browserName, customerName;

	@Parameters({ "envName", "envServer", "osName", "osVersion", "browser" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("dev") String envServer, @Optional("Windows") String osName, @Optional("10") String osVersion, @Optional("chrome") String browserName) {
		driver = getBrowserDriver(envName, envServer, osName, osVersion, browserName);

		this.browserName = browserName;
		customerName = "";
		driver.get(GlobalConstants.USER_ADMIN_URL);
		loginPage = PageGeneratorManager.getLoginPagePO(driver);

		loginPage.enterToUserIDTextBox(Register.userId);
		loginPage.enterToPasswordTextBox(Register.password);
		loginPage.clickToLoginButton();

		homePage = PageGeneratorManager.getHomePagePO(driver);
		Assert.assertEquals(homePage.getMessageLoginSuccess(), "Welcome To Manager's Page of Guru99 Bank");

		homePage.openPageAtSizeBarByName("New Customer");
		newCustomerPage = PageGeneratorManager.getNewCustomerPO(driver);
	}

	@Test
	public void New_Customer_01_Empty_Name(Method method) {
		ExtentTestManager.startTest(method.getName(), browserName + "- New Customer with empty customer name");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 01: Enter to empty customer name to textbox");
		newCustomerPage.enterToCustomerName(customerName);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 02: Press Tab and move next field");
		newCustomerPage.pressingByKey(Keys.TAB);
		sleepInSecond(1);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 03: Verify error message at customer name");
		Assert.assertEquals(newCustomerPage.getErrorMessageAtCustomerName(), "Customer name must not be blank");

	}

	@Test
	public void New_Customer_02_Name_Is_Numeric(Method method) {
		newCustomerPage.refreshToPage();

		ExtentTestManager.startTest(method.getName(), browserName + "- New Customer with customer name is numeric");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 01: Enter to customer name is numeric 'test1234' to textbox");
		newCustomerPage.enterToCustomerName("test1234");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 02: Press Tab and move next field");
		newCustomerPage.pressingByKey(Keys.TAB);
		sleepInSecond(1);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 03: Verify error message at customer name");
		Assert.assertEquals(newCustomerPage.getErrorMessageAtCustomerName(), "Numbers are not allowed");

	}

	@Test
	public void New_Customer_03_Name_Have_Special_Characters(Method method) {
		newCustomerPage.refreshToPage();

		ExtentTestManager.startTest(method.getName(), browserName + "- New Customer with customer name have special characters");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 01: Enter to customer name is 'test@!23' to textbox");
		newCustomerPage.enterToCustomerName("test@!23");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 02: Press Tab and move next field");
		newCustomerPage.pressingByKey(Keys.TAB);
		sleepInSecond(1);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 03: Verify error message at customer name");
		Assert.assertEquals(newCustomerPage.getErrorMessageAtCustomerName(), "Special characters are not allowed");
	}

	@Test
	public void New_Customer_04_Name_Have_First_Characters_As_Blank_Space(Method method) {
		newCustomerPage.refreshToPage();

		ExtentTestManager.startTest(method.getName(), browserName + "- New Customer with customer name have first characters as blank space");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 01: Enter to customer name is ' test' to textbox");
		newCustomerPage.enterToCustomerName(" test");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 02: Press Tab and move next field");
		newCustomerPage.pressingByKey(Keys.TAB);
		sleepInSecond(1);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 03: Verify error message at customer name");
		Assert.assertEquals(newCustomerPage.getErrorMessageAtCustomerName(), "First character can not have space");
	}

	@Test
	public void New_Customer_05_Empty_Address(Method method) {
		newCustomerPage.refreshToPage();

		ExtentTestManager.startTest(method.getName(), browserName + "- New Customer with address empty");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 01: Enter to address empty to textbox");
		newCustomerPage.enterToAddressTextarea("");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 02: Press Tab and move next field");
		newCustomerPage.pressingByKey(Keys.TAB);
		sleepInSecond(1);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 03: Verify error message at address");
		Assert.assertEquals(newCustomerPage.getErrorMessageAtAddress(), "Address Field must not be blank");
	}

	@Test
	public void New_Customer_06_Address_Have_First_Characters_As_Blank_Space(Method method) {
		newCustomerPage.refreshToPage();

		ExtentTestManager.startTest(method.getName(), browserName + "- New Customer with address have first characters as blank space");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 01: Enter to address is ' Ha noi' textbox");
		newCustomerPage.enterToAddressTextarea(" Ha noi");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 02: Press Tab and move next field");
		newCustomerPage.pressingByKey(Keys.TAB);
		sleepInSecond(1);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 03: Verify error message at address");
		Assert.assertEquals(newCustomerPage.getErrorMessageAtAddress(), "First character can not have space");
	}

	@Test
	public void New_Customer_07_Empty_City(Method method) {
		newCustomerPage.refreshToPage();

		ExtentTestManager.startTest(method.getName(), browserName + "- New Customer with city empty");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 01: Enter city empty to textbox");
		newCustomerPage.enterToCityTextBox("");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 02: Press Tab and move next field");
		newCustomerPage.pressingByKey(Keys.TAB);
		sleepInSecond(1);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 03: Verify error message at city");
		Assert.assertEquals(newCustomerPage.getErrorMessageAtCity(), "City Field must not be blank");
	}

	@Test
	public void New_Customer_08_City_Is_Numeric(Method method) {
		newCustomerPage.refreshToPage();

		ExtentTestManager.startTest(method.getName(), browserName + "- New Customer with city is numeric");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 01: Enter city is 'hanoi123' to textbox");
		newCustomerPage.enterToCityTextBox("hanoi123");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 02: Press Tab and move next field");
		newCustomerPage.pressingByKey(Keys.TAB);
		sleepInSecond(1);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 03: Verify error message at city");
		Assert.assertEquals(newCustomerPage.getErrorMessageAtCity(), "Numbers are not allowed");
	}

	@Test
	public void New_Customer_09_City_Have_Special_Characters(Method method) {
		newCustomerPage.refreshToPage();

		ExtentTestManager.startTest(method.getName(), browserName + "- New Customer with city have special characters");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 01: Enter city is 'hanoi @@' to textbox");
		newCustomerPage.enterToCityTextBox("hanoi @@");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 02: Press Tab and move next field");
		newCustomerPage.pressingByKey(Keys.TAB);
		sleepInSecond(1);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 03: Verify error message at city");
		Assert.assertEquals(newCustomerPage.getErrorMessageAtCity(), "Special characters are not allowed");
	}

	@Test
	public void New_Customer_10_City_Have_First_Characters_As_Blank_Space(Method method) {
		newCustomerPage.refreshToPage();

		ExtentTestManager.startTest(method.getName(), browserName + "- New Customer with city have first characters as blank space");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 01: Enter city is ' Ha noi' to textbox");
		newCustomerPage.enterToCityTextBox(" Ha noi");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 02: Press Tab and move next field");
		newCustomerPage.pressingByKey(Keys.TAB);
		sleepInSecond(1);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 03: Verify error message at city");
		Assert.assertEquals(newCustomerPage.getErrorMessageAtCity(), "First character can not have space");
	}

	@Test
	public void New_Customer_11_Empty_State(Method method) {
		newCustomerPage.refreshToPage();

		ExtentTestManager.startTest(method.getName(), browserName + "- New Customer with state empty");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 01: Enter state empty to textbox");
		newCustomerPage.enterToStateTextBox("");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 02: Press Tab and move next field");
		newCustomerPage.pressingByKey(Keys.TAB);
		sleepInSecond(1);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 03: Verify error message at state");
		Assert.assertEquals(newCustomerPage.getErrorMessageAtState(), "State must not be blank");
	}

	@Test
	public void New_Customer_12_State_Is_Numeric(Method method) {
		newCustomerPage.refreshToPage();

		ExtentTestManager.startTest(method.getName(), browserName + "- New Customer with state is numeric");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 01: Enter state is 'Pass123'to textbox");
		newCustomerPage.enterToStateTextBox("Pass123");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 02: Press Tab and move next field");
		newCustomerPage.pressingByKey(Keys.TAB);
		sleepInSecond(1);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 03: Verify error message at state");
		Assert.assertEquals(newCustomerPage.getErrorMessageAtState(), "Numbers are not allowed");
	}

	@Test
	public void New_Customer_13_State_Have_Special_Characters(Method method) {
		newCustomerPage.refreshToPage();

		ExtentTestManager.startTest(method.getName(), browserName + "- New Customer with state has special chracters");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 01: Enter state is 'Pass@@' to textbox");
		newCustomerPage.enterToStateTextBox("Pass@@");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 02: Press Tab and move next field");
		newCustomerPage.pressingByKey(Keys.TAB);
		sleepInSecond(1);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 03: Verify error message at state");
		Assert.assertEquals(newCustomerPage.getErrorMessageAtState(), "Special characters are not allowed");
	}

	@Test
	public void New_Customer_14_State_Have_First_Characters_As_Blank_Space(Method method) {
		newCustomerPage.refreshToPage();

		ExtentTestManager.startTest(method.getName(), browserName + "- New Customer with state empty");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 01: Enter state is ' Pass' to textbox");
		newCustomerPage.enterToStateTextBox(" Pass");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 02: Press Tab and move next field");
		newCustomerPage.pressingByKey(Keys.TAB);
		sleepInSecond(1);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 03: Verify error message at state");
		Assert.assertEquals(newCustomerPage.getErrorMessageAtState(), "First character can not have space");
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
}
