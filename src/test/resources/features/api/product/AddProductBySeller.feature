Feature: API - Register supplier as a user

  As a new user
  I want to add a product on marketcube
  So that seller is able to add product on behalf of vendor

  Scenario: Seller add a product to marketcbe on behalf of vendor
    When User is able to log into application
      |email                     | password  |
      |mohit.agrawal@successive.tech | Mohit@1989 |
    Then user should be able to login to the system and store token
    When user enter details of product
      | title | description | handle | vendor | vendorId  | tags | collections | productType | comparePrice | isTaxable | price | barcode | inventoryManagement | sku | isShipping | weight | weightUnit | fulfillmentService | option1 | option2 | option3 | images | variants | approved | userId | isWebhook | shopifyProductId |
      | Puma  | this is added by api | handle | test | 5dcbfbe0e07320001a882d18 | s | | household | 123  | true      | 122   | 423ljlj | Mohit               | 23  | true       | 1      | kg         | yes                | Option 1| option2 | option3 |        |   a      | true     | 5dc93694b47bb36e90665083 | true |     |
    Then product should be added to system

  Scenario Outline: Seller add a product to marketcbe with some information forgot to validate error message
    When User is able to log into application
      |email                     | password  |
      |mohit.agrawal@successive.tech | Mohit@1989 |
    Then user should be able to login to the system and store token
    When user enter details of product
      | title | description | handle | vendor | vendorId  | tags | collections | productType | comparePrice | isTaxable | price | barcode | inventoryManagement | sku | isShipping | weight | weightUnit | fulfillmentService | option1 | option2 | option3 | images | variants | approved | userId | isWebhook | shopifyProductId |
      | <title>  | <description> | <handle> | <vendor> | <vendorId> | <tags> | <collections> | <productType> | <comparePrice>  | <isTaxable>      | <price>   | <barcode> | <inventoryManagement> | <sku>  | <isShipping> | <weight> | <weightUnit> | <fulfillmentService> | <option1>| <option2> | <option3> | <images> | <variants>  | <approved> | <userId> | <isWebhook> | <shopifyProductId> |
    And enter error message to be validate
      | message |
      |   Title is required.      |
      | Handle is required.       |
      | Invalid supplier provided       |
    Then product should not be added to system and error message should be verified
    Examples:
      | title | description | handle | vendor | vendorId  | tags | collections | productType | comparePrice | isTaxable | price | barcode | inventoryManagement | sku | isShipping | weight | weightUnit | fulfillmentService | option1 | option2 | option3 | images | variants | approved | userId | isWebhook | shopifyProductId |
      |   | this is added by api | handle | test | 5dcbfbe0e07320001a882d18 | s | | household | 123  | true      | 122   | 423ljlj | Mohit               | 23  | true       | 1      | kg         | yes                | Option 1| option2 | option3 |        |   a      | true     | 5dc93694b47bb36e90665083 | true |     |
      | puma  | this is added by api |  | test | 5dcbfbe0e07320001a882d18 | s | | household | 123  | true      | 122   | 423ljlj | Mohit               | 23  | true       | 1      | kg         | yes                | Option 1| option2 | option3 |        |   a      | true     | 5dc93694b47bb36e90665083 | true |     |
      | puma  | this is added by api | mohit | t233est | 5dcbfbe0e07320001a882d18 | s | | household | 123  | true      | 122   | 423ljlj | Mohit               | 23  | true       | 1      | kg         | yes                | Option 1| option2 | option3 |        |   a      | true     | 5dc93694b47bb36e90665083 | true |     |
