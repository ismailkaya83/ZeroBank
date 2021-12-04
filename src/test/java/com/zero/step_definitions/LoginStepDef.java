package com.zero.step_definitions;

import com.zero.pages.LoginPage;
import com.zero.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDef {

    @Given("the user logged in")
    public void user_logged_in() {

        LoginPage loginPage = new LoginPage();
        loginPage.login();

    }

    @Then("the {string} page should be displayed")
    public void the_page_should_be_displayed(String menuName) {

        String currentTitle = Driver.get().getTitle();

        Assert.assertTrue("Title is not matching", currentTitle.contains(menuName));

    }


    @When("enter invalid {string} and {string}")
    public void enterInvalidAnd(String username, String password) {

        LoginPage loginPage = new LoginPage();
        loginPage.userNameTextBox.sendKeys(username);
        loginPage.passwordTextBox.sendKeys(password);
        loginPage.signInButton.click();

    }

    @Then("Login error message {string} should be displayed")
    public void loginErrorMessageShouldBeDisplayed(String expectedErrorMessage) {
        LoginPage loginPage = new LoginPage();
        String actualErrorMessage = loginPage.getMessageContent();
        System.out.println("actualErrorMessage = " + actualErrorMessage);
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);

    }
}
