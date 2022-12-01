Feature: User is able to manipulate with address book

  Background:
    Given I am logged in to the shop

  Scenario Outline: Add new address
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
      | Sarah     | Tomson   | Test street 1 | Qwerty | Turkey    | Ankara | ZXC123   |


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

