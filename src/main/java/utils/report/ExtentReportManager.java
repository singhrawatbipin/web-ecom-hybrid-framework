package utils.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

	private static ExtentReports extent;

	public static ExtentReports getInstance() {
		if (extent == null) {
			ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/extent-report.html");
			reporter.config().setReportName("Ecommerce Automation Report");
			reporter.config().setDocumentTitle("Test Execution Results");

			extent = new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Tester", "Bipin");
		}
		return extent;
	}
}
