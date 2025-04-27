# Created by augusthansen at 26/04/2025
Feature: A user can register time on an activity


#  Scenario: A user registers time on an activity successfully
#    Given an employee with ID "bano" exists
#    And an activity with ID "ana1" exists for employee "bano"
#    When the employee "bano" registers 5 hours on activity "ana1"
#    Then the system should show that 5 hours are logged for activity "ana1"
#
#
#  Scenario: A user tries to register time on an activity that does not exist
#    Given an employee with ID "bano" exists
#    But no activity with ID "fakeActivity" exists for employee "bano"
#    When the employee "bano" tries to register 3 hours on activity "fakeActivity"
#    Then the system should return an error: "Activity does not exist."
#
#
#  Scenario: Registering time on an employee that does not exist
#    Given no employee with ID "ghost" exists
#    When the employee "ghost" tries to register 2 hours on activity "ana1"
#    Then the system should return an error: "Employee not found."
#
#  Scenario: Registering negative hours
#    Given an employee with ID "bano" exists
#    And an activity with ID "ana1" exists for employee "bano"
#    When the employee "bano" tries to register -4 hours on activity "ana1"
#    Then the system should return an error: "Invalid number of hours."
#
#
#  Scenario: Registering zero hours
#    Given an employee with ID "bano" exists
#    And an activity with ID "ana1" exists for employee "bano"
#    When the employee "bano" tries to register 0 hours on activity "ana1"
#    Then the system should return an error: "Invalid number of hours."