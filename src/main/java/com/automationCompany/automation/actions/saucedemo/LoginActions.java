package com.automationCompany.automation.actions.saucedemo;

import com.automationCompany.automation.core.BasePage;
import com.automationCompany.automation.pages.saucedemo.LoginPage;
import com.automationCompany.automation.utils.ReportManager;
import com.automationCompany.automation.utils.ScreenshotUtil;
import com.automationCompany.automation.utils.ValidationHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginActions extends BasePage {

    private LoginPage page = new LoginPage();

    public LoginActions(WebDriver driver) {
        super(driver);
    }

    public void performLogin(String user, String pass) {

        ReportManager.startNode("Validating SauceDemo Login Node");

        ReportManager.step("Starting login process", true);

        da.type(page.username, user);
        da.type(page.password, pass);
        da.click(page.loginBtn);

        ValidationHelper.softAssertTrue(
                da.isDisplayed(page.productsTitle),
                "User should be logged in successfully"
        );

        ReportManager.step("Login process finished", true);

        ReportManager.endNode();
    }

    public void performLoginWrongPath(String user, String pass) {
        ReportManager.startNode("Validating SauceDemo WrongPath Login Node");

        ReportManager.step("Starting wrong-path login", true);

        da.type(page.username, user);
        da.type(page.password, pass);
        da.click(page.loginBtn);

        ValidationHelper.softAssertTrue(
                da.isDisplayed(page.loginError),
                "Error message should be displayed for invalid credentials"
        );

        ReportManager.step("Wrong-path login validated", true);

        ReportManager.endNode();
    }

    public void addAllItemsToCartAndStartCheckout() {
        ReportManager.startNode("Validating add-to-cart and checkout start");

        int expectedItems = driver.findElements(page.addToCartButtons).size();

        ReportManager.step("Found add-to-cart buttons: " + expectedItems);

        while (true) {
            List<WebElement> buttons = driver.findElements(page.addToCartButtons);
            if (buttons.isEmpty()) {
                break;
            }
            buttons.get(0).click();
        }

        da.click(page.shoppingCartLink);

        ScreenshotUtil.takeScreenshot(driver, "cart_content_validation");
        ReportManager.step("Cart screenshot captured", true);

        int removeButtons = driver.findElements(page.removeButtons).size();
        ValidationHelper.softAssertTrue(
                removeButtons == expectedItems,
                "Cart should contain same number of added items. Expected: "
                        + expectedItems + ", Found: " + removeButtons
        );

        da.click(page.checkoutButton);
        ReportManager.step("Checkout button clicked", true);

        ReportManager.endNode();
    }
}
