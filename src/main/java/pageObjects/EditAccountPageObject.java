package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.EditAccountPageUI;

public class EditAccountPageObject extends BasePage {
	WebDriver driver;

	public EditAccountPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getTitleText() {
		waitForElementVisible(EditAccountPageUI.TITLE_TEXT);
		return getElementText(EditAccountPageUI.TITLE_TEXT);
	}

	public void enterToAccountIDTextBox(String accountID) {
		waitForElementVisible(EditAccountPageUI.ACCOUNT_ID_TEXBOX);
		sendKeyToElement(EditAccountPageUI.ACCOUNT_ID_TEXBOX, accountID);
	}

	public void clickToSubmitButton() {
		waitForElementClickable(EditAccountPageUI.SUBMIT_BUTTON);
		clickToElement(EditAccountPageUI.SUBMIT_BUTTON);
	}

}
