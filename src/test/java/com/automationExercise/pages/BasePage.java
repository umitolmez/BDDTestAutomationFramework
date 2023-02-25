package com.automationExercise.pages;

import com.automationExercise.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//li/a[@href='/']")
    public WebElement home;

    @FindBy(xpath = "//li/a[@href='/login']")
    public WebElement signupLogin;

    @FindBy(linkText = "Delete Account")
    public WebElement deleteAccount;

}
