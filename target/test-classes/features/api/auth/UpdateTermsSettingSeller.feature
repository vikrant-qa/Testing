Feature: API - Login as a registered user

  As a registered user
  I want to update terms setting for seller

  Scenario Outline: Login with valid registered user details and change terms setting for seller for different payment terms
    When User is able to log into application
    |email                         | password   |
    |mohit.agrawal@successive.tech | Mohit@1989 |
    Then user should be able to login to the system and store token
    When User make a request to change the terms settings by entering return type and return period
      | isReturn       | returnPeriod          |
      | <isReturn>     | <returnPeriod>        |
    And user enters payment terms
      | days      | type   |
      |  <days>   | <type> |
    Then User is able to successfully change the terms settings for seller
    Examples:
      |    isReturn    | returnPeriod   |  days |   type               |
      |    return      |     10         |   2   |   postFulfilment     |
      |    return      |     10         |   2   |   preFulfilment      |
      |    return      |     10         |   2   |   postReturnExpiry   |

  Scenario: Login with valid registered user details and change terms setting for seller when product return is not available
    When User is able to log into application
      |email                         | password       |
      |mohit.agrawal@successive.tech | Mohit@1989     |
    Then user should be able to login to the system and store token
    When User make a request to change the terms settings by entering return type and return period
      | isReturn     | returnPeriod |
      | noReturn     | 10           |
    And user enters payment terms
      | days | type           |
      |  2   | postFulfilment |
    Then User is able to successfully change the terms settings for seller

  Scenario: Login with valid registered user details and change terms setting for seller when type left blank
    When User is able to log into application
      |email                         | password   |
      |mohit.agrawal@successive.tech | Mohit@1989 |
    Then user should be able to login to the system and store token
    When User make a request to change the terms settings by entering return type and return period
      | isReturn   | returnPeriod |
      | return     | 10        |
    And user enters payment terms
      | days   | type |
      |  2     |      |
    Then User is not able to change the terms and get validation error message for type

  Scenario: Login with valid registered user details and change terms setting for seller when returnPeriod left blank
    When User is able to log into application
      |email                     | password  |
      |mohit.agrawal@successive.tech | Mohit@1989 |
    Then user should be able to login to the system and store token
    When User make a request to change the terms settings by entering return type and return period
      | isReturn   | returnPeriod |
      | return     |              |
    And user enters payment terms
      | days | type           |
      |  2   | postFulfilment |
    Then User is not able to change the terms and get validation error message for returnPeriod