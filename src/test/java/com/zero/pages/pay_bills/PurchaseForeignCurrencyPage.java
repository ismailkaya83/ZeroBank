package com.zero.pages.pay_bills;

import com.zero.pages.BasePage;
import com.zero.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PurchaseForeignCurrencyPage extends BasePage {

    public Select select;

    public PurchaseForeignCurrencyPage() {
        select = new Select(selectCurrency);
    }


    @FindBy(id = "pc_currency")
    public WebElement selectCurrency;

    @FindBy(id = "purchase_cash")
    public WebElement btnPurchase;


    public List<String> getCurrencyList() {
        List<WebElement> elementList = select.getOptions();
        return BrowserUtils.getElementsText(elementList);
    }

    public void clickPurchase() {
        btnPurchase.click();
        BrowserUtils.waitFor(2);
    }

}
