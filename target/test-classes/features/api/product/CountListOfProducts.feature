Feature:  Product - Count list of products - get -   /product/count

        As a registered user
        I want to Count list of products

  Scenario Outline: Login with valid registered user details as a seller and user make a request to Count list of products
    When User is able to log into application
      | email                                 | password       |
      | vikrant.singh@successive.tech         | HaiVikki12     |
    Then user should be able to login to the system and store token
    When User enters details to count of list products
      | filter         |
      | <filter>       |
    Then User should be able to count list of products that he requested
    Examples:
      | filter              |
      | new                 |
      | review              |
      | reviewed            |
      | Approved            |
      | rejected            |
      | Deleted             |
      | accepted            |
      | pending             |
      | published           |
      | approved            |


  Scenario Outline: Login with valid registered user details as a System Admin and user make a request to Count list of products
    When User is able to log into application
      | email                                 | password       |
      | systemadmin@marketcube.io             | 12345678n@N    |
    Then user should be able to login to the system and store token
    When User enters details to count of list products
      | filter         |
      | <filter>       |
    Then User should be able to count list of products that he requested
    Examples:
      | filter              |
      | new                 |
      | review              |
      | reviewed            |
      | Approved            |
      | rejected            |
      | Deleted             |
      | accepted            |
      | pending             |
      | published           |
      | approved            |



  Scenario Outline: Login with valid registered user details as a vendor and user make a request to Count list of products
    When User is able to log into application
      | email                                 | password       |
      | vikrant.singh@successive.tech         | 1234567890     |
    Then user should be able to login to the system and store token
    When User enters details to count of list products
      | filter         |
      | <filter>       |
    Then User should be able to count list of products that he requested
    Examples:
      | filter              |
      | new                 |
      | review              |
      | reviewed            |
      | Approved            |
      | rejected            |
      | Deleted             |
      | accepted            |
      | pending             |
      | published           |
      | approved            |
