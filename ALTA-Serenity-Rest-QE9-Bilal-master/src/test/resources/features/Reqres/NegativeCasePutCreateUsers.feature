Feature: Negative Case Put Create Users
  @Tugas
  Scenario: Post create new user
    Given Create new user with invalid json
    When Send request post create users
    Then Status code should be 400 bad request
    And Response body name should be "bilaloke" and job is "jobless"