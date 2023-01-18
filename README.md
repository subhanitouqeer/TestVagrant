Tech Stack Used:

Java
Cucumber
Serenity-BDD
JUnit
Serenity is used for reporting purposes and you'll find the report under the "Target/site/serenity" directory, in the "index.html" file.

Build Tool: gradle

NOTE: Since there were no endpoints given, the json file was treated as a response and the required Validations have performed keeping this pre-requisite in mind.

Directions to Execute:

- The entirity of the program is under "src/test/java" as it should be.
- The project has been made in IntelliJ IDEA and gradle was the build tool.
- In order to generate a serenity report, you'll have to add a gradle configuration and under "Run" you'll have to enter "clean build test aggregate" and click on Okay.
- In case no reports are required, then simply click on the Run button from the IDE using the CucumberRunner Class file which is placed under "src/test/java/runner" and the test case should run fine
