package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.DeleteCustomerPageUI;

public class DeleteCustomerPageObject extends BasePage {
	WebDriver driver;

	public DeleteCustomerPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void enterToCustomerID(String customerID) {
		waitForElementVisible(DeleteCustomerPageUI.CUSTOMER_ID_TEXTBOX);
		sendKeyToElement(DeleteCustomerPageUI.CUSTOMER_ID_TEXTBOX, customerID);
	}

	public void clickToSubmitButton() {
		waitForElementClickable(DeleteCustomerPageUI.SUBMIT_BUTTON);
		clickToElement(DeleteCustomerPageUI.SUBMIT_BUTTON);
	}

	public String getErrorMessageAtCustomerID() {
		waitForElementVisible(DeleteCustomerPageUI.ERROR_MESSAGE_AT_CUSTOMER_ID);
		return getElementText(DeleteCustomerPageUI.ERROR_MESSAGE_AT_CUSTOMER_ID);
	}

	public void acceptDeleteAlert() {
		waitForAlertPresence();
		acceptAlert();
	}

	public String getTextInAlert() {
		waitForAlertPresence();
		return getTextAlert();
	}

}
