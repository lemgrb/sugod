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
