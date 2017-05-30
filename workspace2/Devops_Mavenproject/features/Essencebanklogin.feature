Feature: Test Essencebank Login Smoke Scenarios

Scenario: Test Login with valid credentials
Given Open Google chrome and start bank application	
When I enter credentials
Then Login should be successfull
And Then Logout should be Successfull

Scenario: Test Login with invalid credentials
Given Open Google chrome and start bank application	
When I enter invalid username and valid pwd
Then Login should fail and Invalid username should be displayed
