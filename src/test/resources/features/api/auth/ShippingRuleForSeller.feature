Feature: API - Login as a registered user

  As a registered user
  I want to change the shipping rule for seller

  Scenario Outline: Login with valid registered user details and create shipping rule for seller
    When User is able to log into application
    |email                     | password  |
    |mohit.agrawal@successive.tech | Mohit@1989 |
    Then user should be able to login to the system and store token
    When User enter details  for  create shipping rule for seller
    | shippingBandId | price | description | condition | destinationCodes | productIds | priceType | isShippingDisabled |
    | <shippingBandId> | <price> | <description> | <condition> | <destinationCodes> | <productIds> | <priceType> | <isShippingDisabled> |
    Then User should be able to create rule for seller
    Examples:
      | shippingBandId | price | description | condition | destinationCodes | productIds | priceType | isShippingDisabled |
      | 5d9d9076a789b8001ed11981 | 23 | free | product |  | | free | false |

  Scenario Outline: Login with valid registered user details and validate shipping rule for seller error messages
    When User is able to log into application
      |email                     | password  |
      |mohit.agrawal@successive.tech | Mohit@1989 |
    Then user should be able to login to the system and store token
    When User enter details  for  create shipping rule for seller
      | shippingBandId | price | description | condition | destinationCodes | productIds | priceType | isShippingDisabled |
      | <shippingBandId> | <price> | <description> | <condition> | <destinationCodes> | <productIds> | <priceType> | <isShippingDisabled> |
    Then User should not be able to create rule for seller and get error message
    | ShippingBandId is required. |
    | Description is required.    |
    | Condition is required.      |
    | PriceType is required.      |
    Examples:
      | shippingBandId | price | description | condition | destinationCodes | productIds | priceType | isShippingDisabled |
      |  | 23 | free | product |  | | free | false |
      | 5d9d9076a789b8001ed11981 | 23 |  | product |  | | free | false |
      | 5d9d9076a789b8001ed11981 | 23 | free |  |  | | free | false |
      | 5d9d9076a789b8001ed11981 | 23 | free | product |  | |  | false |