package org.education.endpoints;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import static org.education.endpoints.Config.BASE_URI;

public abstract class Api {

    public RequestSpecification requestSpecification() {
        RestAssured.baseURI = BASE_URI;
        return RestAssured
                .given()
                .contentType("application/json")
                .filter(new AllureRestAssured()
                        .setRequestTemplate("http-request.ftl")
                        .setResponseTemplate("http-response.ftl"));
    }
}
