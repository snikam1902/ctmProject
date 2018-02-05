Feature: Gas Supplier Comparision
  As a customer
  I want to compare Gas supplier
  So that I can get best supplier
  @test2
  Scenario: Compare Gas supplier
    Given user is on supplier page
    When user enter postcode
    And user  have electricity bill and select "Gas only" option
    And select Gas supplier and click next button
    Then user navigate to the Energy Page
    When user select terrif type and payment options
    And selct gas is not main source of heating
    And enter current gas usage , click next button
    Then user navigate to the customer details page
    When user select interested terrif and interested payment method
    And enter  emailId
    And agree terms and conditions
    Then  user navigate to result page
    And get best options for gas supplier
