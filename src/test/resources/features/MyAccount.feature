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

#  Scenario Outline: User is able to see and edit his/her personal information (positive scenario)
#    When I click My Account menu in form of table on the right of screen
#    And I click "Edit your account information" on the left of screen under My Account title
#    Then I see <oldFirstName> in First Name field and change it to <newFirstName>
#    And I see <oldLastName> in Last Name field and change it to <newLastName>
#    And I see <oldEmail> in E-Mail field and change it to <newEmail>
#    And I see <oldTelephone> in Telephone field and change it to <newTelephone>
#    Then I click Continue button to save changes
#    Examples:
#      | oldFirstName | newFirstName | oldLastName | newLastName    | oldEmail            | newEmail            | oldTelephone | newTelephone |
#      | Mari         | Test_name    | Test        | Test_last_name | mari.test@yahoo.com | Test_email@test.com | 1111122222   | 12345678910  |


