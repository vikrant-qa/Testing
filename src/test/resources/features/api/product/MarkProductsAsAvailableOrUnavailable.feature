Feature: Product - Mark Products as Available - put - /product/mark-publish
         Product - Mark Products as Unavailable.-  put -  /product/mark-unpublish

         Login as a registered user as a seller
         I want to mark the Products as a Available for customers

         Login as a registered user as a seller
         I want to mark the Products as a Unavailable for customers

  Scenario: Login with valid registered user details as a Seller and user make a request for mark the Products as a Unavailable customers
    When User is able to log into application
      | email                                 | password       |
      | vikrant.singh@successive.tech         | HaiVikki12     |
    Then user should be able to login to the system and store token
    When user enters the Object ids of product
      | 5e53831cc317d30017cb894f     |
      | 5e53831cc317d30017cb894f     |
      | 5e537878edb8830017e45195     |
    And user make a request to mark the Products as a Unavailable for customers
    Then user should be able to mark the Products as a Unavailable


  Scenario: Login with valid registered user details as a Seller and user make a request for mark the Products as a available for customers
    When User is able to log into application
      | email                                 | password       |
      | vikrant.singh@successive.tech         | HaiVikki12     |
    Then user should be able to login to the system and store token
    When user enters the Object ids of product
      | 5e53831cc317d30017cb894f     |
      | 5e53831cc317d30017cb894f     |
      | 5e537878edb8830017e45195     |
    When user make a request to mark the Products as a Available for customers
    Then user should be able to mark the Products as a Available



  Scenario: Login with valid registered user details as a seller and user make a request for mark the Products as a Unavailable customers with blank id field
    When User is able to log into application
      | email                                 | password       |
      | vikrant.singh@successive.tech         | HaiVikki12     |
    Then user should be able to login to the system and store token
    When user enters the Object ids of product
      |                       |
    And user make a request to mark the Products as a Unavailable for customers
    Then user should not be able to mark the Products as a Unavailable and user should get a validation message
      | Ids is required.  |
#Bug--login as a seller ,user make a request to mark as available/unavailable  of products with blank id then it should be expected error message as a "Ids is required." but in actual scenario it gives response as a true and message ok



  Scenario: Login with valid registered user details as a seller and user make a request for mark the Products as a available for customers with blank id field
    When User is able to log into application
      | email                                 | password       |
      | vikrant.singh@successive.tech         | HaiVikki12     |
    Then user should be able to login to the system and store token
    When user enters the Object ids of product
      |                       |
    When user make a request to mark the Products as a Available for customers
    Then user should not be able to mark the Products as a Available and user should get a validation message
      | Ids is required.  |
#Bug--login as a seller ,user make a request to mark as available/unavailable  of products with blank id then it should be expected error message as a "Ids is required." but in actual scenario it gives response as a true and message ok


  Scenario: Login with valid registered user details as a seller and user make a request for mark the Products as a Unavailable customers with incorrect id field
    When User is able to log into application
      | email                                 | password       |
      | vikrant.singh@successive.tech         | HaiVikki12     |
    Then user should be able to login to the system and store token
    When user enters the Object ids of product
      | 12345678901234567890  |
    And user make a request to mark the Products as a Unavailable for customers
    Then user should not be able to mark the Products as a Unavailable and user should get a validation message
      | Invalid ids provided, Not found  |
#Bug--login as a seller ,user make a request to mark as available/unavailable  of products with invalid id then it should be expected error message as a "Invalid ids provided, Not found" but in actual scenario it gives response as a true and message ok


  Scenario: Login with valid registered user details as a seller and user make a request for mark the Products as a available for customers with incorrect id field
    When User is able to log into application
      | email                                 | password       |
      | vikrant.singh@successive.tech         | HaiVikki12     |
    Then user should be able to login to the system and store token
    When user enters the Object ids of product
      | 12345678901234567890  |
    When user make a request to mark the Products as a Available for customers
    Then user should not be able to mark the Products as a Available and user should get a validation message
      | Invalid ids provided, Not found  |
