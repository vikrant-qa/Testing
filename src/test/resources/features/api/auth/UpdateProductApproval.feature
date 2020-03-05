Feature: API - user update product approval setting for user

  I want to update product approval setting for users.

  Scenario: Login with valid registered user details and update product approval settings successfully
    When User is able to log into application
    |email                     | password  |
    |mohit.agrawal@successive.tech | Mohit@1989 |
    Then user should be able to login to the system and store token
    Then user enter approval setting and submit request
    | reviewAll | approveSelected | approveAll | isProductSync |
    | true| true | true | true |
    Then user should be able to update approval settings for any seller or vendor
