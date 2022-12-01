Feature: New account registration and login

  Scenario Outline: Registration - Valid credentials (8,1; 8,2) and User is on 'My Account" page after successful registration(9.1)
    When I am on register page
    And I enter valid firstname "<firstname>"
    Then I enter valid lastname "<lastname>"
    And I enter valid Email "<email>"
    And I enter valid telephone "<number>"
    Then I enter valid password "<password>"
    And I enter valid password confirmation "<confpassword>"
    And I check that no subscribe button is selected
    Then I click on the Privacy Policy
    And I click continue button
    And I see confirmation page with message "Your Account Has Been Created!"
    And I click continue button to complete registration
    And I see My Account heading in large font on the left side of the screen
    Examples:
      | firstname | lastname | email             | number  | password | confpassword |
      | Tom       | Doe      | t.doe55@gmail.com | 1234567 | qwerty   | qwerty       |

  Scenario Outline: Login -Valid credentials(8,5)
    When I am on Login page
    Then I am logged in with "<email>" and "<password>"
    Examples:
      | email             | password |
      | t.doe55@gmail.com | qwerty   |

  Scenario Outline: Registration info is the same as in account page (8,6)
    When I am logged in with "<email>" and "<password>"
    Then I go to the My Account Information page
    Then I see registration data in fields:
      | firstName | <firstname> |
      | lastName  | <lastname>  |
      | email     | <email>     |
      | number    | <number>    |
    Examples:
      | firstname | lastname | email             | number  | password |
      | Tom       | Doe      | t.doe22@gmail.com | 1234567 | qwerty   |

  Scenario: Registration - input fields are mandatory (8,4)
    When I am on register page
    Then I input all fields and do not mark Privacy Policy
    And I click continue button
    And I see Privacy Policy warning message
    Then I mark Privacy Policy and delete Firstname
    And I click continue button
    And I see Firstname warning message
    Then I input Firstname and delete Lastname
    And I click continue button
    And I see Lastname warning message
    Then I input Lastname and delete email
    And I click continue button
    And I see email warning message
    Then I input email and delete Telephone
    And I click continue button
    And I see Telephone warning message
    Then I input Telephone and delete Password
    And I click continue button
    And I see Two Password warning messages
    Then I input Password and delete Confirmation Password
    And I click continue button
    And I see Confirmation Password warning message


