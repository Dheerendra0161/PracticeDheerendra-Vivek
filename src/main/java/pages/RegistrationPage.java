package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

	WebDriver driver;

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement firstName;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement lastName;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement emailField;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement telePhoneField;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement passWord;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement confirmPassWord;

	@FindBy(xpath = "//label[normalize-space()='Yes']//input[@name='newsletter']")
	WebElement YesNewLetterSubscribe;

	@FindBy(xpath = "//input[@value='0']")
	WebElement NoNewLetterSubscribe;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement agreePrivacyPolicy;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement continueButton;

	@FindBy(xpath = "//div[text()='Warning: E-Mail Address is already registered!']")
	WebElement warningMessage;
	
	
	
	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public String warningMessage() {
		return warningMessage.getText();
	}
	
	
	
	public void RegistrationFields() {

		firstName.sendKeys("Dheerendra");
		lastName.sendKeys("Vishwakarma");
		emailField.sendKeys("dheendra1608@gmail.com");
		telePhoneField.sendKeys("9838159161");
		passWord.sendKeys("123456");
		confirmPassWord.sendKeys("123456");
		YesNewLetterSubscribe.click();
		agreePrivacyPolicy.click();
		continueButton.click();
		
	}

	public void UserRegistrationField(String FirstName, String LastName, String EmailID, String TelephoneNo,
			String PassWord, String ConfirmPassWord) {

		firstName.sendKeys(FirstName);
		lastName.sendKeys(LastName);
		emailField.sendKeys(EmailID);
		telePhoneField.sendKeys(TelephoneNo);
		passWord.sendKeys(PassWord);
		confirmPassWord.sendKeys(ConfirmPassWord);
		YesNewLetterSubscribe.click();
		agreePrivacyPolicy.click();
		continueButton.click();
	}

}
