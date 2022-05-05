Feature: Login feature
Background:  
Given User navigated to the Application
    Scenario: Valid admin login
   
    When user valid username and valid password
    And user clicks on login button
    Then user is successfully logged in
     @Smoke1
    Scenario: Valid admin login
   
    When user valid "Admin" and valid "admin123"
    And user clicks on login button
    Then user is successfully logged in
    
     @Smoke
    Scenario Outline: Login Functionality
   
    When user enters different "<username>" and "<password>"
    And user clicks on login button
    Then user verify the "<error>" for all the combinations
     Examples:
    |username|password|error|
    |Admin   |xyz     |Invalid credentials|
    |cristiano|admin123|Invalid credentials|
    |         |admin123|Username cannot be empty|
    |Admin    |           |Password cannot be empty|