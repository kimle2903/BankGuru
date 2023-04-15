package pageUIs;

public class FundTransferPageUI {
	public static final String TITLE_TEXT = "XPATH=//td/p";
	public static final String PAYER_ACCOUNT_NUMBER_TEXTBOX = "XPATH=//td[text()='Payers account no']/following-sibling::td/input";
	public static final String PAYEE_ACCOUNT_NUMBER_TEXTBOX = "XPATH=//td[text()='Payees account no']/following-sibling::td/input";
	public static final String AMOUNT_TEXTBOX = "XPATH=//td[text()='Amount']/following-sibling::td/input";
	public static final String DESCRIPTION_TEXBOX = "XPATH=//td[text()='Description']/following-sibling::td/input";
	public static final String SUBMIT_BUTTON = "XPATH=//input[@value='Submit']";

	public static final String FROM_ACCOUNT_NUMBER = "XPATH=//td[text()='From Account Number']/following-sibling::td";
	public static final String TO_ACCOUNT_NUMBER = "XPATH=//td[text()='To Account Number']/following-sibling::td";
	public static final String AMOUNT_FUND = "XPATH=//td[text()='Amount']/following-sibling::td";
	public static final String DESCRIPTION_FUND = "XPATH=//td[text()='Description']/following-sibling::td";
}
