Feature: Negative Case Put Update Users
  @Tugas
  Scenario Outline: Put update user
    Given Update user with invalid json and invalid parameter id <id>
    When Send request put update users
    Then Status code should be 404 not found
    And Response body name should be "bilaloke" and job is "jobless"
    Examples:
      | id                 |
      | 100000000000000000 |