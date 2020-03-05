Feature: API - User add paypal details for vendor/seller

  As a registered user
  I want to add paypal details for seller/vendor

  Scenario: Login with valid registered user details and add paypal details successfully
    When User is able to log into application
    |email                     | password  |
    |mohit.agrawal@successive.tech | Mohit@1989 |
    Then user should be able to login to the system and store token
    When user enters paypal detais for seller or vendor
    | secret | clientId | emailId | isActive |
    | secretKey| csdfsdlj32 | mohit.agrawal@successive.tech | true |
    Then user should be able to add paypal  details for any seller or vendor

  Scenario Outline: Login with valid registered user details and check validation error messages
    When User is able to log into application
      |email                     | password  |
      |mohit.agrawal@successive.tech | Mohit@1989 |
    Then user should be able to login to the system and store token
    When user enters paypal detais for seller or vendor
      | secret | clientId | emailId | isActive |
      | <secret>| <clientId> | <emailId> | <isActive> |
    And enter validation error message for paypal
      | ClientId is required. |
      | Secret is required. |
    Then user should not be able to add paypal  details for any seller or vendor
  Examples:
      | secret | clientId | emailId | isActive |
      | secretKey|  | mohit.agrawal@successive.tech | true |
      | | adsfsaa | mohit.agrawal@successive.tech | true |
