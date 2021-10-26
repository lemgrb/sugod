package pages.autcompletepage;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

@Slf4j
public class AutoCompletePageVerifyController {

    private static final String header1 = "Autocomplete";

    private final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public AutoCompletePageVerifyController(WebDriver driver) {
        this.driver.set(driver);
    }

    public AutoCompletePageVerifyController pageIsDisplayed() {
        log.info("["+Thread.currentThread().getName()+"] " + "Verify page has header1 : " + header1 + "\n");
        Reporter.log("["+Thread.currentThread().getName()+"] " + "Verify page has header1: " + header1 + "\n");

        Assert.assertEquals(driver.get().findElement(AutoCompletePage.h1()).getText(), header1);
        return this;
    }

    public AutoCompletePageVerifyController allFieldsArePopulated() {
        log.info("["+Thread.currentThread().getName()+"] " + "Verify all fields are populated : " + header1 + "\n");
        Reporter.log("["+Thread.currentThread().getName()+"] " + "Verify all fields are populated: " + header1 + "\n");

        Assert.assertFalse(driver.get()
                .findElement(AutoCompletePage.address_field())
                .getAttribute("value").isBlank());

        // TODO: Assert other fields

        return this;
    }

}
