Feature: API - Update branding of seller

  As a seller
  I want to update branding of seller on marketcube

  Scenario: Update branding of seller with valid values
    When User is able to log into application
      |email                     | password  |
      |mohit.agrawal@successive.tech | Mohit@1989 |
    Then user should be able to login to the system and store token
    When User enter branding information
    | domain | logo | footer | emailSign | loginText | color | headerFont | buttonColor | buttonFont | hideMcContactInfo|
    | mohit-selenium.myshopify.com | logo | footer text | email sign | login text | red | header font | red | areal | true |
    And Enter register details
    | title | desc |
    | title | desc |
    Then user should be able to update branding of seller