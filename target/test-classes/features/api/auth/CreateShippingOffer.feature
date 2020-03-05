Feature: API - Login as a registered user

  As a registered user
  I want to change the shipping rule for seller

  Scenario Outline: Login with valid registered user details and create shipping rule for seller
    When User is able to log into application
    |email                     | password  |
    |mohit.agrawal@successive.tech | Mohit@1989 |
    Then user should be able to login to the system and store token
    When user enters details for create shipping offer for seller
    |_id|shippingBandId|condition|productId|destinationCode|productPrice|productQuantity|description|price|priceType|isCumulative|
    |<_id>|<shippingBandId>|<condition>|<productId>|<destinationCode>|<productPrice>|<productQuantity>|<description>|<price>|<priceType>|<isCumulative>|
    Then User should be able to create shipping offer for seller
    Examples:
      |_id                     |shippingBandId          |condition|productId|destinationCode|productPrice|productQuantity|description|price|priceType|isCumulative|
      |5de7b9382aebea001955c0f8|5ddf91a070ae98001bda133c|product  |         |               |            |               |dsfs       |23   |free     |false       |

  Scenario Outline: Login with valid registered user details and validate shipping rule for seller error messages
    When User is able to log into application
      |email                     | password  |
      |mohit.agrawal@successive.tech | Mohit@1989 |
    Then user should be able to login to the system and store token
    When user enters details for create shipping offer for seller
      |_id|shippingBandId|condition|productId|destinationCode|productPrice|productQuantity|description|price|priceType|isCumulative|
      |<_id>|<shippingBandId>|<condition>|<productId>|<destinationCode>|<productPrice>|<productQuantity>|<description>|<price>|<priceType>|<isCumulative>|
    Then User should not be able to create offer for seller and get error message
    | _id is required.            |
    | Description is required.    |
    | PriceType is required.      |
    Examples:
      |_id                     |shippingBandId          |condition|productId|destinationCode|productPrice|productQuantity|description|price|priceType|isCumulative|
      |                        |5ddf91a070ae98001bda133c|product  |         |               |            |               |dsfs       |23   |free     |false       |
      |5de7b9382aebea001955c0f8|5ddf91a070ae98001bda133c|product  |         |               |            |               |           |23   |free     |false       |
      |5de7b9382aebea001955c0f8|5ddf91a070ae98001bda133c|product  |         |               |            |               |dsfs       |23   |         |false       |