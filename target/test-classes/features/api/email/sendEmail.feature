Feature:user want to send an email

  Scenario: User want to send an email with valid field credentials
    When user enter the email-id,subject and message field with valid data
      | message                | subject              |  email                               |
      | this is testing messge | testing subject      |  vikrant.singh@@successive.tech      |
    Then Email sent successfully and user should get message as ok



  Scenario Outline: User want to send an email with Incorrect field credentials
    When User enter the email-id,Subject and Message field as a blank
      | message                | subject              |  email                               |
      | <message>              | <subject>            |  <email>                             |
    Then Email not sent successfully and user got message error received
    Examples:
      | message                | subject              |  email                               |
      | this is testing messge | testing subject      |                                      |
      | this is testing messge |                      |  vikrant.singh@@successive.tech      |
      |                        | testing subject      |  vikrant.singh@@successive.tech      |


