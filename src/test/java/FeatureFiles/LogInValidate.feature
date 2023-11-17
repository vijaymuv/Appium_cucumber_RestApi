@Login
Feature:Login functionality ItBusinessBook
  Background:
    Given user enters url into website login page should be present
@validLogin
    Scenario: Login functionality with valid credentials
    When user enters email as "vijayametv@gmail.com"
    And user enters password as "Vijay@2608"
    Then login should be success

  @invalidLogin
    Scenario: Login functionality with invalid credentials
    When user enters email as "vijay@gmail.com"
    And user enters password as "vijay"
    Then login should be fail