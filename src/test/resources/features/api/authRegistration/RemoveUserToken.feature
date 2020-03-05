Feature: User wants to remove token that is form of logout functionality

  Scenario Outline: user use the system and wants to remove token by clicking Logout button
    When User is able to log into application
      |email                     | password  |
      |mohit.agrawal@successive.tech | Mohit@1989 |
    Then user should be able to login to the system and store token
    When user remove valid token by clicking Logout button
      | status          | data        |
      | <status>        | <data>      |
    Then user should get comes out of the system successfully
    Examples:
      | status          | data        |
      | ok              | true        |
      | ok              | false       |
      |                 | true        |
      | ok              |             |
      |                 |             |


  Scenario Outline: user wants to remove Incorrect/Wrong token by clicking Logout button
    When user wants to remove valid token by clicking Logout button
      | status          | data        |
      | <status>        | <data>      |
    Then user make a request to remove token with Incorrect/blank token field in form of without login credentials
      | token                      |
      | <token>                    |
    Then user should not be able to remove token without follow any field validation then user should get a  validation message for Incorrect/blank token
      | Invalid token provided          |
    Examples:
      | token                           |
      |  sgshhshhshhshshhsh             |
      |                                 |
