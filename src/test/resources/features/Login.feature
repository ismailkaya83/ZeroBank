Feature: Login functionality

  Scenario:login with valid credentials
    Given the user logged in
    Then the "Account Summary" page should be displayed

  Scenario Outline: login with invalid credentials
    When enter invalid "<username>" and "<password>"
    Then Login error message "Login and/or password are wrong." should be displayed
    Examples:
      | username | password |
      |          | password |
      | username |          |
      | wrong    | wrong    |
      | username | wrong    |
      | wrong    | password |
      |          |          |
