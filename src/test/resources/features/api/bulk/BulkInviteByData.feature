Feature: API - Register supplier as a user

  As a seller or system admin
  I want to invite vendor by data in bulk
  So that vendor can register himself

  Scenario Outline: Login with valid registered user details as a Seller and user send bulk invite to vendor by data
    When User is able to log into application
      | email                             | password    |
      | vikrant.singh@successive.tech     | HaiVikki12  |
    Then user should be able to login to the system and store token
    When user enters email ids
      | vikrant.singh@successive.tech |
      | vikrant.singh@successive.tech |
    And  user enters details of Message
      | message            | subject |
      | <message>          | <subject> |
    And user enter details of messageData for list
      | storeName   | url                     |
      | <storeName> | <url>                   |
    And user enter details of sentBy
      | type          | userid   |
      | <type>        | <userid> |
    And user make a request to send bulk invite to vendor by data
    Then invite should be sent
   Examples:
     | message          | subject  | storeName       | url                    | type           | userid     |
     | This is message  | sub      | testing         | http://www.google.com  | testinguser    | userID     |



  Scenario Outline: Login with valid registered user details as a Seller and without following any field validation user request to send bulk invite to vendor by data
    When User is able to log into application
      | email                             | password    |
      | vikrant.singh@successive.tech     | HaiVikki12  |
    Then user should be able to login to the system and store token
    When user enters email ids
      | vikrant.singh@successive.tech |
      | vikrant.singh@successive.tech |
    And  user enters details of Message
      | message            | subject   |
      | <message>          | <subject> |
    And user enter details of messageData for list
      | storeName   | url                     |
      | <storeName> | <url>                   |
    And user enter details of sentBy
      | type          | userid   |
      | <type>        | <userid> |
    And user make a request to send bulk invite to vendor by data
    Then invite should not be sent and user should get validation message
      |  Please insert message        |
      |  Please insert subject        |
      |  Message is required.         |
      |  Please insert type           |
      |  Please insert userid         |
      |  sentBy is required.          |
      | Invalid type provided         |
      | Invalid userId provided.      |
      |  Please insert storeName      |
      |  Please insert url            |
      |  MessageData is required.     |
    Examples:
      | message          | subject  | storeName       | url                    | type           | userid                          |
      |                  | sub      | testing         | http://www.google.com  | seller         | 59c134d3c8efb4001a2bf1ad        |
      | This is message  |          | testing         | http://www.google.com  | seller         | 59c134d3c8efb4001a2bf1ad        |
      |                  |          | testing         | http://www.google.com  | seller         | 59c134d3c8efb4001a2bf1ad        |
      | This is message  | sub      | testing         | http://www.google.com  |                | 59c134d3c8efb4001a2bf1ad        |
      | This is message  | sub      | testing         | http://www.google.com  | seller         |                                 |
      | This is message  | sub      | testing         | http://www.google.com  |                |                                 |
      | This is message  | sub      | testing         | http://www.google.com  | sellersdhsjjsj | 59c134d3c8efb4001a2bf1ad        |
      | This is message  | sub      | testing         | http://www.google.com  | seller         | 59c134d3c8efb4001a2bf1adww      |
      | This is message  | sub      |                 | http://www.google.com  | testinguser    | userID                          |
      | This is message  | sub      | testing         |                        | testinguser    | userID                          |
      | This is message  | sub      | testing         |                        |                | userID     |

#Bug--Login as a Seller and when user request to send bulk invite to vendor by data  with blank sentBy type field it should be expected message as a "Please insert type" and but it gives a response true and status ok
#Bug--Login as a Seller and when user request to send bulk invite to vendor by data  with blank sentBy userid  field it should be expected message as a "Please insert userid" and but it gives a response true and status ok
#Bug--Login as a Seller and when user request to send bulk invite to vendor by data  with blank sentBy  field (without type and userid field) it should be expected message as a "sentBy is required." and but it gives a response true and status ok
#Bug- Login as a Seller and when user request to send bulk invite to vendor by data  with invalid sentBy type  field  it should be expected message as a "Invalid type provided" and but it gives a response true and status ok
#Bug- Login as a Seller and when user request to send bulk invite to vendor by data  with invalid sentBy userid field  it should be expected message as a "Invalid userId provided." and but it gives a response true and status ok

#Bug-Login as a Seller and when user request to send bulk invite to vendor by data  with blank Message subject  it should be expected message as a "Please insert subject" and but it gives a response true and status ok

