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

public class New_Customer_02 extends BaseTest {
	WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private NewCustomerPageObject newCustomerPage;
	private String browserName, customerName, address, dateOfBirth, dateOfBirthAfter, city, state, pin, phoneNumber, email, password;
	public static String customerID;

	@Parameters({ "envName", "envServer", "osName", "osVersion", "browser" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("dev") String envServer, @Optional("Windows") String osName, @Optional("10") String osVersion, @Optional("chrome") String browserName) {
		driver = getBrowserDriver(envName, envServer, osName, osVersion, browserName);
		customerName = "Automation test";
		address = "Thanh xuan";
		dateOfBirth = "29/03/1997";
		dateOfBirthAfter = "1997-03-29";
		city = "Ha noi";
		state = "Pass";
		pin = "123456";
		phoneNumber = "0348856666";
		email = "test" + randomInt() + "@gmail.com";
		password = "123123";

		this.browserName = browserName;
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
	public void New_Customer_15_Pin_Is_Numeric(Method method) {
		ExtentTestManager.startTest(method.getName(), browserName + "- New Customer with pin is numeric");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 01: Enter pin is '12345P' to textbox");
		newCustomerPage.enterToPinTextBox("12345P");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 02: Press Tab and move next field");
		newCustomerPage.pressingByKey(Keys.TAB);
		sleepInSecond(1);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 03: Verify error message at pin");
		Assert.assertEquals(newCustomerPage.getErrorMessageAtPin(), "Characters are not allowed");
	}

	@Test
	public void New_Customer_16_Empty_Pin(Method method) {
		newCustomerPage.refreshToPage();

		ExtentTestManager.startTest(method.getName(), browserName + "- New Customer with pin empty");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 01: Enter pin is '' to textbox");
		newCustomerPage.enterToPinTextBox("");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 02: Press Tab and move next field");
		newCustomerPage.pressingByKey(Keys.TAB);
		sleepInSecond(1);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 03: Verify error message at pin");
		Assert.assertEquals(newCustomerPage.getErrorMessageAtPin(), "PIN Code must not be blank");
	}

	@Test
	public void New_Customer_17_Pin_Less_Than_6_Digits(Method method) {
		newCustomerPage.refreshToPage();

		ExtentTestManager.startTest(method.getName(), browserName + "- New Customer with pin is numeric");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 01: Enter pin is '12345' to textbox");
		newCustomerPage.enterToPinTextBox("12345");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 02: Press Tab and move next field");
		newCustomerPage.pressingByKey(Keys.TAB);
		sleepInSecond(1);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 03: Verify error message at pin");
		Assert.assertEquals(newCustomerPage.getErrorMessageAtPin(), "PIN Code must have 6 Digits");
	}

	@Test
	public void New_Customer_18_Pin_Have_Special_Characters(Method method) {
		newCustomerPage.refreshToPage();

		ExtentTestManager.startTest(method.getName(), browserName + "- New Customer with pin have special characters");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 01: Enter pin is '12345@' to textbox");
		newCustomerPage.enterToPinTextBox("12345@");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 02: Press Tab and move next field");
		newCustomerPage.pressingByKey(Keys.TAB);
		sleepInSecond(1);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 03: Verify error message at pin");
		Assert.assertEquals(newCustomerPage.getErrorMessageAtPin(), "Special characters are not allowed");
	}

	@Test
	public void New_Customer_19_Pin_Have_First_Characters_As_Blank_Space(Method method) {
		newCustomerPage.refreshToPage();

		ExtentTestManager.startTest(method.getName(), browserName + "- New Customer with pin have first characters as blank space");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 01: Enter pin is ' 12345' to textbox");
		newCustomerPage.enterToPinTextBox(" 12345");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 02: Press Tab and move next field");
		newCustomerPage.pressingByKey(Keys.TAB);
		sleepInSecond(1);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 03: Verify error message at pin");
		Assert.assertEquals(newCustomerPage.getErrorMessageAtPin(), "First character can not have space");
	}

	@Test
	public void New_Customer_20_Pin_Have_Blank_Space(Method method) {
		newCustomerPage.refreshToPage();

		ExtentTestManager.startTest(method.getName(), browserName + "- New Customer with pin have blank space");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 01: Enter pin is '1234 5' to textbox");
		newCustomerPage.enterToPinTextBox("1234 5");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 02: Press Tab and move next field");
		newCustomerPage.pressingByKey(Keys.TAB);
		sleepInSecond(1);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 03: Verify error message at pin");
		Assert.assertEquals(newCustomerPage.getErrorMessageAtPin(), "Characters are not allowed");
	}

	@Test
	public void New_Customer_21_Empty_Phone(Method method) {
		newCustomerPage.refreshToPage();

		ExtentTestManager.startTest(method.getName(), browserName + "- New Customer with phone empty");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 01: Enter phone empty to textbox");
		newCustomerPage.enterToPhoneTextBox("");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 02: Press Tab and move next field");
		newCustomerPage.pressingByKey(Keys.TAB);
		sleepInSecond(1);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 03: Verify error message at phone textbox");
		Assert.assertEquals(newCustomerPage.getErrorMessageAtPhoneTextBox(), "Mobile no must not be blank");
	}

	@Test
	public void New_Customer_22_Phone_Have_Special_Characters(Method method) {
		newCustomerPage.refreshToPage();

		ExtentTestManager.startTest(method.getName(), browserName + "- New Customer with phone have special characters");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 01: Enter phone is '03466589@' to textbox");
		newCustomerPage.enterToPhoneTextBox("03466589@");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 02: Press Tab and move next field");
		newCustomerPage.pressingByKey(Keys.TAB);
		sleepInSecond(1);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 03: Verify error message at phone textbox");
		Assert.assertEquals(newCustomerPage.getErrorMessageAtPhoneTextBox(), "Special characters are not allowed");
	}

	@Test
	public void New_Customer_23_Phone_Have_Blank_Space(Method method) {
		newCustomerPage.refreshToPage();

		ExtentTestManager.startTest(method.getName(), browserName + "- New Customer with phone have blank space");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 01: Enter phone is '034 886 9888' to textbox");
		newCustomerPage.enterToPhoneTextBox("034 886 9888");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 02: Press Tab and move next field");
		newCustomerPage.pressingByKey(Keys.TAB);
		sleepInSecond(1);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 03: Verify error message at phone textbox");
		Assert.assertEquals(newCustomerPage.getErrorMessageAtPhoneTextBox(), "Characters are not allowed");
	}

	@Test
	public void New_Customer_24_Phone_Have_First_Characters_As_Blank_Space(Method method) {
		newCustomerPage.refreshToPage();

		ExtentTestManager.startTest(method.getName(), browserName + "- New Customer with phone have first characters as blank space");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 01: Enter phone is ' 0348858888' to textbox");
		newCustomerPage.enterToPhoneTextBox(" 0348858888");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 02: Press Tab and move next field");
		newCustomerPage.pressingByKey(Keys.TAB);
		sleepInSecond(1);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 03: Verify error message at phone textbox");
		Assert.assertEquals(newCustomerPage.getErrorMessageAtPhoneTextBox(), "First character can not have space");
	}

	@Test
	public void New_Customer_25_Empty_Email(Method method) {
		newCustomerPage.refreshToPage();

		ExtentTestManager.startTest(method.getName(), browserName + "- New Customer with email empty");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 01: Enter email empty to textbox");
		newCustomerPage.enterToEmailTextBox("");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 02: Press Tab and move next field");
		newCustomerPage.pressingByKey(Keys.TAB);
		sleepInSecond(1);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 03: Verify error message at phone textbox");
		Assert.assertEquals(newCustomerPage.getErrorMessageAtEmailTextBox(), "Email-ID must not be blank");
	}

	@Test
	public void New_Customer_26_Email_Incorrect_Format(Method method) {
		newCustomerPage.refreshToPage();

		ExtentTestManager.startTest(method.getName(), browserName + "- New Customer with email incorrect format");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 01: Enter email is 'bankguru@99' to textbox");
		newCustomerPage.enterToEmailTextBox("bankguru@99");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 02: Press Tab and move next field");
		newCustomerPage.pressingByKey(Keys.TAB);
		sleepInSecond(1);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 03: Verify error message at phone textbox");
		Assert.assertEquals(newCustomerPage.getErrorMessageAtEmailTextBox(), "Email-ID is not valid");
	}

	@Test
	public void New_Customer_27_Email_Have_First_Characters_As_Blank_Space(Method method) {
		newCustomerPage.refreshToPage();

		ExtentTestManager.startTest(method.getName(), browserName + "- New Customer with email have first character as blank space");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 01: Enter email is ' bankguru@gmail.com' to textbox");
		newCustomerPage.enterToEmailTextBox(" bankguru@gmail.com");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 02: Press Tab and move next field");
		newCustomerPage.pressingByKey(Keys.TAB);
		sleepInSecond(1);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 03: Verify error message at phone textbox");
		Assert.assertEquals(newCustomerPage.getErrorMessageAtEmailTextBox(), "First character can not have space");
	}

	@Test
	public void New_Customer_28_Success(Method method) {
		newCustomerPage.refreshToPage();
		ExtentTestManager.startTest(method.getName(), browserName + "- New Customer success");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  New Customer - Step 01: Enter  is ' bankguru@gmail.com' to textbox");
		newCustomerPage.enterToCustomerName(customerName);
		newCustomerPage.enterToDateOfBirth(dateOfBirth);
		newCustomerPage.enterToAddressTextarea(address);
		newCustomerPage.enterToCityTextBox(city);
		newCustomerPage.enterToStateTextBox(state);
		newCustomerPage.enterToPinTextBox(pin);
		newCustomerPage.enterToPhoneTextBox(phoneNumber);
		newCustomerPage.enterToEmailTextBox(email);
		newCustomerPage.enterToPasswordTextBox(password);

		newCustomerPage.clickToSubmitButton();
		sleepInSecond(2);

		Assert.assertEquals(newCustomerPage.getMessageNewCustomerSuccess(), "Customer Registered Successfully!!!");
		Assert.assertEquals(newCustomerPage.getCustomerNameAfterNewSuccess(), customerName);
		Assert.assertEquals(newCustomerPage.getDateOfBirthAfterNewSuccess(), dateOfBirthAfter);
		Assert.assertEquals(newCustomerPage.getAddressAfterNewSuccess(), address);
		Assert.assertEquals(newCustomerPage.getCityAfterNewSuccess(), city);
		Assert.assertEquals(newCustomerPage.getStateAfterNewSuccess(), state);
		Assert.assertEquals(newCustomerPage.getPinAfterNewSuccess(), pin);
		Assert.assertEquals(newCustomerPage.getPhoneAfterNewSuccess(), phoneNumber);
		Assert.assertEquals(newCustomerPage.getEmailAfterNewSuccess(), email);

		customerID = newCustomerPage.getCustomerID();
		System.out.println(customerID);

	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
}
