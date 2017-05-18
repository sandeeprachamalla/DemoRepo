Feature: Fund Transfer

  Scenario: Fund transfer within the bank
    Given User should be logged in successfully And should be navigated to Funds transfer page
    And Target account should be present And there should be sufficient account balance
    When user selects Target account And click on Funds Transfer
    Then User account should be Debited And Target account should be Credited
    And Proper Successful message should be dispayed #Fund Transfer is Successful#

  Scenario: Invalid Account number
    Given User should be logged in successfully And should be navigated to Funds transfer page
    When User enters Invalid account number that is not equal to 12 digits
    Then Proper error message should be displayed #Account Number is Invalid#

  Scenario: Insufficient Account balance
    Given User should be logged in successfully And should be navigated to Funds transfer page
    When User enters valid account number And Amount greater than Current account balance
    Then Proper error message should be displayed #Insufficient account balance#

  Scenario: Invalid Amounts
    Given User should be logged in successfully And should be navigated to Funds transfer page
    When User enters valid account number And Invalid amount
    Then Proper error message should be displayed #Invalid Amount - 0.0, -234 #

  #Scenario
  Scenario: User clicks on Back button
    Given User should be logged in successfully And should be navigated to Funds transfer page
    When I click on the Back button
    Then Back button should not work

  #Scenario
  Scenario: Logout from Funds Transfer page
    Given User should be logged in successfully And should be navigated to Funds transfer page
    When I click on the Logout button
    Then User should be logged out of the bank application successfully

  ## - Outside bank
  @UnderTest
  Scenario Outline: Fund transfer outside the bank
    Given User should be logged in successfully And should be navigated to Funds transfer page
    And User navigates to Outside bank
    And Target account should be present And there should be sufficient account balance in From Account
    When user enters <From Account>, <Target Account> And <IFSC Code> And click on Funds Transfer
    Then User <From Account> should be Debited And <Target Account> should be Credited
    And Proper Successful message should be dispayed #Fund Transfer is Successful#

    Examples: 
      | From Account | Target Account | IFSC Code |
      |   1111999911 |       12131312 | BOB123234 |
      |   8573043821 |    12131312334 | SBI123456 |
      |   1111999911 |         121312 | ICICI111  |

  Scenario: Invalid Account number
    Given User should be logged in successfully And should be navigated to Funds transfer page
    When User enters Invalid account number that is not equal to 12 digits
    Then Proper error message should be displayed #Account Number is Invalid#

  Scenario: Insufficient Account balance
    Given User should be logged in successfully And should be navigated to Funds transfer page
    When User enters valid account number And Amount greater than Current account balance
    Then Proper error message should be displayed #Insufficient account balance#

  Scenario: Invalid Amounts
    Given User should be logged in successfully And should be navigated to Funds transfer page
    When User enters valid account number And Invalid amount
    Then Proper error message should be displayed #Invalid Amount - 0.0, -234 #
