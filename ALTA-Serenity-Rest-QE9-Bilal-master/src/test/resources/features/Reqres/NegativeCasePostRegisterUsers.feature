Feature: Negative Case Post Register Users
@Tugas
Scenario: Register user with empty password
  Given User register with empty password
  When Send request post register user
  Then Status code should be 400 bad request
  And Response body message should be "Missing password"
  And Validate register empty password json schema

@Tugas
Scenario: Register user with empty email
  Given User register with empty email
  When Send request post register user
  Then Status code should be 400 bad request
  And Response body message should be "Missing email or username"
  And Validate register empty email json schema