Feature: Only authorized users should be able to login
@wip
  Scenario:login with valid credentials
    Given the user is on the login page
    When the user logs in using valid credentials
    Then the "Account Summary" page should be displayed