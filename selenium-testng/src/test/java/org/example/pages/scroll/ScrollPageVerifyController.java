package org.example.pages.scroll;

import lombok.extern.slf4j.Slf4j;
import org.example.pages.Page;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.example.pages.PageVerifyController;
import org.example.pages.common.Log;

import java.util.Map;

@Slf4j
public class ScrollPageVerifyController extends PageVerifyController {

    private final String heading1 = "Large page content";

    public ScrollPageVerifyController(WebDriver driver) {
        super(driver);
    }

    @Override
    public ScrollPageVerifyController pageIsDisplayed(){
        Log.info("["+Thread.currentThread().getName()+"] " + "Verify page has heading 1 <h1>" + heading1 + "</h1>");
        Assert.assertEquals(driver.get().findElement(Page.h1()).getText(), heading1);
        return this;
    }

    public ScrollPageVerifyController allFieldsArePopulated(Map<String,String> formValues) {
        Log.info("["+Thread.currentThread().getName()+"] " + "Verify all fields are populated : " + formValues + "");

        SoftAssert sassert = new SoftAssert();

        sassert.assertEquals(driver.get()
                .findElement(ScrollPage.name_textbox())
                .getAttribute("value"), formValues.get("name"));

        sassert.assertEquals(driver.get()
                .findElement(ScrollPage.date_textbox())
                .getAttribute("value"), formValues.get("date"));

        sassert.assertAll();

        return this;
    }

}
