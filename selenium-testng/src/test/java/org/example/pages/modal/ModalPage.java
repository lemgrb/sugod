package org.example.pages.modal;

import lombok.extern.slf4j.Slf4j;
import org.example.pages.Page;
import org.example.pages.common.Log;
import org.example.pages.common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Slf4j
public class ModalPage extends Page {

    private String directURL = "http://formy-project.herokuapp.com/modal";

    private ModalPageVerifyController keyPressVerifyController;

    private ModalPage(WebDriver driver, ModalPageVerifyController keyPressVerifyController) {
        super(driver);
        this.keyPressVerifyController = keyPressVerifyController;
    }

    public ModalPage goToPage() {
        Log.info("["+Thread.currentThread().getName()+"] " + "Open page: " + directURL + "");
        driver.get().get(directURL);
        return this;
    }

    public static ModalPage getModalPage(WebDriver driver) {
        return new ModalPage(driver, new ModalPageVerifyController(driver));
    }

    /**
     * Act
     */

    public ModalPage openModal() throws InterruptedException {
        Log.info("["+Thread.currentThread().getName()+"] " + "Open modal");

        driver.get().findElement(modal_button()).click();
        new WebDriverWait(driver.get(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(modal()));
        return this;
    }

    /**
     * The method demonstrates clicking via JS Executor. Using WebElement.click returns ElementNotInteractableException
     * @return
     */
    public ModalPage closeModal() {
        Log.info("["+Thread.currentThread().getName()+"] " + "Click the [x] button");

        Utilities.click(driver.get(), driver.get().findElement(close_button()));

        new WebDriverWait(driver.get(), Duration.ofSeconds(10))
                .until(ExpectedConditions.invisibilityOfElementLocated(modal()));

        return this;
    }


    /**
     * Assert
     */
    public ModalPageVerifyController verify() {
        return keyPressVerifyController;
    }

    /**
     * Locators : I use snake_case
     */

    public static By modal_button() {
        return By.id("modal-button");
    }
    public static By modal() {
        return By.id("exampleModal");
    }
    public static By close_button() {
        return By.id("close-button");
    }


}
