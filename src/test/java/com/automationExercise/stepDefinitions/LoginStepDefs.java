package com.automationExercise.stepDefinitions;

import com.automationExercise.pages.SignupLoginPage;
import com.automationExercise.utilities.ConfigurationReader;
import com.automationExercise.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class LoginStepDefs {

    SignupLoginPage signupLoginPage = new SignupLoginPage();

    @Given("launch browser")
    public void launch_browser() {
        //hooks
    }

    @When("Navigate to url {string}")
    public void navigate_to_url(String url) {
        Driver.get().get(url);
    }

    @Then("Verify that home page is visible successfully")
    public void verify_that_home_page_is_visible_successfully() {
        String expectedUrl = ConfigurationReader.get("url");
        String actualUrl= Driver.get().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

        String colorOfElement= signupLoginPage.home.getAttribute("style");
        Assert.assertTrue(colorOfElement.contains("orange"));
    }

    @When("Click on Signup Login button")
    public void click_on_Signup_Login_button() {
        signupLoginPage.signupLogin.click();
    }

    @Then("Verify Login to your account is visible")
    public void verify_Login_to_your_account_is_visible() {
        Assert.assertTrue(signupLoginPage.loginFormTitle.isDisplayed());

        String expectedTitle = "Login to your account";
        String actualTitle = signupLoginPage.loginFormTitle.getText();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @When("Enter correct email address and password")
    public void enter_correct_email_address_and_password() {
        String email = ConfigurationReader.get("email");
        signupLoginPage.emailLogin.sendKeys(email);

        String password = ConfigurationReader.get("password");
        signupLoginPage.password.sendKeys(password);
    }

    @When("Click login button")
    public void click_login_button() {
        signupLoginPage.loginButton.click();
    }


    @Then("Verify that logged in as username is visible")
    public void verify_that_logged_in_as_username_is_visible() {
        String expectedText = "Logged in as " +ConfigurationReader.get("name");
        String actualText = signupLoginPage.loggedInAs.getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @When("Enter incorrect {string} address and {string}")
    public void enter_incorrect_address_and(String incorrectEmail, String incorrectPassword) {
        signupLoginPage.emailLogin.sendKeys(incorrectEmail);

        signupLoginPage.password.sendKeys(incorrectPassword);
    }

    @Then("Verify error {string} is visible")
    public void verify_error_is_visible(String errorMessage) {
        String actualMessage = signupLoginPage.errorMessage.getText();

        Assert.assertEquals(errorMessage, actualMessage);
    }

    @When("Click Logout button")
    public void click_Logout_button() {
        signupLoginPage.logoutButton.click();
    }

    @Then("Verify that user is navigated to login page")
    public void verify_that_user_is_navigated_to_login_page() {
        Assert.assertTrue(Driver.get().getCurrentUrl().endsWith("/login"));
    }
}
