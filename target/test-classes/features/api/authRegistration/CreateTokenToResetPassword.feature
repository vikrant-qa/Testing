Feature: User wants to create a token in case of forget password

    As a user--
    I want to create a token that user got by their registered emailId
    and then user use this token to reset Password

    Scenario:User enter their registered valid emailId and create a token that will be used for reset password
      When User enter the registered email and generate the token
        | email|
        | systemadmin@marketcube.io |
      Then Token has been created successfully and user should get a message as a Mail Sent Successfully

  Scenario Outline: User enter incorrect/wrong  emailId and wants to create a token that will be used for reset password
    When User enter the incorrect/wrong email and wants to create a token
      | email   |
      | <email> |
    Then user should get validation error message
      | Email is required.    |
      | Invalid data provided |
    Examples:
      | email                           |
      |                                 |
      | systemadmin@marketcube.io.com   |



