package org.education.endpoints;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public abstract class Api {

    public RequestSpecification requestSpecification() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        return RestAssured
                .given()
                //.filters(new RequestLoggingFilter(), new ResponseLoggingFilter())
                ;
    }
}
