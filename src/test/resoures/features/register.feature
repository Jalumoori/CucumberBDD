@all @Register
Feature: Validate Register functionality

  Background: 
    Given I am on the AUT Homepage

  @Valid
  Scenario: Validate Register functionality with valid all data
    When I navigate to Register page
    And I enter all the valid details
      | firstName        | abcdef |
      | lastName         | abcdef |
      | phone            | 123456 |
      | password         | abcdef |
      | Password_Confirm | abcdef |
    And I enter valid "<email>"
    And click on privacy policy "yes"
    And I click on continue
    Then I should see account created success message

  Scenario Outline: Validate Register functionality with duplicate Email_id
    When I navigate to Register page
    And I enter all the valid details
      | firstName        | abcdef |
      | lastName         | abcdef |
      | phone            | 123456 |
      | password         | abcdef |
      | Password_Confirm | abcdef |
    And I enter duplicate <email>
    And click on privacy policy "yes"
    And I click on continue
    Then I should see email already registered message

    Examples: 
      | email                |
      | abcdef2220@gmail.com |

  @RunThisScenario
  Scenario: Validate Register functionality with no details
    When I navigate to Register page
    And click on privacy policy "yes"
    And I click on continue
    Then I should see warning message
