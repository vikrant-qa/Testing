Feature: Order - Update order line item tracking. - put -  /order/line-tracking

         As a registered user
         I want to update order  line item tracking

  Scenario: Login with valid registered user details as a seller and user wants to update order line item
    When User is able to log into application
      | email                                 | password       |
      | vikrant.singh@successive.tech         | HaiVikki12     |
    Then user should be able to login to the system and store token
    When User enters details of order line item that needs to be update
      | lineItemId                 | orderId                   | trackingNumber  | trackingCompany  | dueDays  |
      | 5e5e4d6ec82c2a0017007c80   | 5e5e4d6ec82c2a0017007c7f  | sdf             | sfdsdf           | 32       |
    Then User should be able to update order line item
# take lineItemId from objectid of orderLines tables and orederid from orders table



  Scenario: Login with valid registered user details as a vendor as a vendor and user wants to update order line item
    When User is able to log into application
      | email                                 | password       |
      | vikrant.singh@successive.tech         | 1234567890     |
    Then user should be able to login to the system and store token
    When User enters details of order line item that needs to be update
      | lineItemId                 | orderId                   | trackingNumber  | trackingCompany  | dueDays  |
      | 5e5e4a9539f0790017375969   | 5e5e4a9539f0790017375968  | sdf             | sfdsdf           | 32       |
    Then User should be able to update order line item
# take lineItemId from objectid of orderLines tables and orederid from orders table


  Scenario: Login with valid registered user details as a vendor as a System Admin and user wants to update order line item
    When User is able to log into application
      | email                                 | password       |
      | systemadmin@marketcube.io             | 12345678n@N    |
    Then user should be able to login to the system and store token
    When User enters details of order line item that needs to be update
      | lineItemId                 | orderId                   | trackingNumber  | trackingCompany  | dueDays  |
      | 5e5e4d6ec82c2a0017007c80   | 5e5e4d6ec82c2a0017007c7f  | sdf             | sfdsdf           | 32       |
    Then User should not be able to update order line item and user should gets a validate error message
      | User is not authorized to perform this action. |
# take lineItemId from objectid of orderLines tables and orederid from orders table




  Scenario Outline: Login with valid registered user details as a seller and user wants to update order line item without follow field validation
    When User is able to log into application
      | email                                 | password       |
      | vikrant.singh@successive.tech         | HaiVikki12     |
    Then user should be able to login to the system and store token
    When User enters details of order line item that needs to be update
      | lineItemId   | orderId   | trackingNumber   | trackingCompany   | dueDays   |
      | <lineItemId> | <orderId> | <trackingNumber> | <trackingCompany> | <dueDays> |
    Then User should not be able to update order line item and user should gets a validate error message
      | LineItemId is required.      |
      | OrderId is required.         |
      | TrackingNumber is required.  |
      | TrackingCompany is required. |
      | Invalid data provided        |
      | Invalid data provided        |
    Examples:
      |lineItemId                  | orderId                   | trackingNumber  | trackingCompany  | dueDays  |
      |                            | 5df32cccddc51e001065ec16  | sdf             | sfdsdf           | 32       |
      | 5dea2ebe729fab001ae927e9   |                           | sdf             | sfdsdf           | 32       |
      | 5dea2ebe729fab001ae927e9   | 5df32cccddc51e001065ec16  |                 | sfdsdf           | 32       |
      | 5dea2ebe729fab001ae927e9   | 5df32cccddc51e001065ec16  | sdf             |                  | 32       |
      | 5e5e4d6ec82c2a0017007c80   | 5e5e4d6ec82c2a0017007c7f  | sdf             | sfdsdf           | 32       |
      | 5e5e4d6ec82c2a0017007c80   | 5e5e4d6ec82c2a0017007c7f  | sdf             | sfdsdf           | 32       |


  Scenario Outline: User make a request to update order line item with valid ids field by passing Incorrect/blank token data
    When User enters details of order line item that needs to be update for token check
      | lineItemId                 | orderId                   | trackingNumber  | trackingCompany  | dueDays  |
      | 5e5e4d6ec82c2a0017007c80   | 5e5e4d6ec82c2a0017007c7f  | sdf             | sfdsdf           | 32       |
    When user make a request to update order line item with Incorrect/blank token field in form of without login credentials
      |  token                      |
      | <token>                     |
    Then User should not be able to update order line item and user should gets a validate error message
      | Invalid token provided          |
      | Invalid token provided          |
    Examples:
      | token                           |
      |  sgshhshhshhshshhsh             |
      |                                 |
