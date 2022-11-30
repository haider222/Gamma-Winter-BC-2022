Feature: New account registration

  Background:
    Given I am on register page

  Scenario: successful registration
    When I enter valid firstname
    Then I enter valid lastname
    And I enter valid Email
    And I enter valid telephone
    Then I enter valid password
    And I enter valid password confirmation
    And I check that no subscribe button is selected
    Then I click on the Privacy Policy
    And I click continue button
