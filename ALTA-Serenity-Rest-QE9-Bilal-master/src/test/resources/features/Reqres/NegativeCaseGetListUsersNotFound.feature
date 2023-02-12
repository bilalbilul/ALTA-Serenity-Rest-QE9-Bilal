Feature: Negative Case Get List Users Not Found
  @Tugas
  Scenario: Get list user with invalid parameter
    Given Get list users with invalid parameter page 23
    When Send request get list users not found
    Then Status code should be 404 not found
    And Validate get list user not found json schema