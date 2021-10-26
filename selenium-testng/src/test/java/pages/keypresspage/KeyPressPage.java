package pages.keypresspage;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

@Slf4j
public class KeyPressPage {

    private String directURL = "http://formy-project.herokuapp.com/keypress";

    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private KeyPressPageVerifyController keyPressVerifyController;

    private KeyPressPage(WebDriver driver, KeyPressPageVerifyController keyPressVerifyController) {
        this.driver.set(driver);
        this.keyPressVerifyController = keyPressVerifyController;
    }

    public KeyPressPage goToWebsite() {
        log.info("["+Thread.currentThread().getName()+"] " + "Go to website: " + directURL + "\n");
        Reporter.log("["+Thread.currentThread().getName()+"] " + "Go to website: " + directURL + "\n");

        driver.get().get(directURL);
        return this;
    }

    public static KeyPressPage getKeyPressPage(WebDriver driver) {
        log.info("["+Thread.currentThread().getName()+"] " + "Get KeyPress page\n");
        Reporter.log("["+Thread.currentThread().getName()+"] " + "Get KeyPress page\n");

        return new KeyPressPage(driver, new KeyPressPageVerifyController(driver));
    }

    /**
     * Act
     */

    public KeyPressPage submitForm(String fullName) {
        log.info("["+Thread.currentThread().getName()+"] " + "Enter fullName: " + fullName + "\n");
        Reporter.log("["+Thread.currentThread().getName()+"] " + "Enter fullName: " + fullname_textbox() + "\n");

        driver.get().findElement(fullname_textbox()).sendKeys(fullName);
        driver.get().findElement(submit_button()).click();
        return this;
    }

    public String getHeader1() {
        String header1 = driver.get().findElement(fullname_textbox()).getText();
        log.info("["+Thread.currentThread().getName()+"] " + "Getting Header1: " + header1 + "\n");
        Reporter.log("["+Thread.currentThread().getName()+"] " + "Getting Header1: " + header1 + "\n");

        return header1;
    }


    /**
     * Assert
     */
    public KeyPressPageVerifyController verify() {
        return keyPressVerifyController;
    }

    /**
     * Locators
     */

    public static By fullname_textbox() {
        return By.id("name");
    }

    public static By submit_button() {
        return By.id("button");
    }

    public static By h1() {
        return By.tagName("h1");
    }

}
