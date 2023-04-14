package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void enterEmailToTextBox(String email) {
		waitForElementVisible(RegisterPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(RegisterPageUI.EMAIL_TEXTBOX, email);
	}

	public void clickToSubmitButton() {
		waitForElementClickable(RegisterPageUI.SUBMIT_BUTTON);
		clickToElement(RegisterPageUI.SUBMIT_BUTTON);
	}

	public String getTitleAfterRegister() {
		waitForElementVisible(RegisterPageUI.TITLE_AFTER_REGISTER);
		return getElementText(RegisterPageUI.TITLE_AFTER_REGISTER);
	}

	public String getUserId() {
		waitForElementVisible(RegisterPageUI.USER_ID_TEXT);
		return getElementText(RegisterPageUI.USER_ID_TEXT);
	}

	public String getPassword() {
		waitForElementVisible(RegisterPageUI.PASSWORD_TEXT);
		return getElementText(RegisterPageUI.PASSWORD_TEXT);
	}

}
