package com.zero.pages;

import com.zero.utilities.BrowserUtils;
import com.zero.utilities.ConfigurationReader;
import com.zero.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "user_login")
    public WebElement userNameTextBox;

    @FindBy(id = "user_password")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//input[@value='Sign in']")
    public WebElement signInButton;

    @FindBy(id = "details-button")
    public WebElement advanced;

    @FindBy(id = "proceed-link")
    public WebElement link;

    public void login() {

        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");

        userNameTextBox.sendKeys(username);
        passwordTextBox.sendKeys(password);
        signInButton.click();
        advanced.click();
        link.click();
        BrowserUtils.waitFor(2);
    }

    public String getMessageContent(){
        WebElement message = Driver.get().findElement(By.cssSelector(".alert.alert-error"));
        return message.getText();
    }
}
