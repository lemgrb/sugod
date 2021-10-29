package org.example.pages.keypress;

import lombok.extern.slf4j.Slf4j;
import org.example.pages.Page;
import org.example.pages.common.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Slf4j
public class KeyPressPage extends Page {

    private final String DIRECT_URL = "http://formy-project.herokuapp.com/keypress";

    private KeyPressPageVerifyController keyPressVerifyController;

    private KeyPressPage(WebDriver driver, KeyPressPageVerifyController keyPressVerifyController) {
        super(driver);
        this.keyPressVerifyController = keyPressVerifyController;
    }

    public KeyPressPage goToPage() {
        Log.info("["+Thread.currentThread().getName()+"] " + "Open page: " + DIRECT_URL);

        driver.get().get(DIRECT_URL);
        return this;
    }

    public static KeyPressPage getKeyPressPage(WebDriver driver) {
        return new KeyPressPage(driver, new KeyPressPageVerifyController(driver));
    }

    /**
     * Act
     */

    public KeyPressPage submitForm(String fullName) {
        Log.info("["+Thread.currentThread().getName()+"] " + "Enter fullName: " + fullName);

        driver.get().findElement(fullname_textbox()).sendKeys(fullName);
        driver.get().findElement(submit_button()).click();
        return this;
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

}
