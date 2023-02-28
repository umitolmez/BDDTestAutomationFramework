package com.automationExercise.pages;

import com.automationExercise.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class SignupPage extends BasePage{
    @FindBy(id = "days")
    public WebElement day;

    @FindBy(id = "months")
    public WebElement months;

    @FindBy(id = "years")
    public WebElement years;

    /**
     * Selects random values from dropdown.
     */
    public void randomDateOfBirth(){
        Random random = new Random();

        Select daysDropdown= new Select(day);
        List<WebElement> dayOptions = Driver.get().findElements(By.xpath("//select[@id='days']/option"));
        int sizeOfDays = dayOptions.size()-1;
        int indexOfRandomDay = random.nextInt(sizeOfDays)+1;
        daysDropdown.selectByIndex(indexOfRandomDay);

        Select monthsDropdown= new Select(months);
        List<WebElement> monthOptions = Driver.get().findElements(By.xpath("//select[@id='months']/option"));
        int sizeOfMonths = monthOptions.size()-1;
        int indexOfRandomMonth = random.nextInt(sizeOfMonths)+1;
        daysDropdown.selectByIndex(indexOfRandomMonth);

        Select yearsDropdown = new Select(years);
        List<WebElement> yearOptions = Driver.get().findElements(By.xpath("//select[@id='years']/option"));
        int sizeOfYears = yearOptions.size()-1;
        int indexOfRandomYear = random.nextInt(sizeOfYears)+1;
        yearsDropdown.selectByIndex(indexOfRandomYear);
    }

    public void selectRandomCountry(){
        Select countries = new Select(country);
        List<WebElement> options = Driver.get().findElements(By.xpath("//select[@id='country']/option"));
        int size= options.size();

        Random random = new Random();
        int randomIndex = random.nextInt(size);
        countries.selectByIndex(randomIndex);
    }

    @FindBy(id = "country")
    public WebElement country;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//*[contains(text(),'Sign up for our newsletter!')]")
    public WebElement newsletter;

    @FindBy(xpath = "//*[contains(text(),'Receive special offers from our partners!')]")
    public WebElement receiveSpecialOffer;

    @FindBy(id = "first_name")
    public WebElement firstName;

    @FindBy(id = "last_name")
    public WebElement lastName;

    @FindBy(id = "company")
    public WebElement company;

    @FindBy(id = "address1")
    public WebElement address;

    @FindBy(id = "address2")
    public WebElement address2;

    @FindBy(id = "state")
    public WebElement state;

    @FindBy(id = "city")
    public WebElement city;

    @FindBy(id = "zipcode")
    public WebElement zipcode;

    @FindBy(id = "mobile_number")
    public WebElement mobileNumber;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    public WebElement createAccountButton;

    @FindBy(xpath = "//*[text()='Account Created!']")
    public WebElement accountCreated;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    public WebElement continueButton;

    @FindBy(xpath = "//*[text()='Account Deleted!']")
    public WebElement accountDeleted;

}
