package org.education.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import org.education.endpoints.StoreEndPoint;
import org.education.models.OrderModel;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.IOException;

import static org.education.utils.FileUtils.createOrder;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.Is.isA;

@Epic("Order tests")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PetOrderTest {
    private final StoreEndPoint storeEndPoint = new StoreEndPoint();
    private final OrderModel order = createOrder("src/main/resources/data/order.json");
    private final int orderId = order.getId();
    private final String status = order.getStatus();

    public PetOrderTest() throws IOException {
    }

    /**
     * Test to verify adding of order
     */
    @Test()
    @Order(1)
    @Description(useJavaDoc = true)
    public void addOrderTest() {
        storeEndPoint
                .createOrderTest(order)
                .statusCode(200);
    }

    /**
     * Test to verify status and size of order
     */
    @Test
    @Order(2)
    @Description(useJavaDoc = true)
    public void getOrderByIdTest() {
        storeEndPoint
                .getOrderByIdTest(orderId)
                .statusCode(200)
                .body("size()", is(6))
                .body("status", is("placed"));
    }

    /**
     * Test to verify inventory
     */
    @Test
    @Order(3)
    @Description(useJavaDoc = true)
    public void getInventoryTest() {
        storeEndPoint
                .getInventoryByPetStatus(status)
                .statusCode(200)
                .body("sold", isA(Integer.class));
    }

    /**
     * Test to verify deletion of order
     */
    @Test
    @Order(4)
    @Description(useJavaDoc = true)
    public void deleteOrderTest() {
        storeEndPoint
                .deleteOrderTest(orderId)
                .statusCode(200);
    }
}
