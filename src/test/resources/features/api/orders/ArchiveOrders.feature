Feature: API - Count list of orders

  As a registered user
  I want to Count list of orders

  Scenario: Login with valid registered user details and Count list of orders
    When User is able to log into application
      |email                         | password   |
      |mohit.agrawal@successive.tech | Mohit@1989 |
    Then user should be able to login to the system and store token
    When User enters details of seller to proceed with archive
      |   sellerId                    |   vendorId                     |
      |   5dc93694b47bb36e90665083    |   5dcbfbe0e07320001a882d18     |
    Then User should be able to archive all order of given seller