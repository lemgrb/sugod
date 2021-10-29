package org.example.pages.common;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

@Slf4j
public class CommonVerificationVerifyController {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public CommonVerificationVerifyController(WebDriver driver) {
        this.driver.set(driver);
    }

    // verify
    public CommonVerificationVerifyController elementIsDisplayed(By element) {
        Log.info("Verify element is displayed: " + element);
        Assert.assertTrue(driver.get().findElement(element).isDisplayed(), "Verify element is displayed: " + element.toString());
        return this;
    }

    // verify
    public CommonVerificationVerifyController textIsDisplayed(String text) {
        Log.info("Explicitly wait max of 10 seconds for presence of element with text = " + text);
        WebElement element = null;
        try {
            element = new WebDriverWait(driver.get(), Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'"+text+"')]")));
        } catch (TimeoutException e){}

        Log.info("Verify \"" + text +"\" is displayed using xpath: " + "//*[contains(text(),'"+text+"')]");
        Assert.assertTrue(element!=null, "Verify text is displayed: " + text);
        return this;
    }
}
