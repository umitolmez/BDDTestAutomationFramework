package com.automationExercise.stepDefinitions;

import com.automationExercise.pages.SignupLoginPage;
import com.automationExercise.pages.SignupPage;
import com.automationExercise.utilities.BrowserUtils;
import com.automationExercise.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterStepDefs {
    Faker faker = new Faker();
    String randomName= faker.name().firstName();
    String randomSurname= faker.name().lastName();
    String randomFullName= randomName +" "+ randomSurname;
    String randomEmail= faker.internet().emailAddress();
    String randomAddress= faker.address().fullAddress();
    String randomAddress2= faker.address().secondaryAddress();
    String randomCompany= faker.company().name();
    String randomState= faker.address().state();
    String randomCity= faker.country().capital();
    String randomZipcode= faker.address().zipCode();
    String randomMobileNumber= faker.phoneNumber().phoneNumber();

    SignupLoginPage signupLoginPage= new SignupLoginPage();
    SignupPage signupPage = new SignupPage();

    @Then("Verify New User Signup! is visible")
    public void verify_New_User_Signup_is_visible() {
        Assert.assertTrue(signupLoginPage.signupFormTitle.isDisplayed());

        String expectedTitle = "New User Signup!";
        String actualTitle = signupLoginPage.signupFormTitle.getText();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @When("Enter name and email address")
    public void enter_name_and_email_address() {
        signupLoginPage.nameBox.sendKeys(randomFullName);
        signupLoginPage.emailSignup.sendKeys(randomEmail);
    }

    @When("Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number")
    public void fill_details_First_name_Last_name_Company_Address_Address2_Country_State_City_Zipcode_Mobile_Number() {
        signupPage.firstName.sendKeys(randomName);
        signupPage.lastName.sendKeys(randomSurname);
        signupPage.company.sendKeys(randomCompany);
        signupPage.address.sendKeys(randomAddress);
        signupPage.address2.sendKeys(randomAddress2);
        signupPage.state.sendKeys(randomState);
        signupPage.city.sendKeys(randomCity);
        signupPage.zipcode.sendKeys(randomZipcode);
        signupPage.mobileNumber.sendKeys(randomMobileNumber);
    }

    @When("Click Signup button")
    public void click_Signup_button() {
        signupLoginPage.signupButton.click();
    }

    @Then("Verify that ENTER ACCOUNT INFORMATION is visible")
    public void verify_that_ENTER_ACCOUNT_INFORMATION_is_visible() {
        Assert.assertTrue(signupLoginPage.formTitle.isDisplayed());

        String expectedTitle= "ENTER ACCOUNT INFORMATION";
        String actualTitle= signupLoginPage.formTitle.getText();
        Assert.assertEquals(expectedTitle, actualTitle);
    }
    @When("Fill details: Title, Name, Email, Password, Date of birth")
    public void fill_details_Title_Name_Email_Password_Date_of_birth() {
        signupLoginPage.titleMr.click();

        String randomPassword= faker.internet().password();
        signupLoginPage.password.sendKeys(randomPassword);
        signupPage.randomDateOfBirth();
    }
    @When("Select checkbox Sign up for our newsletter!")
    public void select_checkbox_Sign_up_for_our_newsletter() {
        BrowserUtils.scrollToElement(signupPage.newsletter);
        signupPage.newsletter.click();
    }
    @When("Select checkbox Receive special offers from our partners!")
    public void select_checkbox_Receive_special_offers_from_our_partners() {
        signupPage.receiveSpecialOffer.click();
    }

    @When("Click Create Account button")
    public void click_Create_Account_button() {
        BrowserUtils.scrollToElement(signupPage.createAccountButton);
        signupPage.createAccountButton.click();
    }
    @Then("Verify that ACCOUNT CREATED! is visible")
    public void verify_that_ACCOUNT_CREATED_is_visible() {
        WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
        wait.until(ExpectedConditions.visibilityOf(signupPage.accountCreated));

        Assert.assertTrue(signupPage.accountCreated.isDisplayed());

        String expectedText = "ACCOUNT CREATED!";
        String actualText = signupPage.accountCreated.getText();
        Assert.assertEquals(expectedText, actualText);
    }
    @When("Click Continue button")
    public void click_Continue_button() {
        signupPage.continueButton.click();
    }

    @Then("Verify that ACCOUNT DELETED! is visible and click Continue button")
    public void verify_that_ACCOUNT_DELETED_is_visible_and_click_Continue_button() {
        Assert.assertTrue(signupPage.accountDeleted.isDisplayed());

        String expectedText = "ACCOUNT DELETED!";
        String actualText = signupPage.accountDeleted.getText();
        Assert.assertEquals(expectedText, actualText);

        signupPage.continueButton.click();
    }

    @Then("Verify that Logged in as username is visible")
    public void verify_that_Logged_in_as_username_is_visible() {
        Driver.get().switchTo().frame(signupPage.iFrameAds);
        signupPage.closeAdvertisement.click();
        Driver.get().switchTo().parentFrame();

        String expectedText = "Logged in as " + randomFullName;
        String actualText = signupLoginPage.loggedInAs.getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @When("Click Delete Account button")
    public void click_Delete_Account_button() {
        signupLoginPage.deleteAccount.click();
    }
}
