Feature: Account summary content

  Scenario: verify title
    Given the user logged in
    Then the title should be "Zero - Account Summary"

    Scenario: account types
      Given the user logged in
      Then the title should be "Zero - Account Summary"
      And the account types should be
        | Cash Accounts       |
        | Investment Accounts |
        | Credit Accounts     |
        | Loan Accounts       |

  Scenario: column types
    Given the user logged in
    Then the title should be "Zero - Account Summary"
    And the column types under "Credit Accounts" should be such as
      | Account     |
      | Credit Card |
      | Balance     |