package org.example.pages.scroll;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.example.pages.Page;
import org.example.pages.common.Log;

import java.util.Map;

@Slf4j
public class ScrollPage extends Page {

    private String directURL = "http://formy-project.herokuapp.com/scroll";

    private ScrollPageVerifyController keyPressVerifyController;

    private ScrollPage(WebDriver driver, ScrollPageVerifyController keyPressVerifyController) {
        super(driver);
        this.keyPressVerifyController = keyPressVerifyController;
    }

    public ScrollPage goToPage() {
        Log.info("["+Thread.currentThread().getName()+"] " + "Open page: " + directURL + "");
        driver.get().get(directURL);
        return this;
    }

    public static ScrollPage getScrollPage(WebDriver driver) {
        return new ScrollPage(driver, new ScrollPageVerifyController(driver));
    }

    /**
     * Act
     */

    public ScrollPage populateForm(Map<String,String> formValues) {
        Log.info("["+Thread.currentThread().getName()+"] " + "Enter name: " + formValues.get("name") + "");
        Log.info("["+Thread.currentThread().getName()+"] " + "Enter date: " + formValues.get("date") + "");

        // Scroll
        Actions actions = new Actions(driver.get());
        actions.moveToElement(driver.get().findElement(name_textbox()));
        driver.get().findElement(name_textbox()).sendKeys(formValues.get("name"));
        driver.get().findElement(date_textbox()).sendKeys(formValues.get("date"));
        return this;
    }


    /**
     * Assert
     */
    public ScrollPageVerifyController verify() {
        return keyPressVerifyController;
    }

    /**
     * Locators : I use snake_case
     */

    public static By name_textbox() {
        return By.id("name");
    }

    public static By date_textbox() {
        return By.id("date");
    }


}
