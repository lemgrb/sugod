package org.example;

import lombok.extern.slf4j.Slf4j;
import org.example.pages.bootstrapdropdown.BootstrapDropdownPage;
import org.example.pages.common.CommonVerification;
import org.example.pages.dragdrop.DragAndDropPage;
import org.example.pages.form.FormPage;
import org.example.pages.modal.ModalPage;
import org.example.pages.radiobutton.RadioButtonPage;
import org.openqa.selenium.ImmutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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

    @Test
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

    public void verifyDragAndDropPage() throws InterruptedException {

        DragAndDropPage.getDragAndDropPage(driver.get())
                .goToPage()
                .verify()
                .pageIsDisplayed();

        DragAndDropPage.getDragAndDropPage(driver.get())
                .goToPage()
                .dragImageThenDrop()
                .verify()
                .imageIsInTheBox();
    }

    @Test
    public void verifyRadioButtonPage() throws InterruptedException {

        RadioButtonPage.getRadioButtonPage(driver.get())
                .goToPage()
                .verify()
                .pageIsDisplayed();

        RadioButtonPage.getRadioButtonPage(driver.get())
                .goToPage()
                .selectOption("Radio button 3")
                .verify()
                .radioButtonIsSelected("Radio button 3");
    }

    @Test
    public void verifySelectItemFromDropdown() throws InterruptedException {

        BootstrapDropdownPage.getBootstrapDropdownPage(driver.get())
                .goToPage()
                .verify()
                .pageIsDisplayed();

        BootstrapDropdownPage.getBootstrapDropdownPage(driver.get())
                .goToPage()
                .selectDropdownItem("Modal");

        ModalPage.getModalPage(driver.get())
                .goToPage()
                .verify()
                .pageIsDisplayed();
    }

    @DataProvider(name = "formTestData")
    public Object[][] formTestData() {
        Map<String,String> set1 = new HashMap<>();
        set1.put("first_name","Lemuel");
        set1.put("last_name","B");
        set1.put("job_title","None");
        set1.put("highest_level_of_education", "College");
        set1.put("sex", "Female");
        set1.put("years_of_experience", "2-4");
        set1.put("date", "10/22/2021");

        Map<String,String> set2 = new HashMap<>();
        set2.put("first_name","Firstname");
        set2.put("last_name","Lastname");
        set2.put("job_title","None");
        set2.put("highest_level_of_education", "College");
        set2.put("sex", "Female");
        set2.put("years_of_experience", "2-4");
        set2.put("date", "10/22/2021");
        // OBJECT LITERAL
        return new Object[][] {
                {set1},
                {set2}
        };
    }


    @Test(groups="sanity", dataProvider = "formTestData")
    public void verifyForm(HashMap formValues) throws InterruptedException {


        FormPage.getFormPage(driver.get())
                .goToPage()
                .verify()
                .pageIsDisplayed();

        FormPage.getFormPage(driver.get())
                .goToPage()
                .populateForm(formValues);

        CommonVerification.getCommonVerification(driver.get())
                .verify()
                .textIsDisplayed("The form was successfully submitted!");

    }

    @AfterMethod(groups = "sanity")
    public void closeBrowser() {
        if(driver.get()!=null)
            driver.get().quit();
    }
}
