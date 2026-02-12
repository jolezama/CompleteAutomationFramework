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

    @Test(description = "LoginTest_sauceDemo_wrongPath")
    public void sauceDemo_loginWrongPathTest() {
        LoginActions login = new LoginActions(DriverManager.getDriver());
        login.performLoginWrongPath("standard_user", "wrong_password");
    }

    @Test(description = "PurchaseTest_sauceDemo_addAllAndCheckout")
    public void sauceDemo_purchaseFlowTest() {
        LoginActions login = new LoginActions(DriverManager.getDriver());
        login.performLogin("standard_user", "secret_sauce");
        login.addAllItemsToCartAndStartCheckout();
    }
}
