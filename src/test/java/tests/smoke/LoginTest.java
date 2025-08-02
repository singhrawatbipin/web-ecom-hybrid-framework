package tests.smoke;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import core.base.BaseTest;
import pages.LoginPage;
import utils.loggerutils.LoggerUtil;

@Listeners(listeners.TestListener.class)
public class LoginTest extends BaseTest {

	private static final Logger log = LoggerUtil.getLogger(LoginTest.class);

	@Test
	public void verifyValidLogin() {

		LoginPage loginPage = new LoginPage();
		log.info("Starting login test");
		loginPage.openLoginPage();
		loginPage.login("singhrawatbipin@example.com", "password123");
		Assert.fail();
		Assert.assertTrue(loginPage.isLoginSuccessful(), "Login was not successful");

	}

}
