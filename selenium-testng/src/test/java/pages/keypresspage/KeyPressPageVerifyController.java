package pages.keypresspage;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

@Slf4j
public class KeyPressPageVerifyController {

    private static String header1 = "Keyboard and Mouse Input";

    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public KeyPressPageVerifyController(WebDriver driver) {
        this.driver.set(driver);
    }

    public KeyPressPageVerifyController pageIsDisplayed() {
        log.info("["+Thread.currentThread().getName()+"] " + "Verify page has header1 : " + header1 + "\n");
        Reporter.log("["+Thread.currentThread().getName()+"] " + "Verify page has header1: " + header1 + "\n");

        Assert.assertEquals(driver.get().findElement(KeyPressPage.h1()).getText(), header1);
        return this;
    }

}
