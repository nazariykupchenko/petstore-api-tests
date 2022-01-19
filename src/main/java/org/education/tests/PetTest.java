package org.education.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.education.endpoints.PetEndPoint;
import org.education.models.PetModel;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.IOException;

import static org.education.utils.FileUtils.createPet;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("Pet tests")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PetTest {
    private final PetEndPoint petEndPoint = new PetEndPoint();
    private final PetModel pet = createPet("src/main/resources/data/pet.json");
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
        petEndPoint
                .createPet(pet)
                .assertThat()
                .statusCode(200);
    }

    /**
     * Test to verify image upload to created pet
     */
    @Test
    @Order(2)
    @Description(useJavaDoc = true)
    void uploadPetImage() {
        petEndPoint
                .uploadImage("src/main/resources/data/dog-photo.jpg", petId)
                .assertThat()
                .statusCode(200);
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
                .assertThat()
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
                .assertThat()
                .statusCode(404);
    }

    /**
     * Test to check availability of pets
     */
    @Test
    @Order(5)
    @Description(useJavaDoc = true)
    void getPetByStatusTest() {
        String status = "available";
        petEndPoint
                .getPetByStatus(status)
                .assertThat()
                .statusCode(200);
    }

    /**
     * Test to verify category name of created pet
     */
    @Test
    @Order(6)
    @Description(useJavaDoc = true)
    void categoryNameTest() {
        String name = petEndPoint
                .getPetById(petId)
                .assertThat()
                .statusCode(200)
                .extract()
                .response()
                .jsonPath()
                .getString("category.name");
        assertEquals("dog", name);
    }

    /**
     * Test to verify deletion of a pet
     */
    @Test
    @Order(7)
    @Description(useJavaDoc = true)
    void deletePetTest() {
        petEndPoint
                .deletePetById(petId)
                .assertThat()
                .statusCode(200);
    }
}
