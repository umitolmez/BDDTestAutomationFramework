@regression @login
Feature: Login/Logout

  Background:
    Given launch browser
    When Navigate to url "http://automationexercise.com"
    Then Verify that home page is visible successfully
    When Click on Signup Login button
    Then Verify Login to your account is visible


  @TC2
  Scenario: TC2: Login with correct email and password
    When Enter correct email address and password
    And Click login button
    Then Verify that logged in as username is visible

  @TC3
  Scenario Outline: TC3: Login User with incorrect email and password
    When Enter incorrect "<email>" address and "<password>"
    And Click login button
    Then Verify error "Your email or password is incorrect!" is visible
    Examples:
      | email                    | password      |
      | umitolmez455@hotmail.com | 123456789     |
      | umitolmez455@gmail       | 123456789     |
      | umitolmez455@gmail.com   | wrongPassword |

  @TC4
  Scenario: TC4: Logout user
    When Enter correct email address and password
    And Click login button
    Then Verify that logged in as username is visible
    When Click Logout button
    Then Verify that user is navigated to login page