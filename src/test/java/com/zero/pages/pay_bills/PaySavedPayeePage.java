package com.zero.pages.pay_bills;

import com.zero.pages.BasePage;
import com.zero.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PaySavedPayeePage extends BasePage {

    public String getMessageContent(){
        WebElement message = Driver.get().findElement(By.id("alert_content"));
        return message.getText();
    }

}
