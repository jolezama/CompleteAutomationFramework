package com.automationCompany.automation.core;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected WebDriver driver;
    protected DriverActions da;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.da = new DriverActions(driver);
    }
}
