Feature: User Login Scenarios

  #Scenario1
 
  Scenario: Try to access HTTP url of the bank application
    Given Bank URL is setup
    And open Chrome browser and launch the Bank url with HTTP prefix
    When I click on Enter button
    Then Bank URL should be accessible and user should be directed to User Login page successfully
    And Close Browser Window

  #Scenario2

  Scenario: Try to access HTTPS url of the bank application
    Given Bank URL is setup
    And open Chrome browser and launch the Bank url with HTTPS prefix
    When I click on Enter button
    Then Bank URL should not be accessible
    And Close Browser Window

  #Scenario3
 #@UnderTest
  Scenario Outline: Valid User Login for registered user across multiple browsers
    Given Registered user is configured in system
    And open <browser> and launch the Bank url
    When I enter the valid user credentials in User Login page
    And I click on Submit button
    Then User should be logged in successfully
    And User homepage should have Username entry in the screen
    And Close Browser Window

    Examples: 
      | browser |
      | Chrome  |
      | IE      |
      | Firefox |

  #Scenario4
 @UnderTest
  Scenario: Valid User Login for registered user
    Given Registered user is configured in system
    And open Chrome browser and launch the Bank url
    When I enter UPPERCASE username and valid password in User Login page
    And I click on Submit button
    Then User should be logged in successfully
    And User homepage should have Username entry in the screen
    And Close Browser Window

  #Scenario5
 
  Scenario: Valid User Login for registered user
    Given Registered user is configured in system
    And open Chrome browser and launch the Bank url
    When I enter LOWERCASE username and valid password in User Login page
    And I click on Submit button
    Then User should be logged in successfully
    And User homepage should have Username entry in the screen
    And Close Browser Window

  #Scenario6

  Scenario: Invalid User Login for registered user
    Given Registered user is configured in system
    And open Chrome browser and launch the Bank url
    When I enter valid username and password is left blank in User Login page
    And I click on Submit button
    Then User should not be logged in successfully
    And Error message should be displayed #"Password is mandatory"
    And Close Browser Window

  #Scenario7

  Scenario: Invalid User Login for registered user
    Given Registered user is configured in system
    And open Chrome browser and launch the Bank url
    When I enter the password and Username is left blank in User Login page
    And I click on Submit button
    Then User should not be logged in successfully
    And Error message should be displayed #"Username is mandatory"
    And Close Browser Window

  #Scenario8
  
  Scenario: Invalid User Login for registered user
    Given Registered user is configured in system
    And open Chrome browser and launch the Bank url
    When I enter the valid username and invalid password in User Login page
    And I click on Submit button
    Then User login should fail
    And Error message should be displayed #"Entered User Name or Password is incorrect"
    And Close Browser Window

  #Scenario9
 
  Scenario: Invalid User Login for non-registered user
    Given User is not registered in the system
    And open Chrome browser and launch the Bank url
    When I enter username and password in User Login page
    And I click on Submit button
    Then User login should fail
    And Error message should be displayed #"Username is not registered. Please visit Branch Office"
    And Close Browser Window

  #Scenario10
 
  Scenario Outline: Account Lock for 3 consecutive Incorrect login attempts
    Given Registered user is configured in system
    And open Chrome browser and launch the Bank url
    When I enter valid <username> and invalid <password> in User Login page
    And I click on Submit button
    Then User Account should be locked
    And a message should be displayed saying that Account is locked #"You have reached maximum incorrect login attempts. Your account has been locked. Please contact nearest Branch"
    And Close Browser Window

    Examples: 
      | username | password |
      | akash    | 123@12   |
      | akash    | vrr@111  |
      | akash    | ina@123  |

  #Scenario11
  
  Scenario: Attempt to login for the locked Account
    Given Registered user is configured in system
    And open Chrome browser and launch the Bank url
    When I enter valid username and valid password in User Login page
    And I click on Submit button
    Then User Account should be locked and not able to log in
    And a message should be displayed saying that Account is locked #"You have reached maximum incorrect login attempts. Your account has been locked. Please contact nearest Branch"
    And Close Browser Window

  #Reset should be done in backend on database - have a column to update the status of the User - Active/Inactive/Locked
  #Scenario12
  
  Scenario: Attempt to login for the locked Account after reset
    Given Registered user is configured in system
    And open Chrome browser and launch the Bank url
    When I enter valid username and valid password in User Login page
    And I click on Submit button
    Then User should be logged in successfully
    And User homepage should have Username entry in the screen
    And Close Browser Window

  #Scenario13
 
  Scenario: Attempt to enter 11 character User Id
    Given Registered user is configured in system
    And open Chrome browser and launch the Bank url
    When I enter 11 characters in username field in User Login page
    And I click on Submit button
    Then User Id should not allow more than ten characters
    And Close Browser Window

  #Scenario14

  Scenario: Account Statement page
    Given Registered user is configured in system
    And open Chrome browser and launch the Bank url
    When I enter valid username and valid password in User Login page
    And I click on Submit button
    Then User should be logged in successfully
    And User homepage should have Username entry in the screen
    And User should be able to see Account Details Option in User homepage and click it
    And Close Browser Window

  #Scenario15
 
  Scenario: Funds Transfer page
    Given Registered user is configured in system
    And open Chrome browser and launch the Bank url
    When I enter valid username and valid password in User Login page
    And I click on Submit button
    Then User should be logged in successfully
    And User homepage should have Username entry in the screen
    And User should be able to see Funds Transfer Option in User homepage and click it
    And Close Browser Window
    
  #Scenario16
 
  Scenario: User clicks on Back button
    Given Registered user is configured in system
    And User is logged in successfully
    When I click on Back button
    Then Back button should be disabled 
    And Close Browser Window
    
  #Scenario17
 
  Scenario: Logout from User Home page
    Given Registered user is configured in system
    And User is logged in successfully
    When I click on Logout button
    Then User should be logged out successfully
    And Close Browser Window
 