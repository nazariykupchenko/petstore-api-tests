package org.education.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.response.ValidatableResponse;
import org.education.endpoints.PetEndPoint;
import org.education.models.PetModel;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.IOException;

import static org.education.utils.FileUtils.getPetPropertiesFromJson;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Pet tests")
@Feature("Pet tests feature")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PetTest {

    private final PetEndPoint petEndPoint = new PetEndPoint();
    private final PetModel pet = getPetPropertiesFromJson("src/main/resources/dog.json");
    private final int petId = pet.getId();

    public PetTest() throws IOException {
    }

    /**
     * Test to verify creation of a pet
     */
    @Test()
    @Order(1)
    @Description(useJavaDoc = true)
    void createPetTest() {
        petEndPoint.createPet(pet);
    }

    /**
     * Test to verify image upload to created pet
     */
    @Test
    @Order(2)
    @Description(useJavaDoc = true)
    void uploadPetImage() {
        petEndPoint.uploadImage("src/main/resources/dog-photo.jpg", petId);
    }

    /**
     * Test to verify successful api call
     */
    @Test
    @Order(3)
    @Description(useJavaDoc = true)
    void successfulResponseTest() {
        petEndPoint
                .getPetById(petId)
                .statusCode(200);
    }

    /**
     * Test to verify that request with invalid pet id gets 404 error
     */
    @Test
    @Order(4)
    @Description(useJavaDoc = true)
    void invalidPetIdTest() {
        int invalidPetId = -5554896;
        petEndPoint
                .getPetById(invalidPetId)
                .statusCode(404);
    }

    /**
     * Test to verify deletion of a pet
     */
    @Test
    @Order(5)
    @Description(useJavaDoc = true)
    void categoryNameTest() {
        ValidatableResponse validatableResponse = petEndPoint.getPetById(petId);
        String name = validatableResponse
                .statusCode(200)
                .extract()
                .response()
                .jsonPath()
                .getString("category.name");
        assertEquals("dog", name);
    }

    /**
     * Test to verify creation of a pet
     */
    @Test
    @Order(6)
    @Description(useJavaDoc = true)
    void deletePetTest() {
        petEndPoint.deletePetById(petId);
    }
}
