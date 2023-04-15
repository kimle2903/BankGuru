package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class PaymentPageObject extends BasePage {
	WebDriver driver;

	public PaymentPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
