Feature:

         As a system admin
         user wants to view list of seller and list of vendor
         and
         As a seller-
         user wants to fetch their associated list of vendor

  Scenario:Login with valid registered user details as a system admin and user gets the list of seller
    When User is able to log into application
      | email                         | password   |
      | systemadmin@marketcube.io     | 123456789  |
    Then user should be able to login to the system and store token
    And user enter the requesterID and userType
      |  userId                     |    userType     |
      |  59c134d3c8efb4001a2bf1ad   |    seller       |
    And user make a request to fetch list of seller
    Then user should be able to gets all list of seller that he requested


  Scenario Outline:Login with valid registered user details as a system admin and user request for list of seller without follow Userid field and Usertype field validation
    When User is able to log into application
      | email                         | password   |
      | systemadmin@marketcube.io     | 123456789  |
    Then user should be able to login to the system and store token
    And user enter the requesterID and userType
      |  userId                     |    userType       |
      |  <userId>                   |    <userType>     |
    And user make a request to fetch list of seller
    Then user should not be able to gets any list of seller that he requested and user should get validation messages
      | UserType is required.                      |
      | UserId is required.                        |
      | Invalid type provided                      |
      | Invalid userId provided.                   |
      | UserId is required.                        |
    Examples:
      |  userId                       |    userType        |
      |  59c134d3c8efb4001a2bf1ad     |                    |
      |                               |    seller          |
      |  59c134d3c8efb4001a2bf1ad     |    sellersdhsjjsj  |
      |  59c134d3c8efb4001a2bf1adww   |    seller          |
      |                               |                    |
# bug --login with system admin and user request for list of seller ,when we enter invalid user id then it should be expected message as a --"Invalid userId provided." ,But it is giving wrong messages as a "Cast to ObjectId failed for value \"59c134d3c8efb4001a2bf1adww\" at path \"_id\" for model \"Users\"


  Scenario:Login with valid registered user details as a system admin and user gets the list of vendor
    When User is able to log into application
      | email                         | password   |
      | systemadmin@marketcube.io     | 123456789  |
    Then user should be able to login to the system and store token
    And user enter the requesterID and userType
      |  userId                     |    userType     |
      |  59c134d3c8efb4001a2bf1ad   |    supplier     |
    And user make a request to fetch list of vendor
    Then user should be able to gets all list of vendor that he requested


  Scenario Outline:Login with valid registered user details as a system admin and user request for list of vendor without follow Userid field and Usertype field validation
    When User is able to log into application
      | email                         | password   |
      | systemadmin@marketcube.io     | 123456789  |
    Then user should be able to login to the system and store token
    And user enter the requesterID and userType
      |  userId                       |    userType       |
      |  <userId>                     |    <userType>     |
    And user make a request to fetch list of vendor
    Then user should not be able to gets any list of vendor that he requested and user should get validation messages
      | UserType is required.                      |
      | UserId is required.                        |
      | Invalid type provided                      |
      | Invalid userId provided.                   |
      | UserId is required.                        |
    Examples:
      |  userId                       |    userType          |
      |  59c134d3c8efb4001a2bf1ad     |                      |
      |                               |    supplier          |
      |  59c134d3c8efb4001a2bf1ad     |    suppliersdhsjjsj  |
      |  59c134d3c8efb4001a2bf1adww   |    supplier          |
      |                               |                      |
