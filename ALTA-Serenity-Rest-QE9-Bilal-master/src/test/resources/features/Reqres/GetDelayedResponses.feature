Feature: Negative Case Get Delayed Response
  @Tugas
  Scenario: Get Delayed Response
    Given Get user with valid page 2
    When Send request get delayed response
    Then Status code should be 200 OK
    And Validate get delayed response json schema