Feature: User is able to manipulate with address book

  Background:
    Given I am logged in to the shop


  Scenario Outline: Add new address (11,1;11,2)
    When I see My Account heading in large font on the left side of the screen
    Then I click to Modify my address
    And I click on New Address Button
    And I see the mandatory input field are availiable
    Then I enter new firstname "<firstname>"
    And I enter new lastname "<lastname>"
    And I enter new address "<address>"
    Then I enter new city "<city>" and postcode "<postcode>"
    And I choose country name "<mycountry>" from dropdown
    And I choose region "<region>" from dropdown
    Then I click Yes to use address as defoult
    And I press Continue button
    Examples:
      | firstname | lastname | address       | city   | mycountry | region | postcode |
      | Sarah     | Tomson   | Test street 6 | Qwerty | Albania   | Kukes  | ZXC123   |

  Scenario Outline: Additional address adding (11,3)
    When I click to Modify my address
    And I click on New Address Button
    And I see the mandatory input field are availiable
    Then I enter new firstname "<firstname>"
    And I enter new lastname "<lastname>"
    And I enter new address "<address>"
    Then I enter new city "<city>" and postcode "<postcode>"
    And I choose country name "<mycountry>" from dropdown
    And I choose region "<region>" from dropdown
    And I press Continue button
    Examples:
      | firstname | lastname | address       | city   | mycountry | region | postcode |
      | Bob       | Johnson  | Test street 2 | Zxcvbn | Togo      | Kara   | 12365DC  |

  Scenario: Back button functionality (11,5)
    When I click to Modify my address
    And I click on New Address Button
    Then I click on Back button
    And I check that I am on address page

  Scenario: Address - input fields are mandatory (11,6)
    When I click to Modify my address
    And I click on New Address Button
    Then I fill in all fields except Firstname
    And I press Continue button
    And I see firstname error message
    Then I fill Firstname field and delete Lastname
    And I press Continue button
    And I see Lastname error message
    Then I fill Lastname and delete Address
    And I press Continue button
    And I see Address error message
    Then I fill Address and delete City
    And I press Continue button
    And I see City error message
    Then I fill City and clear Country dropdown
    And I press Continue button
    And I see Country error message
    Then I fill Country and do not fill Region
    And I press Continue button
    And I see Region error message





  Scenario Outline: Edit address
    When I select address as by data below and click corresponding Edit button
      | firstName | <firstName> |
      | lastName  | <lastName>  |
      | address   | <address>   |
      | city      | <city>      |
      | postCode  | <postCode>  |
      | country   | <country>   |
      | region    | <region>    |
    Examples:
      | firstName | lastName   | address   | city   | postCode   | country | region |
      | MyName    | MyLastName | MyAddress | MyCity | myPostCode | China   | Gansu  |

