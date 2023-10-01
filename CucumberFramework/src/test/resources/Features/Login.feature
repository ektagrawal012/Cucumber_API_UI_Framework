@regression
Feature: login functionaity

Scenario: TC01_InValidLogin
Given user should be on login page
When user enters Invalid credentials and click on login button
Then user can see error message on login page 


Scenario: TC02_ValidLogin
Given user should be on login page
When user enters valid credentials and click on login button
Then user should be navigated to home page 
And click on logout

