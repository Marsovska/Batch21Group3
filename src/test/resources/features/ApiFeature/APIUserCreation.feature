Feature: API User creation


  @api @post
  Scenario: Creating User using valid credentials
    Given Request is prepared using dynamic payload
    When Post call is send for user creation
    Then the status code received is 201
    And the response "Message" is "User Created"


  @api @existingEmail
  Scenario: Creating new User with already registered email address
    Given Request is prepared using dynamic payload
    When Post call is send for user creation
    Then the status code received is 200
    And the response "Message" is "The email address you have entered is already registered"

  @api @invalidEmail
  Scenario: Creating user with invalid email
    Given Request is prepared with invalid email using dynamic payload
    When Post call is send for user creation
    Then the status code received is 400
    And the response "condition" is "error"
    And the response "data" is "Invalid Email"

  @api @emptyPassword
  Scenario: Creating user without providing password
    Given Request is prepared without password using dynamic payload
    When Post call is send for user creation
    Then the status code received is 400
    And the response "condition" is "error"
    And the response "data" is "Please fill all inputs"

  @api @emptyName
  Scenario: Creating user without providing name
    Given Request is prepared without name using dynamic payload
    When Post call is send for user creation
    Then the status code received is 400
    And the response "condition" is "error"
    And the response "data" is "Please fill all inputs"