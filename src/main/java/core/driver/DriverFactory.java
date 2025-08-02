package core.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import core.enums.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public static void initDriver(BrowserType browserType) {
		WebDriver driver = null;

		switch (browserType) {
		case CHROME:
			WebDriverManager.chromedriver().setup();
		    ChromeOptions options = new ChromeOptions();
		    options.addArguments("--disable-notifications");
		    options.addArguments("--disable-popup-blocking");
		    options.addArguments("--disable-infobars");
		    options.addArguments("--start-maximized");
			driver = new ChromeDriver(options);
			break;

		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		case EDGE:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			throw new IllegalArgumentException("Browser not supported: " + browserType);
		}

		driver.manage().window().maximize();
		DriverManager.setDriver(driver);
	}

	public static void quitDriver() {
		WebDriver driver = DriverManager.getDriver();
		if (driver != null) {
			driver.quit();
			DriverManager.unload();
		}
	}

}
