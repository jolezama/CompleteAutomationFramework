package com.automationCompany.automation.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentManager {

    private static ExtentReports extent;
    private static String reportDir;

    public static ExtentReports getInstance() {

        if (extent == null) {

            reportDir = "test-reports/" + getTimestamp();
            new File(reportDir).mkdirs();
            new File(reportDir + "/screenshots").mkdirs();

            ExtentSparkReporter reporter =
                    new ExtentSparkReporter(reportDir + "/extent-report.html");

            reporter.config().setReportName("Automation Results");
            reporter.config().setDocumentTitle("Test Execution Report");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
        }
        return extent;
    }

    public static String getReportDir() {
        return reportDir;
    }

    private static String getTimestamp() {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        return LocalDateTime.now().format(formatter);
    }
}
