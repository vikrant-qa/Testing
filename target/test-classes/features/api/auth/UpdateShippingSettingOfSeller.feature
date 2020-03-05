Feature: API - Login as a registered user

  As a registered user
  I want to delete shipping band for seller

  Scenario: Login with valid registered user details and update shipping setting for seller
    When User is able to log into application
    |email                     | password  |
    |mohit.agrawal@successive.tech | Mohit@1989 |
    Then user should be able to login to the system and store token
    When User enters shipping setting details to update
    | term | type | amount | vendorShipping |
    |23 | free | 223 |  |
    Then User should be able to update shipping setting for seller


  Scenario Outline: Login with valid registered user details and update shipping band for seller
    When User is able to log into application
      |email                     | password  |
      |mohit.agrawal@successive.tech | Mohit@1989 |
    Then user should be able to login to the system and store token
    When User enters shipping setting details to update
      | term | type | amount | vendorShipping |
      |<term> | <type> | <amount> | <vendorShipping> |
    Then User should not be able to update shipping setting for seller and validate error message
      | Term is required. |
      | Type is required. |
    Examples:
      | term | type | amount | vendorShipping |
      | | free | 223 |  |
      |23 |  | 223 |  |
