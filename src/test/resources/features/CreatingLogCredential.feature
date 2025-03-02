Feature: Creating Login details in HRMS Application

  Background:
    ##Given admin is able to navigate to HRMS login page
    When admin enter login credentials and submits
    Then admin lands "Dashboard" page
    And admin click on PIM tab
    And admin click on AddEmployee tab


  @regression @positive_test
  Scenario: Admin creates access credential for new employee
    When admin enter "Billy", "" and "Idol"
    When admin check Create Login Details box
    Then admin sees clear rule message about password
    When admin set "RebeolllYuel", "RebelSynt@x3222", "RebelSynt@x3222" as user credentials
    When admin make sure status is enabled
    When admin click save button
    Then admin ends on "Personal Details" page
    Then the system should automatically generate employee ID
    Then admin logs out
    Then employee shall be able to login with "RebeolllYuel", "RebelSynt@x3222" and get "Welcome Billy" message

  @regression @negative_test
  Scenario:Admin ensures password and re-enter password must be a match
    When admin enter "Billy", "" and "Idol"
    When admin check Create Login Details box
    When admin set "RebellYel", "RebelSynt@x12", "RebelSynt@x123" as user credentials
    When admin click save button
    Then admin shall get an error message "Passwords do not match"

  @regression @negative_test @otherOption
  Scenario: To Create Login Credential Admin need to fill up mandatory fields
    When admin enter "", "Billy" and ""
    When admin check Create Login Details box
    Then admin sees clear rule message about password
    When admin set "RebellYuel", "RebelSynt@x12", "RebelSynt@x12" as user credentials
    When admin make sure status is enabled
    When admin click save button
    Then admin gets an error message "Required"

  @regression @negative_test @thirdOption
  Scenario: Admin Cannot Create Login Credential while Status is Disabled
    When admin enter "Marry", "" and "Jane"
    When admin check Create Login Details box
    Then admin sees clear rule message about password
    When admin set "MarryJane", "Synt@xBatch30", "Synt@xBatch30" as user credentials
    Then admin set Status as Disabled
    When admin click save button
    Then admin logs out
    Then employee shall not be able to login using "MarryJane", "Synt@xBatch30" as credentials
    And employee will get "Account disabled" error message