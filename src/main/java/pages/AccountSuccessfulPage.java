package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessfulPage {

	WebDriver driver;

	@FindBy(xpath = "//p[contains(text(),'Congratulations! Your new account has been success')]")
	WebElement SuccessMessage;

	public AccountSuccessfulPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String accountSuccessMessage() {

		return  SuccessMessage.getText();
	}

}
