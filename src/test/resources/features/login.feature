@login
Feature: Login/Logout

  Scenario:TC2: Login with correct email and password
    Given launch browser
    When Navigate to url http://automationexercise.com
    Then Verify that home page is visible successfully
    When Click on Signup / Login button
    Then Verify Login to your account is visible
    When Enter correct email address and password
    And Click login button
    Then Verify that logged in as username is visible