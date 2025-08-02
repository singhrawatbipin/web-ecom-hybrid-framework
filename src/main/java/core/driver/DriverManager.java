package core.driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {

	// For parallel execution, each thread will get its own isolated WebDriver
	// instance — avoiding conflicts.

	private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static WebDriver getDriver() {
		return driver.get();
	}

	//driverInstance is created in DriverFactory
	public static void setDriver(WebDriver driverInstance) {
		driver.set(driverInstance);
	}

	public static void unload() {
		driver.remove();
	}
}
