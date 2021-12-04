package com.zero.step_definitions;

import com.zero.pages.pay_bills.AddNewPayeePage;
import com.zero.pages.pay_bills.PaySavedPayeePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class AddNewPayeeStepDef {
    @And("creates new payee using following information")
    public void createsNewPayeeUsingFollowingInformation(Map<String, String> payeeInformation) {
        AddNewPayeePage addNewPayeePage = new AddNewPayeePage();
        addNewPayeePage.enterTextPayeeName(payeeInformation.get("Payee Name"));
        addNewPayeePage.enterTextPayeeAddress(payeeInformation.get("Payee Address"));
        addNewPayeePage.enterTextAccount(payeeInformation.get("Account"));
        addNewPayeePage.enterTextPayeeDetails(payeeInformation.get("Payee details"));
        addNewPayeePage.clickButtonAdd();
    }

    @Then("message {string} should be displayed")
    public void messageShouldBeDisplayed(String expectedMessage) {
        PaySavedPayeePage paySavedPayeePage = new PaySavedPayeePage();
        String actualMessage = paySavedPayeePage.getMessageContent();
        Assert.assertEquals(expectedMessage,actualMessage);
    }
}
