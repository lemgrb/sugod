package org.example.pages.radiobutton;

import lombok.extern.slf4j.Slf4j;
import org.example.pages.Page;
import org.example.pages.common.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Map;

@Slf4j
public class RadioButtonPage extends Page {

    private final String DIRECT_URL = "http://formy-project.herokuapp.com/radiobutton";

    private RadioButtonPageVerifyController radioButtonPageVerifyController;

    private RadioButtonPage(WebDriver driver, RadioButtonPageVerifyController radioButtonPageVerifyController) {
        super(driver);
        this.radioButtonPageVerifyController = radioButtonPageVerifyController;
    }

    public RadioButtonPage goToPage() {
        Log.info("["+Thread.currentThread().getName()+"] " + "Open page: " + DIRECT_URL);
        driver.get().get(DIRECT_URL);
        return this;
    }

    public static RadioButtonPage getRadioButtonPage(WebDriver driver) {
        return new RadioButtonPage(driver, new RadioButtonPageVerifyController(driver));
    }

    /**
     * Act
     */

    public RadioButtonPage selectOption(String value) {
        Log.info("["+Thread.currentThread().getName()+"] " + "Select radio button with value: " + value + "");
        WebElement radioButton = driver.get().findElement(radio_button_with_value(value));
        radioButton.click();
        return this;
    }


    /**
     * Assert
     */
    public RadioButtonPageVerifyController verify() {
        return radioButtonPageVerifyController;
    }

    /**
     * Locators : I use snake_case
     */

    public static By radio_button_with_value(String value) {
        return By.xpath("//label[contains(text(),'"+value+"')]/preceding-sibling::input[@type=\"radio\"]");
    }

}
