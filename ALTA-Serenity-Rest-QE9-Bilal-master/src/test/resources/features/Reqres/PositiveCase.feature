Feature: Tugas Reqres API Testing Automation QE Batch 9 - Positive Case
  @Tugas
  Scenario Outline: Get single user with valid parameter
    Given Get single users with valid parameter id <id>
    When Send request get single users
    Then Status code should be 200 OK
    Examples:
      | id |
      | 1  |
      | 2  |

  @Tugas
  Scenario: Post Register User with Valid Json
    Given Register user with valid json
    When Send request post register user
    Then Status code should be 200 OK
    And Response body id should be 4

  @Tugas
  Scenario: Post Login User with Valid Json
    Given Login user with valid json
    When Send request post login user
    Then Status code should be 200 OK
    And Response body token should be "QpwL5tke4Pnpja7X4"

  @Tugas
  Scenario: Patch update user with valid json
    Given Patch Update user with valid json and parameter id 2
    When Send request patch update users
    Then Status code should be 200 OK
    And Response body name should be "Bilal" and job is "QE Automation"

