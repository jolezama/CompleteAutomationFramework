package com.automationCompany.automation.tests;

import com.automationCompany.automation.config.ConfigManager;
import com.automationCompany.automation.core.DriverFactory;
import com.automationCompany.automation.core.DriverManager;
import com.automationCompany.automation.utils.SoftAssertManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    protected abstract String appKey();

    @BeforeMethod
    public void setup() {
        WebDriver driver = DriverFactory.createInstance();
        DriverManager.setDriver(driver);
        DriverManager.getDriver().get(ConfigManager.getBaseUrl(appKey()));
        SoftAssertManager.init();
    }

    @AfterMethod
    public void teardown() {
        SoftAssertManager.assertAll();
        DriverManager.getDriver().quit();
        DriverManager.unload();
    }
}
