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
    And I click Continue button to save data
    And I see message "Success: Your account has been successfully updated." in My Account page
    And I see message is in filled light-green box "rgba(223, 240, 216, 1)" with dark-green font "rgba(60, 118, 61, 1)"
    When I click "Edit your account information" on the left of screen under My Account title
    Then I see previously updated data in form fields:
      | firstName | <newFirstName> |
      | lastName  | <newLastName>  |
      | eMail     | <newEmail>     |
      | telephone | <newTelephone> |
    And I click Continue button to save data
    And I see message "Success: Your account has been successfully updated." in My Account page
    And I see message is in filled light-green box "rgba(223, 240, 216, 1)" with dark-green font "rgba(60, 118, 61, 1)"
    When I click Edit Account menu, in form of table on the right of the screen
    Then I see previously updated data in form fields:
      | firstName | <newFirstName> |
      | lastName  | <newLastName>  |
      | eMail     | <newEmail>     |
      | telephone | <newTelephone> |
    When Click Back button to avoid changes
    Then I do not see any message on top of My Account title on My Account page
    When I click Edit Account menu, in form of table on the right of the screen
    Then I see previously updated data in form fields:
      | firstName | <newFirstName> |
      | lastName  | <newLastName>  |
      | eMail     | <newEmail>     |
      | telephone | <newTelephone> |
    Then I change data in form fields one more time:
      | firstName | <updatedFirstName> |
      | lastName  | <updatedLastName>  |
      | eMail     | <updateEmail>      |
      | telephone | <updatedTelephone> |
    And Click Back button to avoid changes
    And I do not see any message on top of My Account title on My Account page
    When I click Edit Account menu, in form of table on the right of the screen
    Then I do not see data from the last update
      | firstName | <updatedFirstName> |
      | lastName  | <updatedLastName>  |
      | eMail     | <updateEmail>      |
      | telephone | <updatedTelephone> |
    And Instead I see data from earlier update
      | firstName | <newFirstName> |
      | lastName  | <newLastName>  |
      | eMail     | <newEmail>     |
      | telephone | <newTelephone> |

    Examples:
      | newFirstName | newLastName    | newEmail            | newTelephone | updatedFirstName | updatedLastName | updateEmail | updatedTelephone |
      | Test_name    | Test_last_name | Test_email@test.com | 12345678910  | Test_name1       | Test_last_name1 | Test_email1 | 222222222222220  |

#      | oldFirstName | newFirstName | oldLastName | newLastName    | oldEmail            | newEmail            | oldTelephone | newTelephone |
#      | Mari         | Test_name    | Test        | Test_last_name | mari.test@yahoo.com | Test_email@test.com | 1111122222   | 12345678910  |


