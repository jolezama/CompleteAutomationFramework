package com.automationCompany.automation.tests.heroku;


import com.automationCompany.automation.actions.heroku.LoginActions;
import com.automationCompany.automation.core.DriverManager;
import com.automationCompany.automation.tests.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "LoginTest_happyPath")
    public void heroku_loginTest() {
        LoginActions login = new LoginActions(DriverManager.getDriver());
        login.performLogin("tomsmith", "SuperSecretPassword!");
    }
}
