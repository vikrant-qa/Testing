Feature: API - Order - id Fetch order data row
         Login as a seller
         user wants to get the one row data details of order

  Scenario: Login with valid registered user details as System Admin and user make a request for fetch row data details of order
    When User is able to log into application
      | email                                 | password       |
      | systemadmin@marketcube.io             | 12345678n@N    |
    Then user should be able to login to the system and store token
    When user enters the Object id of order and Object id of user who is sending the request
      | id                          | userId                     |
      | 5e31965d2675670016629bac    | 59c134d3c8efb4001a2bf1ad   |
    And user make a request to fetch one row details of desired order
    Then user should be able to fetch one row details of desired order


  Scenario: Login with valid registered user details as Seller and user make a request for fetch row data details of order
    When User is able to log into application
      | email                                 | password       |
      | vikrant.singh@successive.tech         | HaiVikki12     |
    Then user should be able to login to the system and store token
    When user enters the Object id of order and Object id of user who is sending the request
      | id                          | userId                     |
      | 5e31965d2675670016629bac    | 5e29912fbfec74a0272e9a92   |
    And user make a request to fetch one row details of desired order
    Then user should be able to fetch one row details of desired order


  Scenario: Login with valid registered user details as a Seller and user make a request for fetch row data details of order with the use of system Admin userID
    When User is able to log into application
      | email                                 | password       |
      | vikrant.singh@successive.tech         | HaiVikki12     |
    Then user should be able to login to the system and store token
    When user enters the Object id of order and Object id of user who is sending the request
      | id                          | userId                     |
      | 5e31965d2675670016629bac    | 59c134d3c8efb4001a2bf1ad   |
    And user make a request to fetch one row details of desired order
    Then user should not be able to fetch one row details of desired order that he requested and user shuld get a validation message
      | Invalid userId provided.           |
 #use other token and use other userid to get details of order data row.


 #for vendor we  use orderLines object id as a id instead of objectid of orders  that we find from orderLines table
# and use oredrs table and orderLines table
# object id of oredrs table use  as  "orderId": "5e53831cc317d30017cb894f" in orderLines table.
  Scenario: Login with valid registered user details as vendor and user make a request for fetch row data details of order
    When User is able to log into application
      | email                                 | password       |
      | vikrant.singh@successive.tech         | 1234567890     |
    Then user should be able to login to the system and store token
    When user enters the Object id of order and Object id of user who is sending the request
      | id                          | userId                     |
      | 5e31965d2675670016629bad    | 5e2996260da2580011251edb   |
    And user make a request to fetch one row details of desired order
    Then user should be able to fetch one row details of desired order




  Scenario Outline: Login with valid registered user details as a vendor and user make a request for fetch row data details of order without follow input field validation
    When User is able to log into application
      | email                                 | password       |
      | vikrant.singh@successive.tech         | 1234567890     |
    Then user should be able to login to the system and store token
    When user enters the Object id of order and Object id of user who is sending the request
      | id                            | userId                       |
      | <id>                          | <userId>                     |
    And user make a request to fetch one row details of desired order
    Then user should not be able to fetch one row details of desired order that he requested and user shuld get a validation message
      | id is required.                    |
      | UserId is required.                |
      | UserId is required.                |
      | Invalid id provided.               |
      | Invalid userId provided.           |
    Examples:
      | id                          | userId                     |
      |                             | 5e2996260da2580011251edb   |
      | 5e31965d2675670016629bad    |                            |
      |                             |                            |
      | 12345678901234567890        | 5e2996260da2580011251edb   |
      | 5e31965d2675670016629bad    | 12345678901234567890       |
