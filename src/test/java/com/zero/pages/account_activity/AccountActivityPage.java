package com.zero.pages.account_activity;

import com.zero.pages.BasePage;
import com.zero.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityPage extends BasePage {

    @FindBy(id = "aa_accountId")
    public WebElement accountSelectionDropDown;

    @FindBy(xpath = "//table[@class='table table-condensed table-hover']//th")
    public List<WebElement> headers;


    public String getDefaultOption() {
        return new Select(accountSelectionDropDown).getFirstSelectedOption().getText();
    }

    public List<String> getAllOptions() {
        return BrowserUtils.getElementsText(new Select(accountSelectionDropDown).getOptions());
    }

    public List<String> getAllHeaders() {
        return BrowserUtils.getElementsText(headers);
    }

}
