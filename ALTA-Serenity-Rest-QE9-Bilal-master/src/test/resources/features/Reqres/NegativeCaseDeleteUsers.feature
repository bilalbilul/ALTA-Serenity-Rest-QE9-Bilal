Feature: Negative Case Delete Users
  @Tugas
  Scenario Outline: Delete user with invalid parameter
    Given Delete user with invalid id <id>
    When Send request delete users
    Then Status code should be 404 not found
    Examples:
      | id                 |
      | 100000000000000000 |