#Bug--Login as a Seller and when user request to send bulk invite to vendor by data  with blank MessageData -storeName field it should be expected message as a "Please insert storeName" and but it gives a response true and status ok
#Bug--Login as a Seller and when user request to send bulk invite to vendor by data  with blank MessageData url  field it should be expected message as a "Please insert url" and but it gives a response true and status ok
#Bug--Login as a Seller and when user request to send bulk invite to vendor by data  with blank MessageData  field (without url and storename field) it should be expected message as a "MessageData is required." and but it gives a response true and status ok


  Scenario: Login with valid registered user details as a vendor and user request to send bulk invite to vendor by data
    When User is able to log into application
      | email                             | password    |
      | vikrant.singh@successive.tech     | 1234567890  |
    Then user should be able to login to the system and store token
    When user enters email ids
      | vikrant.singh@successive.tech |
      | vikrant.singh@successive.tech |
    And  user enters details of Message
      | message          | subject |
      | This is message  | sub     |
    And user enter details of messageData for list
      | storeName | url                   |
      | testing   | http://www.google.com |
    And user enter details of sentBy
      | type        | userid |
      | testinguser | userID |
    And user make a request to send bulk invite to vendor by data
    Then invite should not be sent and user should get validation message
      | User is not authorized to perform this action. |
#Bug-Login as a vendor and when user request to send bulk invite to vendor by data ,it should be expected message as a "User is not authorized to perform this action." and but it gives a response true and status ok


  Scenario Outline: Login with valid registered user details as a System admin and user send bulk invite to vendor by data
    When User is able to log into application
      | email                             | password    |
      | systemadmin@marketcube.io         | 123456789   |
    Then user should be able to login to the system and store token
    When user enters email ids
      | vikrant.singh@successive.tech |
      | vikrant.singh@successive.tech |
    And  user enters details of Message
      | message            | subject |
      | <message>          | <subject> |
    And user enter details of messageData for list
      | storeName   | url                     |
      | <storeName> | <url>                   |
    And user enter details of sentBy
      | type          | userid   |
      | <type>        | <userid> |
    And user make a request to send bulk invite to vendor by data
    Then invite should be sent
    Examples:
      | message          | subject  | storeName       | url                    | type           | userid     |
      | This is message  | sub      | testing         | http://www.google.com  | testinguser    | userID     |


  Scenario: Login with valid registered user details as a seller and user request to send bulk invite to vendor by data with blank email field
    When User is able to log into application
      | email                             | password    |
      | vikrant.singh@successive.tech     | HaiVikki12  |
    Then user should be able to login to the system and store token
    When user enters email ids
      |     |
    And  user enters details of Message
      | message          | subject |
      | This is message  | sub     |
    And user enter details of messageData for list
      | storeName | url                   |
      | testing   | http://www.google.com |
    And user enter details of sentBy
      | type        | userid |
      | testinguser | userID |
    And user make a request to send bulk invite to vendor by data
    Then invite should not be sent and user should get validation message
      | Emails is required. |


  Scenario: Login with valid registered user details as a seller and user request to send bulk invite to vendor by data with incorrect/wrong email field
    When User is able to log into application
      | email                             | password    |
      | vikrant.singh@successive.tech     | HaiVikki12  |
    Then user should be able to login to the system and store token
    When user enters email ids
      | abc    |
    And  user enters details of Message
      | message          | subject |
      | This is message  | sub     |
    And user enter details of messageData for list
      | storeName | url                   |
      | testing   | http://www.google.com |
    And user enter details of sentBy
      | type        | userid |
      | testinguser | userID |
    And user make a request to send bulk invite to vendor by data
    Then invite should not be sent and user should get validation message
      | Invalid emailId provided |
#Bug-Login as a seller and when user request to send bulk invite to vendor by data with incorrect emailId field ,it should be expected message as a "Invalid emailId provided" and but it gives a response true and status ok

  Scenario Outline: user request to send bulk invite to vendor by data  with incorrect/blank token data <token>
    When user enters email ids
      | vikrant.singh@successive.tech |
      | vikrant.singh@successive.tech |
    And  user enters details of Message
      | message          | subject |
      | This is message  | sub     |
    And user enter details of messageData for list
      | storeName | url                   |
      | testing   | http://www.google.com |
    And user enter details of sentBy
      | type        | userid |
      | testinguser | userID |
    And user make a request to send bulk invitation to vendor by data with incorrect or blank token field in form of without login credentials
      | token                      |
      | <token>                    |
    Then invite should not be sent and user should get validation message
      | Invalid token provided |
      | Invalid token provided |
    Examples:
      | token                           |
      |  sgshhshhshhshshhsh             |
      |                                 |