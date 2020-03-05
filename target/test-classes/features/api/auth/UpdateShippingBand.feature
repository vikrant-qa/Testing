Feature: API - Login as a registered user

  As a registered user
  I want to delete shipping band for seller

  Scenario: Login with valid registered user details and update shipping band for seller
    When User is able to log into application
    |email                     | password  |
    |mohit.agrawal@successive.tech | Mohit@1989 |
    Then user should be able to login to the system and store token
    When User enters shipping band details to update
    | _id | name | description | priceType | price | isUpdateAllowed|
    |5ddf8f3070ae98001bda132e | sdf | dsc | free | 22 | true        |
    Then User should be able to update shipping band for seller


  Scenario Outline: Login with valid registered user details and update shipping band for seller
    When User is able to log into application
      |email                     | password  |
      |mohit.agrawal@successive.tech | Mohit@1989 |
    Then user should be able to login to the system and store token
    When User enters shipping band details to update
      | _id | name | description | priceType | price | isUpdateAllowed|
      |<_id> | <name> | <description> | <priceType> | <price> | <isUpdateAllowed>        |
    Then User should not be able to update shipping band for seller and validate error message
      | _id is required. |
      | Name is required. |
      | Description is required. |
      | PriceType is required.   |
      | IsUpdateAllowed is required. |
    Examples:
      | _id | name | description | priceType | price | isUpdateAllowed|
      | | sdf | dsc | free | 22 | true        |
      |5ddf8f3070ae98001bda132e |  | dsc | free | 22 | true        |
      |5ddf8f3070ae98001bda132e | sdf |  | free | 22 | true        |
      |5ddf8f3070ae98001bda132e | sdf | dsc |  | 22 | true        |
      |5ddf8f3070ae98001bda132e | sdf | dsc | free | 22 |         |