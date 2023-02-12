Feature: Positive Case Get Single Users
  @Tugas
  Scenario: Get single user with valid parameter
    Given Get single users with valid parameter id 2
    When Send request get single users
    Then Status code should be 200 OK
    And Validate get single user json schema
