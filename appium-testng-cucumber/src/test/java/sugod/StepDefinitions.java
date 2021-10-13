package sugod;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class StepDefinitions {

    private static long TIMEOUT_IN_SECONDS = 10;
    private ThreadLocal<AppiumDriver<MobileElement>> driver;

    @Given("Step from {string} in {string} feature file")
    public void step(String scenario, String file) {
        System.out.format("Thread ID - %2d - %s from %s feature file.\n",
                Thread.currentThread().getId(), scenario,file);
    }

    /**
     * Module: Authentication
     */
    @Given("Lemuel opens the SurveyMonkey app")
    public void lemuel_opens_the_survey_monkey_app() throws MalformedURLException {
        File app  = new File("C:/Users/testersnotes/Downloads/surveymonkey.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "3441e22");
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        driver = new ThreadLocal<AppiumDriver<MobileElement>>();
        driver.set(new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities));
        WebDriverWait wait = new WebDriverWait(driver.get(), TIMEOUT_IN_SECONDS);
        MobileElement appRanking = (MobileElement) wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("com.surveymonkey:id/app_ranking")));
        Assert.assertTrue(appRanking.isDisplayed());
    }

    @When("he logs in using valid username {string} and password {string}")
    public void he_logs_in_using_valid_username_and_password(String username, String password) {
        WebDriverWait wait = new WebDriverWait(driver.get(), TIMEOUT_IN_SECONDS);
        MobileElement signInButton = (MobileElement) wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("com.surveymonkey:id/sign_in_button")));
        signInButton.click();

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@text,'Welcome back!')]")));

        MobileElement usernameInput = driver.get().findElement(By.id("com.surveymonkey:id/username_input"));
        MobileElement passwordInput = driver.get().findElement(By.id("com.surveymonkey:id/password_input"));
        MobileElement signInButtonOnLoginPage = driver.get().findElement(By.id("com.surveymonkey:id/sign_in_button"));

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        signInButtonOnLoginPage.click();
    }


    @Then("he is redirected to the home screen")
    public void he_is_redirected_to_the_home_screen() {
        WebDriverWait wait = new WebDriverWait(driver.get(), TIMEOUT_IN_SECONDS);
        MobileElement createSurveyButton = (MobileElement) wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@text,'CREATE SURVEY')]")));
        Assert.assertTrue(createSurveyButton.isDisplayed());
    }

    @When("he logs out")
    public void he_logs_out() {
        driver.get().findElement(
                By.xpath("//*[contains(@resource-id,'com.surveymonkey:id/bottom_navigation_small_container')][3]")).click();

        WebDriverWait wait = new WebDriverWait(driver.get(), TIMEOUT_IN_SECONDS);
        MobileElement signoutButton = (MobileElement) wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@text,'SIGN OUT')]")));

        signoutButton.click();
    }

    @Given("he is redirected to the landing screen")
    public void he_is_redirected_to_the_landing_screen() {
        WebDriverWait wait = new WebDriverWait(driver.get(), TIMEOUT_IN_SECONDS);
        MobileElement appRanking = (MobileElement) wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("com.surveymonkey:id/app_ranking")));
        Assert.assertTrue(appRanking.isDisplayed());
    }

    @After
    public void teardown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "name");
        }
        if(driver!=null && driver.get()!=null)
            driver.get().quit();
    }


}
