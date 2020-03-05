Feature: API - Login as a registered user

  As a registered user
  I want to delete shipping rule for seller

  Scenario: Login with valid registered user details and delete shipping rule for seller
    When User is able to log into application
    |email                     | password  |
    |mohit.agrawal@successive.tech | Mohit@1989 |
    Then user should be able to login to the system and store token
    When User enters shippingRuleId
    | shippingRuleId |
    | 5d9d9076a789b8001ed11981 |
    Then User should be able to delete shipping rule for seller

  Scenario: Login with valid registered user details and validate error message for delete shipping rule for seller
    When User is able to log into application
      |email                     | password  |
      |mohit.agrawal@successive.tech | Mohit@1989 |
    Then user should be able to login to the system and store token
    When User enters shippingRuleId
      | shippingRuleId |
      |   |
    Then User should not be able to delete shipping rule for seller