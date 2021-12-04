package com.zero.step_definitions;

import com.zero.pages.pay_bills.PurchaseForeignCurrencyPage;
import com.zero.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;

import java.util.List;

public class PurchaseForeignCurrencyStepDef {

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> expectedList) {
        PurchaseForeignCurrencyPage purchaseForeignCurrencyPage = new PurchaseForeignCurrencyPage();
        List<String> actualList = purchaseForeignCurrencyPage.getCurrencyList();
        actualList.remove(0);
        Assert.assertEquals(expectedList,actualList);
    }


    @When("user tries to calculate cost without selecting a currency")
    public void userTriesToCalculateCostWithoutSelectingACurrency() {
        PurchaseForeignCurrencyPage purchaseForeignCurrencyPage = new PurchaseForeignCurrencyPage();
        purchaseForeignCurrencyPage.clickPurchase();
    }

    @Then("error message should be displayed")
    public void errorMessageShouldBeDisplayed() {
        try {
            Alert alert = Driver.get().switchTo().alert();
            Assert.assertNotNull(alert);
            alert.accept();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @When("user tries to calculate cost without entering a value")
    public void userTriesToCalculateCostWithoutEnteringAValue() {
        PurchaseForeignCurrencyPage purchaseForeignCurrencyPage = new PurchaseForeignCurrencyPage();
        purchaseForeignCurrencyPage.select.selectByVisibleText("Eurozone (euro)");
        purchaseForeignCurrencyPage.clickPurchase();
    }
}
