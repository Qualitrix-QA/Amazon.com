Feature: Amazon Purchase Flow
  Scenario: Purchase an item from Amazon
    Given user launches the application
    When user logs in with username "testuser" and password "testpassword"
    And user searches for "Laptop"
    And user adds item to the cart
    Then user navigates to checkout