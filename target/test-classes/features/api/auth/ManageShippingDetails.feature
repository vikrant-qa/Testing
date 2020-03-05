Feature: API - Login as a registered user

  As a registered user
  I want to manage shipping details

  Scenario Outline: Login with valid registered user details and manage shipping details
    When User is able to log into application
    |email                     | password  |
    |mohit.agrawal@successive.tech | Mohit@1989 |
    Then user should be able to login to the system and store token
    When user enters manage shipping details
    | term | type | amount | isAllowAllVendor | vendorIds |
    | <term> | <type> | <amount> | <isAllowAllVendor> | <vendorIds> |
    | 2    | free | 1221   | true             | 5dcbfbe0e07320001a882d18|
    Then User should be able to manage shipping details successfully
    Examples:
      | term | type | amount | isAllowAllVendor | vendorIds |
      | 2    | free | 1221   | true             | 5dcbfbe0e07320001a882d18|

  Scenario Outline: Login with valid registered user details and validate error message for manage shipping details
    When User is able to log into application
      |email                     | password  |
      |mohit.agrawal@successive.tech | Mohit@1989 |
    Then user should be able to login to the system and store token
    When user enters manage shipping details
      | term | type | amount | isAllowAllVendor | vendorIds |
      | <term> | <type> | <amount> | <isAllowAllVendor> | <vendorIds> |
    Then User validates error messages for manage shipping details
      | Term is required. |
      | Type is required.  |
    Examples:
      | term | type | amount | isAllowAllVendor | vendorIds |
      |     | free | 1221   | true             | 5dcbfbe0e07320001a882d18|
      |  2   |  | 1221   | true             | 5dcbfbe0e07320001a882d18|