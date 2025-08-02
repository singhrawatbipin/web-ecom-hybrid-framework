package pages;

import org.openqa.selenium.By;

import core.base.BasePage;

public class LoginPage extends BasePage {

	private By loginLink = By.xpath("//a[text()=' Signup / Login']");
	private By emailInput = By.xpath("//input[@data-qa='login-email']");
	private By passwordInput = By.xpath("//input[@data-qa='login-password']");
	private By loginButton = By.xpath("//button[@data-qa='login-button']");
	private By loginConfirmation = By.xpath("//a[contains(text(),'Logged in as')]");

	public void openLoginPage() {
		click(loginLink);
	}

	public void login(String email, String password) {
		type(emailInput, email);
		type(passwordInput, password);
		click(loginButton);
	}

	public boolean isLoginSuccessful() {
		return isElementVisible(loginConfirmation);
	}

}
