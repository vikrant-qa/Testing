Feature: Api- Update profile of Supplier / Seller /SystemAdmin

        As a Supplier / Seller /SystemAdmin
        User wants to change the profile of Vendor

  Scenario: User login as a seller with valid registered details and update the profile of their associated vendor
    When User is able to log into application
      | email                         | password   |
      | vikrant.singh@successive.tech | HaiVikki12 |
    Then user should be able to login to the system and store token
    And User make a request to change the profile of their associated Vendor
    | brandName     | firstName   | lastName   | phoneNumber  | email                           | id                          | address             | city       | country     | pinCode     | commision   | commisionType  | logo  | profile |  editedBy  |
    | Your vendor   | Bigger      | B deal     | 12221212     | vikrant.singh@successive.tech   |  5e2996260da2580011251edb   | delhi1              | delhi2     | India       | 110090      |  12         |                |       | true    |   Seller   |
    Then User is able to change the profile successfully and should get a message as a Profile updated successfully

  Scenario: User login as a Vendor with valid registered details and update the profile of their associated vendor
    When User is able to log into application
      | email                         | password   |
      | vikrant.singh@successive.tech | 1234567890 |
    Then user should be able to login to the system and store token
    And User make a request to change the profile of their associated Vendor
      | brandName     | firstName   | lastName   | phoneNumber  | email                           | id                          | address             | city       | country     | pinCode     | commision   | commisionType  | logo  | profile |  editedBy  |
      | Your vendor   | Bigger      | B deal     | 12221212     | vikrant.singh@successive.tech   |  5e2996260da2580011251edb   | delhi1              | delhi2     | India       | 110090      |  12         |                |       | true    |   Seller   |
    Then User is able to change the profile successfully and should get a message as a Profile updated successfully

  Scenario: User login as a System Admin with valid registered details and update the profile of their associated vendor
    When User is able to log into application
      | email                         | password   |
      | systemadmin@marketcube.io     | 123456789 |
    Then user should be able to login to the system and store token
    And User make a request to change the profile of their associated Vendor
      | brandName     | firstName   | lastName   | phoneNumber  | email                           | id                          | address             | city       | country     | pinCode     | commision   | commisionType  | logo  | profile |  editedBy  |
      | Your vendor   | Bigger      | B deal     | 12221212     | vikrant.singh@successive.tech   |  5e2996260da2580011251edb   | delhi1              | delhi2     | India       | 110090      |  12         |                |       | true    |   Seller   |
    Then User is able to change the profile successfully and should get a message as a Profile updated successfully

  Scenario Outline: user request for change Profile of their associated vendor and not follow any field validation
    When User is able to log into application
      | email                         | password   |
      | vikrant.singh@successive.tech | HaiVikki12 |
    Then user should be able to login to the system and store token
    When User make a request to change the profile of their associated Vendor
      | brandName       | firstName     | lastName     | phoneNumber   | email                             | id                            | address               | city         | country       | pinCode       | commision     | commisionType    | logo    | profile   |  editedBy    |
      | <brandName>     | <firstName>   | <lastName>   | <phoneNumber> | <email>                           | <id>                          | <address>             | <city>       | <country>     | <pinCode>     | <commision>   | <commisionType>  | <logo>  | <profile> |  <editedBy>  |
    Then user will not able to change profile and user should get validation messages
      |  All fields marked with * are required        |
      |  All fields marked with * are required        |
      |  All fields marked with * are required        |
      |  All fields marked with * are required        |
      |  Cast to ObjectId failed for value \"5e2996260da2580011251edb1\" at path \"_id\" for model \"Users\"  |
    Examples:
      | brandName     | firstName   | lastName   | phoneNumber  | email                           | id                          | address             | city       | country     | pinCode     | commision   | commisionType  | logo  | profile |  editedBy  |
      | Your vendor   |             | B deal     | 12221212     | vikrant.singh@successive.tech   |  5e2996260da2580011251edb   | delhi1              | delhi2     | India       | 110090      |  12         |                |       | true    |   Seller   |
      | Your vendor   | Bigger      |            | 12221212     | vikrant.singh@successive.tech   |  5e2996260da2580011251edb   | delhi1              | delhi2     | India       | 110090      |  12         |                |       | true    |   Seller   |
      | Your vendor   | Bigger      | B deal     |              | vikrant.singh@successive.tech   |  5e2996260da2580011251edb   | delhi1              | delhi2     | India       | 110090      |  12         |                |       | true    |   Seller   |
      | Your vendor   | Bigger      | B deal     | 12221212     | vikrant.singh@successive.tech   |                             | delhi1              | delhi2     | India       | 110090      |  12         |                |       | true    |   Seller   |
      | Your vendor   | Bigger      | B deal     | 12221212     | vikrant.singh@successive.tech   |  5e2996260da2580011251edb1  | delhi1              | delhi2     | India       | 110090      |  12         |                |       | true    |   Seller   |

  Scenario Outline: user wants to update the profile of their associated vendor with incorrect/blank token data
    And User make a request to change the profile of their associated Vendor with Incorrect Token
      | brandName     | firstName   | lastName   | phoneNumber  | email                           | id                          | address             | city       | country     | pinCode     | commision   | commisionType  | logo  | profile |  editedBy  |
      | Your vendor   | Bigger      | B deal     | 12221212     | vikrant.singh@successive.tech   |  5e2996260da2580011251edb   | delhi1              | delhi2     | India       | 110090      |  12         |                |       | true    |   Seller   |
    When user make a request to change profile of vendor with Incorrect/blank token field in form of without login credentials
      |  token                           |
      |  <token>                         |
    Then user will not able to change profile and user should get validation messages for incorrect/blank token
    Examples:
      | token                           |
      |  sgshhshhshhshshhsh             |
      |                                 |

