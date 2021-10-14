## Areas of concern

| Concern | Implemented | Comment |
|---|---|---|
| Test data management | ✔ | Test data embedded in feature files. Add POI as dependency if need to read test data from Excel. See [ExcelTestDataReader](https://github.com/lemgrb/testtemplates/blob/main/e2eweb/src/test/java/io/github/lemgrb/testtemplates/e2eweb/utilities/ExcelTestDataReader.java) as sample   |
| Assertion library | ✔ |TestNG |
| Screenshots and videos | ✔ |Cucumber's Scenario.attach in @After hook for screenshots. For vids, just use built in recording from e.g. Saucelabs |
| Reports | ✔|Using cucumber plugins (HTML, timeline) |
| Parallel execution | ✔ |Maven FailSafe plugin's parallel feature; Java's ThreadLocal class|
| Data-driven tests | ✔ |Cucumber's Scenario outline, or TestNG's data provider | 
| Keyword-driven tests | ❌ |  | 
| Logging and telemetry | ❌ | Just use @slf4j paired with lombok for logging. Also read more about Jaeger - OpenTelemetry  [here (https://www.selenium.dev/documentation/grid/advanced_features/observability/)|
| Automation library | ✔ |Appium (extends Selenium) |
| Design pattern : Page Object Model |❌ | Not implemented |
| Design pattern : Fluent interface | ❌ |Not implemented |
| Where are the test cases 'stored'? | ✔ |In cucumber .feature files |
| BDD | ✔ |Cucumber + Gherkin |
| Remote execution and cross-browser testing | ❌ | Plan to use Saucelabs or similar service |

## Pre-requisite
1. Install java
2. Install mvn
3. [Install Appium Desktop and Android SDK](https://appium.io/docs/en/about-appium/getting-started/?lang=en)

## Steps
1. Generate maven project from archetype. By default, **JUnit4 is used in pom.xml**.
```bash
mvn archetype:generate                      \
   "-DarchetypeGroupId=io.cucumber"           \
   "-DarchetypeArtifactId=cucumber-archetype" \
   "-DarchetypeVersion=6.10.4"               \
   "-DgroupId=io.github.lemgrb"                  \
   "-DartifactId=appium-testng-cucumber"               \
   "-Dpackage=sugod"                  \
   "-Dversion=1.0.0-SNAPSHOT"                 \
   "-DinteractiveMode=false" 
```
2. **Replace JUnit with TestNG and use Failsafe.** See [Parallel Execution
   ](https://cucumber.io/docs/guides/parallel-execution/). In JUnit the feature files are run in parallel rather than scenarios, which means all the scenarios in a feature file will be executed by the same thread. In TestNG the scenarios and rows in a scenario outline are executed in multiple threads. To run, use `mvn integration-test` or `mvn verify`.
3. **Add Reports** : 
   1. For HTML Report, specify in command line `-Dcucumber.plugin="html:target\cucumber"` or `@CucumberOptions`
      ![HTML Report](cucumber-report.png)
   2. For Visual representation of threads, `@CucumberOptions(plugin= {"timeline:<report folder>"})`
      ![Cucumber threads visual](cucumber-threads-report.png)
4. Add Appium's 'java-client'. See [How to install latest java client Beta/Snapshots](https://github.com/appium/java-client#how-to-install-latest-java-client-betasnapshots)
5. Add example Gherkin and glue code for Login feature. See templates from [The starting of an app](https://github.com/appium/java-client/blob/master/docs/The-starting-of-an-Android-app.md)
   ![Example cucumber report](cucumber-report-1.png)
6. Add screenshot on failure in @After hook. Read more [here](https://cucumber.io/docs/guides/browser-automation/)
   ![Screenshot on failure](cucumber-report-screenshot-on-failure.png)