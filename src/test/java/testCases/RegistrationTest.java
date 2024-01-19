package testCases;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Base.Base;
import pages.RegistrationPage;
import utils.Utilities;

public class RegistrationTest extends Base{
	RegistrationPage registration;
	
	@Test(dataProvider = "excelDataRead")
	public void RegistrationWithValidCredential(String FirstName1, String LastName1, String EmailID1, String TelephoneNo1,
			String PassWord1, String ConfirmPassWord1) {
		
		
		registration=home.navigateToRegistrationPage();
		registration.UserRegistrationField(FirstName1, LastName1, EmailID1, TelephoneNo1, PassWord1, ConfirmPassWord1);
		
		
		
		
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
