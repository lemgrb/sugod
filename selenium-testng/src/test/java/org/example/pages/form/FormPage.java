package org.example.pages.form;

import lombok.extern.slf4j.Slf4j;
import org.example.pages.Page;
import org.example.pages.common.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

@Slf4j
public class FormPage extends Page {

    private final String DIRECT_URL = "http://formy-project.herokuapp.com/form";

    private FormPageVerifyController formPageVerifyController;

    private FormPage(WebDriver driver, FormPageVerifyController formPageVerifyController) {
        super(driver);
        this.formPageVerifyController = formPageVerifyController;
    }

    public FormPage goToPage() {
        Log.info("["+Thread.currentThread().getName()+"] " + "Open page: " + DIRECT_URL);
        driver.get().get(DIRECT_URL);
        return this;
    }

    public static FormPage getFormPage(WebDriver driver) {
        return new FormPage(driver, new FormPageVerifyController(driver));
    }

    /**
     * Act
     */

    public FormPage populateForm(Map<String,String> formValues) {
        Log.info("["+Thread.currentThread().getName()+"] " + "Enter first name: " + formValues.get("first_name") + "");
        Log.info("["+Thread.currentThread().getName()+"] " + "Enter last name: " + formValues.get("last_name") + "");
        Log.info("["+Thread.currentThread().getName()+"] " + "Enter job title: " + formValues.get("job_title") + "");
        Log.info("["+Thread.currentThread().getName()+"] " + "Enter highest level of education: " + formValues.get("highest_level_of_education") + "");
        Log.info("["+Thread.currentThread().getName()+"] " + "sex: " + formValues.get("sex") + "");
        Log.info("["+Thread.currentThread().getName()+"] " + "years of experience: " + formValues.get("years_of_experience") + "");
        Log.info("["+Thread.currentThread().getName()+"] " + "date: " + formValues.get("date") + "");

        driver.get().findElement(first_name()).sendKeys(formValues.get("first_name"));
        driver.get().findElement(last_name()).sendKeys(formValues.get("last_name"));
        driver.get().findElement(job_title()).sendKeys(formValues.get("job_title"));

        // Radio button
        List<WebElement> educationOptions = driver.get().findElements(highest_level_of_education_divs());
        for(WebElement e: educationOptions)
            if(e.getText().contains(formValues.get("highest_level_of_education")))
                driver.get().findElement(with(highest_level_of_education()).near(e)).click();

        // Sex check box
        List<WebElement> sexOptions = driver.get().findElements(sex_divs());
        for(WebElement e: sexOptions)
            if(e.getText().contains(formValues.get("sex")))
                driver.get().findElement(with(sex()).near(e)).click();

        // Dropdown
        Select select = new Select(driver.get().findElement(years_of_experience()));
        select.selectByVisibleText(formValues.get("years_of_experience"));

        // Date (just type in textbox)
        driver.get().findElement(date()).sendKeys(formValues.get("date"));
        driver.get().findElement(date()).click();

        // Submit
        driver.get().findElement(submit()).click();

        return this;
    }


    /**
     * Assert
     */
    public FormPageVerifyController verify() {
        return formPageVerifyController;
    }

    /**
     * Locators : I use snake_case
     */

    public static By first_name() {
        return By.id("first-name");
    }
    public static By last_name() {
        return By.id("last-name");
    }
    public static By job_title() {
        return By.id("job-title");
    }
    public static By highest_level_of_education_divs() {
        return By.xpath("//input[@type=\"radio\"]/parent::div");
    }
    public static By highest_level_of_education() {
        return By.cssSelector("input[type=radio]");
    }
    public static By sex_divs() {
        return By.xpath("//input[@type=\"checkbox\"]/parent::div");
    }
    public static By sex() {
        return By.cssSelector("input[type=checkbox]");
    }
    public static By years_of_experience() {
        return By.id("select-menu");
    }
    public static By date() {
        return By.id("datepicker");
    }
    public static By submit() {
        return By.cssSelector("a.btn");
    }


}
