package com.automationCompany.automation.core;

import com.automationCompany.automation.config.ConfigManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    public static WebDriver createInstance() {

        WebDriver driver;

        switch (ConfigManager.get("browser")) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            default:
                throw new RuntimeException("Browser not supported");
        }

        driver.manage().window().maximize();
        driver.get(ConfigManager.get("baseUrl"));

        return driver;
    }
}
