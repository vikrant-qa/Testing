Feature: API - Register supplier as a user

  As a new user
  I want to regsiter a supplier on marketcube
  So that supplier is able to access the platform and manage my inventory

  Scenario: Register vendor on marketcube by seller
    When User is able to log into application
      |email                     | password  |
      |mohit.agrawal@successive.tech | Mohit@1989 |
    Then user should be able to login to the system and store token
    When user enter details of vendor
   | email | brandName | firstName | lastName | phoneNumber | address | city | country |  pinCode | isSystemAdmin | seller | isOtp | isVerified | isVendor | password |
   | mohit.agrawal | Testing | Mohit | Agrawal | 9898989898 | testing address | Noida | India | 201301 | false | 5dc93694b47bb36e90665083 | true | true | true | Mohit@1989 |
    Then Vendor should be registered successfully into the system

  Scenario Outline: Verify validation error message for Register vendor on marketcube
    When User is able to log into application
      |email                     | password  |
      |mohit.agrawal@successive.tech | Mohit@1989 |
    Then user should be able to login to the system and store token
    When user enter details of vendor
      | email | brandName | firstName | lastName | phoneNumber | address | city | country |  pinCode | isSystemAdmin | seller | isOtp | isVerified | isVendor | password |
      | <email> | <brandName> | <firstName> | <lastName> | <phoneNumber> | <address> | <city> | <country> | <pinCode> | <isSystemAdmin> | <seller> | <isOtp> | <isVerified> | <isVendor> | <password> |
    And enter error Message
      | message |
      | Email is required. |
      | IsVendor is required. |
      | Password is required. |
      | FirstName is required. |
      | LastName is required. |
      | PhoneNumber is required. |
      | BrandName is required. |
      | Address is required.   |
      | City is required.      |
      | Country is required.   |
      | Password should be minimum 8 characters long |
      | Invalid email provided                       |
    Then Vendor should not be registered successfully into the system
    Examples:
      | email | brandName | firstName | lastName | phoneNumber | address | city | country |  pinCode | isSystemAdmin | seller | isOtp | isVerified | isVendor | password |
      |  | Testing | Mohit | Agrawal | 9898989898 | testing address | Noida | India | 201301 | false | 5dc93694b47bb36e90665083 | true | true | true | Mohit@1989 |
      | dsfsdf | Testing | Mohit | Agrawal | 9898989898 | testing address | Noida | India | 201301 | false | 5dc93694b47bb36e90665083 | true | true |  | Mohit@1989 |
      | dsfsdf | Testing | Mohit | Agrawal | 9898989898 | testing address | Noida | India | 201301 | false | 5dc93694b47bb36e90665083 | true | true | true |  |
      | dsfsdf | Testing |   | Agrawal | 9898989898 | testing address | Noida | India | 201301 | false | 5dc93694b47bb36e90665083 | true | true | true | Mohit@1989 |
      | dsfsdf | Testing |  Mohit |  | 9898989898 | testing address | Noida | India | 201301 | false | 5dc93694b47bb36e90665083 | true | true | true | Mohit@1989 |
      | dsfsdf | Testing |  Mohit | agarwal |   | testing address | Noida | India | 201301 | false | 5dc93694b47bb36e90665083 | true | true | true | Mohit@1989 |
      | dsfsdf |   |  Mohit | agarwal |  2323233223 | testing address | Noida | India | 201301 | false | 5dc93694b47bb36e90665083 | true | true | true | Mohit@1989 |
      | dsfsdf |  test |  Mohit | agarwal |  2323233223 |   | Noida | India | 201301 | false | 5dc93694b47bb36e90665083 | true | true | true | Mohit@1989 |
      | dsfsdf |  test |  Mohit | agarwal |  2323233223 | testing address |   | India | 201301 | false | 5dc93694b47bb36e90665083 | true | true | true | Mohit@1989 |
      | dsfsdf |  test |  Mohit | agarwal |  2323233223 | testing address | Noida  |   | 201301 | false | 5dc93694b47bb36e90665083 | true | true | true | Mohit@1989 |
      | dsfsdf |  test |  Mohit | agarwal |  2323233223 | testing address |  Noida | India |   | false | 5dc93694b47bb36e90665083 | true | true | true | Mo89 |
      | invalid |  test |  Mohit | agarwal |  2323233223 | testing address |  Noida | India |   | false | 5dc93694b47bb36e90665083 | true | true | true | Mohit@1989 |

