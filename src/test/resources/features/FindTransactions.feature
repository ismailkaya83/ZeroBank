Feature: Find Transactions in Account Activity

  Background:
    Given the user logged in
    When navigate to "Account Activity" page
    Then navigate to "Find Transactions" sub page

  Scenario: Search date range
    When the user enters date range from "2012-09-01" to "2012-09-06" and click search
    Then results table should only show transactions dates between "2012-09-01" to "2012-09-06"
    And the result should be sorted by most recent date
    When the user enters date range from "2012-09-02" to "2012-09-06" and click search
    Then results table should only show transactions dates between "2012-09-02" to "2012-09-06"
    And the results table should only not contain transactions dated "2012-09-01"

  Scenario: Search description
    When the user enters description "ONLINE" and click search
    Then results table should only show descriptions containing "ONLINE"
    When the user enters description "OFFICE" and click search
    Then results table should only show descriptions containing "OFFICE"
    But results table should not show descriptions containing "ONLINE"

  Scenario: Search description case insensitive
    When the user enters description "ONLINE" and click search
    Then results table should only show descriptions containing "ONLINE"
    When the user enters description "online" and click search
    Then results table should only show descriptions containing "ONLINE"

    Scenario: Type
      And click search
      Then results table should show at least one result under Deposit
      Then results table should show at least one result under Withdrawal
      When user selects type "Deposit"
      Then results table should show at least one result under Deposit
      But results table should show no result under Withdrawal
      When user selects type "Withdrawal"
      Then results table should show at least one result under Withdrawal
      But results table should show no result under Deposit