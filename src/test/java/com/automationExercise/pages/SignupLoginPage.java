package com.automationExercise.pages;

import io.cucumber.java.eo.Se;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SignupLoginPage extends BasePage{

    @FindBy(xpath = "//div[@class='login-form']/h2")
    public WebElement loginFormTitle;

    @FindBy(xpath = "//div[@class='signup-form']/h2")
    public WebElement signupFormTitle;

    @FindBy(name = "name")
    public WebElement nameBox;

    @FindBy(xpath ="(//input[@name='email'])[2]")
    public WebElement emailSignup;

    @FindBy(name="email")
    public WebElement emailLogin;

    @FindBy(name="password")
    public WebElement password;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    public WebElement loginButton;

    @FindBy(xpath = "(//button[@type='submit'])[2]")
    public WebElement signupButton;

    @FindBy(xpath = "//i[@class='fa fa-user']/..")
    public WebElement loggedInAs;

    @FindBy(xpath = "//div[@class='login-form']/h2/b")
    public WebElement formTitle;

    @FindBy(id = "uniform-id_gender1")
    public WebElement titleMr;

}
