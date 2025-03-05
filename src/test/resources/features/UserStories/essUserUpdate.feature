Feature: Updating ESS user personal details scenarios

  Background:
    #all background is coming from essLogin.feature
    #essUsername and #essPassword will need to be updated in config properties for ESS user

    #Given user is able to navigate to HRMS login page
    When user enters their essUsername and essPassword
    And user clicks on login button
    Then user lands on Dashboard page
    When user selects My Info tab
    And user clicks Edit button

  @negative_test
  Scenario: Required fields firstname and lastname must have data
    When user enters "" and "" in the firstname and lastname
    And user clicks save button
    Then user gets an error message Required for firstname
    Then user gets an error message Required for lastname

  @positive_test
  Scenario: Optional field middle name can be empty
    When  user enters "" in middlename field
    And user clicks save button
    Then Personal details are updated successfully


  @positive_test
  Scenario: User is able to update personal details
    And user enters data "Hamdi" and "M." and "Ziad"
    When user selects their gender "Male"
    And user selects their nationality "British"
    And user selects their marital status "Single"
    And user clicks save button
    Then Personal details are updated successfully