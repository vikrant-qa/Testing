Feature: As a System Admin
      user wants to ctreate Association between vendor and seller
      and then remove Association between vendor and seller.

  Scenario: Login with valid registered user details as a system admin and create Association between vendor and seller
    When User is able to log into application
      | email                         | password   |
      | systemadmin@marketcube.io     | 123456789  |
    Then user should be able to login to the system and store token
    And user select the vendor and seller by way of entering the vendor id and seller id for create association
    | vendor                         | seller                     |
    | 5e4111fbdbf899001a5580ae       | 5e29912fbfec74a0272e9a92   |
    And user make a request to create a association between vendor and seller
    Then user should be able to create a association and user should get a message as a Association Created

  Scenario: Login with valid registered user details as a system admin and create Association between vendor and seller while they already have a  Association
    When User is able to log into application
      | email                         | password   |
      | systemadmin@marketcube.io     | 123456789  |
    Then user should be able to login to the system and store token
    And user select the vendor and seller by way of entering the vendor id and seller id for create association
      | vendor                         | seller                     |
      | 5e4111fbdbf899001a5580ae       | 5e29912fbfec74a0272e9a92   |
    And user make a request to create a association between vendor and seller while they already have a Association
    Then user should not be able to create a association and user should get a validation message as a Association already exists


  Scenario: Login with valid registered user details as a system admin and remove association between vendor and seller
     When User is able to log into application
       | email                         | password   |
       | systemadmin@marketcube.io     | 123456789  |
     Then user should be able to login to the system and store token
     And user select the vendor and seller by way of entering the vendor id and seller id for remove association
       | _id                            | seller                     |
       | 5e4111fbdbf899001a5580ae       | 5e29912fbfec74a0272e9a92   |
     And user make a request to remove a association between vendor and seller
     Then user should be able to remove a association and user should get a message as a Associations removed successfully

  Scenario Outline: Login with valid registered user details as a seller or vendor and try to remove association between vendor and seller
    When User is able to log into application
      | email                             | password     |
      | <email>                           | <password>   |
    Then user should be able to login to the system and store token
    And user select the vendor and seller by way of entering the vendor id and seller id for remove association
      | _id                            | seller                     |
      | 5e4111fbdbf899001a5580ae       | 5e29912fbfec74a0272e9a92   |
    And user make a request to remove a association between vendor and seller
    Then user should not be able to remove a association and user should get a message as a Invalid user provided
    Examples:
      | email                             | password    |
      | vikrant.singh@successive.tech     | 1234567890  |
      | vikrant.singh@successive.tech     |  HaiVikki12 |

  Scenario Outline: Login with valid registered user details as a seller or vendor and try to create Association between vendor and seller
    When User is able to log into application
      | email                             | password     |
      | <email>                           | <password>   |
    Then user should be able to login to the system and store token
    And user select the vendor and seller by way of entering the vendor id and seller id for create association
      | vendor                         | seller                     |
      | 5e4111fbdbf899001a5580ae       | 5e29912fbfec74a0272e9a92   |
    And user make a request to create a association between vendor and seller
    Then user should not be able to create a association and user should get a message as a User is not authorized to perform this action
    Examples:
      | email                             | password    |
      | vikrant.singh@successive.tech     | 1234567890  |
      | vikrant.singh@successive.tech     |  HaiVikki12 |


  Scenario Outline: Login with valid registered user details as a system admin and create association between vendor and seller by way of without selecting vendor and seller
    When User is able to log into application
      | email                         | password   |
      | systemadmin@marketcube.io     | 123456789  |
    Then user should be able to login to the system and store token
    And user select the vendor and seller by way of entering the vendor id and seller id for create association
      | vendor                         | seller                     |
      | <vendor>                       | <seller>                   |
    And user make a request to create a association between vendor and seller
    Then user should not be able to create a association without follow any field validation then user should get a validation message
      | Seller is required.    |
      |  Vendor is required.   |
    Examples:
      | vendor                         | seller                     |
      | 5e4111fbdbf899001a5580ae       |                            |
      |                                | 5e29912fbfec74a0272e9a92   |

  Scenario Outline: Login with valid registered user details as a system admin and remove association between vendor and seller by way of without  selecting vendor and seller
    When User is able to log into application
      | email                         | password   |
      | systemadmin@marketcube.io     | 123456789  |
    Then user should be able to login to the system and store token
    And user select the vendor and seller by way of entering the vendor id and seller id for remove association
      | _id                            | seller                     |
      | <_id>                          | <seller>                   |
    And user make a request to remove a association between vendor and seller
    Then user should not be able to remove a association without follow any field validation then user should get a  validation message
    | Seller is required.                   |
    | _id is required.                      |
    Examples:
      | _id                            | seller                     |
      | 5e4111fbdbf899001a5580ae       |                            |
      |                                | 5e29912fbfec74a0272e9a92   |

  Scenario Outline: User wants to remove association between vendor and seller by passing with Incorrect/blank token data
    When user make a request to remove association with Incorrect/blank token field in form of without login credentials
      | token                      |
      | <token>                    |
    Then user should not be able to remove a association without follow any field validation then user should get a  validation message for Incorrect/blank token
      | Invalid token provided          |
    Examples:
      | token                           |
      |  sgshhshhshhshshhsh             |
      |                                 |