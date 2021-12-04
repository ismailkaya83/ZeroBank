package com.zero.pages.pay_bills;

import com.zero.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PayBillsPage extends BasePage {

    @FindBy(id = "sp_payee")
    public WebElement payeeButton;

    @FindBy(id = "sp_account")
    public WebElement accountButton;

    @FindBy(id = "sp_amount")
    public WebElement amountButton;

    @FindBy(id = "sp_date")
    public WebElement dateButton;

    @FindBy(id = "sp_description")
    public WebElement descriptionButton;

    @FindBy(id = "pay_saved_payees")
    public WebElement payButton;

    @FindBy(id = "alert_content")
    public WebElement messageSuccess;

    public void selectPayee(String payee) {
        new Select(payeeButton).selectByVisibleText(payee);
    }

    public void selectAccount(String account) {
        new Select(accountButton).selectByVisibleText(account);
    }

    public String getSuccessMessage() {
        return new PayBillsPage().messageSuccess.getText();
    }

    public String getAmountValidationMessage() {
        return new PayBillsPage().amountButton.getAttribute("validationMessage");
    }

    public String getDateValidationMessage() {
        return new PayBillsPage().dateButton.getAttribute("validationMessage");
    }

    public boolean checkDataType(String field) {
        if (field.equals("amount")) {
            return amountButton.getAttribute("value").isEmpty();
        } else {
            return dateButton.getAttribute("value").isEmpty();
        }
    }
}
