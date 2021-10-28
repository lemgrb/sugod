package org.example.pages.dragdrop;

import lombok.extern.slf4j.Slf4j;
import org.example.pages.Page;
import org.example.pages.common.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

@Slf4j
public class DragAndDropPage extends Page {

    private final String DIRECT_URL = "http://formy-project.herokuapp.com/dragdrop";

    private DragAndDropVerifyController dragdropVerifyController;

    private DragAndDropPage(WebDriver driver, DragAndDropVerifyController dragdropVerifyController) {
        super(driver);
        this.dragdropVerifyController = dragdropVerifyController;
    }

    public DragAndDropPage goToPage() {
        Log.info("["+Thread.currentThread().getName()+"] " + "Open page: " + DIRECT_URL);
        driver.get().get(DIRECT_URL);
        return this;
    }

    public static DragAndDropPage getDragAndDropPage(WebDriver driver) {
        return new DragAndDropPage(driver, new DragAndDropVerifyController(driver));
    }

    /**
     * Act
     */

    public DragAndDropPage dragImageThenDrop() {
        // Scroll
        Actions actions = new Actions(driver.get());
        actions.dragAndDrop(driver.get().findElement(image()), driver.get().findElement(box()))
                .build()
                .perform();

        return this;
    }


    /**
     * Assert
     */
    public DragAndDropVerifyController verify() {
        return dragdropVerifyController;
    }

    /**
     * Locators : I use snake_case
     */

    public static By image() {
        return By.tagName("img");
    }

    public static By box() {
        return By.id("box");
    }


}
