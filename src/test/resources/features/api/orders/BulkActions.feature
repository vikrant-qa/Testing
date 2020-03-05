Feature: API - Bulk Action like paid, dispute status update.

  As a registered user
  I want to update bulk actions

  Scenario: Login with valid registered user details and do bulk actions
    When User is able to log into application
    |email                     | password  |
    |mohit.agrawal@successive.tech | Mohit@1989 |
    Then user should be able to login to the system and store token
    When user enters line item id
    |5b5f0f7e7ff7bf000f3d9207|
    And user enters details of order line items
    |key | sellerId | isSystemAdmin |
    |   dispute   | 5b5eff5d12e77f58be159e50 | true|
    Then User should be able to perform bulk actions