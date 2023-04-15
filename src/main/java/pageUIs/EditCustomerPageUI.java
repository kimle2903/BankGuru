package pageUIs;

public class EditCustomerPageUI {

	public static final String CUSTOMER_ID_TEXTBOX = "xpath=//input[@name='cusid']";
	public static final String SUBMIT_BUTTON = "xpath=//input[@name='AccSubmit']";
	public static final String SUBMIT_BUTTON_IN_FORM_EDIT = "xpath=//input[@name='sub']";
	public static final String ERROR_MESSAGE_AT_CUSTOMER_ID = "xpath=//input[@name='cusid']/following-sibling::label";
	public static final String TITLE_EDIT_CUSTOMER = "xpath=//td/p[@class='heading3']";

	public static final String CUSTOMER_NAME_TEXTBOX = "XPATH=//input[@name='name']";
	public static final String ADDRESS_TEXTAREA = "XPATH=//textarea[@name='addr']";
	public static final String CITY_TEXTBOX = "XPATH=//input[@name='city']";
	public static final String STATE_TEXTBOX = "XPATH=//input[@name='state']";
	public static final String PIN_TEXTBOX = "XPATH=//input[@name='pinno']";
	public static final String PHONE_NUMBER_TEXTBOX = "XPATH=//input[@name='telephoneno']";
	public static final String EMAIL_TEXTBOX = "XPATH=//input[@name='emailid']";

	public static final String ERROR_MESSAGE_AT_ADDRESS = "XPATH=//textarea[@name='addr']/following-sibling::label";
	public static final String ERROR_MESSAGE_AT_CUSTOMER_NAME = "XPATH=//input[@name='name']/following-sibling::label";
	public static final String ERROR_MESSAGE_AT_CITY = "XPATH=//input[@name='city']/following-sibling::label";
	public static final String ERROR_MESSAGE_AT_STATE = "XPATH=//input[@name='state']/following-sibling::label";
	public static final String ERROR_MESSAGE_AT_PIN = "XPATH=//input[@name='pinno']/following-sibling::label";
	public static final String ERROR_MESSAGE_AT_PHONE = "XPATH=//input[@name='telephoneno']/following-sibling::label";
	public static final String ERROR_MESSAGE_AT_EMAIL = "XPATH=//input[@name='emailid']/following-sibling::label";

	public static final String ADDRESS_AFTER_EDIT = "XPATH=//td[text()='Address']/following-sibling::td";
	public static final String CITY_AFTER_EDIT = "XPATH=//td[text()='City']/following-sibling::td/input";
	public static final String STATE_AFTER_EDIT = "XPATH=//td[text()='State']/following-sibling::td/input";
	public static final String PIN_AFTER_EDIT = "XPATH=//td[text()='PIN']/following-sibling::td/input";
	public static final String PHONE_AFTER_EDIT = "XPATH=//td[text()='Mobile Number']/following-sibling::td/input";
	public static final String EMAIL_AFTER_EDIT = "XPATH=//td[text()='E-mail']/following-sibling::td/input";
}
