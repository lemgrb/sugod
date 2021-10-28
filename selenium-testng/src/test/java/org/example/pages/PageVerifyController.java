package org.example.pages;

import lombok.extern.slf4j.Slf4j;
import org.example.pages.keypress.KeyPressPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

/**
 * The SUT do not have titles so we verify if page is displayed
 * by checking the <h1>Heading 1</h1>
 */
@Slf4j
public abstract class PageVerifyController {

    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected static String heading1 = "Note to tester: No <h1> tag specified in child class.";

    public PageVerifyController(WebDriver driver) {
        this.driver.set(driver);
    }

    public abstract PageVerifyController pageIsDisplayed();
}
