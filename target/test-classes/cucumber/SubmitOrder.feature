
@tag
Feature: Purchase the order from ecommerce website

Background:
Given I landed on ecommerce page
  @Regression
  Scenario Outline: Positive tests of submitting the order
    Given Logged in with username <username> and password <password>
    When I add product <productName> from cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on the confirmation page

    Examples: 
  		| username  							 | password 		| productName		 |
      | shetty@gmail.com		 |  Iamking@000 |IPHONE 13 PRO 	 |
      | pathakpiyush93@gmail.com |   Piyush123@ | ADIDAS ORIGINAL|
