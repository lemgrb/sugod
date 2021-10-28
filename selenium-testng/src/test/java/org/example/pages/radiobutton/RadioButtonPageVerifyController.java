package org.example.pages.radiobutton;

import lombok.extern.slf4j.Slf4j;
import org.example.pages.Page;
import org.example.pages.PageVerifyController;
import org.example.pages.common.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.Map;

@Slf4j
public class RadioButtonPageVerifyController extends PageVerifyController {

    private final String heading1 = "Radio buttons";

    public RadioButtonPageVerifyController(WebDriver driver) {
        super(driver);
    }

    @Override
    public RadioButtonPageVerifyController pageIsDisplayed(){
        Log.info("["+Thread.currentThread().getName()+"] " + "Verify page has heading 1 <h1>" + heading1 + "</h1>");
        Assert.assertEquals(driver.get().findElement(Page.h1()).getText(), heading1);
        return this;
    }

    public RadioButtonPageVerifyController radioButtonIsSelected(String value) {
        WebElement radioButton = driver.get().findElement(RadioButtonPage.radio_button_with_value(value));
        Assert.assertTrue(radioButton.isSelected(), "Verify radio button with value " + value + " is selected.");
        return this;
    }

}
