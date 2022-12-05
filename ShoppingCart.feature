Feature: Placing order functionality is working fine or not

  Scenario: Place order from the begining
    Given user is on the Home_Page
    And user click on the signin tab
    When user enters the username and password
    And user click the login button
    And user enters the hom page
    And user clicks AddtoCart for any products
    And user gets the price of that product
    And user clicks contiue shopping
    And user clicks the checkout option
    And user compares the Actuall price and Cart value
    Then place order