package com.automationCompany.automation.pages.saucedemo;

import org.openqa.selenium.By;

public class LoginPage {
    public By username = By.id("username");
    public By password = By.id("password");
    public By loginBtn = By.cssSelector("button[type='submit']");
    public By logoutBtn = By.cssSelector(".icon-signout");
}

