package com.automationCompany.automation.pages.saucedemo;

import org.openqa.selenium.By;

public class LoginPage {
    public By username = By.id("user-name");
    public By password = By.id("password");
    public By loginBtn = By.id("login-button");
    public By productsTitle = By.cssSelector("span.title");

    public By loginError = By.cssSelector("h3[data-test='error']");

    public By addToCartButtons = By.xpath("//button[text()='Add to cart']");
    public By shoppingCartLink = By.cssSelector("a[data-test*='shopping']");
    public By removeButtons = By.xpath("//button[text()='Remove']");
    public By checkoutButton = By.cssSelector("button[id='checkout']");
}
