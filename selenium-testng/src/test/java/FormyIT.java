import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.ImmutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.autcompletepage.AutoCompletePage;
import pages.keypresspage.KeyPressPage;

import java.net.MalformedURLException;
import java.net.URL;

@Slf4j
public class FormyIT {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeMethod
    public void init() throws MalformedURLException {
        ImmutableCapabilities capabilities = new ImmutableCapabilities("browserName", "chrome");
        driver.set(new RemoteWebDriver(new URL("http://localhost:4444/"), capabilities));
    }

    @Test
    public void verifyKeyPressPage() {
        KeyPressPage.getKeyPressPage(driver.get())
                .goToWebsite()
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
                .goToWebsite()
                .verify()
                .pageIsDisplayed();

        AutoCompletePage.getAutoCompletePage(driver.get())
                .autocomplete("1555 Park Blvd, Palo Alto, CA")
                .verify()
                .allFieldsArePopulated();
    }

    @AfterMethod
    public void tearDown() {
        if(driver.get()!=null)
            driver.get().quit();
    }
}
