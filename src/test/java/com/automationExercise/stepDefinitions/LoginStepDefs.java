package com.automationExercise.stepDefinitions;

import com.automationExercise.pages.LoginPage;
import com.automationExercise.utilities.ConfigurationReader;
import com.automationExercise.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class LoginStepDefs {

    LoginPage loginPage = new LoginPage();

    @Given("launch browser")
    public void launch_browser() {
        //hooks
    }

    @When("Navigate to url http://automationexercise.com")
    public void navigate_to_url_http_automationexercise_com() {
        String url= ConfigurationReader.get("url");
        Driver.get().get(url);
    }

    @Then("Verify that home page is visible successfully")
    public void verify_that_home_page_is_visible_successfully() {
        String expectedUrl = ConfigurationReader.get("url");
        String actualurl= Driver.get().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualurl);

        String colorOfElement= loginPage.home.getAttribute("style");
        Assert.assertTrue(colorOfElement.contains("orange"));
    }

    @When("Click on Signup / Login button")
    public void click_on_Signup_Login_button() {
        loginPage.signupLogin.click();
    }

    @Then("Verify Login to your account is visible")
    public void verify_Login_to_your_account_is_visible() {
        Assert.assertTrue(loginPage.loginFormTitle.isDisplayed());

        String expectedTitle = "Login to your account";
        String actualTitle = loginPage.loginFormTitle.getText();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @When("Enter correct email address and password")
    public void enter_correct_email_address_and_password() {
        String email = ConfigurationReader.get("email");
        loginPage.email.sendKeys(email);

        String password = ConfigurationReader.get("password");
        loginPage.password.sendKeys(password);
    }

    @When("Click login button")
    public void click_login_button() {
        loginPage.loginButton.click();
    }

    @Then("Verify that Logged in as username is visible")
    public void verify_that_Logged_in_as_username_is_visible() {
        String expectedText = "Logged in as " + "Ümit Ölmez";
        String actualText = loginPage.loggedInAs.getText();
        Assert.assertEquals(expectedText, actualText);
    }

    @When("Click Delete Account button")
    public void click_Delete_Account_button() {
        loginPage.deleteAccount.click();
    }

}
