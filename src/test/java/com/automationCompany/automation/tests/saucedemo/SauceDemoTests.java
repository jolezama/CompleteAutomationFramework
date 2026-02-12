package com.automationCompany.automation.tests.saucedemo;


import com.automationCompany.automation.actions.saucedemo.LoginActions;
import com.automationCompany.automation.core.DriverManager;
import com.automationCompany.automation.tests.BaseTest;
import org.testng.annotations.Test;

public class SauceDemoTests extends BaseTest {

    @Override
    protected String appKey() {
        return "saucedemo";
    }

    @Test(description = "LoginTest_sauceDemo_happyPath")
    public void sauceDemo_loginTest() {
        LoginActions login = new LoginActions(DriverManager.getDriver());
        login.performLogin("standard_user", "secret_sauce");
    }
}
