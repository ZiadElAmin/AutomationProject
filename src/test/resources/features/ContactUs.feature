Feature: Contact Us Form

  Scenario: Verify that a user can submit the Contact Us form
    Given I navigate to the homepage
    When I click on Contact Us
    And I fill the contact form with name "Test User" email "test@test.com" subject "Test Subject" message "This is a test message"
    And I submit the contact form
    Then I should see contact success message
