Feature: API - Reset the user password

  As a new user
  I want to reset user password
  So that I am able to access the platform and manage my inventory with new password

  Scenario: User reset password by generating token
    When User enter the registered email and generate the token
    |email|
    | systemadmin@marketcube.io |
    Then Token has been created successfully and user should get a message as a Mail Sent Successfully
    When User should be able to change password with new passowrd
    | newPassword|
    | 123456789 |
    And User password changed successfully and user should get a message as a Password Changed Successfully
    When User is enters email and password
      |email                     | password  |
      |systemadmin@marketcube.io | 123456789 |
    Then user should be able to login to the system

  Scenario: Verify that User should not be able to login with the old password after changing the password
    When User is enters email and password
      |email                     | password  |
      |systemadmin@marketcube.io | 1234567890 |
    Then user should not be able to login to system

   Scenario: Try verifying the account with an expired verification link
     When User entered new password and try to login with expired token
      | newPassword|
      | 123456789 |
     Then user should get error message

  Scenario: Verify if the user has requested resend verification email twice and then try to change password
    When User enter the registered email and generate the token
      |email|
      | systemadmin@marketcube.io |
    When User enter the registered email and generate the token
      |email|
      | systemadmin@marketcube.io |
    When User is enters email and password
      |email                     | password  |
      |systemadmin@marketcube.io | 123456789 |
    Then user should be able to login to the system



  Scenario: User try to re-use the same token to reset password second time
    When User enter the registered email and generate the token
      | email                     |
      | systemadmin@marketcube.io |
    Then Token has been created successfully and user should get a message as a Mail Sent Successfully
    When User should be able to change password with new passowrd
      | newPassword|
      | 123456789 |
    And User password changed successfully and user should get a message as a Password Changed Successfully
    Then user should not be able to reset password
      | newPassword|
      | 123456789 |