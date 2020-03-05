Feature:  Order - Update order.-  put -  /order

          As a registered user,
          I want to update order

  Scenario: Login with valid registered user details as a seller and user wants to update order
    When User is able to log into application
      | email                                 | password       |
      | vikrant.singh@successive.tech         | HaiVikki12     |
    Then user should be able to login to the system and store token
    Then user should be able to login to the system and store token
    When user enters unique id of order
      | id                        |
      | 5df32ccbddc51e001065ec14  |
    And User enters details of order to be updated
      | sellerId                   | shopifyOrderId   | email                         | note   | shipping_address   |
      | 5dc93694b47bb36e90665083   | 1974551674965    | mohit.agrawal@successive.tech | sdfsd  | sdfsdf             |
    Then User should be able to update order


  Scenario Outline: Login with valid registered user details and validate error message for all fields
    When User is able to log into application
      |email | password  |
      |mohit.agrawal@successive.tech | Mohit@1989 |
    Then user should be able to login to the system and store token
    When user enters unique id of order
      | id                        |
      | <id>                      |
    And User enters details of order to be updated
      |sellerId | shopifyOrderId | email | note |shipping_address|
      | <sellerId> |<shopifyOrderId> |<email>|<note>| <shipping_address>|
    Then User should not be able to update order
      |SellerId is required.|
    Examples:
      | sellerId | id                       | shopifyOrderId  | email                           | note   | shipping_address  |
      |          | 5df32ccbddc51e001065ec14 | 1974551674965   | mohit.agrawal@successive.tech   | sdfsd  | sdfsdf            |