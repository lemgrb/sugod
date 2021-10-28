package org.example.pages.keypress;

import lombok.extern.slf4j.Slf4j;
import org.example.pages.Page;
import org.example.pages.PageVerifyController;
import org.example.pages.common.Log;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

@Slf4j
public class KeyPressPageVerifyController extends PageVerifyController {

    private final String heading1 = "Keyboard and Mouse Input";

    public KeyPressPageVerifyController(WebDriver driver) {
        super(driver);
    }

    @Override
    public KeyPressPageVerifyController pageIsDisplayed(){
        Log.info("["+Thread.currentThread().getName()+"] " + "Verify page has heading 1 <h1>" + heading1 + "</h1>");
        Assert.assertEquals(driver.get().findElement(Page.h1()).getText(), heading1);
        return this;
    }

}
