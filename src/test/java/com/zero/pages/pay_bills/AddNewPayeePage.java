package com.zero.pages.pay_bills;

import com.zero.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNewPayeePage extends BasePage {

    @FindBy(id = "np_new_payee_name")
    public WebElement txtPayeeName;

    @FindBy(id = "np_new_payee_address")
    public WebElement txtPayeeAddress;

    @FindBy(id = "np_new_payee_account")
    public  WebElement txtAccount;

    @FindBy(id = "np_new_payee_details")
    public WebElement txtPayeeDetails;

    @FindBy(id = "add_new_payee")
    public WebElement btnAdd;


    public void enterTextPayeeName(String text){
        txtPayeeName.sendKeys(text);
    }

    public void enterTextPayeeAddress(String text){
        txtPayeeAddress.sendKeys(text);
    }

    public void enterTextAccount(String text){
        txtAccount.sendKeys(text);
    }

    public void enterTextPayeeDetails(String text){
        txtPayeeDetails.sendKeys(text);
    }

    public void clickButtonAdd(){
        btnAdd.click();
    }


}
