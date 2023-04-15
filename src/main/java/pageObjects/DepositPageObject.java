package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class DepositPageObject extends BasePage {
	WebDriver driver;

	public DepositPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getTitleText() {
		// TODO Auto-generated method stub
		return null;
	}

}
