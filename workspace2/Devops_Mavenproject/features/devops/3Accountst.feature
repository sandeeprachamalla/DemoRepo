Feature: Account Statement
@UnderTest
  Scenario: Search with Dates filter
    Given User should be logged in Successfully and should be navigated to Account Statement page
    When User selects Start Date, End Date and clicks on Search button
    Then User should be able to see all the transaction details with in the selected date range
    And close Browser window

  Scenario: Reset button Functionality
    Given User should be logged in Successfully and should be navigated to Account Statement page
    When User selects Start Date, End Date and clicks on Reset button
    Then Start date and End date fields should be cleared
    And close Browser window

  Scenario: Search with Dates filter
    Given User should be logged in Successfully and should be navigated to Account Statement page
    When User selects Start Date greater than today, End Date and clicks on Search button
    Then Proper error message should be dispalyed #Start date cannot be greater than Today#
    And close Browser window

  Scenario: Search with Dates filter
    Given User should be logged in Successfully and should be navigated to Account Statement page
    When User selects Start Date greater than today, End Date less than or equal to Today and clicks on Search button
    Then Proper error message should be dispalyed #Start date cannot be greater than Today and End date cannot be less than Start date#
    And close Browser window

  Scenario Outline: Search with Transaction type filter
    Given User should be logged in Successfully and should be navigated to Account Statement page
    When User selects <Transaction Type> and clicks on Apply Filter button
    Then User should be able to see all the transaction details of the selected Transaction Type
    And close Browser window
    
    Examples: 
      | Transaction Type |
      | All              |
      | Credit           |
      | Debit            |


  Scenario Outline: Search with Dates and Transaction Type filters
    Given User should be logged in Successfully and should be navigated to Account Statement page
    When User selects Start Date, End Date and <Transaction Type> and clicks on Apply Filter button
    Then User should be able to see all the transaction details with in the selected date range and selected Transaction Type
    And close Browser window

    Examples: 
      | Transaction Type |
      | All              |
      | Credit           |
      | Debit            |
