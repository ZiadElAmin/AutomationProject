Feature: User Registration

  Scenario: Verify that a new user can register successfully
    Given I navigate to the homepage
    When I click on Signup Login
    And I enter new name "Zzzzzzziadddd Amin" and email "zzzzzzziadddd576@gmail.com"
    And I click the Signup button
    And I fill all registration details with password "ziad2580"
    And I click Create Account
    Then I should see account created message
