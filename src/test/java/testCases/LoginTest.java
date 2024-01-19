package testCases;

import org.testng.annotations.Test;

import Base.Base;
import pages.LoginPage;

public class LoginTest extends Base{
	LoginPage login;
	@Test
	public void loginTest() {
		 login=home.navigateToLoginPage();
		 
	}
	

}
