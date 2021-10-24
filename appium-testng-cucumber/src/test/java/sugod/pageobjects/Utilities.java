package sugod.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

public class Utilities {

    /**
     * https://appium.io/docs/en/commands/interactions/touch/scroll/
     * @param driver
     * @param mobileElement
     */
    public static void scrollToElement(AppiumDriver driver, MobileElement mobileElement) {
        WebElement webElement = (WebElement) mobileElement;
        TouchActions actions = new TouchActions(driver);
        actions.scroll(webElement, 10, 100);
        actions.perform();
    }

    /**
     * Source: http://appium.io/docs/en/writing-running-appium/tutorial/swipe/android-simple/#:~:text=ScrollIntoView%20has%20UiSelector%20as%20search%20criteria%20input%20that,available%20search%20methods%20Android%20developer%20documentation%20for%20UiSelector.
     * @param driver
     * @param partialText
     */
    public  static void scrollToElementByPartialText(AppiumDriver driver, String partialText) {
        MobileElement element = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\""+partialText+"\"))"));

    }

}
