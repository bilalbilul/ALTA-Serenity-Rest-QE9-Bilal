Feature: Positive Case Patch Update Users
  @Tugas
  Scenario Outline: Patch update user with valid json
    Given Patch Update user with valid json and parameter id <id>
    When Send request patch update users
    Then Status code should be 200 OK
    And Response body name should be "<name>" and job is "<job>"
    Examples:
      | id | name  | job           |
      | 2  | Bilal | QE Automation |