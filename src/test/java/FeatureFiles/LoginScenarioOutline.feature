Feature:Login module

  Scenario Outline: Validate Login module with valid details or credentials
    Given user should enter url and get login page
    When user enter "<email>" and "<password>" into txtfield
    And user click on login element
    Then user is navigates to homepage of it

    Examples:
    |email|password|
    |vijayametv@gmail.com|Vijay@2608|
    |vijay@gmail.com     |vijay     |
