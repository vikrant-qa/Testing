Feature: Order - Fetch list of orders - get -  /order

        Login as a registered user(System admin/seller/vendor)
        I want to fetch list of orders

  Scenario: Login with valid registered user details as  System admin and user make a request for  fetch order list
    When User is able to log into application
      | email                         | password     |
      | systemadmin@marketcube.io     | 12345678n@N  |
    Then user should be able to login to the system and store token
    And user enters the requesterID for order list
      |  userId                     |
      |  59c134d3c8efb4001a2bf1ad   |
    And user make a request to fetch list of orders
    Then User should be able to fetch order list that he requested


  Scenario: Login with valid registered user details as a seller and user make a request for  fetch order list
    When User is able to log into application
      | email                             | password     |
      | vikrant.singh@successive.tech     | HaiVikki12   |
    Then user should be able to login to the system and store token
    And user enters the requesterID for order list
      |  userId                     |
      |  5e29912fbfec74a0272e9a92   |
    And user make a request to fetch list of orders
    Then User should be able to fetch order list that he requested


  Scenario: Login with valid registered user details as a vendor and user make a request for  fetch order list
    When User is able to log into application
      | email                                | password     |
      | vikrant.singh@successive.tech        | 1234567890   |
    Then user should be able to login to the system and store token
    And user enters the requesterID for order list
      |  userId                     |
      |  5e2996260da2580011251edb   |
    And user make a request to fetch list of orders
    Then User should be able to fetch order list that he requested


  Scenario: Login with valid registered user details as a vendor that not associated with any seller and user make a request for  fetch order list
    When User is able to log into application
      | email                                | password     |
      | vikrant.singh+13@successive.tech     | 1234512345   |
    Then user should be able to login to the system and store token
    And user enters the requesterID for order list
      |  userId                     |
      |  5e3baa47df34800019a752d4   |
    And user make a request to fetch list of orders
    Then User should be able to fetch order list that he requested


  Scenario Outline: Login with valid registered user details as a vendor and user make a request for  fetch order list without follow userId field validation
    When User is able to log into application
      | email                                | password     |
      | vikrant.singh@successive.tech        | 1234567890   |
    Then user should be able to login to the system and store token
    And user enters the requesterID for order list
      |  userId                     |
      |  <userId>                   |
    And user make a request to fetch list of orders
    Then User should not be able to fetch order list that he requested and user should get validation message
      | UserId is required.   |
      | Invalid user provided |
      | Invalid user provided |
    Examples:
      |  userId                    |
      |                            |
      | 123456789123456789123456   |
      | 1234567                    |
#bug-- when login with as a user and user enters the requester userID with invalid data  for order list then it should be expected error message as a "Invalid user provided"  but in actual scenario it gives the actual error message as a ""Cast to ObjectId failed for value \"123456789\" at path \"_id\" for model \"Users\"""



  Scenario: Login with valid registered user details as a vendor and the user will not get any list of orders by passing other vendorIds
    When User is able to log into application
      | email                                | password     |
      | vikrant.singh@successive.tech        | 1234567890   |
    Then user should be able to login to the system and store token
    And user enters the requesterID for order list
      |  userId                     |
      |  5ba08432171487000f09697a   |
    And user make a request to fetch list of orders
    Then User should not be able to fetch order list that he requested and user should get validation message
      | Invalid user provided |

#bug-- when login with as a user and user enters the requester userID with any other person userId for order list then it should be expected error message as a "Invalid user provided"  but in actual scenario it accepts the response true and status ok


  Scenario: Login with valid registered user details as a seller and the user will not get any list of orders by passing other vendorIds
    When User is able to log into application
      | email                                | password     |
      | vikrant.singh@successive.tech        | HaiVikki12   |
    Then user should be able to login to the system and store token
    And user enters the requesterID for order list
      |  userId                        |
      |  5b9fa03e7ef81d000f031b42      |
    And user make a request to fetch list of orders
    Then User should not be able to fetch order list that he requested and user should get validation message
      | Invalid user provided |

#bug-- when login with as a user and user enters the requester userID with any other person userId for order list then it should be expected error message as a "Invalid user provided"  but in actual scenario it accepts the response true and status ok

  Scenario Outline:User make a request for list of order by passing with Incorrect/blank token data with valid userId
    And user enters the requesterID for order list
      |  userId                        |
      |  5b9fa03e7ef81d000f031b42      |
    When user make a request for list of orders with Incorrect/blank token field in form of without login credentials
      | token                      |
      | <token>                    |
    Then User should not be able to fetch order list that he requested and user should get validation message
      | Invalid token provided          |
      | Invalid token provided          |
    Examples:
      | token                           |
      |  sgshhshhshhshshhsh             |
      |                                 |




#  by Mohit sir

  Scenario: Login with valid registered user details as  System admin and user request fetch order
    When User is able to log into application
      | email                         | password   |
      | systemadmin@marketcube.io     | 123456789  |
    Then user should be able to login to the system and store token
    When user enters search filter
      | searchFilter|
      | status     |
    And User enters details of order to be fetched
      | userId                    | sortName          | sortOrder | perPage | page | filter  | search | searchFilter |
      | 5dc93694b47bb36e90665083  | vendor            | asc       | 10      | skip | pending | 1      | status       |
    Then User should be able to fetch order

  Scenario: Login with valid registered user details and validate fetch order errors
    When User is able to log into application
      | email                         | password  |
      | mohit.agrawal@successive.tech | Mohit@1989 |
    Then user should be able to login to the system and store token
    When user enters search filter
      | searchFilter |
      | status       |
    And User enters details of order to be fetched
      | userId | sortName | sortOrder | perPage | page | filter   | search | searchFilter |
      |        | vendor   | asc       | 10      | skip | pending  | 1      | status       |
    Then User should be able to validate fetch order validation messages
      |UserId is required.|