Feature: Reqres API Testing Automation QE Batch 9
  Scenario: Get list user with valid parameter
    Given get list users with valid parameter page 2
    When Send request get list users
    Then Status code should be 200 OK
    And Response body page should be 2

  Scenario: Post create new user
    Given Create new user with valid json
    When Send request post create users
    Then Status code should be 201 Created
    And Response body name should be "Muhammad Bilal" and job is "QE Automation"