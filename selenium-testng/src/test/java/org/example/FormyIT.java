package org.example;

import lombok.extern.slf4j.Slf4j;
import org.example.pages.modal.ModalPage;
import org.openqa.selenium.ImmutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.example.pages.autocomplete.AutoCompletePage;
import org.example.pages.keypress.KeyPressPage;
import org.example.pages.scroll.ScrollPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class FormyIT {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeMethod(groups = "sanity")
    public void openBrowser() throws MalformedURLException {
        ImmutableCapabilities capabilities = new ImmutableCapabilities("browserName", "chrome");
        driver.set(new RemoteWebDriver(new URL("http://localhost:4444/"), capabilities));
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void verifyKeyPressPage() {
        KeyPressPage.getKeyPressPage(driver.get())
                .goToPage()
                .verify()
                .pageIsDisplayed();

        KeyPressPage.getKeyPressPage(driver.get())
                .submitForm("Some Name")
                .verify()
                .pageIsDisplayed();
    }

    @Test
    public void verifyAutocompletePage() {
        AutoCompletePage.getAutoCompletePage(driver.get())
                .goToPage()
                .verify()
                .pageIsDisplayed();

        AutoCompletePage.getAutoCompletePage(driver.get())
                .autocomplete("1555 Park Blvd, Palo Alto, CA")
                .verify()
                .allFieldsArePopulated();
    }

    @Test
    public void verifyScrollPage() {
        Map<String, String> formValues = new HashMap<>();
        formValues.put("name","Lemuel");
        formValues.put("date","10/27/2021");

        ScrollPage.getScrollPage(driver.get())
                .goToPage()
                .verify()
                .pageIsDisplayed();

        ScrollPage.getScrollPage(driver.get())
                .populateForm(formValues)
                .verify()
                .allFieldsArePopulated(formValues);
    }

    @Test(groups="sanity")
    public void verifyModalPage() throws InterruptedException {

        ModalPage.getModalPage(driver.get())
                 .goToPage()
                 .verify()
                 .pageIsDisplayed();

        ModalPage.getModalPage(driver.get())
                .goToPage()
                .openModal()
                .closeModal()
                .verify()
                .modalIsClosed();
    }

    @AfterMethod(groups = "sanity")
    public void closeBrowser() {
        if(driver.get()!=null)
            driver.get().quit();
    }
}
