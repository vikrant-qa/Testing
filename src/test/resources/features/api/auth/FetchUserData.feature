Feature: As a system admin-
         user wants to view all the seller and vendor details
         and
         As a seller-
         user wants to fetch their associated vendor details


  Scenario:Login with valid registered user details as a system admin and user gets the specific seller details
    When User is able to log into application
      | email                         | password   |
      | systemadmin@marketcube.io     | 12345678n@N  |
    Then user should be able to login to the system and store token
    And user enter the requesterID , sellerId and userType
      |  userId                    | id                        |    userType     |
      |  59c134d3c8efb4001a2bf1ad  | 5e29912fbfec74a0272e9a92  |    seller       |
    And user make a request to fetch details of seller
    Then user should be able to gets all the details of a person that he requested

  Scenario Outline:Login with valid registered user details as a system admin and user request for seller details without follow Userid field ,sellerId field and Usertype field validation
    When User is able to log into application
      | email                         | password   |
      | systemadmin@marketcube.io     | 12345678n@N  |
    Then user should be able to login to the system and store token
    And user enter the requesterID , sellerId and userType
      |  userId                      | id                          |    userType     |
      |  <userId>                    | <id>                        |    <userType>     |
    And user make a request to fetch details of seller
    Then user should not be able to get all the details of a person that he requested and user should get validation messages
      | UserType is required.                         |
      | Invalid type provided.                        |
      | UserId is required.                           |
      | Invalid userId provided.                      |
      | id is required.                               |
      | Invalid id provided.                          |
      | UserId is required.                           |
    Examples:
      |  userId                          | id                              |    userType     |
      |  59c134d3c8efb4001a2bf1ad        | 5e29912fbfec74a0272e9a92        |                 |
      |  59c134d3c8efb4001a2bf1ad        | 5e29912fbfec74a0272e9a92        |    sellerssssss |
      |                                  | 5e29912fbfec74a0272e9a92        |    seller       |
      |  abcdefghijkerststytsggsg        | 5e29912fbfec74a0272e9a92        |    seller       |
      |  59c134d3c8efb4001a2bf1ad        |                                 |    seller       |
      |  59c134d3c8efb4001a2bf1ad        | abcdefghijkerststytsggsg        |    seller       |
      |                                  |                                 |                 |
#Bug-    login as a system admin and user request for seller details, if usertype field is with invalid data then it should be expected message as a --""invalid type provided-"" ,But it give response as a  "Invalid data provided"
# bug --login as a system admin and user request for seller details, if userid field is with invalid data then it should be expected message as a --"Invalid userId provided." ,But it is giving wrong messages as a "Cast to ObjectId failed for value \"abcdefghijkerststytsggsg\" at path \"_id\" for model \"Users\"
# bug --login as a system admin and user request for seller details, if id field is with blank data then it should be expected message as a --"id is required." ,But it give response as a  true and show all the details of seller ,
# bug --login as a system admin and user request for seller details, if id field is with invalid data then it should be expected message as a --"Invalid id provided." ,But it is giving wrong messages as a "Cast to ObjectId failed for value \"abcdefghijkerststytsggsg\" at path \"_id\" for model \"Users\"


  Scenario:Login with valid registered user details as a system admin and user gets the specific vendor details
    When User is able to log into application
      | email                         | password   |
      | systemadmin@marketcube.io     | 123456789  |
    Then user should be able to login to the system and store token
    And user enter the requesterID , vendorId and userType
      |  userId                    | id                        |    userType       |
      |  59c134d3c8efb4001a2bf1ad  | 5e2996260da2580011251edb  |    supplier       |
    And user make a request to fetch details of vendor
    Then user should be able to gets all the details of a person that he requested

  Scenario Outline:Login with valid registered user details as a system admin and user request for vendor details without follow Userid field ,sellerId field and Usertype field validation
    When User is able to log into application
      | email                         | password     |
      | systemadmin@marketcube.io     | 12345678n@N  |
    Then user should be able to login to the system and store token
    And user enter the requesterID , vendorId and userType
      |  userId                    | id                        |    userType         |
      |  <userId>                  | <id>                      |    <userType>       |
    And user make a request to fetch details of vendor
    Then user should not be able to get all the details of a person that he requested and user should get validation messages
      | UserType is required.                         |
      | Invalid type provided.                        |
      | UserId is required.                           |
      | Invalid userId provided.                      |
      | id is required.                               |
      | Invalid id provided.                          |
      | UserId is required.                           |
    Examples:
      |  userId                          | id                              |    userType       |
      |  59c134d3c8efb4001a2bf1ad        | 5e2996260da2580011251edb        |                   |
      |  59c134d3c8efb4001a2bf1ad        | 5e2996260da2580011251edb        |    supplierssssss |
      |                                  | 5e2996260da2580011251edb        |    supplier       |
      |  abcdefghijkerststytsggsg        | 5e2996260da2580011251edb        |    supplier       |
      |  59c134d3c8efb4001a2bf1ad        |                                 |    supplier       |
      |  59c134d3c8efb4001a2bf1ad        | abcdefghijkerststytsggsg        |    supplier       |
      |                                  |                                 |                   |
 #Bug-  login as a system admin and user request for vendor details, if usertype field is with invalid data then it should be expected message as a --""invalid type provided-"" ,But it is giving wrong messages as a ""Invalid data provided""
