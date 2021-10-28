package org.example.pages.bootstrapdropdown;

import lombok.extern.slf4j.Slf4j;
import org.example.pages.Page;
import org.example.pages.common.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class BootstrapDropdownPage extends Page {

    private final String DIRECT_URL = "http://formy-project.herokuapp.com/dropdown";

    private BootstrapDropdownPageVerifyController dropdownVerifyController;

    private BootstrapDropdownPage(WebDriver driver, BootstrapDropdownPageVerifyController dropdownVerifyController) {
        super(driver);
        this.dropdownVerifyController = dropdownVerifyController;
    }

    public BootstrapDropdownPage goToPage() {
        Log.info("["+Thread.currentThread().getName()+"] " + "Open page: " + DIRECT_URL);
        driver.get().get(DIRECT_URL);
        return this;
    }

    public static BootstrapDropdownPage getBootstrapDropdownPage(WebDriver driver) {
        return new BootstrapDropdownPage(driver, new BootstrapDropdownPageVerifyController(driver));
    }

    /**
     * Act
     */

    public BootstrapDropdownPage selectDropdownItem(String value) {
        Log.info("["+Thread.currentThread().getName()+"] " + "Select dropdown with value: " + value + "");
        driver.get().findElement(dropdown()).click();
        List<WebElement> dropdownItems = driver.get().findElements(dropdown_items(value));
        for(WebElement e: dropdownItems)
            if(e.getText().equalsIgnoreCase(value))
                e.click();

        return this;
    }


    /**
     * Assert
     */
    public BootstrapDropdownPageVerifyController verify() {
        return dropdownVerifyController;
    }

    /**
     * Locators : I use snake_case
     */

    public static By dropdown() {
        return By.cssSelector("#dropdownMenuButton");
    }

    public static By dropdown_items(String value) {
        return By.cssSelector("#dropdownMenuButton+div>a");
    }

}
