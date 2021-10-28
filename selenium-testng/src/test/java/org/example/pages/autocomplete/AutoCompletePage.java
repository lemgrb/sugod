package org.example.pages.autocomplete;

import lombok.extern.slf4j.Slf4j;
import org.example.pages.Page;
import org.example.pages.common.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Slf4j
public class AutoCompletePage extends Page {

    private final String DIRECT_URL = "http://formy-project.herokuapp.com/autocomplete";

    private AutoCompletePageVerifyController autoCompletePageVerifyController;

    private AutoCompletePage(WebDriver driver, AutoCompletePageVerifyController autoCompletePageVerifyController) {
        super(driver);
        this.autoCompletePageVerifyController = autoCompletePageVerifyController;
    }

    public AutoCompletePage goToPage() {
        Log.info("["+Thread.currentThread().getName()+"] " + "Open page: " + DIRECT_URL);

        driver.get().get(DIRECT_URL);
        return this;
    }

    public static AutoCompletePage getAutoCompletePage(WebDriver driver) {
        return new AutoCompletePage(driver, new AutoCompletePageVerifyController(driver));
    }

    /**
     * Act
     */
    public AutoCompletePage autocomplete(String address) {
        Log.info("["+Thread.currentThread().getName()+"] " + "Enter in address field: " + address);

        driver.get().findElement(address_field()).sendKeys(address);

        WebElement autoCompleteField = new WebDriverWait(driver.get(), Duration.ofSeconds(5))
                .until(driver -> driver.findElement(autocomplete_result()));

        autoCompleteField.click();

        return this;
    }


    /**
     * Assert
     */
    public AutoCompletePageVerifyController verify() {
        return autoCompletePageVerifyController;
    }

    /**
     * Locators
     */

    public static By address_field() {
        return By.id("autocomplete");
    }
    public static By autocomplete_result() {
        return By.className("pac-item");
    }
    public static By street_number() {
        return By.id("street_number");
    }

}
