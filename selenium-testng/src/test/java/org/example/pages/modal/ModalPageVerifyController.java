package org.example.pages.modal;

import lombok.extern.slf4j.Slf4j;
import org.example.pages.Page;
import org.example.pages.PageVerifyController;
import org.example.pages.common.Log;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Map;

@Slf4j
public class ModalPageVerifyController extends PageVerifyController {

    private final String heading1 = "Modal";

    public ModalPageVerifyController(WebDriver driver) {
        super(driver);
    }

    @Override
    public ModalPageVerifyController pageIsDisplayed(){
        Log.info("["+Thread.currentThread().getName()+"] " + "Verify page has heading 1 <h1>" + heading1 + "</h1>");
        Assert.assertEquals(driver.get().findElement(Page.h1()).getText(), heading1);
        return this;
    }

    public ModalPageVerifyController modalIsClosed() throws InterruptedException {
        Log.info("["+Thread.currentThread().getName()+"] " + "Verify that the modal is closed.");
        Assert.assertFalse(driver.get().findElement(ModalPage.modal()).isDisplayed(),"Modal page is not displayed");
        return this;
    }

}
