Feature: Reqres API Testing Automation QE Batch 9
  @Latihan
  Scenario Outline: Get list user with valid parameter
    Given get list users with valid parameter page <page>
    When Send request get list users
    Then Status code should be 200 OK
    And Response body page should be <page>
    Examples:
      | page |
      | 1    |
      | 2    |

  @Latihan
  Scenario: Get list user with json schema
    Given get list users with valid parameter page 2
    When Send request get list users
    Then Status code should be 200 OK
    And Validate get list user json schema

  @Latihan
  Scenario: Post create new user
    Given Create new user with valid json
    When Send request post create users
    Then Status code should be 201 Created
    And Response body name should be "Muhammad Bilal" and job is "QE Automation"

  @Latihan
  Scenario Outline: Put update user
    Given Update user with valid json and parameter id <id>
    When Send request put update users
    Then Status code should be 200 OK
    And Response body name should be "Muhammad Bilal" and job is "QE Automation"
    Examples:
      | id |
      | 1  |
      | 2  |

  @Latihan
  Scenario Outline: Delete User with valid parameter id
    Given Delete user with valid id <id>
    When Send request delete users
    Then Status code should be 204 no content
    Examples:
      | id |
      | 1  |
      | 2  |
