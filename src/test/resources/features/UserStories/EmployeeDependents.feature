#Feature: As an employee or admin, I want to be able to add dependents to an employee's profile
 # within the HRMS application, So that dependent information is accurately recorded and easily accessible.

  #Background:
   # Given user is logged into HRMS application
    #And user navigates to employee profile with Id "13841171"
    #And user clicks on the Dependents tab

  #@positive @draz
  #Scenario: Adding a dependent with valid information
   # When user clicks on "Add" button
    #And user enters dependent name "David Smith"
    #And user selects relationship "Child" from dropdown
    #And user selects date of birth "2005-02-27"
    #And user clicks on "Save" button
    #Then the dependent should appear in the dependents list
    #And database should reflect the new dependent

  #@negative @draz
  #Scenario Outline: System shows validation messages for missing fields
   # When user clicks on "Add" button
    #And user enters dependent with name "<Name>", relationship "<Relation>" and birth date "<DOB>"
    #And user clicks on "Save" button
    #Then system shows error message "<Error>"

    #Examples:
     # | Name      | Relation | DOB        | Error                     |
      #|           | Sibling  | 2005-02-27 | Name is required          |
      #| John Cena |          | 2005-02-27 | Relationship is required  |
      #| Paul      | Parent   |            | Date of Birth is required |

  #@positive @draz
  #Scenario: Editing an existing dependent
   # When user clicks on "Add" button
    #And user enters dependent name "David Smith"
    #And user selects relationship "Child" from dropdown
    #And user selects date of birth "2005-02-27"
    #And user clicks on "Save" button
    #And user clicks on "Edit" button for dependent "David Smith"
    #And user selects relationship "Other" from dropdown
    #And user clicks on "Save" button
    #Then the dependent should appear in the dependents list
    #And database should reflect the new dependent

  #@positive @draz
  #Scenario: Removing a dependent
   # When user clicks on "Add" button
    #And user enters dependent name "David Smith"
    #And user selects relationship "Child" from dropdown
    #And user selects date of birth "2005-02-27"
    #And user clicks on "Save" button
    #And user clicks on "Delete" button for dependent "David Smith"
    #And user clicks on "Delete" button in confirmation dialog
    #Then the dependent should no longer appear in the list
