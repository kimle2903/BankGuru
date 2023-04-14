package com.bankguru.commons;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.RegisterPageObject;
import reportConfigs.ExtentTestManager;

public class Register extends BaseTest {
	WebDriver driver;
	private RegisterPageObject registerPage;
	public static String email, userId, password;
	private String browserName;

	@Parameters({ "envName", "envServer", "osName", "osVersion", "browser" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("dev") String envServer, @Optional("Windows") String osName, @Optional("10") String osVersion, @Optional("chrome") String browserName) {
		driver = getBrowserDriver(envName, envServer, osName, osVersion, browserName);

		this.browserName = browserName;
		registerPage = PageGeneratorManager.getRegisterPO(driver);
		email = "auto" + randomInt() + "@gmail.com";
	}

	@Test
	public void Register_Success(Method method) {
		ExtentTestManager.startTest(method.getName(), browserName + "- Register account");
		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Register account - Step 01: Enter to email register is '" + email + "'");
		registerPage.enterEmailToTextBox(email);

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Register account - Step 02: Click to button submit");
		registerPage.clickToSubmitButton();

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Register account - Step 03: Verify title after register");
		Assert.assertEquals(registerPage.getTitleAfterRegister(), "Access details to demo site.");

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Register account - Step 04: Get userId");
		userId = registerPage.getUserId();

		ExtentTestManager.getTest().log(Status.INFO, browserName + "-  Register account - Step 05: Get password");
		password = registerPage.getPassword();
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
}
