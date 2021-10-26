package pages.common;

import org.openqa.selenium.WebDriver;

public class CommonVerification {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private CommonVerificationVerifyController commonVerificationVerifyController;

    public CommonVerification(WebDriver driver, CommonVerificationVerifyController commonVerificationVerifyController) {
        this.driver.set(driver);
        // TODO: Watch again the video why CommonVerificationVerifyController is instantiated in getCommonVerification()
        this.commonVerificationVerifyController = commonVerificationVerifyController;
    }

    public CommonVerificationVerifyController verify() {
        return commonVerificationVerifyController;
    }


    public static CommonVerification getCommonVerification(WebDriver driver) {
        return new CommonVerification(driver, new CommonVerificationVerifyController(driver));
    }

}
