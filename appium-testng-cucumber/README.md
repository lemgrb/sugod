## Pre-requisite
1. Install java
2. Install mvn

## Steps
1. Generate maven project from archetype
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
By default, JUnit4 is used in pom.xml.
2. **Replace JUnit with TestNG and use Failsafe.** See [Parallel Execution
   ](https://cucumber.io/docs/guides/parallel-execution/). In JUnit the feature files are run in parallel rather than scenarios, which means all the scenarios in a feature file will be executed by the same thread. In TestNG the scenarios and rows in a scenario outline are executed in multiple threads.