#Bug--login as a seller ,user make a request to mark as available/unavailable  of products with invalid id then it should be expected error message as a "Invalid ids provided, Not found" but in actual scenario it gives response as a true and message ok



  Scenario: Login with valid registered user details as a System-Admin and user make a request for mark the Products as a Unavailable customers
    When User is able to log into application
      | email                                 | password       |
      | systemadmin@marketcube.io             | 12345678n@N    |
    Then user should be able to login to the system and store token
    When user enters the Object ids of product
      | 5e53831cc317d30017cb894f     |
      | 5e53831cc317d30017cb894f     |
      | 5e537878edb8830017e45195     |
    And user make a request to mark the Products as a Unavailable for customers
    Then user should not be able to mark the Products as a Unavailable and user should get a validation message
      | User is not authorized to perform this action  |


  Scenario: Login with valid registered user details as a System-Admin and user make a request for mark the Products as a available for customers
    When User is able to log into application
      | email                                 | password       |
      | systemadmin@marketcube.io             | 12345678n@N    |
    Then user should be able to login to the system and store token
    When user enters the Object ids of product
      | 5e53831cc317d30017cb894f     |
      | 5e53831cc317d30017cb894f     |
      | 5e537878edb8830017e45195     |
    When user make a request to mark the Products as a Available for customers
    Then user should not be able to mark the Products as a Available and user should get a validation message
      | User is not authorized to perform this action  |

  Scenario: Login with valid registered user details as a Vendor and user make a request for mark the Products as a Unavailable customers
    When User is able to log into application
      | email                                 | password       |
      | vikrant.singh@successive.tech         | 1234567890     |
    Then user should be able to login to the system and store token
    When user enters the Object ids of product
      | 5e53831cc317d30017cb894f     |
      | 5e53831cc317d30017cb894f     |
      | 5e537878edb8830017e45195     |
    And user make a request to mark the Products as a Unavailable for customers
    Then user should not be able to mark the Products as a Unavailable and user should get a validation message
      | User is not authorized to perform this action  |


  Scenario: Login with valid registered user details as a Vendor and user make a request for mark the Products as a available for customers
    When User is able to log into application
      | email                                 | password       |
      | vikrant.singh@successive.tech         | 1234567890     |
    Then user should be able to login to the system and store token
    When user enters the Object ids of product
      | 5e53831cc317d30017cb894f     |
      | 5e53831cc317d30017cb894f     |
      | 5e537878edb8830017e45195     |
    When user make a request to mark the Products as a Available for customers
    Then user should not be able to mark the Products as a Available and user should get a validation message
      | User is not authorized to perform this action  |



  Scenario Outline: User make a request to mark product as avaliable with valid ids field by passing Incorrect/blank token data
    When user enters the Object ids of product
       | 5e53831cc317d30017cb894f     |
       | 5e53831cc317d30017cb894f     |
       | 5e537878edb8830017e45195     |
    When user make a request to mark product as avaliable with Incorrect/blank token field in form of without login credentials
       |  token                      |
       | <token>                     |
    Then user should not be able to mark the Products as a Available and user should get a validation message
      | Invalid token provided          |
      | Invalid token provided          |
    Examples:
      | token                           |
      |  sgshhshhshhshshhsh             |
      |                                 |

  Scenario Outline: User make a request to mark product as Unavaliable with valid ids field by passing Incorrect/blank token data
    When user enters the Object ids of product
      | 5e53831cc317d30017cb894f     |
      | 5e53831cc317d30017cb894f     |
      | 5e537878edb8830017e45195     |
    When user make a request to mark product as Unavaliable with Incorrect/blank token field in form of without login credentials
      |  token                      |
      | <token>                     |
    Then user should not be able to mark the Products as a Unavailable and user should get a validation message
      | Invalid token provided          |
      | Invalid token provided          |
    Examples:
      | token                           |
      |  sgshhshhshhshshhsh             |
      |                                 |



  Scenario: Testing Secenario1
    When user enters the Object ids of product1
      | 5e58bd1672d6c500170cd903     |
      | 5e58bd1672d6c500170cd904     |
      | 5e58bd1672d6c500170cd905     |