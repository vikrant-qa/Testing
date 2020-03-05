Feature: Auth - Register Self Seller


     As a new user
     I want regsiter as a seller on marketcube
     So that I am able to access the platform and manage my shop and inventory

  Scenario: As a new user , seller request for registration directly on marketcube app as a new seller
    When New user enters the emaliId and password field for registration for seller
      | email    | password      |
      | user+    | 123456789     |
    And User make a request to get registered into the system for seller
    Then User should be registered successfully into the system for seller

  Scenario Outline: As a new user , seller request for registration directly on marketcube app as a new seller without follow any field validation
    When New user enters the emaliId and password field for registration for seller
      | email      | password        |
      | <email>    | <password>      |
    And User make a request to get registered into the system for seller
    Then The user will not be able to register on marketcube app for seller and the user should get a validation message
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

  Scenario: As a new user ,seller for registration  directly on marketcube app as a new seller with already registered email
    When seller enters the registered emaliId and password field for registration
      | email                                 | password       |
      | vikrant.singh@successive.tech         | HaiVikki12     |
    And User make a request to get registered into the system for seller
    Then The user will not be able to register on marketcube app for seller and the user should get a validation message
      | Already registered email.         |

  Scenario Outline: As a new user ,seller request for registration  directly on marketcube app as a new seller with incorrect/wrong email field
    When New user enters the emaliId and password field for seller registration
      | email      | password        |
      | <email>    | <password>      |
    And User make a request to get registered into the system for seller
    Then The user will not be able to register on marketcube app for seller and the user should get a validation message
      | Invalid email provided         |
      | Invalid email provided         |
    Examples:
      | email                             | password      |
      | systemadmin                       | 123456789     |
      | 12345678901222333                 | 123456789     |