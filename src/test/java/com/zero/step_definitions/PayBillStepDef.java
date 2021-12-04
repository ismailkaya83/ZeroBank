package com.zero.step_definitions;

import com.zero.pages.pay_bills.PayBillsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class PayBillStepDef {

    @Given("select payee {string}")
    public void select_any_payee(String payee) {
        new PayBillsPage().selectPayee(payee);
    }

    @Then("select account {string}")
    public void selectAccount(String account) {
        new PayBillsPage().selectAccount(account);
    }

    @Then("enter {string} in the amount button")
    public void enterInTheAmountButton(String amount) {
        new PayBillsPage().amountButton.sendKeys(amount);
    }

    @Then("enter {string} in the date button")
    public void enterInTheDateButton(String date) {
        new PayBillsPage().dateButton.sendKeys(date);
    }

    @Then("enter {string} in the description button")
    public void enterInTheDescriptionButton(String description) {
        new PayBillsPage().descriptionButton.sendKeys(description);
    }

    @Then("click pay button")
    public void clickPayButton() {
        new PayBillsPage().payButton.click();
    }

    @Then("verify {string} message should be displayed")
    public void verifyMessageShouldBeDisplayed(String expectedMessage) {

        if ("The payment was successfully submitted.".equals(expectedMessage)) {
            String actualMessage = new PayBillsPage().getSuccessMessage();
            System.out.println("actualMessage = " + actualMessage);
            Assert.assertEquals(expectedMessage, actualMessage);
        } else if (new PayBillsPage().amountButton.getAttribute("value").isEmpty()) {
            String actualMessage = new PayBillsPage().getAmountValidationMessage();
            System.out.println("actualMessage = " + actualMessage);
            Assert.assertEquals(expectedMessage, actualMessage);
        } else if (new PayBillsPage().dateButton.getAttribute("value").isEmpty()) {
            String actualMessage = new PayBillsPage().getDateValidationMessage();
            System.out.println("actualMessage = " + actualMessage);
            Assert.assertEquals(expectedMessage, actualMessage);
        }
    }

    @Then("verify {string} field should be empty")
    public void verifyFieldShouldBeEmpty(String field) {
        boolean isEmpty = new PayBillsPage().checkDataType(field.toLowerCase());
        Assert.assertTrue(isEmpty);
    }
}
