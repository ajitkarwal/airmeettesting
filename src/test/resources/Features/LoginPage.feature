Feature: Login Page Feature

  Scenario: Check Login Page Title
    Given user is on Login Page
    When user gets the title of the page
    Then the title of the page should be "Airmeet"

  Scenario: Privacy Policy Link
    Given user is on Login Page
    Then Privacy Policy link should be displayed

  Scenario: Login with correct credentials
    Given user is on Login Page
    When user enters email Id "ajitkarwal1980@gmail.com"
    And user click on Continue button
    And user enters password "Jugnu@1980"
    And user clicks on Login button
    Then user gets the title of the page
    And the title of the page should be "Airmeet"


#  Scenario: Forgot Password Link
#    Given user is on Login Page
#    When user enters email Id "ajitkarwal1980@gmail.com"
#    And user click on Continue button
#    Then Forgot Password link should be displayed