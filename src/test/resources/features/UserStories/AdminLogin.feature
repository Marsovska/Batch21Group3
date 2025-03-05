Feature: Admin User Login for HRMS Application

  Background:
    ##Given the user is on the login page

  @regression @positive_test @admin_login @juan @juan1
  Scenario: Successful Login with Valid Credentials
    When the user enters valid admin credentials
    And the user clicks the login button
    Then the user should be redirected to the admin "dashboard" page

  @regression @negative_test @admin_login @juan
  Scenario: Login Failure with Invalid Username
    When the user enters invalid username and valid password
    And the user clicks the login button
    Then an error message "Invalid credentials" should be displayed

  @regression @negative_test @admin_login @juan
  Scenario: Login Failure with Invalid Password
    When the user enters valid username and invalid password
    And the user clicks the login button
    Then an error message "Invalid credentials" should be displayed

  @regression @negative_test @admin_login @juan
  Scenario: Login Failure with Empty Username
    When the user leaves the username field empty
    And the user clicks the login button
    Then an error message "Username cannot be empty" should be displayed

  @regression @negative_test @admin_login @juan
  Scenario: Login Failure with Empty Password
    When the user leaves the password field empty
    And the user clicks the login button
    Then an error message "Password is Empty" should be displayed