@Leadall @regression
Feature: Lead functionaity

@createlead
Scenario: TC03_CreateLeadWithMandatoryFields
Given user should be on login page
When user enters valid credentials and click on login button
Then user should be navigated to home page 
When user clicks on new lead link
And user puts mandatory values within lead form and click on save button
Then lead should created successfully
And click on logout