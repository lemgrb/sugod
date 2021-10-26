package pages.autcompletepage;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.time.Duration;

@Slf4j
public class AutoCompletePage {

    private final String directURL = "http://formy-project.herokuapp.com/autocomplete";

    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private AutoCompletePageVerifyController autoCompletePageVerifyController;

    private AutoCompletePage(WebDriver driver, AutoCompletePageVerifyController keyPressVerifyController) {
        this.driver.set(driver);
        this.autoCompletePageVerifyController = keyPressVerifyController;
    }

    public AutoCompletePage goToWebsite() {
        log.info("["+Thread.currentThread().getName()+"] " + "Go to website: " + directURL + "\n");
        Reporter.log("["+Thread.currentThread().getName()+"] " + "Go to website: " + directURL + "\n");

        driver.get().get(directURL);
        return this;
    }

    public static AutoCompletePage getAutoCompletePage(WebDriver driver) {
        log.info("["+Thread.currentThread().getName()+"] " + "Get Autocomplete page\n");
        Reporter.log("["+Thread.currentThread().getName()+"] " + "Get Autocomplete page\n");

        return new AutoCompletePage(driver, new AutoCompletePageVerifyController(driver));
    }

    /**
     * Act
     */
    public AutoCompletePage autocomplete(String address) {
        log.info("["+Thread.currentThread().getName()+"] " + "Enter in address field: " + address+ "\n");
        Reporter.log("["+Thread.currentThread().getName()+"] " + "Enter in address field: " + address + "\n");

        driver.get().findElement(address_field()).sendKeys(address);

        WebElement autoCompleteField = new WebDriverWait(driver.get(), Duration.ofSeconds(3))
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
    public static By h1() {
        return By.tagName("h1");
    }

}
