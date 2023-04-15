package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.DeleteCustomerPageObject;
import pageObjects.DepositPageObject;
import pageObjects.EditAccountPageObject;
import pageObjects.EditCustomerPageObject;
import pageObjects.FundTransferPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.RegisterPageObject;
import pageObjects.WithDrawalPageObject;

public class PageGeneratorManager {
	public static RegisterPageObject getRegisterPO(WebDriver driver) {
		return new RegisterPageObject(driver);
	}

	public static LoginPageObject getLoginPagePO(WebDriver driver) {
		return new LoginPageObject(driver);
	}

	public static HomePageObject getHomePagePO(WebDriver driver) {
		return new HomePageObject(driver);
	}

	public static NewCustomerPageObject getNewCustomerPO(WebDriver driver) {
		return new NewCustomerPageObject(driver);
	}

	public static EditCustomerPageObject getEditCustomerPO(WebDriver driver) {
		return new EditCustomerPageObject(driver);
	}

	public static DeleteCustomerPageObject getDeleteCustomerPO(WebDriver driver) {
		return new DeleteCustomerPageObject(driver);
	}

	public static NewAccountPageObject getNewAccountPO(WebDriver driver) {
		return new NewAccountPageObject(driver);
	}

	public static EditAccountPageObject getEditAccountPO(WebDriver driver) {
		return new EditAccountPageObject(driver);
	}

	public static DepositPageObject getDepositPO(WebDriver driver) {
		return new DepositPageObject(driver);
	}

	public static WithDrawalPageObject getWithDrawalPO(WebDriver driver) {
		return new WithDrawalPageObject(driver);
	}

	public static FundTransferPageObject getFundTransferPO(WebDriver driver) {
		return new FundTransferPageObject(driver);
	}
}
