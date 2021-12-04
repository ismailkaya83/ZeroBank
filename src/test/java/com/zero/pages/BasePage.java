package com.zero.pages;

import com.zero.utilities.BrowserUtils;
import com.zero.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "(//a[@class='dropdown-toggle'])[2]")
    public static WebElement user;

    @FindBy(id = "logout_link")
    public static WebElement logOut;

    @FindBy(css = "li[id$='_tab'][class='active']")
    public static WebElement activePageTab;

    public String getUserName() {
        return user.getText();
    }

    public static String getTitle() {
        return Driver.get().getTitle();
    }

    public static void logOut() {
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(user);
        BrowserUtils.clickWithJS(logOut);
    }

    public void navigateBetweenPages(String tab) {
        Driver.get().findElement(By.linkText(tab)).click();
        BrowserUtils.waitFor(2);
    }

    public static String getActivePageTab() {
        return activePageTab.getText();
    }


}
