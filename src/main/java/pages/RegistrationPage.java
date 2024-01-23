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

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement privacyPolicyWarning;

	@FindBy(xpath = "//label[@for='input-firstname']")
	WebElement firstNameRedMark;

	@FindBy(xpath = "//label[@for='input-lastname']")
	WebElement lastNameRedMark;

	@FindBy(xpath = "//label[@for='input-email']")
	WebElement emailRedMark;

	@FindBy(xpath = "//label[@for='input-telephone']")
	WebElement telephoneRedMark;

	@FindBy(xpath = "//label[@for='input-password']")
	WebElement inputPassRedMark;

	@FindBy(xpath = "//label[@for='input-confirm']")
	WebElement inputPassConfirmRedMark;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public AccountSuccessfulPage RegistrationWithYesField(String FirstName, String LastName, String EmailID,
			String TelephoneNo, String PassWord, String ConfirmPassWord) {

		firstName.sendKeys(FirstName);
		lastName.sendKeys(LastName);
		emailField.sendKeys(EmailID);
		telePhoneField.sendKeys(TelephoneNo);
		passWord.sendKeys(PassWord);
		confirmPassWord.sendKeys(ConfirmPassWord);
		YesNewLetterSubscribe.click();
		agreePrivacyPolicy.click();
		continueButton.click();
		return new AccountSuccessfulPage(driver);
	}

	public AccountSuccessfulPage RegistrationWithoutYesField(String FirstName, String LastName, String EmailID,
			String TelephoneNo, String PassWord, String ConfirmPassWord) {

		firstName.sendKeys(FirstName);
		lastName.sendKeys(LastName);
		emailField.sendKeys(EmailID);
		telePhoneField.sendKeys(TelephoneNo);
		passWord.sendKeys(PassWord);
		confirmPassWord.sendKeys(ConfirmPassWord);
		agreePrivacyPolicy.click();
		continueButton.click();
		return new AccountSuccessfulPage(driver);
	}

	public void RegistrationClickButton() {
		continueButton.click();

	}
	
	public void validateThankYouForRegistration() {
		
	}
	
	

	public void RegistrationClickButtonWIthCheckBox() {
		agreePrivacyPolicy.click();
		continueButton.click();

	}

	public String warningMessageAgreePolicy() {
		return privacyPolicyWarning.getText();
	}

	public String warningMessage() {
		return warningMessage.getText();
	}

	public boolean validateFieldsMarkedWithRedColorSymbol() {
		boolean isFirstNameDisplayed = firstNameRedMark.isDisplayed();
		boolean isLastNameDisplayed = lastNameRedMark.isDisplayed();
		boolean isEmailDisplayed = emailRedMark.isDisplayed();
		boolean isTelephoneDisplayed = telephoneRedMark.isDisplayed();
		boolean isInputPassDisplayed = inputPassRedMark.isDisplayed();
		boolean isInputPassConfirmDisplayed = inputPassConfirmRedMark.isDisplayed();

		// Return true if all elements are displayed, otherwise return false
		return isFirstNameDisplayed && isLastNameDisplayed && isEmailDisplayed && isTelephoneDisplayed
				&& isInputPassDisplayed && isInputPassConfirmDisplayed;
	}

}
