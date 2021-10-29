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

    private final String DIRECT_URL = "http://formy-project.herokuapp.com/scroll";

    private ScrollPageVerifyController scrollPageVerifyController;

    private ScrollPage(WebDriver driver, ScrollPageVerifyController scrollPageVerifyController) {
        super(driver);
        this.scrollPageVerifyController = scrollPageVerifyController;
    }

    public ScrollPage goToPage() {
        Log.info("["+Thread.currentThread().getName()+"] " + "Open page: " + DIRECT_URL);
        driver.get().get(DIRECT_URL);
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
        actions.moveToElement(driver.get().findElement(name_textbox())).build().perform();
        driver.get().findElement(name_textbox()).sendKeys(formValues.get("name"));
        driver.get().findElement(date_textbox()).sendKeys(formValues.get("date"));
        return this;
    }


    /**
     * Assert
     */
    public ScrollPageVerifyController verify() {
        return scrollPageVerifyController;
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
