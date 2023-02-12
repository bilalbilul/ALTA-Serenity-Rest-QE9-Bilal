Feature: Negative Case Get Single Users Unknown
  @Tugas
  Scenario: Get single users unknown
    Given Get single users unknown with parameter 2
    When Send request get single users unknown
    Then Status code should be 200 OK