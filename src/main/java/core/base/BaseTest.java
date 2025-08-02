package core.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import core.config.ConfigLoader;
import core.driver.DriverFactory;
import core.driver.DriverManager;
import core.enums.BrowserType;

public class BaseTest {

	protected WebDriver driver;

	@BeforeMethod
	public void setUp() {
		// You can later fetch this value from config
		String browser = ConfigLoader.get("browser").toUpperCase();
		DriverFactory.initDriver(BrowserType.valueOf(browser));

		driver = DriverManager.getDriver();
		driver.get(ConfigLoader.get("baseUrl"));
	}

	@AfterMethod
	public void tearDown() {
		DriverFactory.quitDriver();
	}

}
