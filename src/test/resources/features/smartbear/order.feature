@smart
Feature: Validation of Product

  Scenario: Validation of New Product Creation
    Given User provides valid username and password
    Then User validates the 'Web Orders' and click Order Button
    When User enters the product information 'MyMoney' and '4'
    When User enters the address information 'Ahmet', 'Midway Dr', 'Mount Prospect', 'IL', '60656'
    And User enters payment information '8473456701', '06/12', 'VISA'
    Then User clicks process button and validate the message 'New order has been successfully added.'