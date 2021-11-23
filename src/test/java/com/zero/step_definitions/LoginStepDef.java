package com.zero.step_definitions;

import com.zero.pages.LoginPage;
import com.zero.utilities.BrowserUtils;
import com.zero.utilities.ConfigurationReader;
import com.zero.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDef {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {

        String url = ConfigurationReader.get("url");
        Driver.get().get(url);

    }

    @When("the user logs in using valid credentials")
    public void the_user_logs_in_using_valid_credentials() {

        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");

        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);

    }

    @Then("the {string} page should be displayed")
    public void the_page_should_be_displayed(String expectedActivePageTab) {
        BrowserUtils.waitFor(2);
        Assert.assertTrue(Driver.get().getTitle().contains(expectedActivePageTab));

    }

}
