Feature: Validate Calculator Application

  Scenario: Additional Operations
    Given user opens the calculator application
    When user clicks three and four number
    And user clicks plus button
    And user clicks two number
    Then user validate the results

    Scenario: Division Operation
      When user clicks five and zero number
      And user clicks divisor button
      And user clicks two number
      Then user validate the results of division
