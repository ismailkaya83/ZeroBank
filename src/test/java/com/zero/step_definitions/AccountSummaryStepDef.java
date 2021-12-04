package com.zero.step_definitions;

import com.zero.pages.account_summary.AccountSummaryPage;
import com.zero.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class AccountSummaryStepDef {

    @Then("the title should be {string}")
    public void the_title_should_be(String expectedTitle) {
        String currentTitle = Driver.get().getTitle();
        System.out.println("currentTitle = " + currentTitle);
        Assert.assertEquals(expectedTitle, currentTitle);
    }

    @And("the account types should be")
    public void theAccountTypesShouldBe(List<String> expectedAccountTypes) {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        List<String> actualAccountTypeList = accountSummaryPage.getAccountTypes();
        Assert.assertEquals(expectedAccountTypes, actualAccountTypeList);

    }

    @And("the column types under {string} should be such as")
    public void theColumnTypesUnderShouldBeSuchAs(String accountName, List<String> expectedColumnNames) {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        List<String> actualColumnNames = accountSummaryPage.getColumnNames(accountName);
        Assert.assertEquals(expectedColumnNames, actualColumnNames);
    }

    @When("navigate to {string} page")
    public void navigateToPage(String tab) {
        new AccountSummaryPage().navigateBetweenPages(tab);
    }

    @When("the user clicks on {string} on the Account Summary page")
    public void theUserClicksOnOnTheAccountSummaryPage(String link) {
        new AccountSummaryPage().getLink(link);
    }
}
