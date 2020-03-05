  Feature: User wants to change the Passwords with existing password


  Scenario Outline: Vendor/Seller change password with valid current password
    When User is able to log into application
      |email                         | password  |
      |vikrant.singh@successive.tech |<password> |
    Then user should be able to login to the system and store token
    When User enter the valid old Password and valid new password
      | newPassword   | password   |
      | <newPassword> | <password> |
    Then Password change successfully and user got message ok recieved
    Examples:
      | newPassword                | password                   |
      | 999999999999999999999999   | 1234567890                 |
      | 00000000000000000          | 999999999999999999999999  |
      | ababababababbabababababa   | 00000000000000000         |
      | ************************   | ababababababbabababababa  |
      | WeWeWeWeWeWeWeWe@#@#@#@#   | ************************  |
      | 12345678                   | WeWeWeWeWeWeWeWe@#@#@#@#  |
      | 123456789123456789123456789123456789123456789123456789123456789123456789123456789   | 12345678                  |
      | ababababababbabababababaWeWeWeWeWeWeWeWe@#@#@#@#************************                  | 123456789123456789123456789123456789123456789123456789123456789123456789123456789  |
      | 12         3456          789        | ababababababbabababababaWeWeWeWeWeWeWeWe@#@#@#@#************************      |
      | 1234              56789             | 12         3456          789                  |
      | 1234567890                          | 1234              56789                       |




  Scenario Outline: user request for change password and user not follow any field validation
    When User is able to log into application
      |email                         | password   |
      |vikrant.singh@successive.tech | HaiVikki12 |
    Then user should be able to login to the system and store token

    When User enter the wrong/incorrect Password details for change password request
      |newPassword       |password     |
      |<newPassword>     |<password>   |
    Then user will not able to change password and user should get validation messages
      | Current and new password can not be same     |
      | Password should be minimum 8 characters long |
      | Invalid password provided                    |
      | Current and new password can not be same     |
      | NewPassword is required.                     |
      | Password is required.                        |
      | NewPassword is required.                     |
    Examples:
      | newPassword  | password    |
      | 12345678     | 12345678    |
      | 1234567      | 12345678    |
      | 1234567890   | 12345678    |
      | 123456789    | 123456789   |
      |              | 123456789   |
      | 123456789    |             |
      |              |             |



