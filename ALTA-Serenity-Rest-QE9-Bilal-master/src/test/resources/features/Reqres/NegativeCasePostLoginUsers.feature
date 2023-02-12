Feature: Negative Case Post Login Users
  @Tugas
  Scenario: User login with empty password
    Given Send login with empty password
    When Send request post login user
    Then Status code should be 400 bad request
    And Response body message should be "Missing password"
    And Validate empty password json schema

  @Tugas
  Scenario: User login with empty email
    Given Send login with empty email
    When Send request post login user
    Then Status code should be 400 bad request
    And Response body message should be "Missing email or username"
    And Validate empty email json schema