# bug --login as a system admin and user request for vendor details, if userid field is with invalid data then it should be expected message as a --"Invalid userId provided." ,But it is giving wrong messages as a "Cast to ObjectId failed for value \"abcdefghijkerststytsggsg\" at path \"_id\" for model \"Users\"
# bug --login as a system admin and user request for vendor details, if id field is with blank data then it should be expected message as a --"id is required." ,But it give response as a  true and show all the details of seller ,
# bug --login as a system admin and user request for vendor details, if id field is with invalid data then it should be expected message as a --"Invalid id provided." ,But it is giving wrong messages as a "Cast to ObjectId failed for value \"abcdefghijkerststytsggsg\" at path \"_id\" for model \"Users\"




  Scenario:Login with valid registered user details as a Seller and user request for other seller details with valid Userid field , valid sellerId field and valid Usertype field
    When User is able to log into application
      | email                             | password    |
      | vikrant.singh@successive.tech     | HaiVikki12  |
    Then user should be able to login to the system and store token
    And user enter the requesterID , sellerId and userType
      |  userId                    | id                        |    userType     |
      |  5e29912fbfec74a0272e9a92  | 5bb5b19ffd448f5db46c2890  |    seller       |
    And user make a request to fetch details of seller
    Then user should not be able to get all the details of a person that he requested and user should get validation messages
      | Invalid user provided  |



  Scenario:Login with valid registered user details as a Seller and user request for their associated vendor details with valid Userid field , valid sellerId field and valid Usertype field
    When User is able to log into application
      | email                             | password    |
      | vikrant.singh@successive.tech     | HaiVikki12  |
    Then user should be able to login to the system and store token
    And user enter the requesterID , sellerId and userType
      |  userId                    | id                        |    userType       |
      |  5e29912fbfec74a0272e9a92  | 5e2996260da2580011251edb  |    supplier       |
    And user make a request to fetch details of vendor
    Then user should be able to gets all the details of a person that he requested




  Scenario Outline:Login with valid registered user details as a Seller and user request for their associated vendor details without follow Userid field ,sellerId field and valid Usertype field validation
    When User is able to log into application
      | email                             | password    |
      | vikrant.singh@successive.tech     | HaiVikki12  |
    Then user should be able to login to the system and store token
    And user enter the requesterID , sellerId and userType
      |  userId                    | id                        |    userType       |
      |  <userId>                  | <id>                      |    <userType>     |
    And user make a request to fetch details of vendor
    Then user should not be able to get all the details of a person that he requested and user should get validation messages
      | UserType is required.                         |
      | Invalid type provided.                        |
      | UserId is required.                           |
      | Invalid userId provided.                      |
      | id is required.                               |
      | Invalid id provided.                          |
      | UserId is required.                           |
    Examples:
      |  userId                    | id                        |    userType       |
      |  5e29912fbfec74a0272e9a92  | 5e2996260da2580011251edb  |                   |
      |  5e29912fbfec74a0272e9a92  | 5e2996260da2580011251edb  |    suppliereeee   |
      |                            | 5e2996260da2580011251edb  |    supplier       |
      |  abcdefghijkerststytsggsg  | 5e2996260da2580011251edb  |    supplier       |
      |  5e29912fbfec74a0272e9a92  |                           |    supplier       |
      |  5e29912fbfec74a0272e9a92  | abcdefghijkerststytsggsg  |    supplier       |
      |                            |                           |                   |
