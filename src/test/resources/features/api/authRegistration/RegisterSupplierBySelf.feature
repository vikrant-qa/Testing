Feature: Auth - Register Supplier by Self

      As a new user
     I want regsiter as a vendor on marketcube
     So that I am able to access the platform and manage my inventory

  Scenario: As a new user , vendor request for registration directly on marketcube app as a vendor
    When New user enters the emaliId and password field for registration
      | email    | password      |
      | user+    | 123456789     |
    And User make a request to get registered into the system
    Then User should be registered successfully into the system


  Scenario Outline: As a new user , vendor request for registration directly on marketcube app as a vendor without follow any field validation
    When New user enters the emaliId and password field for registration
      | email      | password        |
      | <email>    | <password>      |
    And User make a request to get registered into the system
    Then The user will not be able to register on marketcube app and the user should get a validation message
      | Email is required.                             |
      | Password is required.                          |
      | Email is required.                             |
      | Password should be minimum 8 characters long   |
    Examples:
      | email       | password      |
      |             | 123456789     |
      | user+       |               |
      |             |               |
      | user+       | 1234567       |


  Scenario: As a new user ,vendor request for registration  directly on marketcube app as a vendor with already registered email
    When new user enters the registered emaliId and password field for registration
      | email                                 | password      |
      | vikrant.singh@successive.tech         | 123456789     |
    And User make a request to get register into the system
    Then The user will not be able to register on marketcube app and the user should get a validation message
      | Already registered email.         |


  Scenario Outline: As a new user ,vendor request for registration  directly on marketcube app as a vendor with incorrect/wrong email field
    When user enters the emaliId and password field for registration
      | email                               | password        |
      | <email>                             | <password>      |
    And User make a request to get register into the system
    Then The user will not be able to register on marketcube app and the user should get a validation message
      | Invalid email provided         |
      | Invalid email provided         |
    Examples:
      | email                             | password      |
      | systemadmin                       | 123456789     |
      | 12345678901222333                 | 123456789     |





