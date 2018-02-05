Feature: Gas and Electricity Supplier
  As a customer
  I want to compare gas and electricity supplier
  So that I can get best supplier

  @test3
  Scenario: Compare Gas and Electricity supplier
    Given user is on supplier page
    When user enter postcode
    And user choose compare "Gas and Electricity" option
    And have electricity bill,different gas and electricity supplier
    And enter all details of gas and electricity supplier
    Then user navigate to Energy Page
    When user select energy plan and method of payment for electricity
    And select don't have economy7meter
    And select electricity is not main source of heating and enter current electricity usage
    And select type of gas terrif ,method of gas payment
    And choose gas is not main source of heating and enter current gas usage
    Then user navigate to customer details page
    When user select interested terrif, interested payment type
    And enter email and agree terms and condition
    And click on next button
    Then custome lands on result page
    And get best supplier

