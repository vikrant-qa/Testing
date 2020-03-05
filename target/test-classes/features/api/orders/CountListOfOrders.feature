Feature: API - Count list of orders

          As a registered user
          I want to Count list of orders

  Scenario Outline: Login with valid registered user details as a seller and user Count list of orders
    When User is able to log into application
      | email                                 | password       |
      | vikrant.singh@successive.tech         | HaiVikki12     |
    Then user should be able to login to the system and store token
    When User enters details to count of list orders
      | userId   | filter         |
      | <userId> | <filter>       |
    Then User should be able to count list of orders that he requested
    Examples:
      | userId                          | filter            |
      | 5e29912fbfec74a0272e9a92        | accepted          |
      | 5e29912fbfec74a0272e9a92        | pending           |
      | 5e29912fbfec74a0272e9a92        | closed            |
      | 5e29912fbfec74a0272e9a92        | rejected          |
      | 5e29912fbfec74a0272e9a92        | shipped           |

  Scenario Outline: Login with valid registered user details as a system admin and user Count list of orders
    When User is able to log into application
      | email                                 | password       |
      | systemadmin@marketcube.io             | 12345678n@N    |
    Then user should be able to login to the system and store token
    When User enters details to count of list orders
      | userId   | filter         |
      | <userId> | <filter>       |
    Then User should be able to count list of orders that he requested
    Examples:
      | userId                         | filter            |
      | 59c134d3c8efb4001a2bf1ad       | accepted          |
      | 59c134d3c8efb4001a2bf1ad       | pending           |
      | 59c134d3c8efb4001a2bf1ad       | closed            |
      | 59c134d3c8efb4001a2bf1ad       | rejected          |
      | 59c134d3c8efb4001a2bf1ad       | shipped           |

  Scenario Outline: Login with valid registered user details as a vendor and user Count list of orders
    When User is able to log into application
      | email                                 | password       |
      | vikrant.singh@successive.tech         | 1234567890     |
    Then user should be able to login to the system and store token
    When User enters details to count of list orders
      | userId   | filter         |
      | <userId> | <filter>       |
    Then User should be able to count list of orders that he requested
    Examples:
      | userId                         | filter             |
      | 5e4111fbdbf899001a5580ae       | accepted          |
      | 5e4111fbdbf899001a5580ae       | pending           |
      | 5e4111fbdbf899001a5580ae       | closed            |
      | 5e4111fbdbf899001a5580ae       | rejected          |
      | 5e4111fbdbf899001a5580ae       | shipped           |


  Scenario Outline: Login with valid registered user details as a seller and user make a request for Count list of orders without following userid field
    When User is able to log into application
      | email                                 | password       |
      | vikrant.singh@successive.tech         | HaiVikki12     |
    Then user should be able to login to the system and store token
    When User enters details to count of list orders
      | userId   | filter         |
      | <userId> | <filter>       |
    Then User should not be able to count list of orders that he requested
    Examples:
      | userId                          | filter            |
      |                                 | accepted          |
      |                                 | pending           |
      |                                 | closed            |
      |                                 | rejected          |
      |                                 | shipped           |
      | 12345678901234567890            | accepted          |
      | 12345678901234567890            | pending           |
      | 12345678901234567890            | closed            |
      | 12345678901234567890            | rejected          |
      | 12345678901234567890            | shipped           |
#Bug
#1- when login with seller or system admin or vendor#2- it count all the data on the basis of what type of token,we have after login 3- if we use user id field in postman and #4- then with blank or invalid user Id field #5-it  show the data and response true

  Scenario Outline:User make a request for count list of orders  by passing with Incorrect/blank token data
    When user passing the Incorrect/blank token data field in form of without login credentials
      | token                      |
      | <token>                    |
    When User enters details to count of list orders for token
      | userId                         | filter            |
      | 5e4111fbdbf899001a5580ae       | accepted          |
    Then User should not be able to count list of orders that he requested then user should get a  validation message for Incorrect/blank token
    Examples:
      | token                           |
      |  sgshhshhshhshshhsh             |
      |                                 |