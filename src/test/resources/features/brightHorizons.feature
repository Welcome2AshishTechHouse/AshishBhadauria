@Test_BrightHorizons
Feature: Verify BrightHorizons Functionality

  Background:
    Given User is on "BrightHorizons" home page

  @TestCase_01
  Scenario: TC_01 Verify search functionality
    When User click on the search icon
    Then User should see the search field
    When User enter "Employee Education in 2018: Strategies to Watch" into the search field
    And User click on the Search button
    Then Validate first search result should match the search query

  @TestCase_02
  Scenario: TC_02 User searches for child care center
    When User clicks on Find a Center
    Then Verify new page contains "child-care-locator" in URL
    When User searches for "New York"
    Then Verify the number of found centers matches the displayed list
    When User clicks on the first center
    Then Verify if center name and address are the same on the list and popup


