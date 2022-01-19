package org.education.endpoints;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.education.models.OrderModel;

import static org.education.endpoints.Config.*;

public class StoreEndPoint extends Api {

    @Step
    public ValidatableResponse getInventoryByPetStatus(String status) {
        return requestSpecification()
                .param("status", status)
                .get(GET_INVENTORY_BY_STATUS)
                .then();
    }

    @Step
    public ValidatableResponse getOrderByIdTest(int Id) {
        return requestSpecification()
                .get(FIND_ORDER_BY_ID, Id)
                .then();
    }

    @Step
    public ValidatableResponse createOrderTest(OrderModel orderModel) {
        return requestSpecification()
                .body(orderModel)
                .post(CREATE_ORDER)
                .then();
    }

    @Step
    public ValidatableResponse deleteOrderTest(int Id) {
        return requestSpecification()
                .delete(DELETE_ORDER, Id)
                .then();
    }
}
