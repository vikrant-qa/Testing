Feature: API - Manage discount functionality for user

  As a registered user
  I want to manage discount for user

  Scenario: Login with valid registered user details and update product discount
    When User is able to log into application
    |email                     | password  |
    |mohit.agrawal@successive.tech | Mohit@1989 |
    Then user should be able to login to the system and store token
    When user enter details for discount
    |price|type|userId|ruleBy|
    |123|flat|123|sdf|
    And user enter advance values for discount
    |price|type|productId|vendorId|
    |1212|category|1231231231233|2342|
    Then user should be able to update discount settings for user