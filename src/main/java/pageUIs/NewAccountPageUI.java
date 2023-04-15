package pageUIs;

public class NewAccountPageUI {
	public static final String TITLE_TEXT = "XPATH=//td/p";
	public static final String CUSTOMER_ID_TEXTBOX = "xpath=//td[text()='Customer id']/following-sibling::td/input";
	public static final String ACCOUNT_TYPE_DROPDOWN = "xpath=//td[text()=' Account type']/following-sibling::td/select";
	public static final String INITIAL_DEPOSIT_TEXTBOX = "xpath=//td[contains(text(), 'Initial deposit')]/following-sibling::td/input";
	public static final String SUBMIT_BUTTON = "xpath=//input[@value='submit']";
	public static final String ACCOUNT_ID_TEXTBOX = "xpath=//td[text()='Account ID']/following-sibling::td";

	public static final String CUSTOMER_ID_TEXTBOX_AFTER_NEW = "xpath=//td[text()='Customer ID']/following-sibling::td";
	public static final String ACCOUNT_TYPE_TEXTBOX_AFTER_NEW = "xpath=//td[text()='Account Type']/following-sibling::td";
	public static final String CURRENT_AMOUNT_TEXTBOX_AFTER_NEW = "xpath=//td[text()='Current Amount']/following-sibling::td";

}
