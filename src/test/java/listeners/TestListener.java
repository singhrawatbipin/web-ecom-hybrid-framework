package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.report.ExtentReportManager;
import utils.screenshotutils.ScreenShotUtil;

public class TestListener implements ITestListener {

	private static ExtentReports extent = ExtentReportManager.getInstance();
	private static ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();

	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest test = extent.createTest(result.getMethod().getMethodName());
		testThread.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		testThread.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String screenshotPath = ScreenShotUtil.captureScreenshot(result.getMethod().getMethodName());
		testThread.get().log(Status.FAIL, "Test Failed: " + result.getThrowable());
		testThread.get().addScreenCaptureFromPath(screenshotPath);
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
