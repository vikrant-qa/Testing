Feature: API - Login as a registered user

  As a registered user
  I want to change the commission for any user

  Scenario: Login with valid registered user details and mute email notification
    When User is able to log into application
    |email                     | password  |
    |mohit.agrawal@successive.tech | Mohit@1989 |
    Then user should be able to login to the system and store token
    When User enter label and reset information that needs to be muted
    | label | isResetAll |
    |   test | true      |
    Then User should be able to mute respective notificaiton

  Scenario: Login with valid registered user details and try to mute email notificaiton without providing label details
    When User is able to log into application
      |email                     | password  |
      |mohit.agrawal@successive.tech | Mohit@1989 |
    Then user should be able to login to the system and store token
    When User enter label and reset information that needs to be muted
      | label | isResetAll |
      |    | false      |
    Then User should not be able to mute respective notificaiton