#Bug-  login as a Seller and user request for vendor details, if usertype field is with invalid data then it should be expected message as a --""invalid type provided-"" ,But it is giving wrong messages as a ""Invalid data provided""
# bug --login as a Seller and user request for vendor details, if userid field is with invalid data then it should be expected message as a --"Invalid userId provided." ,But it is giving wrong messages as a "Cast to ObjectId failed for value \"abcdefghijkerststytsggsg\" at path \"_id\" for model \"Users\"
# bug --login as a Seller and user request for vendor details, if id field is with blank data then it should be expected message as a --"id is required." ,But it give response as a  true and show all the details of seller ,
# bug --login as a Seller and user request for vendor details, if id field is with invalid data then it should be expected message as a --"Invalid id provided." ,But it is giving wrong messages as a "Invalid data provided"


  Scenario:Login with valid registered user details as a Seller and User requested for other vendor details with which he is not associated  with valid Userid field , valid sellerId field and valid Usertype field
    When User is able to log into application
      | email                             | password    |
      | vikrant.singh@successive.tech     | HaiVikki12  |
    Then user should be able to login to the system and store token
    And user enter the requesterID , sellerId and userType
      |  userId                    | id                        |    userType       |
      |  5e29912fbfec74a0272e9a92  | 5bd2c369df5196000f0be456  |    supplier       |
    And user make a request to fetch details of vendor
    Then user should not be able to get all the details of a person that he requested and user should get validation messages
      | Invalid data provided  |



  Scenario:Login with valid registered user details as a Vendor and User requested for other vendor details
    When User is able to log into application
      | email                             | password    |
      | vikrant.singh@successive.tech     | 1234567890  |
    Then user should be able to login to the system and store token
    And user enter the requesterID , sellerId and userType
      |  userId                    | id                        |    userType       |
      |  5e2996260da2580011251edb  | 5bb5b19ffd448f5db46c2890  |    supplier       |
    And user make a request to fetch details of vendor
    Then user should not be able to get all the details of a person that he requested and user should get validation messages
      | Invalid user provided |


  Scenario:Login with valid registered user details as a Vendor and User requested for seller details
    When User is able to log into application
      | email                             | password    |
      | vikrant.singh@successive.tech     | 1234567890  |
    Then user should be able to login to the system and store token
    And user enter the requesterID , sellerId and userType
      |  userId                    | id                        |    userType       |
      |  5e2996260da2580011251edb  | 5e29912fbfec74a0272e9a92  |    seller         |
    And user make a request to fetch details of seller
    Then user should not be able to get all the details of a person that he requested and user should get validation messages
      | Invalid user provided |


  Scenario Outline:User make a request for list of seller or vendor by passing with Incorrect/blank token data with valid userID and userType
    And user enter the requesterID , sellerId and userType
      |  userId                    | id                        |    userType       |
      |  5e2996260da2580011251edb  | 5bb5b19ffd448f5db46c2890  |    supplier       |
    When user make a request for seller or vendor details with Incorrect/blank token field in form of without login credentials
      | token                      |
      | <token>                    |
    Then user should not be able to gets any vendor or seller details that he requested then user should get a  validation message for Incorrect/blank token
      | Invalid token provided          |
    Examples:
      | token                           |
      |  sgshhshhshhshshhsh             |
      |                                 |