# bug --login with system admin and user request for list of vendor ,when we enter invalid user id then it should be expected message as a --"Invalid userId provided." ,But it is giving wrong messages as a "Cast to ObjectId failed for value \"59c134d3c8efb4001a2bf1adww\" at path \"_id\" for model \"Users\"


  Scenario:Login with valid registered user details as a seller and user gets the list of their associated vendor
    When User is able to log into application
      | email                             | password    |
      | vikrant.singh@successive.tech     | HaiVikki12  |
    Then user should be able to login to the system and store token
    And user enter the requesterID and userType
      |  userId                     |    userType     |
      |  5e29912fbfec74a0272e9a92   |    supplier     |
    And user make a request to fetch list of vendor
    Then user should be able to gets all list of vendor that he requested


  Scenario Outline:Login with valid registered user details as a seller and user request for list of vendor without follow Userid field and Usertype field validation
    When User is able to log into application
      | email                             | password    |
      | vikrant.singh@successive.tech     | HaiVikki12  |
    Then user should be able to login to the system and store token
    And user enter the requesterID and userType
      |  userId                       |    userType       |
      |  <userId>                     |    <userType>     |
    And user make a request to fetch list of vendor
    Then user should not be able to gets any list of vendor that he requested and user should get validation messages
      | UserType is required.                      |
      | UserId is required.                        |
      | Invalid type provided                      |
      | Invalid userId provided.                   |
      | UserId is required.                        |
    Examples:
      |  userId                       |    userType          |
      |  59c134d3c8efb4001a2bf1ad     |                      |
      |                               |    supplier          |
      |  59c134d3c8efb4001a2bf1ad     |    suppliersdhsjjsj  |
      |  59c134d3c8efb4001a2bf1adww   |    supplier          |
      |                               |                      |
# bug --login with seller and user request for list of vendor ,when we enter invalid user id then it should be expected message as a --"Invalid userId provided." ,But it is giving wrong messages as a "Cast to ObjectId failed for value \"59c134d3c8efb4001a2bf1adww\" at path \"_id\" for model \"Users\"


  Scenario:Login with valid registered user details as a vendor and user request for list of vendor with own userID
    When User is able to log into application
      | email                             | password    |
      | vikrant.singh@successive.tech     | 1234567890  |
    Then user should be able to login to the system and store token
    And user enter the requesterID and userType
      |  userId                       |    userType       |
      |  5e2996260da2580011251edb     |    supplier       |
    And user make a request to fetch list of vendor
    Then so user as a vendor should not be able to gets any list of vendor or seller that he requested and user should get validation message
      | Invalid user provided      |


  Scenario:Login with valid registered user details as a vendor and user request for list of seller with own userID
    When User is able to log into application
      | email                             | password    |
      | vikrant.singh@successive.tech     | 1234567890  |
    Then user should be able to login to the system and store token
    And user enter the requesterID and userType
      |  userId                       |    userType       |
      |  5e2996260da2580011251edb      |    seller        |
    And user make a request to fetch list of seller
    Then so user as a vendor should not be able to gets any list of vendor or seller that he requested and user should get validation message
      | Invalid user provided      |




  Scenario Outline:Login with valid registered user details as a vendor and user use vendor tokens to request list of vendor or seller with System-Admin userID
    When User is able to log into application
      | email                             | password    |
      | vikrant.singh@successive.tech     | 1234567890  |
    Then user should be able to login to the system and store token
    And user enter the requesterID and userType
      |  userId                       |    userType       |
      |  <userId>                     |    <userType>     |
    And user make a request to fetch list of vendor
    Then so user as a vendor should not be able to gets any list of vendor or seller that he requested and user should get validation message
      | Invalid user provided      |
      | Invalid user provided      |
    Examples:
      |  userId                     |    userType     |
      |  59c134d3c8efb4001a2bf1ad   |    supplier     |
      |  59c134d3c8efb4001a2bf1ad   |    seller       |
#Bug Login user as a vendor  and user use vendor tokens to request list of vendor or seller with System-Admin userID ,it should be expected message as a --"Invalid user provided." ,But it give response as a  true and show all the details of seller and vendor ,


  Scenario Outline:Login with valid registered user details as a vendor and user use vendor tokens to request list of vendor or seller with seller userID
    When User is able to log into application
      | email                             | password    |
      | vikrant.singh@successive.tech     | 1234567890  |
    Then user should be able to login to the system and store token
    And user enter the requesterID and userType
      |  userId                       |    userType       |
      |  <userId>                     |    <userType>     |
    And user make a request to fetch list of vendor
    Then so user as a vendor should not be able to gets any list of vendor or seller that he requested and user should get validation message
      | Invalid user provided      |
      | Invalid user provided      |
    Examples:
      |  userId                     |    userType     |
      |  5e29912fbfec74a0272e9a92   |    supplier     |
      |  5e29912fbfec74a0272e9a92   |    seller       |
