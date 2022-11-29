Feature: 9.2 All sub menu are on 'My Account' page

  Background:
    Given I am logged in to the shop

  Scenario: test scenario
    When I click navigation menu item My Account
    And I click sub menu item My Account
    Then I see menu in form of table column on the right side of screen
      | My Account         |
      | Edit Account       |
      | Password           |
      | Address Book       |
      | Wish List          |
      | Order History      |
      | Downloads          |
      | Recurring payments |
      | Reward Points      |
      | Returns            |
      | Transactions       |
      | Newsletter         |
      | Logout             |