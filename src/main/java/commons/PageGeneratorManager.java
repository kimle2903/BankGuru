package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.EditCustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.RegisterPageObject;

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
}