#Bug Login user as a vendor  and user use vendor tokens to request list of vendor with seller userID ,it should be expected message as a --"Invalid user provided." ,But it give response as a  true and show all the details of vendor ,
#Bug Login user as a vendor  and user use vendor tokens to request list of seller with seller userID ,it should be expected message as a --"Invalid user provided." ,But it giving a wrong response as a  "Invalid type provided" ,



  Scenario Outline:User make a request for list of seller or vendor by passing with Incorrect/blank token data with valid userID and userType
    And user enter the requesterID and userType
      |  userId                     |    userType     |
      |  5e29912fbfec74a0272e9a92   |    supplier     |
    When user make a request for list of seller or vendor with Incorrect/blank token field in form of without login credentials
      | token                      |
      | <token>                    |
    Then user should not be able to gets any list of vendor or seller that he requested then user should get a  validation message for Incorrect/blank token
      | Invalid token provided          |
    Examples:
      | token                           |
      |  sgshhshhshhshshhsh             |
      |                                 |



  Scenario Outline: Login as a seller with valid registered user details and the user will not get any list of vendor if there is no association between the user and required vendor by passing their vendorID
    When User is able to log into application
      | email                                | password    |
      | vikrant.singh@successive.tech        | HaiVikki12  |
    Then user should be able to login to the system and store token
    And user enter the requesterID and userType
      |  userId                     |    userType     |
      |  <userId>                   |    <userType>   |
    And user make a request to fetch list of vendor
    Then user should not be able to gets any list of vendor that he requested and user should get validation messages
      |    Invalid user provided    |
      |    Invalid user provided    |
    Examples:
      |  userId                     |    userType     |
      |  5ba08432171487000f09697a   |    supplier     |
      |  5b9fa03e7ef81d000f031b42   |    supplier     |


  Scenario Outline: Login as a seller with valid registered user details and the user will not get any list of other seller by passing other sellerIDs
    When User is able to log into application
      | email                                | password    |
      | vikrant.singh@successive.tech        | HaiVikki12  |
    Then user should be able to login to the system and store token
    And user enter the requesterID and userType
      |  userId                     |    userType     |
      |  <userId>                   |    <userType>   |
    And user make a request to fetch list of seller
    Then user should not be able to gets any list of vendor that he requested and user should get validation messages
      |    Invalid type provided    |
      |    Invalid type provided    |
    Examples:
      |  userId                     |    userType     |
      |  5b9f445dfd448f5db406086d   |    seller       |
      |  5ba0ae70fd448f5db41d272b   |    seller       |


  Scenario: Login as a seller with valid registered user details and the user will not get any vendor list if that user is not associated with any vendor(seller have no vendor case)
    When User is able to log into application
      | email                                   | password    |
      | vikrant.singh+60@successive.tech        | 123456789   |
    Then user should be able to login to the system and store token
    And user enter the requesterID and userType
      |  userId                     |    userType     |
      |  5e467ab03dcebee6ad14a23f   |    supplier     |
    And user make a request to fetch list of seller
    Then user should not be able to gets any list of vendor that he requested and user should get validation messages
      |  Invalid data provided    |


  Scenario Outline: Login as a vendor with valid registered user details and the user will not get any list of other vendor by passing other vendorIds
    When User is able to log into application
      | email                                | password       |
      | vikrant.singh+13@successive.tech     | 1234512345   |
    Then user should be able to login to the system and store token
    And user enter the requesterID and userType
      |  userId                       |    userType       |
      |  <userId>                     |    <userType>     |
    And user make a request to fetch list of vendor
    Then user should not be able to gets any list of vendor that he requested and user should get validation messages
      |    Invalid user provided    |
      |    Invalid user provided    |
    Examples:
      |  userId                     |    userType     |
      |  5e3baa47df34800019a752d4   |    supplier     |
      |  5b9f7962171487000f0968d2   |    supplier     |
