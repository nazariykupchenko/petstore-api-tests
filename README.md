# Petstore test automation project
[Swagger Petstore](https://petstore.swagger.io/)

##Tools
Java 8, Maven, RestAssured, JUnit 5, Lombok, Jackson Databind, Allure report

##Install
1. JDK 8
2. Maven
3. Intellij Idea or Eclipse

##Getting Started
`mvn clean test` - to run tests

Report can be generated with:
* `mvn allure:serve` - report will be generated into temp folder. Web server with results will start
* `mvn allure:report` - report will be generated to directory: target/site/allure-maven-plugin/index.html
* `mvn clean test allure:serve` or `mvn clean test allure:report` - to run tests and generate report
* `allure generate target/allure-results --clean -o target/allure-report` - allure command to generate report to: target/allure-report/index.html