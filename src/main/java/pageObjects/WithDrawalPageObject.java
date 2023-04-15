package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.WithDrawalPageUI;

public class WithDrawalPageObject extends BasePage {
	WebDriver driver;

	public WithDrawalPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getTitleText() {
		waitForElementVisible(WithDrawalPageUI.TITLE_TEXT);
		return getElementText(WithDrawalPageUI.TITLE_TEXT);
	}

	public void enterToAccountIDTextBox(String accountID) {
		waitForElementVisible(WithDrawalPageUI.ACCOUNT_ID_TEXBOX);
		sendKeyToElement(WithDrawalPageUI.ACCOUNT_ID_TEXBOX, accountID);
	}

	public void enterToAmountTextBox(String accountWithdrawal) {
		waitForElementVisible(WithDrawalPageUI.AMOUNT_TEXBOX);
		sendKeyToElement(WithDrawalPageUI.AMOUNT_TEXBOX, accountWithdrawal);
	}

	public void enterToDescriptionTextBox(String description) {
		waitForElementVisible(WithDrawalPageUI.DESCRIPTION_TEXBOX);
		sendKeyToElement(WithDrawalPageUI.DESCRIPTION_TEXBOX, description);
	}

	public void clickToSubmitButton() {
		waitForElementClickable(WithDrawalPageUI.SUBMIT_BUTTON);
		clickToElement(WithDrawalPageUI.SUBMIT_BUTTON);
	}

}
