package org.example.pages.autocomplete;

import lombok.extern.slf4j.Slf4j;
import org.example.pages.common.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

@Slf4j
public class AutoCompletePageVerifyController {

    private static final String heading1 = "Autocomplete";

    private final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public AutoCompletePageVerifyController(WebDriver driver) {
        this.driver.set(driver);
    }

    public AutoCompletePageVerifyController pageIsDisplayed() {
        Log.info("["+Thread.currentThread().getName()+"] " + "Verify page has heading1 <h1>" + heading1+"</h1>");

        Assert.assertEquals(driver.get().findElement(AutoCompletePage.h1()).getText(), heading1);
        return this;
    }

    public AutoCompletePageVerifyController allFieldsArePopulated() {
        Log.info("["+Thread.currentThread().getName()+"] " + "Verify form fields are auto-populated");

        // Wait for at least one field (street_number) to be populated
        WebElement streetNumberTextfield = driver
                .get().findElement(AutoCompletePage.street_number());
        new WebDriverWait(driver.get(), Duration.ofSeconds(10))
                .until(ExpectedConditions.attributeToBeNotEmpty(streetNumberTextfield, "value" ));

        // TODO: Refactor to assert other fields are populated with pre-determined data
        String streetNumber = driver.get()
                .findElement(AutoCompletePage.street_number())
                .getAttribute("value");
        Assert.assertFalse(streetNumber.isBlank(),"Verify that street number is not blank. Actual=" + streetNumber);


        return this;
    }

}
