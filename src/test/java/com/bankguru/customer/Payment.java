package com.bankguru.customer;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.commons.Register;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.DepositPageObject;
import pageObjects.EditAccountPageObject;
import pageObjects.FundTransferPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.WithDrawalPageObject;

public class Payment extends BaseTest {
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private NewAccountPageObject newAccountPage;
	private EditAccountPageObject editAccountPage;
	private DepositPageObject depositPage;
	private WithDrawalPageObject withDrawalPage;
	private FundTransferPageObject fundTransfer;

	WebDriver driver;
	private String browserName, accountType, initialDeposit, accountWithdrawal, description;
	private static String accountID;

	@Parameters({ "envName", "envServer", "osName", "osVersion", "browser" })
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("dev") String envServer, @Optional("Windows") String osName, @Optional("10") String osVersion, @Optional("chrome") String browserName) {
		driver = getBrowserDriver(envName, envServer, osName, osVersion, browserName);
		this.browserName = browserName;
		accountType = "Savings";
		initialDeposit = "500000";
		accountWithdrawal = "100000";

		driver.get(GlobalConstants.USER_ADMIN_URL);
		loginPage = PageGeneratorManager.getLoginPagePO(driver);

		loginPage.enterToUserIDTextBox(Register.userId);
		loginPage.enterToPasswordTextBox(Register.password);
		loginPage.clickToLoginButton();

		homePage = PageGeneratorManager.getHomePagePO(driver);
		Assert.assertEquals(homePage.getMessageLoginSuccess(), "Welcome To Manager's Page of Guru99 Bank");

	}

	@Test
	public void TC_01_Add_New_Account(Method method) {
		homePage.openPageAtSizeBarByName("New Account");
		newAccountPage = PageGeneratorManager.getNewAccountPO(driver);
		Assert.assertEquals(newAccountPage.getTitleText(), "Add new account form");

		newAccountPage.enterToCustomerIDTextBox(New_Customer_02.customerID);
		newAccountPage.chooseAccountTypeInDropdown(accountType);
		newAccountPage.enterInitialDepositTextBox(initialDeposit);
		newAccountPage.clickToButtonSubmit();

		Assert.assertEquals(newAccountPage.getTitleText(), "Account Generated Successfully!!!");
		Assert.assertEquals(newAccountPage.getCustomerID(), New_Customer_02.customerID);
		Assert.assertEquals(newAccountPage.getAccountType(), accountType);
		Assert.assertEquals(newAccountPage.getCurrentAmount(), initialDeposit);

		accountID = newAccountPage.getAccountID();
	}

	@Test
	public void TC_04_Withdrawal_Money(Method method) {
		description = "Withdrawal money";
		newAccountPage.openPageAtSizeBarByName("Withdrawal");
		withDrawalPage = PageGeneratorManager.getWithDrawalPO(driver);

		Assert.assertEquals(withDrawalPage.getTitleText(), "Amount Withdrawal Form");
		withDrawalPage.enterToAccountIDTextBox(accountID);
		withDrawalPage.enterToAmountTextBox(accountWithdrawal);
		withDrawalPage.enterToDescriptionTextBox(description);
		withDrawalPage.clickToSubmitButton();

		Assert.assertEquals(withDrawalPage.getTitleText(), "Transaction details of Withdrawal for Account " + accountID);
	}

	@Test
	public void TC_05_FundTransfer(Method method) {
		description = "Fund transfer";
		withDrawalPage.openPageAtSizeBarByName("Fund Transfer");
		fundTransfer = PageGeneratorManager.getFundTransferPO(driver);

		Assert.assertEquals(fundTransfer.getTitleText(), "Fund transfer");
		fundTransfer.enterToPayerAccountNumberTextBox(accountID);
		fundTransfer.enterToPayeesAccountNumberTextBox("121332");
		fundTransfer.enterToAmountTextBox(accountWithdrawal);
		fundTransfer.enterToDescriptionTextBox(description);
		fundTransfer.clickToSubmitButton();

		Assert.assertEquals(fundTransfer.getTitleText(), "Fund Transfer Details");
		Assert.assertEquals(fundTransfer.getFromAccountNumber(), accountID);
		Assert.assertEquals(fundTransfer.getToAccountNumber(), "121332");
		Assert.assertEquals(fundTransfer.getAmount(), accountWithdrawal);
		Assert.assertEquals(fundTransfer.getDescription(), description);
	}

	@Test
	public void TC_05_Delete_Account(Method method) {
		description = "Fund transfer";
		withDrawalPage.openPageAtSizeBarByName("Fund Transfer");
		fundTransfer = PageGeneratorManager.getFundTransferPO(driver);

		Assert.assertEquals(fundTransfer.getTitleText(), "Fund transfer");
		fundTransfer.enterToPayerAccountNumberTextBox(accountID);
		fundTransfer.enterToPayeesAccountNumberTextBox("121332");
		fundTransfer.enterToAmountTextBox(accountWithdrawal);
		fundTransfer.enterToDescriptionTextBox(description);
		fundTransfer.clickToSubmitButton();

		Assert.assertEquals(fundTransfer.getTitleText(), "Fund Transfer Details");
		Assert.assertEquals(fundTransfer.getFromAccountNumber(), accountID);
		Assert.assertEquals(fundTransfer.getToAccountNumber(), "121332");
		Assert.assertEquals(fundTransfer.getAmount(), accountWithdrawal);
		Assert.assertEquals(fundTransfer.getDescription(), description);
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
}
