package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement myAccountButton;

	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement registerButton;

	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement loginButton;

	@FindBy(xpath = "//span[normalize-space()='Wish List (0)']")
	WebElement wishListButton;

	@FindBy(xpath = "//span[normalize-space()='Shopping Cart']")
	WebElement shoppingCartButton;

	@FindBy(xpath = "//div[@id='top-links']")
	WebElement checkoutButton;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public RegistrationPage navigateToRegistrationPage() {
		myAccountButton.click();
		registerButton.click();
		return new RegistrationPage(driver);

	}

	public LoginPage navigateToLoginPage() {
		myAccountButton.click();
		loginButton.click();
		return new LoginPage(driver);
	}

	public ShoppingCartPage navigateToShoppingCartPage() {
		myAccountButton.click();
		shoppingCartButton.click();
		return new ShoppingCartPage(driver);
	}

	public CheckOutPage navigateToCheckOutPage() {
		myAccountButton.click();
		loginButton.click();
		return new CheckOutPage(driver);
	}

}
