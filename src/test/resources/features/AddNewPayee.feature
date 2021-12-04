Feature: Add new payee under pay bills

  Scenario: Add a new payee

    Given the user logged in
    When navigate to "Pay Bills" page
    Then navigate to "Add New Payee" sub page
    And creates new payee using following information
      | Payee Name    | The Law Offices of Hyde, Price & Scharks |
      | Payee Address | 100 Same st, Anytown, USA, 10001         |
      | Account       | Checking                                 |
      | Payee details | XYZ account                              |
    Then message "The new payee The Law Offices of Hyde, Price & Scharks was successfully created." should be displayed