package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Base;
import pages.AccountSuccessfulPage;
import pages.HomePage;
import pages.RegistrationPage;
import utils.CreateTestData;
import utils.Utilities;

public class RegistrationTest extends Base {

	WebDriver driver;
	RegistrationPage registration;

	AccountSuccessfulPage ACpage;

	public RegistrationTest() {
		super();
	}

//	@BeforeMethod	
//	public void setUp() {
//		
//	    driver=launchingBrowser("Chrome");
//		HomePage home=new HomePage(driver);
//		registration = home.navigateToRegistrationPage();
//		
//	}
//	
//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}

	@Test(dataProvider = "excelDataRead")
	public void Registration_Valid_NewUsers(String FirstName1, String LastName1, String EmailID1, String TelephoneNo1,
			String PassWord1, String ConfirmPassWord1) {

		// Create unique data in excel file
		registration = home.navigateToRegistrationPage();
		ACpage = registration.RegistrationWithYesField(FirstName1, LastName1, EmailID1, TelephoneNo1, PassWord1,
				ConfirmPassWord1);
//		Assert.assertEquals(ACpage.accountSuccessMessage(),
//				"Congratulations! Your new account has been successfully created!",
//				"Account Success page is not displayed");
	}

	@Test(dataProvider = "excelDataRead")
	public void Registration_With_Existing_Email(String FirstName1, String LastName1, String EmailID1,
			String TelephoneNo1, String PassWord1, String ConfirmPassWord1) {

		registration = home.navigateToRegistrationPage();
		ACpage = registration.RegistrationWithYesField(FirstName1, LastName1, EmailID1, TelephoneNo1, PassWord1,
				ConfirmPassWord1);

	}

	@DataProvider(name = "excelDataRead")
	public Object[][] excelDataRead() throws EncryptedDocumentException, IOException {
		Object[][] Data = Utilities.readDataFromExcel("RegistrationTestData");
		return Data;

	}

	
	
	@Test
	public void Registration_NewUsers() throws InterruptedException {

		registration = home.navigateToRegistrationPage();
		ACpage = registration.RegistrationWithoutYesField(CreateTestData.UniqueName("Dheerendra"),
				CreateTestData.UniqueName("Vishwakarma"), CreateTestData.Email_ID_TestData("Dheerendra"),
				CreateTestData.UniqueMobiled("8750"),"Dheere64644", "Dheere64644");
		
		Thread.sleep(Duration.ofSeconds(5));
		Assert.assertEquals(ACpage.accountSuccessMessage(),
				"Congratulations! Your new account has been successfully created!",
				"Account Success page is not displayed");
		
	}
	
	@Test
	public  void Registration_Without_AnyField() {
		
		registration = home.navigateToRegistrationPage();
		registration.RegistrationClickButton();
		Assert.assertEquals(registration.warningMessageAgreePolicy(), "Warning: You must agree to the Privacy Policy!", "PrivacyPolicyMessage Not found");
		
	}
	
	
	@Test
	public void Registration_PrivacyPolicy_checkbox_option_Selected() {
		registration = home.navigateToRegistrationPage();
		registration.RegistrationClickButtonWIthCheckBox();
	}
	
	
	@Test
	public void testFieldRedColorSymbols() {
		registration = home.navigateToRegistrationPage();
	    boolean areFieldsMarkedWithRedColor = registration.validateFieldsMarkedWithRedColorSymbol();

	    // Assert that all fields are marked with red color symbols
	    Assert.assertTrue(areFieldsMarkedWithRedColor, "Fields are not marked with red color symbols");
	}



}
