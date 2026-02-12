package com.automationCompany.automation.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.automationCompany.automation.core.DriverManager;
import org.testng.IConfigurationListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener, IConfigurationListener {

    private static final ExtentReports extent = ExtentManager.getInstance();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(
                result.getMethod().getDescription() != null
                        ? result.getMethod().getDescription()
                        : result.getMethod().getMethodName()
        );
        ReportManager.setTest(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ReportManager.step("Test finished successfully");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ensureTestNode(result);
        String reason = result.getThrowable() != null
                ? result.getThrowable().getMessage()
                : "Test skipped";
        ReportManager.warning("Skipped: " + reason, false);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ensureTestNode(result);
        captureFailureScreenshot(result.getMethod().getMethodName());
        String reason = result.getThrowable() != null
                ? result.getThrowable().getMessage()
                : "Unknown failure";
        ReportManager.fail("Failure: " + reason, false);
    }

    @Override
    public void onConfigurationFailure(ITestResult itr) {
        ensureTestNode(itr);
        captureFailureScreenshot("config_failure_" + itr.getMethod().getMethodName());

        String reason = itr.getThrowable() != null
                ? itr.getThrowable().getMessage()
                : "Configuration failed";

        ReportManager.fail("Configuration failure: " + reason, false);
    }

    @Override
    public void onConfigurationSkip(ITestResult itr) {
        ensureTestNode(itr);
        String reason = itr.getThrowable() != null
                ? itr.getThrowable().getMessage()
                : "Configuration skipped";
        ReportManager.warning("Configuration skipped: " + reason, false);
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

    private void ensureTestNode(ITestResult result) {
        if (ReportManager.getCurrentTest() == null) {
            String testName = result.getMethod().getDescription() != null
                    ? result.getMethod().getDescription()
                    : result.getMethod().getMethodName();
            ReportManager.setTest(extent.createTest(testName));
        }
    }

    private void captureFailureScreenshot(String fileName) {
        if (DriverManager.getDriver() != null) {
            ScreenshotUtil.takeScreenshot(DriverManager.getDriver(), fileName);
        }
    }
}
