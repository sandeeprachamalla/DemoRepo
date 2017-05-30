Feature: Fund Transfer

  Scenario: Fund transfer within the bank
    Given User should be logged in successfully And should be navigated to Funds transfer page
    And Target account should be present And there should be sufficient account balance
    When user selects Target account And click on Funds Transfer
    Then User account should be Debited And Target account should be Credited
    And Proper Successful message should be dispayed #Fund Transfer within bank is Successful#
    And close Browser Window

  #Scenario: Invalid Account number
    #Given User should be logged in successfully And should be navigated to Funds transfer page
    #When User enters Invalid account number that is not equal to 12 digits
    #Then Proper error message should be displayed #Account Number is Invalid#
    #And close Browser Window
 @UnderTest    
  Scenario: Same Account number
    Given User should be logged in successfully And should be navigated to Funds transfer page
    When User enters same From account and To account number
    Then Proper error message should be displayed #From Account and To Account can not be same#
    And close Browser Window

  Scenario: Insufficient Account balance
    Given User should be logged in successfully And should be navigated to Funds transfer page
    When User enters valid account number And Amount greater than Current account balance for within bank
    Then Proper error message should be displayed #Insufficient account balance for within bank#
    And close Browser Window

  Scenario: Invalid Amounts
    Given User should be logged in successfully And should be navigated to Funds transfer page
    When User enters valid account number And Invalid amount in within bank
    Then Proper error message should be displayed #Invalid Amount for within bank - 0.0, -234 #
    And close Browser Window

  Scenario: User clicks on Back button
    Given User should be logged in successfully And should be navigated to Funds transfer page
    When I click on the back button
    Then Back button should not work
    And close Browser Window

  Scenario: Logout from Funds Transfer page
    Given User should be logged in successfully And should be navigated to Funds transfer page
    When I click on the logout button
    Then User should be logged out of the bank application successfully
    And close Browser Window

  ## - Outside bank

  Scenario Outline: Fund transfer outside the bank
    Given User should be logged in successfully And should be navigated to Funds transfer page
    And User navigates to Outside bank
    And Target account should be present And there should be sufficient account balance in From Account
    When user enters <From Account>, <Target Account> And <IFSC Code> And click on Funds Transfer
    Then User <From Account> should be Debited And <Target Account> should be Credited
    And Proper Successful message should be dispayed #Fund Transfer outside bank is Successful#
    And close Browser Window

    Examples: 
      | From Account | Target Account | IFSC Code |
      |   1111999911 |       12131312 | BOB123234 |
      |   8573043821 |    12131312334 | SBI123456 |
      |   1111999911 |         121312 | ICICI111  |

 
  Scenario: Invalid Account number
    Given User should be logged in successfully And should be navigated to Funds transfer page
    And User navigates to Outside bank
    When User enters Invalid account number that is not equal to 8 digits and clicks on Transfer Funds button
    Then Proper error message should be displayed #Account Number is Invalid for outside bank#
    And close Browser Window
 
 
  Scenario: Insufficient Account balance
    Given User should be logged in successfully And should be navigated to Funds transfer page
    And User navigates to Outside bank
    When User enters valid account number And Amount greater than Current account balance for outside bank
    Then Proper error message should be displayed #Insufficient account balance for outside bank#
    And close Browser Window


  Scenario: Invalid Amounts
    Given User should be logged in successfully And should be navigated to Funds transfer page
    And User navigates to Outside bank
    When User enters valid account number And Invalid amount in outside bank
    Then Proper error message should be displayed #Invalid Amount for outside bank - 0.0, -234 #
    And close Browser Window
