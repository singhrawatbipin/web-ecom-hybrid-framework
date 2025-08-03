package utils.common;

import core.driver.DriverManager;
import utils.loggerutils.LoggerUtil;
import utils.waitutils.WaitUtil;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class PopUpUtil {
	private static final Logger log = LoggerUtil.getLogger(PopUpUtil.class);

	public static void closeIframeIfPresent(String iFrameId) {
		WebDriver driver = DriverManager.getDriver();
		
		//log.info("Waiting for the Iframe PopUp...");
		//WaitUtil.waitForIframeToBePresent(iFrameId);

		try {
			if (iFrameId.length() > 0) {
				((JavascriptExecutor) driver).executeScript(
						"var iframe = document.getElementById('" + iFrameId + "');" + "if(iframe) iframe.remove();");
				log.info("✅ Removed iframe with ID: " + iFrameId);
			} else {
				log.info("ℹ️ Iframe with ID '" + iFrameId + "' not present.");
			}
		} catch (Exception e) {
			log.info("❌ Failed to remove iframe: " + e.getMessage());
		}
	}
}
