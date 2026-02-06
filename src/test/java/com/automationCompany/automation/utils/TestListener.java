package com.automationCompany.automation.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.automationCompany.automation.core.DriverManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private static ExtentReports extent = ExtentManager.getInstance();

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
    public void onTestFailure(ITestResult result) {
        String path = ScreenshotUtil.takeScreenshot(
                DriverManager.getDriver(),
                result.getMethod().getMethodName()
        );
        ReportManager.warning(result.getThrowable().getMessage(), false);
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
