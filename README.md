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
* `mvn clean test allure:serve` - to run tests and generate report