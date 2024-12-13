Feature: Amazon Purchase Flow
  To verify various scenarios of searching, adding items to the cart, and navigating to checkout on Amazon.

  Scenario: Successful purchase flow on Amazon
    Given user launches the application
    When user logs in with username "testuser" and password "testpassword"
    And user searches for "Laptop"
    And user adds item to the cart
    Then user navigates to checkout

  Scenario: Invalid login attempt
    Given user launches the application
    When user logs in with username "invaliduser" and password "wrongpassword"
    Then the login should fail with an error message

  Scenario Outline: Parameterized search and add-to-cart flow
    Given user launches the application
    When user logs in with username "<username>" and password "<password>"
    And user searches for "<item>"
    And user adds item to the cart
    Then user navigates to checkout

    Examples:
      | username      | password      | item         |
      | testuser1     | testpassword1 | Laptop       |
      | testuser2     | testpassword2 | Smartphone   |
      | testuser3     | testpassword3 | Headphones   |

  Scenario: Search and add multiple items to the cart
    Given user launches the application
    When user logs in with username "testuser" and password "testpassword"
    And user searches for "Laptop"
    And user adds item to the cart
    And user searches for "Smartphone"
    And user adds item to the cart
    Then user navigates to checkout
