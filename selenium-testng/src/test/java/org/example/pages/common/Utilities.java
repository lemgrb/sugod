package org.example.pages.common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utilities {

    /**
     * Javascript click if WebElement.click() does not work for any reason.
     * @param driver
     * @param element
     */
    public static void click(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",element);
    }
}
