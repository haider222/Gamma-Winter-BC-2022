Feature: User is able to access and manipulate with account

  Background:
    Given I am logged in to the shop

  Scenario: All sub menu are on 'My Account' page (9.2)
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


  Scenario Outline: User is able to see and edit his/her personal information (10.1 positive scenario)
    When I click My Account menu in form of table on the right of screen
    And I click "Edit your account information" on the left of screen under My Account title
    Then I change data in form fields:
      | firstName | <newFirstName> |
      | lastName  | <newLastName>  |
      | eMail     | <newEmail>     |
      | telephone | <newTelephone> |
    And I click Continue button to save changes
    Examples:
      | newFirstName | newLastName    | newEmail            | newTelephone |
      | Test_name    | Test_last_name | Test_email@test.com | 12345678910  |

#      | oldFirstName | newFirstName | oldLastName | newLastName    | oldEmail            | newEmail            | oldTelephone | newTelephone |
#      | Mari         | Test_name    | Test        | Test_last_name | mari.test@yahoo.com | Test_email@test.com | 1111122222   | 12345678910  |