#bug-  login as a seller/vendor/systemadmin ,user make a request for fetch row data details of order  with blank id field ,then it should be expected message as a "id is required." but in actual scenario it accepts the request , give response as true  and status ok
# bug-  login as a seller/vendor/systemadmin ,user make a request for fetch row data details of order  with invalid/wrong id field ,then it should be expected message as a "Invalid id provided." but in actual scenario it accepts the request ,give response as true and status ok
  # bug-  login as a seller/vendor/systemadmin ,user make a request for fetch row data details of order  with invalid/wrong userId field ,then it should be expected message as a "Invalid userId provided." but in actual scenario it gives the actual message as a "Cast to ObjectId failed for value \"12345678901234567890\" at path \"_id\" for model \"Users\""


  Scenario Outline: Login with valid registered user details as a seller and user make a request for fetch row data details of order without follow input field validation
    When User is able to log into application
      | email                                 | password       |
      | vikrant.singh@successive.tech         | HaiVikki12     |
    Then user should be able to login to the system and store token
    When user enters the Object id of order and Object id of user who is sending the request
      | id                            | userId                       |
      | <id>                          | <userId>                     |
    And user make a request to fetch one row details of desired order
    Then user should not be able to fetch one row details of desired order that he requested and user shuld get a validation message
      | id is required.                    |
      | UserId is required.                |
      | UserId is required.                |
      | Invalid id provided.               |
      | Invalid userId provided.           |
    Examples:
      | id                          | userId                     |
      |                             | 5e2996260da2580011251edb   |
      | 5e31965d2675670016629bac    |                            |
      |                             |                            |
      | 12345678901234567890        | 5e2996260da2580011251edb   |
      | 5e31965d2675670016629bac    | 12345678901234567890       |
#bug-  login as a seller/vendor/systemadmin ,user make a request for fetch row data details of order  with blank id field ,then it should be expected message as a "id is required." but in actual scenario it accepts the request , give response as true  and status ok
# bug-  login as a seller/vendor/systemadmin ,user make a request for fetch row data details of order  with invalid/wrong id field ,then it should be expected message as a "Invalid id provided." but in actual scenario it accepts the request ,give response as true and status ok
  # bug-  login as a seller/vendor/systemadmin ,user make a request for fetch row data details of order  with invalid/wrong userId field ,then it should be expected message as a "Invalid userId provided." but in actual scenario it gives the actual message as a "Cast to ObjectId failed for value \"12345678901234567890\" at path \"_id\" for model \"Users\""


  Scenario Outline: Login with valid registered user details as a system admin and user make a request for fetch row data details of order without follow input field validation
    When User is able to log into application
      | email                                 | password       |
      | systemadmin@marketcube.io             | 12345678n@N    |
    Then user should be able to login to the system and store token
    When user enters the Object id of order and Object id of user who is sending the request
      | id                            | userId                       |
      | <id>                          | <userId>                     |
    And user make a request to fetch one row details of desired order
    Then user should not be able to fetch one row details of desired order that he requested and user shuld get a validation message
      | id is required.                    |
      | UserId is required.                |
      | UserId is required.                |
      | Invalid id provided.               |
      | Invalid userId provided.           |
    Examples:
      | id                          | userId                     |
      |                             | 5e2996260da2580011251edb   |
      | 5e31965d2675670016629bac    |                            |
      |                             |                            |
      | 12345678901234567890        | 5e2996260da2580011251edb   |
      | 5e31965d2675670016629bac    | 12345678901234567890       |
#bug-  login as a seller/vendor/systemadmin ,user make a request for fetch row data details of order  with blank id field ,then it should be expected message as a "id is required." but in actual scenario it accepts the request , give response as true  and status ok
# bug-  login as a seller/vendor/systemadmin ,user make a request for fetch row data details of order  with invalid/wrong id field ,then it should be expected message as a "Invalid id provided." but in actual scenario it accepts the request ,give response as true and status ok
  # bug-  login as a seller/vendor/systemadmin ,user make a request for fetch row data details of order  with invalid/wrong userId field ,then it should be expected message as a "Invalid userId provided." but in actual scenario it gives the actual message as a "Cast to ObjectId failed for value \"12345678901234567890\" at path \"_id\" for model \"Users\""


  Scenario Outline:User make a request for order details by passing with Incorrect/blank token data with valid userId
    When user enters the Object id of order and Object id of user who is sending the request
      | id                            | userId                       |
      | 5e31965d2675670016629bac      | 5e29912fbfec74a0272e9a92     |
    When user make a request for order details with Incorrect/blank token field in form of without login credentials
      | token                      |
      | <token>                    |
    Then user should not be able to fetch one row details of desired order that he requested and user shuld get a validation message
      | Invalid token provided          |
      | Invalid token provided          |
    Examples:
      | token                           |
      |  sgshhshhshhshshhsh             |
      |                                 |

