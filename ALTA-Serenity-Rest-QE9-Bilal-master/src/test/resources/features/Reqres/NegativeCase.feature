Feature: Tugas Reqres API Testing Automation QE Batch 9 - Negative Case
  @Tugas
  Scenario Outline: Get list user with invalid parameter
    Given Get list users with invalid parameter page <page>
    When Send request get list users
    Then Status code should be 404 not found
    And Response body page should be <page>
    Examples:
      | page                     |
      | 112413524635747443546436 |
      |                          |

  @Tugas
  Scenario: Post create new user
    Given Create new user with invalid json
    When Send request post create users
    Then Status code should be 201 bad request
    And Response body name should be "bilaloke" and job is "jobless"

  @Tugas
  Scenario Outline: Put update user
    Given Update user with invalid json and parameter id <id>
    When Send request put update users
    Then Status code should be 200 OK
    And Response body name should be "bilaloke" and job is "jobless"
    Examples:
      | id                 |
      | 100000000000000000 |
      |                    |

  @Tugas
  Scenario Outline: Delete user with invalid parameter
    Given Delete user with invalid id <id>
    When Send request delete users
    Then Status code should be 404 not found
    Examples:
      | id   |  |
      | !@#$ |  |
      |      |  |
