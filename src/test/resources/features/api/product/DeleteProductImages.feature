Feature: Product - Delete Product Image.-  delete -  /product/image

         Login as a registered user as a seller
         I want to delete the image of product

  Scenario Outline: Login with valid registered user details as a seller and user wants to delete the image of product
    When User is able to log into application
      | email                                 | password       |
      | vikrant.singh@successive.tech         | HaiVikki12     |
    Then user should be able to login to the system and store token
    When user enters the details of productId , url of image and sellerid from seller products
      | productId                          | url        | seller   |
      | <productId>                        | <url>      | <seller> |
    And User make a request to delete the image of product
    Then user should be able to delete the image of product
    Examples:
      | productId                        | url      | seller |
      | 5e537878edb8830017e45195         | https://res.cloudinary.com/marketcube/image/upload/v1583223056/mc/test/product/5e537878edb8830017e45195/pfab9zfmuhiuelycuedw.jpg     |  5e29912fbfec74a0272e9a92    |
#take product id  as object id from products table and url from sellerproducts table only for seller




  Scenario Outline: Login with valid registered user details as a Vendor and user wants to delete the image of product
    When User is able to log into application
      | email                                 | password       |
      | vikrant.singh@successive.tech         | 1234567890     |
    Then user should be able to login to the system and store token
    When user enters the details of productId , url of image and vendorid from vendor products
      | productId                          | url        | vendor   |
      | <productId>                        | <url>      | <vendor> |
    And User make a request to delete the image of product
    Then user should be able to delete the image of product
    Examples:
      | productId                        | url      | vendor |
      | 5e537878edb8830017e45195         | https://res.cloudinary.com/marketcube/image/upload/v1583223090/mc/test/product/5e537878edb8830017e45195/c8csb74slwkufe3i5ups.jpg     |  5e2996260da2580011251edb    |
#take product id  as object id from products table and url from products  table only for vendors



  Scenario Outline: Login with valid registered user details as a system admin and user wants to delete the image of vendor product
    When User is able to log into application
      | email                                 | password       |
      | systemadmin@marketcube.io             | 12345678n@N    |
    Then user should be able to login to the system and store token
    When user enters the details of productId , url of image and vendorid from vendor products
      | productId                          | url        | vendor   |
      | <productId>                        | <url>      | <vendor> |
    And User make a request to delete the image of product
    Then user should be able to delete the image of product
    Examples:
      | productId                        | url      | vendor |
      | 5e537878edb8830017e45195         | https://res.cloudinary.com/marketcube/image/upload/v1583223092/mc/test/product/5e537878edb8830017e45195/bubzsobm62auatpbamql.jpg     |  5e2996260da2580011251edb    |
#take product id  as object id from products table and url from products  table only for vendors by system admin



  Scenario Outline: Login with valid registered user details as a system admin and user wants to delete the image of seller product
    When User is able to log into application
      | email                                 | password       |
      | systemadmin@marketcube.io             | 12345678n@N    |
    Then user should be able to login to the system and store token
    When user enters the details of productId , url of image and sellerid from seller products
      | productId                          | url        | seller   |
      | <productId>                        | <url>      | <seller> |
    And User make a request to delete the image of product
    Then user should be able to delete the image of product
    Examples:
      | productId                        | url      | seller |
      | 5e537878edb8830017e45195         | https://res.cloudinary.com/marketcube/image/upload/v1583223082/mc/test/product/5e537878edb8830017e45195/hbhqnab69tugmlgb2ov9.jpg     |  5e29912fbfec74a0272e9a92    |
#take product id  as object id from products table and url from sellerproducts table only for seller



  Scenario Outline: Login with valid registered user details as a seller and  without follow field validation user wants to delete the image of product
    When User is able to log into application
      | email                                 | password       |
      | vikrant.singh@successive.tech         | HaiVikki12     |
    Then user should be able to login to the system and store token
    When user enters the details of productId , url of image and sellerid from seller products
      | productId                          | url        | seller   |
      | <productId>                        | <url>      | <seller> |
    And User make a request to delete the image of product
    Then user should not be able to delete the image of product and user should get a validation message
      |  ProductId is required.   |
      |  Invalid data provided    |
      |  Url is required.         |
      |  Invalid image provided   |
      |  sellerid is required.    |
      |  Invalid data provided    |
    Examples:
      | productId                        | url      | seller |
      |                                  | https://res.cloudinary.com/marketcube/image/upload/v1583155055/mc/test/product/5e537878edb8830017e45195/hxzuojwbbj1kurmrlhwj.jpg     |  5e29912fbfec74a0272e9a92    |
      | 12345678901234567890             | https://res.cloudinary.com/marketcube/image/upload/v1583155055/mc/test/product/5e537878edb8830017e45195/hxzuojwbbj1kurmrlhwj.jpg     |  5e29912fbfec74a0272e9a92    |
      | 5e537878edb8830017e45195         |          |  5e29912fbfec74a0272e9a92    |
      | 5e537878edb8830017e45195         | https://res.cloudinary.com/marketcube/image/upload/v1583155055/mc/test/product/5e537878edb8830017e45195/hxzuojwbbj1kurmrlhwj.jpg     |  5e29912fbfec74a0272e9a92    |
      | 5e537878edb8830017e45195         | https://res.cloudinary.com/marketcube/image/upload/v1583155055/mc/test/product/5e537878edb8830017e45195/hxzuojwbbj1kurmrlhwj.jpg     |                              |
      | 5e537878edb8830017e45195         | https://res.cloudinary.com/marketcube/image/upload/v1583155055/mc/test/product/5e537878edb8830017e45195/hxzuojwbbj1kurmrlhwj.jpg     | 12345678901234567890         |



  Scenario Outline: User make a request to delete the image of product with valid productId,url and sellerId field by passing Incorrect/blank token data
    When user enters the details of productId , url of image and sellerid from seller products
      | productId                          | url        | seller   |
      | 5e537878edb8830017e45195           | https://res.cloudinary.com/marketcube/image/upload/v1583217365/mc/test/product/5e537878edb8830017e45195/cwy6kgt452ioc1xh6oly.jpg     |  5e29912fbfec74a0272e9a92    |
    When User make a request to delete the image of product with Incorrect/blank token field in form of without login credentials
      |  token                      |
      | <token>                     |
    Then user should not be able to delete the image of product and user should get a validation message
      | Invalid token provided          |
      | Invalid token provided          |
    Examples:
      | token                           |
      |  sgshhshhshhshshhsh             |
      |                                 |

