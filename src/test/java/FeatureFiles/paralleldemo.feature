@parallelExecutionOfScenarios
Feature: Itbusiness book login module validation

  Scenario: Successful Login with Valid Credentials
    Given User is on first Page
    When User Navigate to LogIn Page
    And User enters UserName and Password
    Then Message displayed Login Successfully

  Scenario: Register function
    When User is on register page
    And user enters firstname, email & password
    Then Message displayed registered Successfully
