package com.automationCompany.automation.tests.saucedemo;


import com.automationCompany.automation.actions.saucedemo.LoginActions;
import com.automationCompany.automation.core.DriverManager;
import com.automationCompany.automation.tests.BaseTest;
import org.testng.annotations.Test;

public class SauceDemoTests extends BaseTest {

    @Test(description = "LoginTest_WrongPath")
    public void sauceDemo_loginTest_WrongPath() {
        LoginActions login = new LoginActions(DriverManager.getDriver());
        login.performLogin("tomsmith", "SuperSecretPassword!");
    }
}
