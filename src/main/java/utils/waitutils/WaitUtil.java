package utils.waitutils;

import core.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtil {

    private static final int DEFAULT_TIMEOUT = 20;

    public static WebElement waitForElementToBeVisible(By locator) {
        WebDriver driver = DriverManager.getDriver();
        return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForElementToBeClickable(By locator) {
        WebDriver driver = DriverManager.getDriver();
        return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static boolean waitForUrlContains(String partialUrl) {
        WebDriver driver = DriverManager.getDriver();
        return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(ExpectedConditions.urlContains(partialUrl));
    }
}
