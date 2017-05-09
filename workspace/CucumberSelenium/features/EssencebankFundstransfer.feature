Feature: Test Essencebank Funds Transfer Scenarios

Scenario: Test Funds transfer display
Given Open Google chrome browser and start Essence bank application	
And user is logged in successfully
When I click on Transfer Funds
And Select from and to accounts and enter amount details and click on submit
Then Funds transfer details should be displayed successfully