Feature: LCWaikiki Web Application Testing
  @ParallelTest
  Scenario: LCWaikiki Web Application
    Given Navigate To Website
    When  Verify the menu options that appear
    And   Type Jacket in the search box and search
    And   Click on the woman button
    And   Select Blazer Jacket from product type
    And   Choose size M
    And   Choose brown from the colors
    And   Click on the first of the results
    And   Click add to cart
    And   Click my cart
    And   Verify that the product has arrived in the cart
    And   Compare the subtotal to the grand total and verify that the amount is the same
    And   Delete product from cart
    And   Verify that the basket is empty
    Then  Go back to the main page and verify that you are on the page


