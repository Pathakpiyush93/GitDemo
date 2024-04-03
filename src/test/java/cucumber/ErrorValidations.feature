
@tag
Feature: Error Validation

  @ErrorValidation
  Scenario Outline: Error validation
    Given I landed on ecommerce page
    When Logged in with username <username> and password <password>
    Then "Incorrect email or password." message is displayed

    Examples: 
    		| username  							 | password 		|
       | pathakpiyush93@gmail.com |   Piyush123 | 
