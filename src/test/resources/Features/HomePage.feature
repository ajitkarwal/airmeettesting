Feature: Check Home Page elements
  Scenario: Check sign in button is displayed
    Given user is on the home page
    And user verifies sign in button is displayed

    Scenario:Check the Title of the Home Page
      Given user is on the home page
      When user gets the title of the page
      Then page title should be "Airmeet"


