package core.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import core.driver.DriverManager;
import utils.waitutils.WaitUtil;

public class BasePage {

	protected WebDriver driver;

	public BasePage() {
		this.driver = DriverManager.getDriver(); // Get driver from ThreadLocal
	}

	protected void click(By locator) {
		WaitUtil.waitForElementToBeClickable(locator).click();
	}

	protected void type(By locator, String text) {
		WebElement element = driver.findElement(locator);
		element.clear();
		element.sendKeys(text);
	}

	protected String getText(By locator) {
		return driver.findElement(locator).getText();
	}

	protected boolean isElementVisible(By locator) {
		return driver.findElement(locator).isDisplayed();
	}

	protected void selectDropdownByValue(By locator, String value) {
		Select dropdown = new Select(driver.findElement(locator));
		dropdown.selectByValue(value);
	}

	protected void scrollToElement(By locator) {
		WebElement element = driver.findElement(locator);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

}
