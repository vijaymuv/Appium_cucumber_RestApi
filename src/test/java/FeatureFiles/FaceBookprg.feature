@Facebook
Feature: Facebook Automation

    @login
    Scenario: Login module
      Given user should navigates to facebook website
      When user enter user1 "8838138967"
      And user enter password1 "vijayvjy"
      Then user should get facebook home page

  @register
  Scenario:Register an account

  Given user should navigates to facebook website
  When user clicks on create an account button
  And user enter firstname
  And user enters lastname
  And user enters mobile or email
  And user enters new password
  And user enters dateOfBirth
  And user selects gender
  Then user click the signup button it should navigates to login page

@ForgetPassword
  Scenario: Forget password

  Given user should navigates to facebook website
  When user clicks on forget password it navigates to find your account page
  And user clicks on search btn
  Then user enters otp and validate the account