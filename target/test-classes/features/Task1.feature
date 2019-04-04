Feature: individual task create 1 scenario outline and 1 scenario for page with url: https://kristinek.github.io/site/tasks/enter_a_number
  As a test engineer

  Background:
    Given I am on Enter a number page

  Scenario Outline: for error cases
    When I enter: "<number>"
    And I click submit
    Then I see error message: "<message>"

  @test
    Examples:
      | number | message                      |
      | 0      | Number is too small          |
      | 48     | Number is too small          |
      | 101    | Number is too big            |
      | Kate   | Please enter a number        |
      |        | You haven't entered anything |

  @test2
  Scenario: for correct numbers
    When I enter: "64"
    And I click submit
    Then I see alert with result: "Square root of 64 is 8.00"







