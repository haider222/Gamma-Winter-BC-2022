Feature: New account registration and login

  Scenario Outline: Registration - Valid credentials (8.3) and User is on 'My Account" page after successful registration(9.1)
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
      | firstname | lastname | email           | number  | password | confpassword |
      | Tom       | Doe      | t.doe10@gmail.com | 1234567 | qwerty   | qwerty       |

  Scenario Outline: Login -Valid credentials(8.7)
    When I am on Login page
    Then I am logged in with "<email>" and "<password>" and click Login
    Examples:
      | email           | password |
      | t.doe@gmail.com | qwerty   |

  Scenario Outline: Registration info is the same as in account page (8.8)
    When I am logged in with "<email>" and "<password>" and click Login
    Then I go to the My Account Information page
    And I see filled inputs with registration info
    Examples:
      | email           | password |
      | t.doe@gmail.com | qwerty   |