Feature: As a seller
        user wants to update their associated vendor information fields

  Scenario Outline: Login with valid registered user details as a seller and user make a request to enable or disable user Brand information, Shipping information and Payment information fields
    When User is able to log into application
      | email                             | password    |
      | vikrant.singh@successive.tech     | HaiVikki12  |
    Then user should be able to login to the system and store token
    And user click enable or disable button to update for Brand information, Shipping information and Payment information fields
    | isShipping     | isBranding    | isPayment |
    | <isShipping>   | <isBranding>| <isPayment> |
    Then user make a request to update the vendor fields by way of click on submit button
    Then user should be able to update the vendor fields that he requested
    Examples:
      | isShipping   | isBranding| isPayment |
      | true         | true      | true      |
      | true         | true      | false     |
      | true         | false     | true      |
      | true         | false     | false     |
      | false        | true      | true      |
      | false        | true      | false     |
      | false        | false     | true      |
      | false        | false     | false     |


 Scenario Outline: Login with valid registered user details as a system admin and user make a request to enable or disable user Brand information, Shipping information and Payment information fields
    When User is able to log into application
      | email                             | password    |
      | systemadmin@marketcube.io         | 123456789   |
    Then user should be able to login to the system and store token
    And user click enable or disable button to update for Brand information, Shipping information and Payment information fields
      | isShipping     | isBranding    | isPayment |
      | <isShipping>   | <isBranding>| <isPayment> |
    Then user make a request to update the vendor fields by way of click on submit button
    Then user should not be able to update the vendor field the he requested and the user should get a verification error message
      | User is not authorized to perform this action. |
    Examples:
      | isShipping   | isBranding| isPayment |
      | true         | true      | true      |
      | true         | true      | false     |
      | true         | false     | true      |
      | true         | false     | false     |
      | false        | true      | true      |
      | false        | true      | false     |
      | false        | false     | true      |
      | false        | false     | false     |
#Bug-  login as a system admin and user request for update vendor fields, if user is system admin  then it should be expected message as a --""User is not authorized to perform this action."" ,But it is giving wrong messages as a ""errorHelper.invalidUser is not a function""


  Scenario Outline: Login with valid registered user details as a vendor and user make a request to enable or disable user Brand information, Shipping information and Payment information fields
    When User is able to log into application
      | email                                 | password     |
      | vikrant.singh@successive.tech         | 1234567890   |
    Then user should be able to login to the system and store token
    And user click enable or disable button to update for Brand information, Shipping information and Payment information fields
      | isShipping     | isBranding    | isPayment |
      | <isShipping>   | <isBranding>| <isPayment> |
    Then user make a request to update the vendor fields by way of click on submit button
    Then user should not be able to update the vendor field the he requested and the user should get a verification error message
      | User is not authorized to perform this action. |
    Examples:
      | isShipping   | isBranding| isPayment |
      | true         | true      | true      |
      | true         | true      | false     |
      | true         | false     | true      |
      | true         | false     | false     |
      | false        | true      | true      |
      | false        | true      | false     |
      | false        | false     | true      |
      | false        | false     | false     |
#Bug-  login as a vendor and user request for update vendor fields, if user is system admin  then it should be expected message as a --""User is not authorized to perform this action."" ,But it is giving wrong messages as a ""errorHelper.invalidUser is not a function""


  Scenario Outline: user wants to enable or disable user Brand information, Shipping information and Payment information fields with incorrect/blank token data <token>
    And user click enable or disable button to update for Brand information, Shipping information and Payment information fields
      | isShipping   | isBranding| isPayment |
      | true         | true      | true      |
    When user make a request to update the vendor fields with Incorrect or blank token field in form of without login credentials
      | token                      |
      | <token>                    |
    Then user should not be able to update the vendor field the he requested and the user should get a verification error message
      | Invalid token provided |
    Examples:
      | token                           |
      |  sgshhshhshhshshhsh             |
      |                                 |