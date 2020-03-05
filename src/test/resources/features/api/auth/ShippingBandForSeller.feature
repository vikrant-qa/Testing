Feature: API - Login as a registered user

  As a registered user
  I want to change the shipping band for seller

  Scenario Outline: Login with valid registered user details and create shipping band for seller
    When User is able to log into application
    |email                     | password  |
    |mohit.agrawal@successive.tech | Mohit@1989 |
    Then user should be able to login to the system and store token
    When User enter details  for  create shipping band for seller
    | name | description | priceType | price | isUpdateAllowed |
    | <name> | <description> | <priceType> | <price> | <isUpdateAllowed> |
    Then User should be able to create shipping successfully for seller
    Examples:
      | name | description | priceType | price | isUpdateAllowed |
      | Albert | this is the desc for fixed | fixed | 23 | true            |
      | Albert | this is the desc for free  | free | 23 | true             |

  Scenario Outline: Login with valid registered user details and create shipping band for seller
    When User is able to log into application
      |email                     | password  |
      |mohit.agrawal@successive.tech | Mohit@1989 |
    Then user should be able to login to the system and store token
    When User enter details  for  create shipping band for seller
      | name | description | priceType | price | isUpdateAllowed |
      | <name> | <description> | <priceType> | <price> | <isUpdateAllowed> |
    Then User should not be able to create shipping successfully for seller and show below error messages
      |Name is required.|
      |Description is required.|
      |PriceType is required.  |
    Examples:
      | name   | description                | priceType       | price      | isUpdateAllowed |
      |\n\n\n\n| this is the desc for fixed | fixed           | 23         | true            |
      | Albert |\n\n\n\n                    | free            | 23         | true            |
      | Albert | sfdsdf                     |\n\n\n\n         | 23         | true            |