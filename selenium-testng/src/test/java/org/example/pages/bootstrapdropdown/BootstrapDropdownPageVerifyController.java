package org.example.pages.bootstrapdropdown;

import lombok.extern.slf4j.Slf4j;
import org.example.pages.Page;
import org.example.pages.PageVerifyController;
import org.example.pages.common.Log;
import org.example.pages.radiobutton.RadioButtonPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

@Slf4j
public class BootstrapDropdownPageVerifyController extends PageVerifyController {

    private final String heading1 = "Dropdown";

    public BootstrapDropdownPageVerifyController(WebDriver driver) {
        super(driver);
    }

    @Override
    public BootstrapDropdownPageVerifyController pageIsDisplayed(){
        Log.info("["+Thread.currentThread().getName()+"] " + "Verify page has heading 1 <h1>" + heading1 + "</h1>");
        Assert.assertEquals(driver.get().findElement(Page.h1()).getText(), heading1);
        return this;
    }

}
