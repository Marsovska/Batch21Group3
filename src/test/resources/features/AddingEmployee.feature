Feature: Adding an Employee to the HRMS Application

  Background:
    Given the user is on the login page
    When the user enters valid admin credentials
    And the user clicks the login button
    Then the user should be redirected to the admin "dashboard" page
    And the user navigates to the PIM tab
    And the user clicks on the Add Employee tab

  @regression @positive_test @add_employee
  Scenario: Add an employee without providing an employee ID
    When the user enters "John", "", "Doe" as employee details
    And the user clicks the save button
    Then the system should generate a unique employee ID
    And the employee record should be saved in the database

  @regression @positive_test @add_employee
  Scenario: Add an employee with a provided employee ID
    When the user enters "Jane", "", "Smith" as employee details
    And the user provides "EMP12345" as the employee ID
    And the user clicks the save button
    Then the system should save the employee with the provided ID
    And the employee record should be saved in the database

  @regression @negative_test @add_employee
  Scenario: Add an employee with incomplete details
    When the user enters "", "", "" as employee details
    And the user clicks the save button
    Then the user should see an error message "Required"