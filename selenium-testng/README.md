**SUT**: http://formy-project.herokuapp.com

## Based on Courses

1. https://www.linkedin.com/learning/selenium-essential-training
2. https://www.pluralsight.com/courses/automated-tests-java-fluent-interface-webdriver-selenium

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
