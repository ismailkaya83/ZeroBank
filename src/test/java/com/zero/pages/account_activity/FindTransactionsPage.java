package com.zero.pages.account_activity;

import com.zero.pages.BasePage;
import com.zero.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class FindTransactionsPage extends BasePage {

    @FindBy(css = "#aa_description")
    public WebElement descriptionButton;

    @FindBy(css = "#aa_fromDate")
    public WebElement fromDateButton;

    @FindBy(css = "#aa_toDate")
    public WebElement toDateButton;

    @FindBy(css = "#aa_fromAmount")
    public WebElement fromAmountButton;

    @FindBy(css = "#aa_toAmount")
    public WebElement toAmountButton;

    @FindBy(css = "#aa_type")
    public WebElement selectTypeButton;

    @FindBy(css = "button[type='submit']")
    public WebElement findButton;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr//th")
    public List<WebElement> columns;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr")
    public List<WebElement> rows;


    public List<String> getColumnInformation(String columnName) {
        int rowNumber = rows.size();
        WebElement columnElement = Driver.get().findElement(By.xpath(("(//th[contains(text(),'" + columnName + "')])[2]")));
        int j = columns.indexOf(columnElement);

        List<String> columnTexts = new ArrayList<>();
        for (int i = 1; i < rowNumber; i++) {
            String row = Driver.get().findElement(By.xpath("//div[@id='filtered_transactions_for_account']//tbody//tr[" + i + "]/td[" + (j + 1) + "]")).getText();
            if (!row.equals("")) {
                columnTexts.add(row);
            } ;
        }
        return columnTexts;
    }

    public List<Date> convertStringListToDateList(List<String> stringList) {
        List<Date> dateList = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (String string : stringList) {
            try {
                dateList.add(simpleDateFormat.parse(string));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return dateList;
    }

    public List<String> convertDateListToStringList(List<Date> dateList, List<String> stringList) {
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        stringList.clear();
        for (Date date : dateList) {
            stringList.add(simpleDateFormat.format(date));
        }
        return stringList;
    }

    public String convertDateString(Date date) {
        DateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date);
    }

    public Date getMinDate(List<Date> dateList) {
        return Collections.min(dateList);
    }

    public Date getMaxDate(List<Date> dateList) {
        return Collections.max(dateList);
    }

    public List<Date> sortDateList(List<Date> dateList) {
        dateList.sort(Collections.reverseOrder());
        return dateList;
    }

    public void selectType(String type) {
        Select select = new Select(selectTypeButton);
        select.selectByVisibleText(type);
    }


}
