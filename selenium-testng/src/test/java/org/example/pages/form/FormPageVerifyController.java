package org.example.pages.form;

import lombok.extern.slf4j.Slf4j;
import org.example.pages.Page;
import org.example.pages.PageVerifyController;
import org.example.pages.common.Log;
import org.example.pages.scroll.ScrollPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.Map;

@Slf4j
public class FormPageVerifyController extends PageVerifyController {

    private final String heading1 = "Complete Web Form";

    public FormPageVerifyController(WebDriver driver) {
        super(driver);
    }

    @Override
    public FormPageVerifyController pageIsDisplayed(){
        Log.info("["+Thread.currentThread().getName()+"] " + "Verify page has heading 1 <h1>" + heading1 + "</h1>");
        Assert.assertEquals(driver.get().findElement(Page.h1()).getText(), heading1);
        return this;
    }

}
