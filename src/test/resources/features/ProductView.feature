Feature: Products Page

  Scenario: Verify all products are listed and product detail page works
    Given I navigate to the homepage
    When I navigate to Products page
    Then I should see all products listed
    When I click View Product on the first product
    Then I should see the product detail page