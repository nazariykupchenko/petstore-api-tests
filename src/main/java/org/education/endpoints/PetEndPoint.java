package org.education.endpoints;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.MultiPartSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.response.ValidatableResponse;
import org.education.models.PetModel;

import java.io.File;

import static org.education.endpoints.Config.*;

public class PetEndPoint extends Api {

    public ValidatableResponse createPet(PetModel body) {
        return requestSpecification()
                .body(body)
                .post(CREATE_PET)
                .then();
    }

    public ValidatableResponse uploadImage(String filePath, int petId) {
        File file = new File(filePath);
        RestAssured.baseURI = Config.BASE_URI;
        return RestAssured
                .given()
                .filter(new AllureRestAssured()
                        .setRequestTemplate("http-request.ftl")
                        .setResponseTemplate("http-response.ftl"))
                .filter(new RequestLoggingFilter())
                .multiPart(new MultiPartSpecBuilder(file)
                        .fileName(file.getName())
                        .controlName("file")
                        .mimeType("multipart/form-data")
                        .build())
                .post(UPLOAD_IMAGE_BY_PET_ID, petId)
                .then();
    }

    public ValidatableResponse getPetById(int petId) {
        return requestSpecification()
                .get(GET_PET_BY_ID, petId)
                .then();
    }

    public ValidatableResponse getPetByStatus(String status) {
        return requestSpecification()
                .param("status", status)
                .get(GET_PET_BY_STATUS)
                .then();
    }

    public ValidatableResponse deletePetById(int petId) {
        return requestSpecification()
                .delete(DELETE_PET_BY_ID, petId)
                .then();
    }
}
