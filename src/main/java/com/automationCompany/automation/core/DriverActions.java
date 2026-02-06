package com.automationCompany.automation.core;

import com.automationCompany.automation.utils.ReportManager;
import org.openqa.selenium.*;

public class DriverActions {

    private WebDriver driver;
    private WaitManager wait;

    public DriverActions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitManager(driver);
    }


    private void smartClick(By locator) {
        WebElement element = wait.waitVisible(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }



    public boolean isDisplayed(By locator) {
        try {
            return wait.waitVisible(locator).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public String getText(By locator) {
        return wait.waitVisible(locator).getText();
    }
    public void click(By locator) {
        ReportManager.step("Click on element: " + locator);
        try {
            wait.waitClickable(locator).click();
        } catch (Exception e) {
            ReportManager.step("Standard click failed, trying JS click", true);
            smartClick(locator);
        }
    }

    public void type(By locator, String text) {
        ReportManager.step("Type '" + text + "' into element: " + locator);
        WebElement el = wait.waitVisible(locator);
        el.clear();
        el.sendKeys(text);
    }


}
