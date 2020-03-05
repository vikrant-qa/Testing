Feature: API - Login as a registered user

  As a registered user
  I want to delete shipping band for seller

  Scenario: Login with valid registered user details and update shipping offer for seller
    When User is able to log into application
    |email                     | password  |
    |mohit.agrawal@successive.tech | Mohit@1989 |
    Then user should be able to login to the system and store token
    When User enters shipping details to update
    | _id | shippingBandId | condition | productId | destinationCode | productPrice | productQuantity | description | price | priceType | isCumulative |
    | 5de7b9382aebea001955c0f8 | 5d4d621ea1ca630016c573c7 | product | | |           |                 | dsf         |   23  | free      | false        |
    Then User should be able to update shipping offer for seller

  Scenario Outline: Login with valid registered user details and update shipping offer for seller
    When User is able to log into application
      |email                     | password  |
      |mohit.agrawal@successive.tech | Mohit@1989 |
    Then user should be able to login to the system and store token
    When User enters shipping details to update
      | _id | shippingBandId | condition | productId | destinationCode | productPrice | productQuantity | description | price | priceType | isCumulative |
      | <_id> | <shippingBandId> | <condition> | <productId> | <destinationCode> | <productPrice> |  <productQuantity> | <description> |   <price>  | <priceType> | <isCumulative> |
    Then User should not be able to update shipping offer for seller and get validation erro message
    | _id is required. |
    | Description is required. |
    | PriceType is required. |
    Examples:
      | _id | shippingBandId | condition | productId | destinationCode | productPrice | productQuantity | description | price | priceType | isCumulative |
      |  | 5d4d621ea1ca630016c573c7 | product | | |           |                 | dsf         |   23  | free      | false        |
      | 5de7b9382aebea001955c0f8 | 5d4d621ea1ca630016c573c7 | product | | |           |                 |   |   23  | free      | false        |
      | 5de7b9382aebea001955c0f8 | 5d4d621ea1ca630016c573c7 | product | | |           |                 | dsf         |   23  |    | false        |