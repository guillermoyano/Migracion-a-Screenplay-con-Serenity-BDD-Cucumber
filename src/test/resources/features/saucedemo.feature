Feature: SauceDemo E-commerce functionality
  As a customer
  I want to interact with the SauceDemo website
  So that I can login, add products to cart, and complete purchases

  Background:
    Given the user is on the SauceDemo website

  Scenario: Successful login
    When the user logs in as a standard user
    Then the user should see the Products page

  Scenario: Complete purchase flow
    Given the user logs in as a standard user
    When the user selects a product and adds it to cart
    And the user proceeds to checkout with personal information
      | firstName | lastName | postalCode |
      | Guillermo | Moyano   | 1234       |
    And the user completes the purchase
    Then the user should see the confirmation message "THANK YOU FOR YOUR ORDER!"

  Scenario: Add multiple products and remove them from cart
    Given the user logs in as a standard user
    When the user adds multiple products to the cart
    Then the user should see the cart page
    When the user removes all products from the cart
    Then the cart should be empty

  Scenario: Logout functionality
    Given the user logs in as a standard user
    When the user logs out
    Then the user should be redirected to the login page