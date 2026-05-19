Feature: User Login

  Scenario: Verify that a registered user can log in successfully
    Given I navigate to the homepage
    When I click on Signup Login
    And I enter valid email "testuser123@mailinator.com" and password "Test@1234" and click Login
    Then I should be logged in as "TestUser123"

  Scenario: Verify that login fails with incorrect credentials
    Given I navigate to the homepage
    When I click on Signup Login
    And I enter wrong email "wrong@email.com" and wrong password "wrongPass" and click Login
    Then I should see login error message
