package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.FundTransferPageUI;

public class FundTransferPageObject extends BasePage {
	WebDriver driver;

	public FundTransferPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getTitleText() {
		waitForElementVisible(FundTransferPageUI.TITLE_TEXT);
		return getElementText(FundTransferPageUI.TITLE_TEXT);
	}

	public void enterToPayerAccountNumberTextBox(String accountID) {
		waitForElementVisible(FundTransferPageUI.PAYER_ACCOUNT_NUMBER_TEXTBOX);
		sendKeyToElement(FundTransferPageUI.PAYER_ACCOUNT_NUMBER_TEXTBOX, accountID);
	}

	public void enterToPayeesAccountNumberTextBox(String payeeAccountID) {
		waitForElementVisible(FundTransferPageUI.PAYEE_ACCOUNT_NUMBER_TEXTBOX);
		sendKeyToElement(FundTransferPageUI.PAYEE_ACCOUNT_NUMBER_TEXTBOX, payeeAccountID);
	}

	public void enterToAmountTextBox(String accountWithdrawal) {
		waitForElementVisible(FundTransferPageUI.AMOUNT_TEXTBOX);
		sendKeyToElement(FundTransferPageUI.AMOUNT_TEXTBOX, accountWithdrawal);
	}

	public void enterToDescriptionTextBox(String description) {
		waitForElementVisible(FundTransferPageUI.DESCRIPTION_TEXBOX);
		sendKeyToElement(FundTransferPageUI.DESCRIPTION_TEXBOX, description);
	}

	public void clickToSubmitButton() {
		waitForElementClickable(FundTransferPageUI.SUBMIT_BUTTON);
		clickToElement(FundTransferPageUI.SUBMIT_BUTTON);
	}

	public String getFromAccountNumber() {
		waitForElementVisible(FundTransferPageUI.FROM_ACCOUNT_NUMBER);
		return getElementText(FundTransferPageUI.FROM_ACCOUNT_NUMBER);
	}

	public String getToAccountNumber() {
		waitForElementVisible(FundTransferPageUI.TO_ACCOUNT_NUMBER);
		return getElementText(FundTransferPageUI.TO_ACCOUNT_NUMBER);
	}

	public String getAmount() {
		waitForElementVisible(FundTransferPageUI.AMOUNT_FUND);
		return getElementText(FundTransferPageUI.AMOUNT_FUND);
	}

	public String getDescription() {
		waitForElementVisible(FundTransferPageUI.DESCRIPTION_FUND);
		return getElementText(FundTransferPageUI.DESCRIPTION_FUND);
	}

}
