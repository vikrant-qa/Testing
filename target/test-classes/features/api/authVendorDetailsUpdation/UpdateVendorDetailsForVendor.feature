Feature: As a seller
         user wants to update their associated vendor fields

  Scenario Outline: Login with valid registered user details as a vendor and user make a request to update their associated vendor fields
    When User is able to log into application
      | email                                 | password     |
      | vikrant.singh@successive.tech         | 1234567890   |
    Then user should be able to login to the system and store token
    And user enters the details of vendor
      | sellerId       | vendorId      | brandName   |
      | <sellerId>     | <vendorId>    | <brandName> |
    Then user make a request to update the vendor field by way of click on submit button
    Then user should be able to update the vendor field that he requested
    Examples:
      | sellerId                         | vendorId                      | brandName                  |
      | 5e29912fbfec74a0272e9a92         | 5e29a688fd2be8001271fb99      | vikrant vendor trial1      |


  Scenario Outline: Login with valid registered user details as a vendor and user make a request to update their associated vendor fields without follow input field validation
    When User is able to log into application
      | email                                 | password     |
      | vikrant.singh@successive.tech         | 1234567890   |
    Then user should be able to login to the system and store token
    And user enters the details of vendor
      | sellerId       | vendorId      | brandName   |
      | <sellerId>     | <vendorId>    | <brandName> |
    Then user make a request to update the vendor field by way of click on submit button
    Then user should not be able to update the vendor field that he requested and user should get validation mesaage
      | SellerId is required.       |
      | VendorId is required.       |
      | SellerId is required.       |
      | Invalid SellerId provided.  |
      | Invalid VendorId provided.  |
    Examples:
      | sellerId                         | vendorId                      | brandName                  |
      |                                  | 5e29a688fd2be8001271fb99      | vikrant vendor trial1      |
      |  5e29912fbfec74a0272e9a92        |                               | vikrant vendor trial1      |
      |                                  |                               | vikrant vendor trial1      |
      | 12345678901234567890             |  5e29a688fd2be8001271fb99     | vikrant vendor trial1      |
      | 5e29912fbfec74a0272e9a92         |     12345678901234567890      | vikrant vendor trial1      |





  Scenario Outline: Login with valid registered user details as a seller and user make a request to update their associated vendor fields
    When User is able to log into application
      | email                                 | password     |
      | vikrant.singh@successive.tech         | HaiVikki12   |
    Then user should be able to login to the system and store token
    And user enters the details of vendor
      | sellerId       | vendorId      | brandName   |
      | <sellerId>     | <vendorId>    | <brandName> |
    Then user make a request to update the vendor field by way of click on submit button
    Then user should not be able to update the vendor field that he requested and user should get validation mesaage
      | User is not authorized to perform this action. |
    Examples:
      | sellerId                         | vendorId                      | brandName                  |
      | 5e29912fbfec74a0272e9a92         | 5e29a688fd2be8001271fb99      | vikrant vendor trial1      |
#Bug when login as a  seller or system admin ,user wants to update the details of vendor ,then it should be expected error message as a "User is not authorized to perform this action." but it gives actual error messages as a "errorHelper.invalidUser is not a function".

  Scenario Outline: Login with valid registered user details as a System Admin and user make a request to update vendor fields
    When User is able to log into application
      | email                                 | password     |
      | systemadmin@marketcube.io             | 12345678n@N  |
    Then user should be able to login to the system and store token
    And user enters the details of vendor
      | sellerId       | vendorId      | brandName   |
      | <sellerId>     | <vendorId>    | <brandName> |
    Then user make a request to update the vendor field by way of click on submit button
    Then user should not be able to update the vendor field that he requested and user should get validation mesaage
      | User is not authorized to perform this action. |
    Examples:
      | sellerId                         | vendorId                      | brandName                  |
      | 5e29912fbfec74a0272e9a92         | 5e29a688fd2be8001271fb99      | vikrant vendor trial1      |
#Bug when login as a  seller or system admin ,user wants to update the details of vendor ,then it should be expected error message as a "User is not authorized to perform this action." but it gives actual error messages as a "errorHelper.invalidUser is not a function".
