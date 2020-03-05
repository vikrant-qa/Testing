Feature: API - Update markup of product

  As a registered user
  I want to update markup of producgt

  Scenario: Login with valid registered user details and update user setting successfully
    When User is able to log into application
    |email                     | password  |
    |mohit.agrawal@successive.tech | Mohit@1989 |
    Then user should be able to login to the system and store token
    When user enters details for user setting update
    | id | isAcceptOrder |
    |   5dc93694b47bb36e90665083     |   true   |
    Then User should be able to update user setting

  Scenario Outline: Login with valid registered user details and update user setting validation messages
    When User is able to log into application
      |email                     | password  |
      |mohit.agrawal@successive.tech | Mohit@1989 |
    Then user should be able to login to the system and store token
    When user enters details for user setting update
      | id | isAcceptOrder |
      |   <id>     |   <isAcceptOrder>   |
    Then User should not be able to update user setting
      |Id is required.|
      |IsAcceptOrder is required.|
    Examples:
      | id | isAcceptOrder |
      |        |   true   |
      |   5dc93694b47bb36e90665083     |     |