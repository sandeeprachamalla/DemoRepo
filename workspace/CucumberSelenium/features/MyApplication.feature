Feature: Test Facebook Smoke Scenarios

Scenario: Test Login with valid credentials
Given Open Google chrome and start application	
When I enter valid username and valid password
Then Login should be successful

Scenario: Test Login with invalid credentials
Given Open Google chrome and start application	
When I enter invalid username and valid password
Then Invalid username should be displayed

Scenario: Test Login with invalid credentials
Given Open Google chrome and start application	
When I enter valid username and invalid password
Then Invalid password should be displayed
