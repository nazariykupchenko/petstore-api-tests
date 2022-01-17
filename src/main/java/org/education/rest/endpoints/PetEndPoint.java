package org.education.rest.endpoints;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.education.rest.models.PetModel;

public class PetEndPoint {

    public RequestSpecification requestSpecification() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        return RestAssured
                .given()
                .header("Connection", "keep-alive")
                .header("Content-Type", "application/json");
        //.filters(new RequestLoggingFilter(), new ResponseLoggingFilter())
    }

    public ValidatableResponse newCreatePet(PetModel body) {
        return requestSpecification()
                .body(body)
                .post("pet")
                .then();
    }

    public ValidatableResponse createPet(PetModel body) {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        return RestAssured
                .given()
                .header("Connection", "keep-alive")
                .header("Content-Type", "application/json")
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter())
                .body(body)
                .post("pet")
                .then();
    }
    public ValidatableResponse getPetById(int id){
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        return RestAssured
                .given()
                .header("Connection", "keep-alive")
                .header("Content-Type", "application/json")
                //.filters(new RequestLoggingFilter(), new ResponseLoggingFilter())
                .get("pet/" + id)
                .then();
    }
}
