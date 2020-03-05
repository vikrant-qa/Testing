Feature: API  for
        Auth -To remove payment details for seller/vendor

        Login as a seller
        user want to remove their payment details

        Login as a vendor
        user want to remove their payment details


  Scenario Outline: Login with valid registered user details as a seller and user wants to remove the payment details
    When User is able to log into application
      | email                             | password   |
      | vikrant.singh@successive.tech     |  HaiVikki12 |
    Then user should be able to login to the system and store token
    And user enter the payment method and request to remove the that payment method in form of clicking on disconnect button
      | paymentMethod   |
      | <paymentMethod> |
    Then user should be able to remove payment method successfully that he requested
    Examples:
      | paymentMethod |
      | stripe        |
      | paypal        |

  Scenario Outline: Login with valid registered user details as a seller and user wants to remove the payment details without follow input field validation
    When User is able to log into application
      | email                             | password    |
      | vikrant.singh@successive.tech     |  HaiVikki12 |
    Then user should be able to login to the system and store token
    And user enter the payment method and request to remove the that payment method in form of clicking on disconnect button
      | paymentMethod   |
      | <paymentMethod> |
    Then user should not be able to remove payment method that he requested and user should get a validation message as a
      | Invalid payment method provided |
      | Invalid payment method provided |
      | PaymentMethod is required.      |
    Examples:
      | paymentMethod |
      | stripluuuu    |
      | sdfsfsfsdf    |
      |               |
#Payment method is required not mention in docs




  Scenario Outline: Login with valid registered user details as a vendor and user wants to remove the payment details
    When User is able to log into application
      | email                             | password     |
      | vikrant.singh@successive.tech     |  1234567890  |
    Then user should be able to login to the system and store token
    And user enter the payment method and request to remove the that payment method in form of clicking on disconnect button
      | paymentMethod   |
      | <paymentMethod> |
    Then user should be able to remove payment method successfully that he requested
    Examples:
      | paymentMethod |
      | stripe        |
      | paypal        |



  Scenario Outline: Login with valid registered user details as a vendor and user wants to remove the payment details without follow input field validation
    When User is able to log into application
      | email                             | password    |
      | vikrant.singh@successive.tech     |  1234567890 |
    Then user should be able to login to the system and store token
    And user enter the payment method and request to remove the that payment method in form of clicking on disconnect button
      | paymentMethod   |
      | <paymentMethod> |
    Then user should not be able to remove payment method that he requested and user should get a validation message as a
      | Invalid payment method provided |
      | Invalid payment method provided |
      | PaymentMethod is required.      |
    Examples:
      | paymentMethod |
      | stripluuuu    |
      | sdfsfsfsdf    |
      |               |
#Payment method is required not mention in docs


  Scenario Outline: Login with valid registered user details as a system admin and user wants to remove the payment details
    When User is able to log into application
      | email                             | password     |
      | systemadmin@marketcube.io         | 123456789    |
    Then user should be able to login to the system and store token
    And user enter the payment method and request to remove the that payment method in form of clicking on disconnect button
      | paymentMethod   |
      | <paymentMethod> |
    Then user should not be able to remove payment method that he requested and user should get a validation message as a
      | User is not authorized to perform this action |
      | User is not authorized to perform this action |
    Examples:
      | paymentMethod |
      | stripe        |
      | paypal        |


  Scenario Outline:User make a request to remove payment method by passing with Incorrect/blank token data with valid payment method
    When user make a request to remove payment method with Incorrect/blank token field in form of without login credentials
      | token                      |
      | <token>                    |
    And user enter the payment method and request to remove the that payment method in form of clicking on disconnect button
      | paymentMethod   |
      | <paymentMethod> |
    Then user should not be able to remove payment method that he requested and user should get a validation message as a
      | Invalid token provided          |
      | Invalid token provided          |
    Examples:
      | token                           |
      |  sgshhshhshhshshhsh             |
      |                                 |
