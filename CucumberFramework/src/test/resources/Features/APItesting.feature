Feature: API Automation

@GetAPI
Scenario Outline: <TCName>
Given endpoint url
When user call get method
Then user can see the response
And Status line should be matched
And validate response data
Examples:
|TCName|
|TC01_Validate Get API List Users page 2|
|TC02_Validate Get API List Users page 1|
|TC03_Validate Get API single Users|

@Postccall
Scenario: TC04 create User
Given endpoint url
When user create the request and call the request method
Then user can see the response
And Status line should be matched
And validate response data

@Postccall
Scenario: TC05 update User
Given endpoint url
When user create the request and call the request method
Then user can see the response
And Status line should be matched
And validate response data

@Postccall
Scenario: TC06 update patch User
Given endpoint url
When user create the request and call the request method
Then user can see the response
And Status line should be matched
And validate response data







  
