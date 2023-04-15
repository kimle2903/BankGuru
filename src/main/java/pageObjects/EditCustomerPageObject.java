package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.EditCustomerPageUI;

public class EditCustomerPageObject extends BasePage {
	WebDriver driver;

	public EditCustomerPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void enterToCustomerID(String customerID) {
		waitForElementVisible(EditCustomerPageUI.CUSTOMER_ID_TEXTBOX);
		sendKeyToElement(EditCustomerPageUI.CUSTOMER_ID_TEXTBOX, customerID);
	}

	public void clickToSubmitButton() {
		waitForElementClickable(EditCustomerPageUI.SUBMIT_BUTTON);
		clickToElement(EditCustomerPageUI.SUBMIT_BUTTON);
	}

	public String getErrorMessageAtCustomerID() {
		waitForElementVisible(EditCustomerPageUI.ERROR_MESSAGE_AT_CUSTOMER_ID);
		return getElementText(EditCustomerPageUI.ERROR_MESSAGE_AT_CUSTOMER_ID);
	}

	public String getTitleEditCustomer() {
		waitForElementVisible(EditCustomerPageUI.TITLE_EDIT_CUSTOMER);
		return getElementText(EditCustomerPageUI.TITLE_EDIT_CUSTOMER);
	}

	public void enterToAddressTextBox(String address) {
		waitForElementVisible(EditCustomerPageUI.ADDRESS_TEXTAREA);
		sendKeyToElement(EditCustomerPageUI.ADDRESS_TEXTAREA, address);
	}

	public String getErrorMessageAtAddressTextBox() {
		waitForElementVisible(EditCustomerPageUI.ERROR_MESSAGE_AT_ADDRESS);
		return getElementText(EditCustomerPageUI.ERROR_MESSAGE_AT_ADDRESS);
	}

	public void enterToCityTextBox(String city) {
		waitForElementVisible(EditCustomerPageUI.CITY_TEXTBOX);
		sendKeyToElement(EditCustomerPageUI.CITY_TEXTBOX, city);
	}

	public String getErrorMessageAtCityTextBox() {
		waitForElementVisible(EditCustomerPageUI.ERROR_MESSAGE_AT_CITY);
		return getElementText(EditCustomerPageUI.ERROR_MESSAGE_AT_CITY);
	}

	public void enterToStateTextBox(String state) {
		waitForElementVisible(EditCustomerPageUI.STATE_TEXTBOX);
		sendKeyToElement(EditCustomerPageUI.STATE_TEXTBOX, state);
	}

	public String getErrorMessageAtStateTextBox() {
		waitForElementVisible(EditCustomerPageUI.ERROR_MESSAGE_AT_STATE);
		return getElementText(EditCustomerPageUI.ERROR_MESSAGE_AT_STATE);
	}

	public void enterToPinTextBox(String pin) {
		waitForElementVisible(EditCustomerPageUI.PIN_TEXTBOX);
		sendKeyToElement(EditCustomerPageUI.PIN_TEXTBOX, pin);
	}

	public String getErrorMessageAtPinTextBox() {
		waitForElementVisible(EditCustomerPageUI.ERROR_MESSAGE_AT_PIN);
		return getElementText(EditCustomerPageUI.ERROR_MESSAGE_AT_PIN);
	}

	public void enterToPhoneTextBox(String phone) {
		waitForElementVisible(EditCustomerPageUI.PHONE_NUMBER_TEXTBOX);
		sendKeyToElement(EditCustomerPageUI.PHONE_NUMBER_TEXTBOX, phone);
	}

	public String getErrorMessageAtPhoneTextBox() {
		waitForElementVisible(EditCustomerPageUI.ERROR_MESSAGE_AT_PHONE);
		return getElementText(EditCustomerPageUI.ERROR_MESSAGE_AT_PHONE);
	}

	public void enterToEmailTextBox(String email) {
		waitForElementVisible(EditCustomerPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(EditCustomerPageUI.EMAIL_TEXTBOX, email);
	}

	public String getErrorMessageAtEmailTextBox() {
		waitForElementVisible(EditCustomerPageUI.ERROR_MESSAGE_AT_EMAIL);
		return getElementText(EditCustomerPageUI.ERROR_MESSAGE_AT_EMAIL);
	}

	public void enterToCustomerNameTextBox(String nameUpdate) {
		waitForElementVisible(EditCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
		sendKeyToElement(EditCustomerPageUI.CUSTOMER_NAME_TEXTBOX, nameUpdate);
	}

	public void clickToSubmitButtonInFormEdit() {
		waitForElementClickable(EditCustomerPageUI.SUBMIT_BUTTON_IN_FORM_EDIT);
		clickToElement(EditCustomerPageUI.SUBMIT_BUTTON_IN_FORM_EDIT);
	}

	public String getAddressAfterEditSuccess() {
		waitForElementVisible(EditCustomerPageUI.ADDRESS_AFTER_EDIT);
		return getElementText(EditCustomerPageUI.ADDRESS_AFTER_EDIT);
	}

	public String getCityAfterEditSuccess() {
		waitForElementVisible(EditCustomerPageUI.CITY_AFTER_EDIT);
		return getElementAttribute(EditCustomerPageUI.CITY_AFTER_EDIT, "value");
	}

	public String getStateAfterEditSuccess() {
		waitForElementVisible(EditCustomerPageUI.STATE_AFTER_EDIT);
		return getElementAttribute(EditCustomerPageUI.STATE_AFTER_EDIT, "value");
	}

	public String getPinAfterEditSuccess() {
		waitForElementVisible(EditCustomerPageUI.PIN_AFTER_EDIT);
		return getElementAttribute(EditCustomerPageUI.PIN_AFTER_EDIT, "value");
	}

	public String getPhoneAfterEditSuccess() {
		waitForElementVisible(EditCustomerPageUI.PHONE_AFTER_EDIT);
		return getElementAttribute(EditCustomerPageUI.PHONE_AFTER_EDIT, "value");
	}

	public String getEmailAfterEditSuccess() {
		waitForElementVisible(EditCustomerPageUI.EMAIL_AFTER_EDIT);
		return getElementAttribute(EditCustomerPageUI.EMAIL_AFTER_EDIT, "value");
	}

}
