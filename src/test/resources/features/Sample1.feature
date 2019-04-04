Feature: Introduction to cucumber part 1
  As a test engineer
  I want to be able to write and execute a simple scenario

  @t1 @test @bug @regression @loginPage
  Scenario: Simple scenario
    When I am on the home page
    Then I should see home page header
    And I should see home page description
    And I should see menu

  @t1 @t2 @ignore
  Scenario: Sample 1 individual task
    When I open styles page
    Then correct header is seen

  @t2
  Scenario: a new scenario 1 with regex
    When I enter name: "Ann"
    And I enter age: 5
    And I click submit age
    Then I see message: "Hello, Ann, you are a kid"