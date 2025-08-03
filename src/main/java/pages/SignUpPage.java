package pages;

import core.base.BasePage;
import org.openqa.selenium.By;

import utils.common.PopUpUtil;
import utils.waitutils.WaitUtil;

public class SignUpPage extends BasePage {

	// Step 1: Initial signup
	private By loginLink = By.xpath("//a[text()=' Signup / Login']");
	private By nameInput = By.xpath("//input[@data-qa='signup-name']");
	private By emailInput = By.xpath("//input[@data-qa='signup-email']");
	private By signupButton = By.xpath("//button[@data-qa='signup-button']");

	// Step 2: Registration form
	private By titleMr = By.id("id_gender1");
	private By passwordInput = By.id("password");
	private By daysDropdown = By.id("days");
	private By monthsDropdown = By.id("months");
	private By yearsDropdown = By.id("years");
	private By createAccountButton = By.xpath("//button[text()='Create Account']");
	private By accountCreatedHeader = By.xpath("//b[text()='Account Created!']");

	// Address Details
	private By firstNameInput = By.xpath("//input[@data-qa='first_name']");
	private By lastNameInput = By.xpath("//input[@data-qa='last_name']");
	private By companyInput = By.xpath("//input[@data-qa='company']");
	private By addressInput = By.xpath("//input[@data-qa='address']");
	private By addressTwoInput = By.xpath("//input[@data-qa='address2']");
	private By countrySelect = By.id("country");
	private By stateInput = By.xpath("//input[@data-qa='state']");
	private By cityInput = By.xpath("//input[@data-qa='city']");
	private By zipcodeInput = By.xpath("//input[@data-qa='zipcode']");
	private By mobileInput = By.xpath("//input[@data-qa='mobile_number']");
	private By popUpFrame = By.id("aswift_1");

	public void goToSignupPage() {
		click(loginLink);
	}

	public void enterSignupDetails(String name, String email) {
		type(nameInput, name);
		type(emailInput, email);
		click(signupButton);
	}

	public void fillRegistrationForm(String password, String firstName, String lastName, String company,
			String address) {
		click(titleMr);
		type(passwordInput, password);
		selectDropdownByValue(daysDropdown, "1");
		selectDropdownByValue(monthsDropdown, "1");
		selectDropdownByValue(yearsDropdown, "2000");

		PopUpUtil.closeIframeIfPresent(driver.findElement(popUpFrame).getDomAttribute("id"));

		// Optional: Newsletter & Offers checkboxes (if present)
		By newsletterCheckbox = By.id("newsletter");
		By offersCheckbox = By.id("optin");

		if (!driver.findElement(newsletterCheckbox).isSelected()) {
			click(newsletterCheckbox);
		}
		if (!driver.findElement(offersCheckbox).isSelected()) {
			click(offersCheckbox);
		}

		// Address info (mandatory)
		type(firstNameInput, firstName);
		type(lastNameInput, lastName);
		type(companyInput, company);
		type(addressInput, address);
		type(addressTwoInput, "Suite 202");
		selectDropdownByValue(countrySelect, "India");
		type(stateInput, "Uttarakhand");
		type(cityInput, "Dehradun");
		type(zipcodeInput, "248001");
		scrollToElement(createAccountButton);
		type(mobileInput, "9876543210");
		click(createAccountButton);

	}

	public boolean isAccountCreated() {
		return WaitUtil.waitForElementToBeVisible(accountCreatedHeader).isDisplayed();
	}

}
