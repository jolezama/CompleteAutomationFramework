package com.automationCompany.automation.utils;

public class ValidationHelper {

    public static void softAssertTrue(boolean condition, String message) {

        if (!condition) {
            ReportManager.warning("Soft validation failed: " + message, true);
        } else {
            ReportManager.step("Validation passed: " + message);
        }

        SoftAssertManager.get().assertTrue(condition, message);
    }

}
