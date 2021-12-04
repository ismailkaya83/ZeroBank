package com.zero.step_definitions;

import com.zero.pages.account_activity.AccountActivityPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class AccountActivityStepDef {

    @Then("dropdown option should be {string}")
    public void dropdown_option_should_be(String expectedDefaultOption) {
        String actualDefaultOption = new AccountActivityPage().getDefaultOption();
        Assert.assertEquals(expectedDefaultOption, actualDefaultOption);
    }

    @Then("dropdown options should be followings:")
    public void dropdownOptionsShouldBeFollowings(List<String> expectedOptions) {

        List<String> actualOptions = new AccountActivityPage().getAllOptions();
        Assert.assertEquals(expectedOptions, actualOptions);

    }

    @Then("transaction table columns are followings:")
    public void transaction_table_columns_are_followings(List<String> expectedHeaders) {

        List<String> actualHeaders = new AccountActivityPage().getAllHeaders();
        Assert.assertEquals(expectedHeaders, actualHeaders);

    }

    @And("Account drop down should have {string} selected")
    public void accountDropDownShouldHaveSelected(String expectedSelect) {
        String defaultSelect = new AccountActivityPage().getDefaultOption();
        Assert.assertEquals(expectedSelect, defaultSelect);
    }
}
