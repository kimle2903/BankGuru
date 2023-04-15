package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.NewAccountPageUI;

public class NewAccountPageObject extends BasePage {
	WebDriver driver;

	public NewAccountPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getTitleText() {
		waitForElementVisible(NewAccountPageUI.TITLE_TEXT);
		return getElementText(NewAccountPageUI.TITLE_TEXT);
	}

	public void enterToCustomerIDTextBox(String customerID) {
		waitForElementVisible(NewAccountPageUI.CUSTOMER_ID_TEXTBOX);
		sendKeyToElement(NewAccountPageUI.CUSTOMER_ID_TEXTBOX, customerID);
	}

	public void chooseAccountTypeInDropdown(String accountType) {
		waitForElementClickable(NewAccountPageUI.ACCOUNT_TYPE_DROPDOWN);
		selectItemInDropdownByVisibleText(NewAccountPageUI.ACCOUNT_TYPE_DROPDOWN, accountType);
	}

	public void enterInitialDepositTextBox(String initialDeposit) {
		waitForElementVisible(NewAccountPageUI.INITIAL_DEPOSIT_TEXTBOX);
		sendKeyToElement(NewAccountPageUI.INITIAL_DEPOSIT_TEXTBOX, initialDeposit);
	}

	public void clickToButtonSubmit() {
		waitForElementClickable(NewAccountPageUI.SUBMIT_BUTTON);
		clickToElement(NewAccountPageUI.SUBMIT_BUTTON);
	}

	public String getCustomerID() {
		waitForElementVisible(NewAccountPageUI.CUSTOMER_ID_TEXTBOX_AFTER_NEW);
		return getElementText(NewAccountPageUI.CUSTOMER_ID_TEXTBOX_AFTER_NEW);
	}

	public String getAccountType() {
		waitForElementVisible(NewAccountPageUI.ACCOUNT_TYPE_TEXTBOX_AFTER_NEW);
		return getElementText(NewAccountPageUI.ACCOUNT_TYPE_TEXTBOX_AFTER_NEW);
	}

	public String getCurrentAmount() {
		waitForElementVisible(NewAccountPageUI.CURRENT_AMOUNT_TEXTBOX_AFTER_NEW);
		return getElementText(NewAccountPageUI.CURRENT_AMOUNT_TEXTBOX_AFTER_NEW);
	}

	public String getAccountID() {
		waitForElementVisible(NewAccountPageUI.ACCOUNT_ID_TEXTBOX);
		return getElementText(NewAccountPageUI.ACCOUNT_ID_TEXTBOX);
	}

}
