Feature: API- Product - Fetch list of products get  - /product

       Login as a registered user(System admin/seller/vendor)
       I want to fetch list of products

  Scenario: Login with valid registered user details as a seller and user request to fetch list of products
    When User is able to log into application
      | email                             | password     |
      | vikrant.singh@successive.tech     | HaiVikki12   |
    Then user should be able to login to the system and store token
    And user enters the requesterID for product list
      |  userId                     |
      |  5e29912fbfec74a0272e9a92   |
    And user make a request to fetch list of products
    Then User should be able to fetch product list that he requested

  Scenario: Login with valid registered user details as a vendor and user request to fetch list of products
    When User is able to log into application
      | email                             | password     |
      | vikrant.singh@successive.tech     | 1234567890   |
    Then user should be able to login to the system and store token
    And user enters the requesterID for product list
      |  userId                     |
      |  5e2996260da2580011251edb   |
    And user make a request to fetch list of products
    Then User should be able to fetch product list that he requested

  Scenario: Login with valid registered user details as a system admin and user request to fetch list of products
    When User is able to log into application
      | email                             | password     |
      | systemadmin@marketcube.io         | 12345678n@N  |
    Then user should be able to login to the system and store token
    And user enters the requesterID for product list
      |  userId                     |
      |  59c134d3c8efb4001a2bf1ad   |
    And user make a request to fetch list of products
    Then User should be able to fetch product list that system admin requested

  Scenario: Login with valid registered user details as a vendor that not associated with any seller and user make a request for  fetch products list
    When User is able to log into application
      | email                                | password     |
      | vikrant.singh+13@successive.tech     | 1234512345   |
    Then user should be able to login to the system and store token
    And user enters the requesterID for product list
      |  userId                     |
      |  5e3baa47df34800019a752d4   |
    And user make a request to fetch list of products
    Then User should be able to fetch product list that he requested


  Scenario Outline: Login with valid registered user details as a vendor and user make a request for  fetch product list without follow userId field validation
    When User is able to log into application
      | email                                | password     |
      | vikrant.singh@successive.tech        | 1234567890   |
    Then user should be able to login to the system and store token
    And user enters the requesterID for product list
      |  userId                     |
      |  <userId>                   |
    And user make a request to fetch list of products
    Then User should not be able to fetch products list that he requested and user should get validation message
      | UserId is required.   |
      | Invalid user provided |
      | Invalid user provided |
    Examples:
      |  userId                    |
      |                            |
      | 123456789123456789123456   |
      | 1234567                    |
#bug-- when login with as a user and user enters the requester userID with invalid data  for products list then it should be expected error message as a "Invalid user provided"  but in actual scenario it gives the actual error message as a ""Cast to ObjectId failed for value \"123456789\" at path \"_id\" for model \"Users\"""


  Scenario: Login with valid registered user details as a vendor and the user will not get any list of products by passing other vendorIds
    When User is able to log into application
      | email                                | password     |
      | vikrant.singh@successive.tech        | 1234567890   |
    Then user should be able to login to the system and store token
    And user enters the requesterID for product list
      |  userId                     |
      |  5ba08432171487000f09697a   |
    And user make a request to fetch list of products
    Then User should not be able to fetch products list that he requested and user should get validation message
      | Invalid user provided |

#bug-- when login with as a user and user enters the requester userID with any other person userId for products list then it should be expected error message as a "Invalid user provided"  but in actual scenario it accepts the response true and status ok


  Scenario: Login with valid registered user details as a seller and the user will not get any list of products by passing other vendorIds
    When User is able to log into application
      | email                                | password     |
      | vikrant.singh@successive.tech        | HaiVikki12   |
    Then user should be able to login to the system and store token
    And user enters the requesterID for product list
      |  userId                        |
      |  5b9fa03e7ef81d000f031b42      |
    And user make a request to fetch list of products
    Then User should not be able to fetch products list that he requested and user should get validation message
      | Invalid user provided |

#bug-- when login with as a user and user enters the requester userID with any other person userId for products list then it should be expected error message as a "Invalid user provided"  but in actual scenario it accepts the response true and status ok


  Scenario Outline:User make a request for list of oredr by passing with Incorrect/blank token data with valid userId
    And user enters the requesterID for product list
      |  userId                        |
      |  5b9fa03e7ef81d000f031b42      |
    When user make a request for list of products with Incorrect/blank token field in form of without login credentials
      | token                      |
      | <token>                    |
    Then User should not be able to fetch products list that he requested and user should get validation message
      | Invalid token provided          |
      | Invalid token provided          |
    Examples:
      | token                           |
      |  sgshhshhshhshshhsh             |
      |                                 |