Feature: Product - Fetch product data - get -  /product/:id

        Login as a registered user(System admin/seller/vendor)
        I want to fetch details of product

  Scenario: Login with valid registered user details as a System Admin and user make a request for fetch data details of product
    When User is able to log into application
      | email                                 | password       |
      | systemadmin@marketcube.io             | 12345678n@N    |
    Then user should be able to login to the system and store token
    When user enters the Object id of product and Object id of user who is sending the request
      | id                          | userId                     |
      | 5e53831cc317d30017cb894f    | 59c134d3c8efb4001a2bf1ad   |
    And user make a request to fetch details of desired product
    Then user should be able to fetch details of desired product

#for seller we  use sellerProducts object id as a id instead of objectid of products  that we find from sellerProducts table
# and use products table and sellerProducts table
# object id of products table use  as  "productId": "5e53831cc317d30017cb894f" in sellerProducts table.

  Scenario: Login with valid registered user details as a seller and user make a request for fetch data details of product
    When User is able to log into application
      | email                                 | password       |
      | vikrant.singh@successive.tech         | HaiVikki12     |
    Then user should be able to login to the system and store token
    When user enters the Object id of product and Object id of user who is sending the request
      | id                          | userId                     |
      | 5e53831c59b31378d494ec14    | 5e29912fbfec74a0272e9a92   |
    And user make a request to fetch details of desired product
    Then user should be able to fetch details of desired product


  Scenario: Login with valid registered user details as a vendor and user make a request for fetch data details of product
    When User is able to log into application
      | email                                 | password       |
      | vikrant.singh@successive.tech         | 1234567890     |
    Then user should be able to login to the system and store token
    When user enters the Object id of product and Object id of user who is sending the request
      | id                          | userId                     |
      | 5e53831cc317d30017cb894f    | 5e2996260da2580011251edb   |
    And user make a request to fetch details of desired product
    Then user should be able to fetch details of desired product




  Scenario: Login with valid registered user details as a vendor and user make a request for fetch data details of product with the use of system Admin userID
    When User is able to log into application
      | email                                 | password       |
      | vikrant.singh@successive.tech         | 1234567890     |
    Then user should be able to login to the system and store token
    When user enters the Object id of product and Object id of user who is sending the request
      | id                          | userId                     |
      | 5e53831cc317d30017cb894f    | 59c134d3c8efb4001a2bf1ad   |
    And user make a request to fetch details of desired product
    Then user should not be able to fetch details of desired product that he requested and user shuld get a validation message
      | Invalid userId provided.           |




  Scenario Outline: Login with valid registered user details as a vendor and user make a request for fetch details of product without follow input field validation
    When User is able to log into application
      | email                                 | password       |
      | vikrant.singh@successive.tech         | 1234567890     |
    Then user should be able to login to the system and store token
    When user enters the Object id of product and Object id of user who is sending the request
      | id                            | userId                       |
      | <id>                          | <userId>                     |
    And user make a request to fetch details of desired product
    Then user should not be able to fetch details of desired product that he requested and user shuld get a validation message
      | id is required.                    |
      | UserId is required.                |
      | UserId is required.                |
      | Invalid id provided.               |
      | Invalid userId provided.           |
    Examples:
      | id                          | userId                     |
      |                             | 5e2996260da2580011251edb   |
      | 5e53831cc317d30017cb894f    |                            |
      |                             |                            |
      | 12345678901234567890        | 5e2996260da2580011251edb   |
      | 5e53831cc317d30017cb894f    | 12345678901234567890       |
#bug-  login as a seller/vendor/systemadmin ,user make a request for fetch row data details of product  with blank id field ,then it should be expected message as a "id is required." but in actual scenario it accepts the request , give response as true  and status ok
# bug-  login as a seller/vendor/systemadmin ,user make a request for fetch row data details of product  with invalid/wrong id field ,then it should be expected message as a "Invalid id provided." but in actual scenario it accepts the request ,give response as true and status ok
  # bug-  login as a seller/vendor/systemadmin ,user make a request for fetch row data details of product  with invalid/wrong userId field ,then it should be expected message as a "Invalid userId provided." but in actual scenario it gives the actual message as a "Cast to ObjectId failed for value \"12345678901234567890\" at path \"_id\" for model \"Users\""


  Scenario Outline: Login with valid registered user details as a seller and user make a request for fetch details of product without follow input field validation
    When User is able to log into application
      | email                                 | password       |
      | vikrant.singh@successive.tech         | HaiVikki12     |
    Then user should be able to login to the system and store token
    When user enters the Object id of product and Object id of user who is sending the request
      | id                            | userId                       |
      | <id>                          | <userId>                     |
    And user make a request to fetch details of desired product
    Then user should not be able to fetch details of desired product that he requested and user shuld get a validation message
      | id is required.                    |
      | UserId is required.                |
      | UserId is required.                |
      | Invalid id provided.               |
      | Invalid userId provided.           |
    Examples:
      | id                          | userId                     |
      |                             | 5e29912fbfec74a0272e9a92   |
      | 5e53831cc317d30017cb894f    |                            |
      |                             |                            |
      | 12345678901234567890        | 5e29912fbfec74a0272e9a92   |
      | 5e53831cc317d30017cb894f    | 12345678901234567890       |
#bug-  login as a seller/vendor/systemadmin ,user make a request for fetch row data details of product  with blank id field ,then it should be expected message as a "id is required." but in actual scenario it accepts the request , give response as true  and status ok
# bug-  login as a seller/vendor/systemadmin ,user make a request for fetch row data details of product  with invalid/wrong id field ,then it should be expected message as a "Invalid id provided." but in actual scenario it accepts the request ,give response as true and status ok
  # bug-  login as a seller/vendor/systemadmin ,user make a request for fetch row data details of product  with invalid/wrong userId field ,then it should be expected message as a "Invalid userId provided." but in actual scenario it gives the actual message as a "Cast to ObjectId failed for value \"12345678901234567890\" at path \"_id\" for model \"Users\""




  Scenario Outline:User make a request for product details with valid userid and id field by passing with Incorrect/blank token
    When user enters the Object id of product and Object id of user who is sending the request
      | id                            | userId                       |
      | 5e53831cc317d30017cb894f      | 5e2996260da2580011251edb     |
    When user make a request for product details with Incorrect/blank token field in form of without login credentials
      | token                      |
      | <token>                    |
    Then user should not be able to fetch details of desired product that he requested and user shuld get a validation message
      | Invalid token provided          |
      | Invalid token provided          |
    Examples:
      | token                           |
      |  sgshhshhshhshshhsh             |
      |                                 |