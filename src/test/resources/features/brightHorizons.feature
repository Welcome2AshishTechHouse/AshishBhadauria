@Test_SearchChildCareCenter
Feature: Verify BrightHorizons Functionality

  Scenario: User searches for child care center
    Given User is on "BrightHorizons" home page
    When User clicks on Find a Center
    Then Verify new page contains "child-care-locator" in URL
    When User searches for "New York"
    Then Verify the number of found centers matches the displayed list
    When User clicks on the first center
    Then Verify if center name and address are the same on the list and popup

