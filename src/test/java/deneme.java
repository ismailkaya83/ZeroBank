import com.zero.pages.*;
import com.zero.utilities.BrowserUtils;
import com.zero.utilities.ConfigurationReader;
import com.zero.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class deneme {

    @Test
    public void test1() throws ParseException {

        List<String> list = new ArrayList<>();

        list.add("bir");
        list.add("");
        list.add(" ");

        System.out.println("list.size() = " + list.size());

        System.out.println("list = " + list);

        for(String value : list){
            System.out.println("value.isEmpty() = " + value.isEmpty());
        }



    }
}

