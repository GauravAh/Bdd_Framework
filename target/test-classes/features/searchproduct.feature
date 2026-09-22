
  Feature: Verify Amazon Logo

    @Smoke
    Scenario: Verify Amazon logo is displayed on home page
      Given I am on Amazon home page
      When I look at the Amazon logo
      Then The Amazon logo should be displayed.

    @Smoke
    Scenario: Verify Sliders item is open in new Tab
      Given I am on Amazon home page
      When I click on Sliders Items
      Then It should be redirected to new tab



