Feature: API - Login as a registered user

  As a registered user
  I want to change the commission for any user

  Scenario: Login with valid registered user details and change flat commission
    When User is able to log into application
    |email                     | password  |
    |mohit.agrawal@successive.tech | Mohit@1989 |
    Then user should be able to login to the system and store token
    When User make a request to change the commission of given user
    | commissionType     | commission  |
    |      flat          |      9      |
    Then User is able to successfully change the commission for the given user

  Scenario: Login with valid registered user details and change percentage commission
    When User is able to log into application
      |email                         | password   |
      |mohit.agrawal@successive.tech | Mohit@1989 |
    Then user should be able to login to the system and store token
    When User make a request to change the commission of given user
      | commissionType      | commission  |
      | percentage          |      2      |
    Then User is able to successfully change the commission for the given user

  Scenario: Login with valid registered user details and change percentage commission
    When User is able to log into application
      |email                     | password  |
      |mohit.agrawal@successive.tech | Mohit@1989 |
    Then user should be able to login to the system and store token
    When User make a request to change the commission of given user
      | commissionType | commission |
      |      percentage          |      2      |
    Then User is able to successfully change the commission for the given user

  Scenario: Login with valid registered user details and change flat commission with blank commision field
    When User is able to log into application
      |email                     | password  |
      |mohit.agrawal@successive.tech | Mohit@1989 |
    Then user should be able to login to the system and store token
    When User make a request to change the commission of given user
      | commissionType | commission |
      |      flat          |         |
    Then User is not able to successfully change the commission for the given user without commission

  Scenario: Login with valid registered user details and change flat commission with blank commision type
    When User is able to log into application
      |email                     | password  |
      |mohit.agrawal@successive.tech | Mohit@1989 |
    Then user should be able to login to the system and store token
    When User make a request to change the commission of given user
      | commissionType | commission |
      |                |    2     |
    Then User is not able to successfully change the commission for the given user without commission type