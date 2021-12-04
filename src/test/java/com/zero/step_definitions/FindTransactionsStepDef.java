package com.zero.step_definitions;

import com.zero.pages.account_activity.FindTransactionsPage;
import com.zero.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FindTransactionsStepDef {

    @Then("navigate to {string} sub page")
    public void navigateToSubPage(String tab) {
        new FindTransactionsPage().navigateBetweenPages(tab);
    }

    @When("the user enters date range from {string} to {string} and click search")
    public void theUserEntersDateRangeFromToAndClickSearch(String fromDate, String toDate) {
        FindTransactionsPage findTransactionsPage = new FindTransactionsPage();
        findTransactionsPage.fromDateButton.clear();
        findTransactionsPage.toDateButton.clear();
        findTransactionsPage.fromDateButton.sendKeys(fromDate);
        findTransactionsPage.toDateButton.sendKeys(toDate);
        findTransactionsPage.findButton.click();
        BrowserUtils.waitFor(3);
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void resultsTableShouldOnlyShowTransactionsDatesBetweenTo(String expFirstDate, String expLastDate) throws ParseException {

        FindTransactionsPage findTransactionsPage = new FindTransactionsPage();
        List<String> dateColumnTexts = findTransactionsPage.getColumnInformation("Date");
        List<Date> dateList = findTransactionsPage.convertStringListToDateList(dateColumnTexts);

        Date eFirstDate = new SimpleDateFormat("yyyy-MM-dd").parse(expFirstDate);
        Date eLastDate = new SimpleDateFormat("yyyy-MM-dd").parse(expLastDate);

        Date actFirstDate = findTransactionsPage.getMinDate(dateList);
        Date actLastDate = findTransactionsPage.getMaxDate(dateList);

        Assert.assertTrue((eFirstDate.before(actFirstDate) || (eFirstDate.equals(actFirstDate))));
        Assert.assertTrue((eLastDate.after(actLastDate) || (eLastDate.equals(actLastDate))));


    }

    @And("the result should be sorted by most recent date")
    public void theResultShouldBeSortedByMostRecentDate() {
        FindTransactionsPage findTransactionsPage = new FindTransactionsPage();
        List<String> actualColumnTexts = findTransactionsPage.getColumnInformation("Date");
        List<Date> dateList = findTransactionsPage.convertStringListToDateList(actualColumnTexts);
        List<Date> dateSortList = findTransactionsPage.sortDateList(dateList);
        List<String> sortColumnTexts = findTransactionsPage.convertDateListToStringList(dateSortList, actualColumnTexts);
        Assert.assertEquals(sortColumnTexts, actualColumnTexts);
    }

    @And("the results table should only not contain transactions dated {string}")
    public void theResultsTableShouldOnlyNotContainTransactionsDated(String expDate) {

        FindTransactionsPage findTransactionsPage = new FindTransactionsPage();
        List<String> dateColumnTexts = findTransactionsPage.getColumnInformation("Date");
        Assert.assertFalse(dateColumnTexts.contains(expDate));

    }

    @When("the user enters description {string} and click search")
    public void theUserEntersDescriptionAndClickSearch(String text) {
        FindTransactionsPage findTransactionsPage = new FindTransactionsPage();
        findTransactionsPage.descriptionButton.clear();
        findTransactionsPage.descriptionButton.sendKeys(text);
        findTransactionsPage.findButton.click();
        BrowserUtils.waitFor(3);

    }

    @Then("results table should only show descriptions containing {string}")
    public void resultsTableShouldOnlyShowDescriptionsContaining(String expectedText) {
        FindTransactionsPage findTransactionsPage = new FindTransactionsPage();
        List<String> descriptionText = findTransactionsPage.getColumnInformation("Description");
        for (String row : descriptionText){
            Assert.assertTrue(row.contains(expectedText));
        }
    }

    @But("results table should not show descriptions containing {string}")
    public void resultsTableShouldNotShowDescriptionsContaining(String unexpectedText) {
        FindTransactionsPage findTransactionsPage = new FindTransactionsPage();
        List<String> descriptionText = findTransactionsPage.getColumnInformation("Description");
        for (String row : descriptionText){
            Assert.assertFalse(row.contains(unexpectedText));
        }
    }

    @And("click search")
    public void clickSearch() {
        FindTransactionsPage findTransactionsPage = new FindTransactionsPage();
        findTransactionsPage.findButton.click();
        BrowserUtils.waitFor(3);
    }

    @Then("results table should show at least one result under Deposit")
    public void resultsTableShouldShowAtLeastOneResultUnderDeposit() {
        FindTransactionsPage findTransactionsPage = new FindTransactionsPage();
        List<String> depositColumnValues = findTransactionsPage.getColumnInformation("Deposit");
        Assert.assertTrue(depositColumnValues.size()>0);

    }

    @Then("results table should show at least one result under Withdrawal")
    public void resultsTableShouldShowAtLeastOneResultUnderWithdrawal() {
        FindTransactionsPage findTransactionsPage = new FindTransactionsPage();
        List<String> withdrawalColumnValues = findTransactionsPage.getColumnInformation("Withdrawal");
        Assert.assertTrue(withdrawalColumnValues.size()>0);
    }

    @When("user selects type {string}")
    public void userSelectsType(String type) {
        FindTransactionsPage findTransactionsPage = new FindTransactionsPage();
        findTransactionsPage.selectType(type);
        findTransactionsPage.findButton.click();
        BrowserUtils.waitFor(3);
    }

    @But("results table should show no result under Withdrawal")
    public void resultsTableShouldShowNoResultUnderWithdrawal() {
        FindTransactionsPage findTransactionsPage = new FindTransactionsPage();
        List<String> withdrawalColumnValues = findTransactionsPage.getColumnInformation("Withdrawal");
        Assert.assertEquals(0, withdrawalColumnValues.size());
    }

    @But("results table should show no result under Deposit")
    public void resultsTableShouldShowNoResultUnderDeposit() {
        FindTransactionsPage findTransactionsPage = new FindTransactionsPage();
        List<String> depositColumnValues = findTransactionsPage.getColumnInformation("Deposit");
        Assert.assertEquals(0, depositColumnValues.size());
    }
}
