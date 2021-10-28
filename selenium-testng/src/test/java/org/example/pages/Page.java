package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.example.pages.common.Log;

public abstract class Page {

    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public Page(WebDriver driver) {
        this.driver.set(driver);
    }

    public abstract Page goToPage();

    public String getHeading1() {
        String header1 = driver.get().findElement(h1()).getText();
        Log.info("["+Thread.currentThread().getName()+"] " + "Getting Header1: " + header1 + "");

        return header1;
    }

    /**
     * Locators : I use snake_case
     */

    public static By h1() {
        return By.tagName("h1");
    }
}
