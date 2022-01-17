package org.education.tests;

import io.restassured.response.ValidatableResponse;
import org.education.endpoints.PetEndPoint;
import org.education.models.CategoryModel;
import org.education.models.PetModel;
import org.education.models.TagModel;
import org.junit.Assert;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PetTest {

    PetEndPoint petEndPoint = new PetEndPoint();
    int petId = 1098656772;
    PetModel pet = new PetModel(
            petId,
            new CategoryModel(0, "string"), "tobby",
            new String[]{"www.zoo.com"},
            new TagModel(0, "string"), "available");

    @Test
    @Order(1)
    void createPetTest() {
        petEndPoint.createPet(pet);
    }

    @Test
    @Order(2)
    void categoryNameTest() {
        ValidatableResponse validatableResponse = petEndPoint.getPetById(petId);
        String name = validatableResponse.extract().response().jsonPath().getString("category.name");
        Assert.assertEquals("string", name);
    }

    @Test
    @Order(3)
    void successfulResponseTest() {
        ValidatableResponse validatableResponse = petEndPoint.getPetById(petId);
        int statusCode = validatableResponse.extract().statusCode();
        Assert.assertEquals(200, statusCode);
    }

    @Test
    @Order(4)
    void deletePetTest() {
        ValidatableResponse validatableResponse = petEndPoint.deletePetById(petId);
        int statusCode = validatableResponse.extract().statusCode();
        Assert.assertEquals(200, statusCode);
    }
}
