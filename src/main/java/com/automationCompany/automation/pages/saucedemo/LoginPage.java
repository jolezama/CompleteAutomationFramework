package com.automationCompany.automation.pages.saucedemo;

import org.openqa.selenium.By;

public class LoginPage {
    public By username = By.id("user-name");
    public By password = By.id("password");
    public By loginBtn = By.id("login-button");
    public By productsTitle = By.cssSelector("span.title");
}
