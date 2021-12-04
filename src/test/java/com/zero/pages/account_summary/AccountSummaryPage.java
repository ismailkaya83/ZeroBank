package com.zero.pages.account_summary;

import com.zero.pages.BasePage;
import com.zero.utilities.BrowserUtils;
import com.zero.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountSummaryPage extends BasePage {

    @FindBy(className = "board-header")
    public List<WebElement> accountTypes;

    @FindBy(xpath = "//h2[text()='Cash Accounts']/following-sibling::div[1]//thead//th")
    public List<WebElement> cashAccountsColumnNames;

    @FindBy(xpath = "//h2[text()='Investment Accounts']/following-sibling::div[1]//thead//th")
    public List<WebElement> investmentAccountsColumnNames;

    @FindBy(xpath = "//h2[text()='Credit Accounts']/following-sibling::div[1]//thead//th")
    public List<WebElement> creditAccountsColumnNames;

    @FindBy(xpath = "//h2[text()='Loan Accounts']/following-sibling::div[1]//thead//th")
    public List<WebElement> loanAccountsColumnNames;


    public List<String> getAccountTypes() {
        return BrowserUtils.getElementsText(accountTypes);
    }

    public List<String> getColumnNames(String accountName) {
        List<String> columnsNames = null;
        switch (accountName) {
            case "Credit Accounts":
                columnsNames = BrowserUtils.getElementsText(creditAccountsColumnNames);
                break;
            case "Cash Accounts":
                columnsNames = BrowserUtils.getElementsText(cashAccountsColumnNames);
                break;
            case "Investment Accounts":
                columnsNames = BrowserUtils.getElementsText(investmentAccountsColumnNames);
                break;
            case "Loan Accounts":
                columnsNames = BrowserUtils.getElementsText(loanAccountsColumnNames);
                break;
        }

        return columnsNames;
    }

    public void getLink(String link){
        Driver.get().findElement(By.xpath("//a[contains(text(),'"+ link +"')]")).click();
    }


}
