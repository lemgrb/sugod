package pages.common;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

@Slf4j
public class CommonVerificationVerifyController {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public CommonVerificationVerifyController(WebDriver driver) {
        this.driver.set(driver);
    }

    // verify
    public CommonVerificationVerifyController elementIsDisplayed(By element) {
        log.info("Verify element is displayed: " + element);
        Reporter.log("Verify element is displayed: " + element);
        Assert.assertTrue(driver.get().findElement(element).isDisplayed(), "Verify element is displayed: " + element.toString());
        return this;
    }

    // verify
    public CommonVerificationVerifyController textIsDisplayed(String text) {
        log.info("Verify text is displayed: " + text);
        Reporter.log("Verify text is displayed: " + text);
        Assert.assertTrue(driver.get().findElement(By.xpath("//*[contains(text(),'"+text+"')]")).isDisplayed(), "Verify text is displayed: " + text);
        return this;
    }
}
