package tests.smoke;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import core.base.BaseTest;
import pages.SignUpPage;
import utils.loggerutils.LoggerUtil;

@Listeners(listeners.TestListener.class)
public class SignUpTest extends BaseTest {

	private static final Logger log = LoggerUtil.getLogger(SignUpTest.class);
	
	@Test
	public void createNewUser() throws InterruptedException {
		String randomEmail = "user" + System.currentTimeMillis() + "@mail.com";

		SignUpPage signUpPage = new SignUpPage();

		signUpPage.goToSignupPage();

		signUpPage.enterSignupDetails("BrijUser", randomEmail);
		signUpPage.fillRegistrationForm("Test@123", "MyName", "Mylastname", "companyName", "streen aa");
		Assert.assertTrue(signUpPage.isAccountCreated(), "Account was not created successfully");
	}

}
