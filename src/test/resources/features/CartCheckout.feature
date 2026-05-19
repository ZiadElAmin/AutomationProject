Feature: Cart and Checkout

  Scenario: Verify user can add a product to cart and complete checkout
    Given I navigate to the homepage
    And I am logged in with email "testuser123@mailinator.com" and password "Test@1234"
    When I go to the Products page
    And I hover over a product and add it to cart
    And I click Continue Shopping
    And I open the Cart
    Then the cart should have at least one product
    When I click Proceed To Checkout
    Then I should see the delivery address
    When I enter comment "Please deliver ASAP" and click Place Order
    And I fill payment details name "Test User" card "4111111111111111" cvc "123" month "12" year "2025"
    And I click Pay and Confirm Order
    Then I should see Order Placed confirmation
