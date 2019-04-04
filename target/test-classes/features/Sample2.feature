Feature: Introduction to cucumber part 2
  As a test engineer
  I want to be able to write and execute a scenario with parameters

  Background:
    Given I am on age page

  Scenario: a new scenario 1 with regex
    When I enter name: "Ann"
    When I enter name: Kate
    And I enter age: 5
    And I click submit age
    Then I see message: "Hello, Ann, you are a kid"

  Scenario: a new scenario 2 with regex
    When I enter name: "Bob"
    And I enter age: 61
    And I click submit age
    Then I see message: "Hello, Bob, you are an adult"

  Scenario: a new scenario 3 with regex
    Given  I open action page
    And I enter number 7 in number field
    And I click Result
    Then I see text: "You entered number: "7""

