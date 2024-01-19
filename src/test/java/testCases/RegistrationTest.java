package testCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.Base;
import pages.HomePage;
import pages.RegistrationPage;
import utils.Utilities;

public class RegistrationTest extends Base{
	
	WebDriver driver;
	RegistrationPage registration ;
	public RegistrationTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		
	    driver=launchingBrowser("Chrome");
		HomePage home=new HomePage(driver);
		registration = home.navigateToRegistrationPage();
		
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(dataProvider = "excelDataRead")
	public void RegistrationWithValidCredential(String FirstName1, String LastName1, String EmailID1, String TelephoneNo1,
			String PassWord1, String ConfirmPassWord1) {
		
		
		registration.UserRegistrationField( FirstName1,  LastName1,  EmailID1,  TelephoneNo1,
				 PassWord1,  ConfirmPassWord1);
		
		
		
		
	 //registration.RegistrationFields();
	// String messageText = registration.warningMessage();
    // assert.assertEquals(messageText,"E-Mail Address is already registered!", "User already exists");
	
	 
	}
	
	@DataProvider(name="excelDataRead")
	public Object[][] excelDataRead() throws EncryptedDocumentException, IOException {
		Object[][] Data=Utilities.readDataFromExcel("RegistrationTestData");
		return Data;	
		
	}
	
	
	
	
	
	
	
	
	
	

}
