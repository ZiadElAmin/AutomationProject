Feature: User Logout

  Scenario: Verify that a logged in user can log out successfully
    Given I navigate to the homepage
    And I am logged in with email "testuser123@mailinator.com" and password "Test@1234" for logout
    When I click Logout
    Then I should be redirected to the Login page