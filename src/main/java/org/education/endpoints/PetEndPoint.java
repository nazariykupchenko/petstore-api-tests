package org.education.endpoints;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.education.models.PetModel;

public class PetEndPoint {

    public RequestSpecification requestSpecification() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        return RestAssured
                .given()
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter())
                //.header("Connection", "keep-alive")
                .header("Content-Type", "application/json");
    }

    public ValidatableResponse createPet(PetModel body) {
        return requestSpecification()
                .body(body)
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter())
                .post("pet")
                .then();
    }

    public ValidatableResponse getPetById(int id) {
        return requestSpecification()
                .get("pet/" + id)
                .then();
    }

    public ValidatableResponse deletePetById(int id) {
        return requestSpecification()
                .delete("pet/" + id)
                .then();
    }
}
