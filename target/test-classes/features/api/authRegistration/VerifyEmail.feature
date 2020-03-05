Feature: API - Register as a direct user

    As a new vendor
    I want to verify new registered Email id  on marketcube
    So that I am able to access the platform and manage my inventory

  Scenario: As a new user , vendor request for registration directly on marketcube app as a vendor and new registered Vendor verify their emailId
    When New user enters the emaliId and password field for registration
      | email    | password      |
      | user+    | 123456789     |
    And User make a request to get registered into the system
    Then User should be registered successfully into the system
    When new vendor confirms the token by clicking on a link that has been sent to its registered email
      |     token       |
      |                 |
    Then New Vendor should be registered successfully into the system and Vendor should get message as a Your Email is Verified Successfully.



  Scenario Outline: User verify their emailId without follow token field validation
    When new vendor enters the token to verify email
      |      token        |
      |     <token>       |
    Then vendor should not be able to register into the system and vendor should get a validation messages
      | Token is required.           |
      | Invalid token provided       |
      | User already verified.       |
    Examples:
      |     token                        |
      |                                  |
      |  12343444555555555               |
      |  e04cebcdca64cb1a2fd7bb473765ea2724ba77a8cb3a618027f2b65369a399e138c5bb4fb13565fd7e634b40be9a27510e190913198de40912f5c23e38712f21               |

