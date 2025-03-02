Feature: ESS Login scenarios

  #only created a valid ESS login test scenario and precondition
  #because testing priority is updating personal info

  @login @background
  Scenario: Valid ESS user login and navigation to update personal information
    When user enters their essUsername and essPassword
    And user clicks on login button
    Then user lands on Dashboard page
    When user selects My Info tab
    And user clicks Edit button