package com.automationCompany.automation.utils;

import org.testng.asserts.SoftAssert;

public class SoftAssertManager {

    private static ThreadLocal<SoftAssert> softAssert = new ThreadLocal<>();

    public static void init() {
        softAssert.set(new SoftAssert());
    }

    public static SoftAssert get() {
        return softAssert.get();
    }

    public static void assertAll() {
        softAssert.get().assertAll();
        softAssert.remove();
    }
}

