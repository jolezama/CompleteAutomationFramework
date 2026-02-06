package com.automationCompany.automation.tests;

import com.automationCompany.automation.core.DriverFactory;
import com.automationCompany.automation.core.DriverManager;
import com.automationCompany.automation.utils.SoftAssertManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setup() {
        WebDriver driver = DriverFactory.createInstance();
        DriverManager.setDriver(driver);
        SoftAssertManager.init();
    }

    @AfterMethod
    public void teardown() {
        SoftAssertManager.assertAll();
        DriverManager.getDriver().quit();
        DriverManager.unload();
    }
}
