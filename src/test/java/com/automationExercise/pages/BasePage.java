package com.automationExercise.pages;

import com.automationExercise.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
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


    @FindAll({
            @FindBy(id = "dismiss-button"),
            @FindBy(id = "BURAYALOCATORYAZ")
    })
    public WebElement closeAdvertisement;

    @FindBy(id = "aswift_1")
    public WebElement iFrameAds;

    @FindBy(linkText = "Logout")
    public WebElement logoutButton;
}
