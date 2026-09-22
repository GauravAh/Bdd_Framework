
  Feature: SignIn functionality

    @Regression
    Scenario: SignIn to an application with valid details
      Given I am on Signin page
      When I entered an emailid
      |Email|
      |gauravtesting5g@gmail.com|
      And I click on Continue button
      And I entered valid password as "testingggg"
      And I click on signin button
      Then I should be redirected to the dashboard page
