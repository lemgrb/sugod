package org.example.pages.dragdrop;

import lombok.extern.slf4j.Slf4j;
import org.example.pages.Page;
import org.example.pages.PageVerifyController;
import org.example.pages.common.CommonVerification;
import org.example.pages.common.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.Map;

@Slf4j
public class DragAndDropVerifyController extends PageVerifyController {

    private final String heading1 = "Drag the image into the box";

    public DragAndDropVerifyController(WebDriver driver) {
        super(driver);
    }

    @Override
    public DragAndDropVerifyController pageIsDisplayed(){
        Log.info("["+Thread.currentThread().getName()+"] " + "Verify page has heading 1 <h1>" + heading1 + "</h1>");
        Assert.assertEquals(driver.get().findElement(Page.h1()).getText(), heading1);
        return this;
    }


    public DragAndDropVerifyController imageIsInTheBox(){
        Log.info("["+Thread.currentThread().getName()+"] " + "Verify image is in the box");

        WebElement box = driver.get().findElement(DragAndDropPage.box());
        WebElement image = driver.get().findElement(DragAndDropPage.image());
        SoftAssert sAssert = new SoftAssert();
        sAssert.assertTrue((image.getLocation().x >= box.getLocation().x));
        sAssert.assertTrue((image.getLocation().x + image.getRect().width) <= (box.getLocation().x + box.getRect().width));
        sAssert.assertTrue((image.getLocation().y >= box.getLocation().y));
        sAssert.assertTrue((image.getLocation().y + image.getRect().height) <= (box.getLocation().y + box.getRect().height));
        sAssert.assertAll();
        return this;
    }

}
