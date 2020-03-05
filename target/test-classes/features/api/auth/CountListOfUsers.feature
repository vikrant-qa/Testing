Feature: Login as System admin
         User wants to count list of users(seller or vendor)

         Login as seller
         User wants to count list of users

  Scenario Outline: Login with valid registered user details as a system admin and user wants to request for count list of users (seller or vendor)
    When User is able to log into application
      | email                         | password     |
      | systemadmin@marketcube.io     | 12345678n@N  |
    Then user should be able to login to the system and store token
    And user enters the userRole field and filter field of requester
      | userRole     | filter   |
      | <userRole>   | <filter> |
    And user make a request to fetch  the count of users
    Then user should be able to get the list of user that he requested
    Examples:
      |  userRole       | filter              |
      |  vendor         |    pending          |
      |  seller         |    pending          |
      |  vendor         |    approved         |
      |  seller         |    approved         |



  Scenario Outline: Login with valid registered user details as a seller and user wants to request for count list of their associated vendors
    When User is able to log into application
      | email                             | password     |
      | vikrant.singh@successive.tech     | HaiVikki12   |
    Then user should be able to login to the system and store token
    And user enters the userRole field and filter field of requester
      | userRole     | filter   |
      | <userRole>   | <filter> |
    And user make a request to fetch  the count of users
    Then user should be able to get the list of user that he requested
    Examples:
      |  userRole       | filter              |
      |  vendor         |    pending          |
      |  vendor         |    approved         |


  Scenario Outline: Login with valid registered user details as a seller and user wants to request for count list of other seller
    When User is able to log into application
      | email                             | password     |
      | vikrant.singh@successive.tech     | HaiVikki12   |
    Then user should be able to login to the system and store token
    And user enters the userRole field and filter field of requester
      | userRole     | filter   |
      | <userRole>   | <filter> |
    And user make a request to fetch  the count of users
    Then user should not be able to get the list of user that he requested and user should get validation messages
      | User is not authorized to perform this action      |
      | User is not authorized to perform this action      |
    Examples:
      |  userRole       | filter              |
      |  seller         |    pending          |
      |  seller         |    approved         |
#Bug login as a seller user wants to request for count list of other seller then it should be expected message as a "User is not authorized to perform this action ",but it give  response true , status ok and show all datas


  Scenario Outline: Login with valid registered user details as a vendor and user wants to request for count list of users
    When User is able to log into application
      | email                             | password     |
      | vikrant.singh@successive.tech     | 1234567890   |
    Then user should be able to login to the system and store token
    And user enters the userRole field and filter field of requester
      | userRole     | filter   |
      | <userRole>   | <filter> |
    And user make a request to fetch  the count of users
    Then user should not be able to get the list of user that he requested and user should get validation messages
      | User is not authorized to perform this action      |
      | User is not authorized to perform this action      |
      | User is not authorized to perform this action      |
      | User is not authorized to perform this action      |
    Examples:
      |  userRole       | filter              |
      |  vendor         |    pending          |
      |  seller         |    pending          |
      |  vendor         |    approved         |
      |  seller         |    approved         |


