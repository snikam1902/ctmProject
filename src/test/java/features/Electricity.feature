Feature: Electricity Supplier Comparision
  As a customer
  I want to compare electricity supplier
  So that I can get best supplier

@test1
  Scenario: Compare  Electricity supplier
    Given user is on supplier page
    When user enter postcode
    When user choose don't have electricity bill and select "Electricity only" option
    And select electricity supplier
    Then user lands on the Energy Page
    When user select no option for EconomySevenMeter
    And ender the expenses for electricity
    Then user navigate to the customer details page
    When user select interested terrif and emailId
    And agree terms and conditions
    Then  user navigate to result page
    And get best options for electricity supplier
