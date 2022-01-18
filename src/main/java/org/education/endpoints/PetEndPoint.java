package org.education.endpoints;

import io.restassured.builder.MultiPartSpecBuilder;
import io.restassured.response.ValidatableResponse;
import org.education.models.PetModel;

import java.io.File;

public class PetEndPoint extends Api {

    public ValidatableResponse createPet(PetModel body) {
        return requestSpecification()
                .header("Content-Type", "application/json")
                .body(body)
                .post("pet")
                .then()
                .assertThat()
                .statusCode(200);
    }

    public ValidatableResponse uploadImage(String filePath, int petId) {
        File file = new File(filePath);
        return requestSpecification()
                .multiPart(new MultiPartSpecBuilder(file)
                        .fileName(file.getName())
                        .controlName("file")
                        .mimeType("multipart/form-data")
                        .build())
                .post("pet/" + petId + "/uploadImage")
                .then()
                .assertThat()
                .statusCode(200);
    }

    public ValidatableResponse getPetById(int petId) {
        return requestSpecification()
                .header("Content-Type", "application/json")
                .get("pet/" + petId)
                .then();
    }

    public ValidatableResponse deletePetById(int petId) {
        return requestSpecification()
                .header("Content-Type", "application/json")
                .delete("pet/" + petId)
                .then()
                .assertThat()
                .statusCode(200);
    }
}
