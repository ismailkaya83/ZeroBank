Feature: Navigating to specific accounts in Accounts Activity

  Background:
    Given the user logged in

  Scenario Outline: Savings account redirect
    When the user clicks on "<link>" on the Account Summary page
    Then the "Account Activity" page should be displayed
    And Account drop down should have "<selected>" selected

    Examples:
      | link        | selected    |
      | Savings     | Savings     |
      | Brokerage   | Brokerage   |
      | Checking    | Checking    |
      | Credit Card | Credit Card |
      | Loan        | Loan        |