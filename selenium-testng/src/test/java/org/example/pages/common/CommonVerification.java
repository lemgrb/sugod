package org.example.pages.common;

import org.openqa.selenium.WebDriver;

public class CommonVerification {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private CommonVerificationVerifyController commonVerificationVerifyController;

    private CommonVerification(WebDriver driver, CommonVerificationVerifyController commonVerificationVerifyController) {
        this.driver.set(driver);
        this.commonVerificationVerifyController = commonVerificationVerifyController;
    }

    public CommonVerificationVerifyController verify() {
        return commonVerificationVerifyController;
    }


    public static CommonVerification getCommonVerification(WebDriver driver) {
        return new CommonVerification(driver, new CommonVerificationVerifyController(driver));
    }

}
