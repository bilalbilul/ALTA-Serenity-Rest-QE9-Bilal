Feature: Positive Case Post Register Users
  @Tugas
  Scenario: Post Register User with Valid Json
    Given Register user with valid json
    When Send request post register user
    Then Status code should be 200 OK
    And Response body id should be 4 and token is "QpwL5tke4Pnpja7X4"

  @Tugas
  Scenario: Register user with json schema
    Given Register user with valid json
    When Send request post register user
    Then Status code should be 200 OK
    And Response body id should be 4 and token is "QpwL5tke4Pnpja7X4"
    And Validate register user json schema
