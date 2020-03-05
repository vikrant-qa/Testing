Feature: API - Login as a registered user

  As a registered user
  I want to create fulfillment.

  Scenario Outline: Login with valid registered user details and create fulfillment for seller
    When User is able to log into application
      |email                         | password     |
      |mohit.agrawal@successive.tech | Mohit@1989   |
    Then user should be able to login to the system and store token
    When User enter details  for  create fulfillment for seller
      | id   | sellerId   | shopifyOrderId   | fulfillments   |
      | <id> | <sellerId> | <shopifyOrderId> | <fulfillments> |
    Then User should be able to create fulfillment successfully for seller
    Examples:
      | id | sellerId | shopifyOrderId | fulfillments |
      |5dede7f0eca5720018c181df|5dc93694b47bb36e90665083|1001| |