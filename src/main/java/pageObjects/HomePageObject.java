package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getMessageLoginSuccess() {
		waitForElementVisible(HomePageUI.MESSAGE_LOGIN_SUCCESS);
		return getElementText(HomePageUI.MESSAGE_LOGIN_SUCCESS);
	}

}
