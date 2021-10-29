**SUT**: http://formy-project.herokuapp.com

## Based on Courses

1. https://www.linkedin.com/learning/selenium-essential-training
2. https://www.pluralsight.com/courses/automated-tests-java-fluent-interface-webdriver-selenium

## Areas of concern

| Concern | Implemented | Comment |
|---|---|---|
| Test data management | ❌ | Test data embedded in @Test methods. See [ExcelTestDataReader](https://github.com/lemgrb/testtemplates/blob/main/e2eweb/src/test/java/io/github/lemgrb/testtemplates/e2eweb/utilities/ExcelTestDataReader.java) as sample   |
| Assertion library | ✔ |TestNG |
| Screenshots and videos | ❌ | Please see [appium-testng-cucumber](../appium-testng-cucumber/README.md) |
| Reports | ✔| Failsafe report |
| Parallel execution | ✔ |Maven FailSafe plugin's parallel feature; Java's ThreadLocal class|
| Data-driven tests | ✔ | TestNG's data provider | 
| Keyword-driven tests | ❌ |  | 
| Logging and telemetry | ✔ | Used @slf4j paired with lombok for logging and TestNG Reporter.log|
| Automation library | ✔ | selenium-java |
| Design pattern : Page Object Model |✔ | See `org.example.pages` package |
| Design pattern : Fluent interface | ✔ | See @Test methods |
| Where are the test cases 'stored'? | ✔ |In @Test methods |
| BDD | ❌ |Please see [appium-testng-cucumber](../appium-testng-cucumber/README.md) |
| Remote execution and cross-browser testing | ✔ | Is using RemoteWebDriver |


## Pre-requisite

Browser drivers are in $PATH or %PATH%

## Tech stack:
- Selenium-java
- TestNG
- Lombok

## Design patterns
- Fluent interface
- Page Object (without PageFactory)

## Other:
- Parallel run using Failsafe


## To run
`mvn clean verify` or `mvn clean integration-test`
