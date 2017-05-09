Feature: Test Essencebank Account statement Scenarios

Scenario: Test Account statement display
Given Open Google chrome and start Essence bank application	
And user logged in successfully
When I click on Account Statement
Then Account Statement details should be displayed successfully