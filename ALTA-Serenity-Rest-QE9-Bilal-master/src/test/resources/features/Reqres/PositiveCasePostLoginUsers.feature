Feature: Positive Case Post Login Users
  @Tugas
  Scenario: Post Login User with Valid Json
    Given Login user with valid json
    When Send request post login user
    Then Status code should be 200 OK
    And Response body token should be "QpwL5tke4Pnpja7X4"
    And Validate login user json schema