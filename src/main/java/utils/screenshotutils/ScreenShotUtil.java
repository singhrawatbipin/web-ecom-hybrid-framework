package utils.screenshotutils;

import core.driver.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShotUtil {

	public static String captureScreenshot(String testName) {
		
		WebDriver driver = DriverManager.getDriver();
		
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		
		String screenshotPath = "screenshots/" + testName + "_" + timestamp + ".png";
		try {
			FileUtils.copyFile(srcFile, new File(screenshotPath));
		} catch (IOException e) {
			throw new RuntimeException("Failed to capture screenshot", e);
		}
		return screenshotPath;
	}

}
