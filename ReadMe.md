### Intro
Selenium demo using Sernity, JBehave and Gradle

Running:
Type the followin to run the project
`gradle test aggregate`

http://thucydides.info/docs/serenity/#_building_serenity_projects_in_gradle

The serenity-gradle-plugin adds below two tasks to your project:

* aggregate
Generates the Serenity aggregate reports from the JSON test results produced when you run the Serenity BDD tests.

* checkOutcomes
Check the test results in the output directory, and fail the build if there are errors or failures.
A typical use case is to run the tests and to always produce the aggregate report, no matter what the test results are. To do this in one line, you need to tell Gradle not to stop if the tests fail. You can do this by setting gradle.startParameter.continueOnFailure to true, and then running the following:

gradle test aggregate
This will run the tests and generate an aggregate report in the target/site/thucydides directory.

### Structure

```
├── ReadMe.md  ## ReadME file of cource ;)
├── build.gradle ## gradle build file 
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradlew ## grdadle warapper
├── src
│   └── test
│       ├── java
│       │   └── test
│       │       ├── WebTest.java ## This is where the tests resides which add all the steps using net.serenitybdd.jbehave.SerenityStepFactory
│       │       └── selenium
│       │           ├── page ## This where all the pages extending net.serenitybdd.core.pages.PageObject
│       │           │   ├── google
│       │           │   │   └── GoogleLanding.java
│       │           │   └── interfaces
│       │           │       └── Landing.java
│       │           └── steps ## Pages are used in steps 
│       │               └── GoogleSteps.java
│       └── resources
│           └── stories
│               └── google
│                   ├── Search2.story
│                   └── search.story
```

###### Refrences

* [jbehave]: http://jbehave.org/
* [gradle]: http://gradle.org/ 
* [serenity]: http://thucydides.info/docs/serenity/#first-steps
