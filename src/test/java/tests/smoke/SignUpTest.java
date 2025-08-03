package tests.smoke;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import core.base.BaseTest;
import dataproviders.ExcelDataProviders;
import pages.SignUpPage;
import utils.common.RandomEmail;
import utils.loggerutils.LoggerUtil;

@Listeners(listeners.TestListener.class)
public class SignUpTest extends BaseTest {

	private static final Logger log = LoggerUtil.getLogger(SignUpTest.class);

	@Test
	public void createNewUser() throws InterruptedException {

		String randomEmail = RandomEmail.generateRandomEmail();
		SignUpPage signUpPage = new SignUpPage();
		signUpPage.goToSignupPage();
		signUpPage.enterSignupDetails("BrijUser", randomEmail);
		signUpPage.fillRegistrationForm("Test@123", "MyName", "Mylastname", "companyName", "streen aa");
		Assert.assertTrue(signUpPage.isAccountCreated(), "Account was not created successfully");
	}

	@Test(dataProvider = "signupData", dataProviderClass = ExcelDataProviders.class)
	public void verifySignupWithExcelData(String name, String email, String password, String firstName, String lastName,
			String company, String address) {

		String randomEmail = RandomEmail.generateRandomEmail();
		SignUpPage signUpPage = new SignUpPage();
		signUpPage.goToSignupPage();
		signUpPage.enterSignupDetails(name, randomEmail);
		signUpPage.fillRegistrationForm(password, firstName, lastName, company, address);
		Assert.assertTrue(signUpPage.isAccountCreated(), "Account was not created");
	}

}
