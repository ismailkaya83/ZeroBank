Feature:  Pay Bills Content

  Background:
    Given the user logged in
    When navigate to "Pay Bills" page

  Scenario: verify title
    Then the title should be "Zero - Pay Bills"


  Scenario Outline: verify successful payment
    Given select payee "<payee>"
    Then select account "<account>"
    Then enter "<amount>" in the amount button
    Then enter "<date>" in the date button
    Then enter "<description>" in the description button
    Then click pay button
    Then verify "The payment was successfully submitted." message should be displayed

    Examples:
      | payee           | account     | amount | date       | description |
      | Sprint          | Savings     | 1000   | 2021       | text        |
      | Bank of America | Savings     | 1000   | 2021-11-27 | text        |
      | Apple           | Savings     | 2000   | 2021-11-27 | text        |
      | Wells Fargo     | Savings     | 2000   | 2021-11-27 | text        |
      | Sprint          | Checking    | 1000   | 2021-11-27 | text        |
      | Bank of America | Checking    | 1000   | 2021-11-27 | text        |
      | Apple           | Checking    | 1000   | 2021-11-27 | text        |
      | Wells Fargo     | Checking    | 2000   | 2021-11-27 | text        |
      | Sprint          | Loan        | 2000   | 2021-11-27 | text        |
      | Bank of America | Loan        | 2000   | 2021-11-27 | text        |
      | Apple           | Loan        | 2000   | 2021-11-27 | text        |
      | Wells Fargo     | Loan        | 2000   | 2021-11-27 | text        |
      | Sprint          | Credit Card | 2000   | 2021-11-27 | text        |
      | Bank of America | Credit Card | 2000   | 2021-11-27 | text        |
      | Apple           | Credit Card | 1000   | 2021-11-27 | text        |
      | Wells Fargo     | Credit Card | 1000   | 2021-11-27 | text        |
      | Sprint          | Brokerage   | 1000   | 2021-11-27 | text        |
      | Bank of America | Brokerage   | 1000   | 2021-11-27 | text        |
      | Apple           | Brokerage   | 1000   | 2021-11-27 | text        |
      | Wells Fargo     | Brokerage   | 5500   | 2021-11-27 | text        |


  Scenario Outline: verify unsuccessful payment without amount or data
    Given select payee "<payee>"
    Then select account "<account>"
    Then enter "<amount>" in the amount button
    Then enter "<date>" in the date button
    Then enter "<description>" in the description button
    Then click pay button
    Then verify "Please fill out this field." message should be displayed

    Examples:
      | payee           | account | amount | date | description |
      | Sprint          | Savings |        | 2021 | text        |
      | Bank of America | Savings | 1000   |      | text        |
      | Apple           | Savings |        |      | text        |


  Scenario Outline: Verify amount field should not accept alphabetical or special character
    Given enter "<amount>" in the amount button
    Then verify "amount" field should be empty

    Examples:
      | amount  |
      | text    |
      | text*)& |

  Scenario Outline: Verify date field should not accept alphabetical character
    Given enter "<date>" in the amount button
    Then verify "DATE" field should be empty

    Examples:
      | date |
      | text |




