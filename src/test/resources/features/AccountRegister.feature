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
      | Tom       | Doe      | t.doe89@gmail.com | 1234567 | qwerty   | qwerty       |

  Scenario Outline: Login -Valid credentials(8,5)
    When I am on Login page
    Then I am logged in with "<email>" and "<password>"
    Examples:
      | email             | password |
      | t.doe89@gmail.com | qwerty   |

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
      | Tom       | Doe      | t.doe89@gmail.com | 1234567 | qwerty   |

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

  Scenario Outline: Registration - Invalid credentials (8,3)
    When I am on register page
    Then I input valid data and invalid Email without @ symbol "<wrongemail>"
    And I click continue button
    Then I see disappearing "<warning>" prompt that matches errors in "<wrongemail>"
    Then I input valid email and invalid Telephone with only two numbers "<telephoneless>"
    And I click continue button
    And I see registration failed and error telephone message
    Then I change Telephone for thirty three numbers "<telephonemore>"
    And I click continue button
    And I see registration failed and error telephone message
    Then I input valid Telephone and invalid Password with only three char "<wrongpass>"
    And I click continue button
    And I see registration failed and error password and confpassword messages
    Then I input valid Password and invalid ConfPassword with only three char "<wrongconfpass>"
    And I click continue button
    And I see registration failed and error confpassword message

    Examples:
      | telephonemore                     | telephoneless | wrongpass | wrongconfpass | wrongemail    | warning                                                                             |
      | 123456789123456789123456789123456 | 12            | qwe       | qwe           | Test_emailtest.com | Please include an '@' in the email address. 'Test_emailtest.com' is missing an '@'. |


