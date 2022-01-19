package org.education.endpoints;

public class Config {
    static final String BASE_URI = "https://petstore.swagger.io/v2";
    static final String CREATE_PET = "pet";
    static final String UPLOAD_IMAGE_BY_PET_ID = "/pet/{petId}/uploadImage";
    static final String GET_PET_BY_ID = "pet/{petID}";
    static final String GET_PET_BY_STATUS = "pet/findByStatus";
    static final String DELETE_PET_BY_ID = "pet/{petID}";
    static final String CREATE_ORDER = "/store/order";
    static final String GET_INVENTORY_BY_STATUS = "/store/inventory";
    static final String FIND_ORDER_BY_ID = "/store/order/{orderId}";
    static final String DELETE_ORDER = "/store/order/{orderId}";
}
