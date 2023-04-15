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

public class Edit_Customer_02 extends BaseTest {
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private EditCustomerPageObject editCustomerPage;

	WebDriver driver;
	private String browserName, addressUpdate, cityUpdate, stateUpdate, pinUpdate, phoneUpdate, emailUpdate;

	@Parameters({ "envName", "envServer", "osName", "osVersion", "browser" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("dev") String envServer, @Optional("Windows") String osName, @Optional("10") String osVersion, @Optional("chrome") String browserName) {
		driver = getBrowserDriver(envName, envServer, osName, osVersion, browserName);

		this.browserName = browserName;
		addressUpdate = "Cho trieu khuc tan trieu";
		cityUpdate = "Thanh hoa";
		stateUpdate = "PASS";
		pinUpdate = "888888";
		phoneUpdate = "0345556666";
		emailUpdate = "test" + randomInt() + "@gmail.com";

		driver.get(GlobalConstants.USER_ADMIN_URL);
		loginPage = PageGeneratorManager.getLoginPagePO(driver);

		loginPage.enterToUserIDTextBox(Register.userId);
		loginPage.enterToPasswordTextBox(Register.password);
		loginPage.clickToLoginButton();

		homePage = PageGeneratorManager.getHomePagePO(driver);
		Assert.assertEquals(homePage.getMessageLoginSuccess(), "Welcome To Manager's Page of Guru99 Bank");

		homePage.openPageAtSizeBarByName("Edit Customer");
		editCustomerPage = PageGeneratorManager.getEditCustomerPO(driver);
		editCustomerPage.enterToCustomerID(New_Customer_02.customerID);
		editCustomerPage.clickToSubmitButton();
	}

	@Test
	public void Edit_Customer_11_Empty_Pin(Method method) {

		ExtentTestManager.startTest(method.getName(), browserName + "- Edit customer with pin empty");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 01: Enter pin empty to textbox");
		editCustomerPage.enterToPinTextBox("");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 02: Press Tab and move next field");
		editCustomerPage.pressingByKey(Keys.TAB);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 03: Verify error message at pin");
		Assert.assertEquals(editCustomerPage.getErrorMessageAtPinTextBox(), "PIN Code must not be blank");
	}

	@Test
	public void Edit_Customer_12_Pin_Is_Numeric(Method method) {
		editCustomerPage.refreshToPage();

		ExtentTestManager.startTest(method.getName(), browserName + "- Edit customer with pin is numeric");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 01: Enter pin is '12347P' to textbox");
		editCustomerPage.enterToPinTextBox("12347P");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 02: Press Tab and move next field");
		editCustomerPage.pressingByKey(Keys.TAB);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 03: Verify error message at pin");
		Assert.assertEquals(editCustomerPage.getErrorMessageAtPinTextBox(), "Characters are not allowed");
	}

	@Test
	public void Edit_Customer_13_Pin_Less_Than_6_Digits(Method method) {
		editCustomerPage.refreshToPage();

		ExtentTestManager.startTest(method.getName(), browserName + "- Edit customer with pin less than 6 digits");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 01: Enter pin is '12347' to textbox");
		editCustomerPage.enterToPinTextBox("12347");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 02: Press Tab and move next field");
		editCustomerPage.pressingByKey(Keys.TAB);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 03: Verify error message at pin");
		Assert.assertEquals(editCustomerPage.getErrorMessageAtPinTextBox(), "PIN Code must have 6 Digits");
	}

	@Test
	public void Edit_Customer_14_Pin_Hava_Special_Characters(Method method) {
		editCustomerPage.refreshToPage();

		ExtentTestManager.startTest(method.getName(), browserName + "- Edit customer with pin have special characters");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 01: Enter pin is '12347@' to textbox");
		editCustomerPage.enterToPinTextBox("12347@");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 02: Press Tab and move next field");
		editCustomerPage.pressingByKey(Keys.TAB);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 03: Verify error message at pin");
		Assert.assertEquals(editCustomerPage.getErrorMessageAtPinTextBox(), "Special characters are not allowed");
	}

	@Test
	public void Edit_Customer_15_Phone_Empty(Method method) {
		editCustomerPage.refreshToPage();

		ExtentTestManager.startTest(method.getName(), browserName + "- Edit customer with phone empty");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 01: Enter phone empty to textbox");
		editCustomerPage.enterToPhoneTextBox("");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 02: Press Tab and move next field");
		editCustomerPage.pressingByKey(Keys.TAB);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 03: Verify error message at phone");
		Assert.assertEquals(editCustomerPage.getErrorMessageAtPhoneTextBox(), "Mobile no must not be blank");
	}

	@Test
	public void Edit_Customer_16_Phone_Have_Special_Characters(Method method) {
		editCustomerPage.refreshToPage();

		ExtentTestManager.startTest(method.getName(), browserName + "- Edit customer with phone have special characters");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 01: Enter phone is '02344888@' to textbox");
		editCustomerPage.enterToPhoneTextBox("02344888@");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 02: Press Tab and move next field");
		editCustomerPage.pressingByKey(Keys.TAB);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 03: Verify error message at phone");
		Assert.assertEquals(editCustomerPage.getErrorMessageAtPhoneTextBox(), "Special characters are not allowed");
	}

	@Test
	public void Edit_Customer_17_Email_Empty(Method method) {
		editCustomerPage.refreshToPage();

		ExtentTestManager.startTest(method.getName(), browserName + "- Edit customer with email empty");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 01: Enter email empty to textbox");
		editCustomerPage.enterToEmailTextBox("");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 02: Press Tab and move next field");
		editCustomerPage.pressingByKey(Keys.TAB);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 03: Verify error message at phone");
		Assert.assertEquals(editCustomerPage.getErrorMessageAtEmailTextBox(), "Email-ID must not be blank");
	}

	@Test
	public void Edit_Customer_18_Email_Invalid_Format(Method method) {
		editCustomerPage.refreshToPage();

		ExtentTestManager.startTest(method.getName(), browserName + "- Edit customer with email invalid format");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 01: Enter email invalid is 'bank123@' to textbox");
		editCustomerPage.enterToEmailTextBox("bank123@");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 02: Press Tab and move next field");
		editCustomerPage.pressingByKey(Keys.TAB);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 03: Verify error message at phone");
		Assert.assertEquals(editCustomerPage.getErrorMessageAtEmailTextBox(), "Email-ID is not valid");
	}

	@Test
	public void Edit_Customer_19_Success(Method method) {
		editCustomerPage.refreshToPage();

		ExtentTestManager.startTest(method.getName(), browserName + "- Edit customer success");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 01: Enter address is '" + addressUpdate + "' to textbox");
		editCustomerPage.enterToAddressTextBox(addressUpdate);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 02: Enter city is '" + cityUpdate + "' to textbox");
		editCustomerPage.enterToCityTextBox(cityUpdate);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 03: Enter state is '" + stateUpdate + "' to textbox");
		editCustomerPage.enterToStateTextBox(stateUpdate);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 04: Enter pin is '" + pinUpdate + "' to textbox");
		editCustomerPage.enterToPinTextBox(pinUpdate);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 05: Enter phone is '" + phoneUpdate + "' to textbox");
		editCustomerPage.enterToPhoneTextBox(phoneUpdate);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 06: Enter email is '" + emailUpdate + "' to textbox");
		editCustomerPage.enterToEmailTextBox(emailUpdate);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Edit customer - Step 07: Click to submit button");
		editCustomerPage.clickToSubmitButtonInFormEdit();

		editCustomerPage.enterToCustomerID(New_Customer_02.customerID);
		editCustomerPage.clickToSubmitButton();

		Assert.assertEquals(editCustomerPage.getAddressAfterEditSuccess(), addressUpdate);
		Assert.assertEquals(editCustomerPage.getCityAfterEditSuccess(), cityUpdate);
		Assert.assertEquals(editCustomerPage.getStateAfterEditSuccess(), stateUpdate);
		Assert.assertEquals(editCustomerPage.getPinAfterEditSuccess(), pinUpdate);
		Assert.assertEquals(editCustomerPage.getPhoneAfterEditSuccess(), phoneUpdate);
		Assert.assertEquals(editCustomerPage.getEmailAfterEditSuccess(), emailUpdate);

	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
}
