/**
 * This package contains all the pages for the SUT.
 * <p>
 * Each page has is paired with a "VerifyController" class.
 * But why am i doing this? This design is based on https://www.pluralsight.com/courses/automated-tests-java-fluent-interface-webdriver-selenium
 * On Selenium.dev guideline, they advise the Page Objects to not contain any assertion. The exceptions is the test
 * assertion that the user is on the correct page.
 * </p>
 *
 * @since 0.1
 * @author lemuel
 * @version 0.1
 */
package pages;