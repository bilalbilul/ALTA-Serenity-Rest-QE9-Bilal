Feature: Negative Case Get Single Users
  @Tugas
  Scenario: Get single user with string parameter
    Given Get single users with string parameter "ok"
    When Send request get single users
    Then Status code should be 404 not found
    And Validate get single user json schema

  @Tugas
  Scenario: Get single user with blank parameter
    Given Get single users with blank parameter id <id>
    When Send request get single users
    Then Status code should be 404 not found