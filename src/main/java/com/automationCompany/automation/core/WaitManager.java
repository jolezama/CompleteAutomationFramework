package com.automationCompany.automation.core;

import com.automationCompany.automation.config.ConfigManager;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitManager {

    private WebDriverWait wait;

    public WaitManager(WebDriver driver) {
        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(Integer.parseInt(ConfigManager.get("explicitWait")))
        );
        wait.pollingEvery(Duration.ofMillis(500));
        wait.ignoring(StaleElementReferenceException.class);
    }

    public WebElement waitVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
