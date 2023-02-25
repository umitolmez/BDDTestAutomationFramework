package com.automationExercise.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//div[@class='login-form']/h2")
    public WebElement loginFormTitle;

    @FindBy(name="email")
    public WebElement email;

    @FindBy(name="password")
    public WebElement password;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    public WebElement loginButton;

    @FindBy(xpath = "//i[@class='fa fa-user']/..")
    public WebElement loggedInAs;



}
