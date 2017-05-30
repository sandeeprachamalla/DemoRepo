Feature: Test Flipkart Smoke Scenarios

Scenario: Test Login with credentials
Given Open IE browser and start Flipkart application	
When I enter valid username and password
Then Login should be successfully done