package com.automationCompany.automation.actions.saucedemo;

import com.automationCompany.automation.core.BasePage;
import com.automationCompany.automation.pages.saucedemo.LoginPage;
import com.automationCompany.automation.utils.ReportManager;
import com.automationCompany.automation.utils.ValidationHelper;
import org.openqa.selenium.WebDriver;

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
}
