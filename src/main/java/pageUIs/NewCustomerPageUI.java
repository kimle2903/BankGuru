package pageUIs;

public class NewCustomerPageUI {
	public static final String CUSTOMER_NAME_TEXTBOX = "XPATH=//input[@name='name']";
	public static final String ADDRESS_TEXTAREA = "XPATH=//textarea[@name='addr']";
	public static final String CITY_TEXTBOX = "XPATH=//input[@name='city']";
	public static final String STATE_TEXTBOX = "XPATH=//input[@name='state']";
	public static final String PIN_TEXTBOX = "XPATH=//input[@name='pinno']";
	public static final String PHONE_NUMBER_TEXTBOX = "XPATH=//input[@name='telephoneno']";
	public static final String EMAIL_TEXTBOX = "XPATH=//input[@name='emailid']";
	public static final String DATE_OF_BIRTH = "XPATH=//input[@id='dob']";
	public static final String PASSWORD_TEXTBOX = "XPATH=//input[@name='password']";

	public static final String ERROR_MESSAGE_AT_CUSTOMER_NAME = "XPATH=//input[@name='name']/following-sibling::label";
	public static final String ERROR_MESSAGE_AT_ADDRESS = "XPATH=//textarea[@name='addr']/following-sibling::label";
	public static final String ERROR_MESSAGE_AT_CITY = "XPATH=//input[@name='city']/following-sibling::label";
	public static final String ERROR_MESSAGE_AT_STATE = "XPATH=//input[@name='state']/following-sibling::label";
	public static final String ERROR_MESSAGE_AT_PIN = "XPATH=//input[@name='pinno']/following-sibling::label";
	public static final String ERROR_MESSAGE_AT_PHONE = "XPATH=//input[@name='telephoneno']/following-sibling::label";
	public static final String ERROR_MESSAGE_AT_EMAIL = "XPATH=//input[@name='emailid']/following-sibling::label";

	public static final String SUBMIT_BUTTON = "XPATH=//input[@name='sub']";
	public static final String MESSAGE_NEW_CUSTOMER_SUCCESS = "XPATH=//td/p[@class='heading3']";
	public static final String CUSTOMER_NAME_AFTER_NEW = "XPATH=//td[text()='Customer Name']/following-sibling::td";
	public static final String DATE_OF_BIRTH_AFTER_NEW = "XPATH=//td[text()='Birthdate']/following-sibling::td";
	public static final String ADDRESS_AFTER_NEW = "XPATH=//td[text()='Address']/following-sibling::td";
	public static final String CITY_AFTER_NEW = "XPATH=//td[text()='City']/following-sibling::td";
	public static final String STATE_AFTER_NEW = "XPATH=//td[text()='State']/following-sibling::td";
	public static final String PIN_AFTER_NEW = "XPATH=//td[text()='Pin']/following-sibling::td";
	public static final String PHONE_AFTER_NEW = "XPATH=//td[text()='Mobile No.']/following-sibling::td";
	public static final String EMAIL_AFTER_NEW = "XPATH=//td[text()='Email']/following-sibling::td";
	public static final String CUSTOMER_ID = "XPATH=//td[text()='Customer ID']/following-sibling::td";

}
