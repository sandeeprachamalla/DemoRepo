Feature: Account Statement

  Scenario: Account Statement functionality
    Given User should be logged in Successfully
    When User selects Account Statement And click on it
    Then User should be able to see account statement table with respective fields
