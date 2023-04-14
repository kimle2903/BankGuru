package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void enterToUserIDTextBox(String userId) {
		waitForElementVisible(LoginPageUI.USER_ID_TEXTBOX);
		sendKeyToElement(LoginPageUI.USER_ID_TEXTBOX, userId);
	}

	public void enterToPasswordTextBox(String password) {
		waitForElementVisible(LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public void clickToLoginButton() {
		waitForElementClickable(LoginPageUI.LOGIN_BUTTON);
		clickToElement(LoginPageUI.LOGIN_BUTTON);
	}

}
