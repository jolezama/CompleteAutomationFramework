package com.automationCompany.automation.utils;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.automationCompany.automation.core.DriverManager;

public class ReportManager {

    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    private static ThreadLocal<ExtentTest> node = new ThreadLocal<>();

    public static void setTest(ExtentTest extentTest) {
        test.set(extentTest);
    }

    public static ExtentTest getCurrentTest() {
        return test.get();
    }

    public static void startNode(String nodeName) {
        node.set(test.get().createNode(nodeName));
    }

    public static void endNode() {
        node.remove();
    }

    // ✅ ESTE MÉTODO ES EL QUE FALTABA
    private static ExtentTest getLogger() {
        return node.get() != null ? node.get() : test.get();
    }

    public static void step(String message) {
        getLogger().log(Status.INFO, "-" + message);
    }

    public static void step(String message, boolean screenshot) {

        if (screenshot) {
            String path = ScreenshotUtil.takeScreenshot(
                    DriverManager.getDriver(),
                    "step_" + System.currentTimeMillis()
            );

            getLogger().log(
                    Status.INFO,
                    "-" + message,
                    MediaEntityBuilder
                            .createScreenCaptureFromPath(path)
                            .build()
            );
        } else {
            step(message);
        }
    }


    public static void fail(String message, boolean screenshot) {
        if (screenshot) {
            String path = ScreenshotUtil.takeScreenshot(
                    DriverManager.getDriver(),
                    "fail_" + System.currentTimeMillis()
            );

            getLogger().log(
                    Status.FAIL,
                    message,
                    MediaEntityBuilder
                            .createScreenCaptureFromPath(path)
                            .build()
            );
        } else {
            getLogger().log(Status.FAIL, message);
        }
    }

    public static void warning(String message, boolean screenshot) {
        if (screenshot) {
            String path = ScreenshotUtil.takeScreenshot(
                    DriverManager.getDriver(),
                    "warn_" + System.currentTimeMillis()
            );

            getLogger().log(
                    Status.WARNING,
                    message,
                    MediaEntityBuilder
                            .createScreenCaptureFromPath(path)
                            .build()
            );
        } else {
            getLogger().log(Status.WARNING, message);
        }
    }
}
