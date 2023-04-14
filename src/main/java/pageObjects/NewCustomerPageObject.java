package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.NewCustomerPageUI;

public class NewCustomerPageObject extends BasePage {
	WebDriver driver;

	public NewCustomerPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void enterToCustomerName(String customerName) {
		waitForElementVisible(NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
		sendKeyToElement(NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX, customerName);
	}

	public String getErrorMessageAtCustomerName() {
		waitForElementVisible(NewCustomerPageUI.ERROR_MESSAGE_AT_CUSTOMER_NAME);
		return getElementText(NewCustomerPageUI.ERROR_MESSAGE_AT_CUSTOMER_NAME);
	}

	public void enterToAddressTextarea(String address) {
		waitForElementVisible(NewCustomerPageUI.ADDRESS_TEXTAREA);
		sendKeyToElement(NewCustomerPageUI.ADDRESS_TEXTAREA, address);
	}

	public void enterToCityTextBox(String city) {
		waitForElementVisible(NewCustomerPageUI.CITY_TEXTBOX);
		sendKeyToElement(NewCustomerPageUI.CITY_TEXTBOX, city);
	}

	public void enterToStateTextBox(String state) {
		waitForElementVisible(NewCustomerPageUI.STATE_TEXTBOX);
		sendKeyToElement(NewCustomerPageUI.STATE_TEXTBOX, state);
	}

	public String getErrorMessageAtAddress() {
		waitForElementVisible(NewCustomerPageUI.ERROR_MESSAGE_AT_ADDRESS);
		return getElementText(NewCustomerPageUI.ERROR_MESSAGE_AT_ADDRESS);
	}

	public String getErrorMessageAtCity() {
		waitForElementVisible(NewCustomerPageUI.ERROR_MESSAGE_AT_CITY);
		return getElementText(NewCustomerPageUI.ERROR_MESSAGE_AT_CITY);
	}

	public String getErrorMessageAtState() {
		waitForElementVisible(NewCustomerPageUI.ERROR_MESSAGE_AT_STATE);
		return getElementText(NewCustomerPageUI.ERROR_MESSAGE_AT_STATE);
	}

	public void enterToPinTextBox(String pin) {
		waitForElementVisible(NewCustomerPageUI.PIN_TEXTBOX);
		sendKeyToElement(NewCustomerPageUI.PIN_TEXTBOX, pin);
	}

	public String getErrorMessageAtPin() {
		waitForElementVisible(NewCustomerPageUI.ERROR_MESSAGE_AT_PIN);
		return getElementText(NewCustomerPageUI.ERROR_MESSAGE_AT_PIN);
	}

	public void enterToPhoneTextBox(String phoneNumber) {
		waitForElementVisible(NewCustomerPageUI.PHONE_NUMBER_TEXTBOX);
		sendKeyToElement(NewCustomerPageUI.PHONE_NUMBER_TEXTBOX, phoneNumber);
	}

	public String getErrorMessageAtPhoneTextBox() {
		waitForElementVisible(NewCustomerPageUI.ERROR_MESSAGE_AT_PHONE);
		return getElementText(NewCustomerPageUI.ERROR_MESSAGE_AT_PHONE);
	}

	public void enterToEmailTextBox(String email) {
		waitForElementVisible(NewCustomerPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(NewCustomerPageUI.EMAIL_TEXTBOX, email);
	}

	public String getErrorMessageAtEmailTextBox() {
		waitForElementVisible(NewCustomerPageUI.ERROR_MESSAGE_AT_EMAIL);
		return getElementText(NewCustomerPageUI.ERROR_MESSAGE_AT_EMAIL);
	}

	public void enterToDateOfBirth(String dateOfBirth) {
		waitForElementVisible(NewCustomerPageUI.DATE_OF_BIRTH);
		sendKeyToElement(NewCustomerPageUI.DATE_OF_BIRTH, dateOfBirth);
	}

	public void clickToSubmitButton() {
		waitForElementClickable(NewCustomerPageUI.SUBMIT_BUTTON);
		clickToElement(NewCustomerPageUI.SUBMIT_BUTTON);
	}

	public void enterToPasswordTextBox(String password) {
		waitForElementClickable(NewCustomerPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(NewCustomerPageUI.PASSWORD_TEXTBOX, password);
	}

	public void acceptAlertNewCustomerSuccess() {
		waitForAlertPresence();
		acceptAlert();
	}

	public String getMessageNewCustomerSuccess() {
		waitForElementVisible(NewCustomerPageUI.MESSAGE_NEW_CUSTOMER_SUCCESS);
		return getElementText(NewCustomerPageUI.MESSAGE_NEW_CUSTOMER_SUCCESS);
	}

	public String getCustomerNameAfterNewSuccess() {
		waitForElementVisible(NewCustomerPageUI.CUSTOMER_NAME_AFTER_NEW);
		return getElementText(NewCustomerPageUI.CUSTOMER_NAME_AFTER_NEW);
	}

	public String getDateOfBirthAfterNewSuccess() {
		waitForElementVisible(NewCustomerPageUI.DATE_OF_BIRTH_AFTER_NEW);
		return getElementText(NewCustomerPageUI.DATE_OF_BIRTH_AFTER_NEW);
	}

	public String getAddressAfterNewSuccess() {
		waitForElementVisible(NewCustomerPageUI.ADDRESS_AFTER_NEW);
		return getElementText(NewCustomerPageUI.ADDRESS_AFTER_NEW);
	}

	public String getCityAfterNewSuccess() {
		waitForElementVisible(NewCustomerPageUI.CITY_AFTER_NEW);
		return getElementText(NewCustomerPageUI.CITY_AFTER_NEW);
	}

	public String getStateAfterNewSuccess() {
		waitForElementVisible(NewCustomerPageUI.STATE_AFTER_NEW);
		return getElementText(NewCustomerPageUI.STATE_AFTER_NEW);
	}

	public String getPinAfterNewSuccess() {
		waitForElementVisible(NewCustomerPageUI.PIN_AFTER_NEW);
		return getElementText(NewCustomerPageUI.PIN_AFTER_NEW);
	}

	public String getPhoneAfterNewSuccess() {
		waitForElementVisible(NewCustomerPageUI.PHONE_AFTER_NEW);
		return getElementText(NewCustomerPageUI.PHONE_AFTER_NEW);
	}

	public String getEmailAfterNewSuccess() {
		waitForElementVisible(NewCustomerPageUI.EMAIL_AFTER_NEW);
		return getElementText(NewCustomerPageUI.EMAIL_AFTER_NEW);
	}

	public String getCustomerID() {
		waitForElementVisible(NewCustomerPageUI.CUSTOMER_ID);
		return getElementText(NewCustomerPageUI.CUSTOMER_ID);
	}

}
