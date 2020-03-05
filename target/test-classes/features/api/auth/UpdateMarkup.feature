Feature: API - Update markup of product

  As a registered user
  I want to update markup of producgt

  Scenario: Login with valid registered user details and update product markup
    When User is able to log into application
    |email                     | password  |
    |mohit.agrawal@successive.tech | Mohit@1989 |
    Then user should be able to login to the system and store token
    When enter details and send request to update markup
    | type | sellerId | ruleBy | price |
    |   flat     |   5dc93694b47bb36e90665083   |    vendor      |        12        |
    And user enter advance values for product
    | price | type | category |
    |   12    |  flat    |          |
    Then User should be able to update product markup

  Scenario Outline: Login with valid registered user details and check validation error message for update product markup
    When User is able to log into application
      |email                     | password  |
      |mohit.agrawal@successive.tech | Mohit@1989 |
    Then user should be able to login to the system and store token
    When enter details and send request to update markup
      | type | sellerId | ruleBy | price |
      |   <type>     |   <sellerId>   |  <ruleBy>    | <price> |
    And user enter advance values for product
      | price | type | category |
      |   12    |  flat    |          |
    Then User should not be able to update product markup and display message
      | RuleBy is required. |
      | SellerId is required. |
    Examples:
      | type | sellerId | ruleBy | price |
      |   flat     |   5dc93694b47bb36e90665083   |      |        12        |
      |   flat     |      |   vendor   |        12        |
