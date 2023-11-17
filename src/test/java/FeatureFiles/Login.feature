@Hooks
@Login
Feature:To test the login functionality

  Scenario: Login functionality with valid credentials
    Given user is on loginpage
    When user enters email or phone number and password
    And user click on loginbutton
    Then user is navigates to homepage


