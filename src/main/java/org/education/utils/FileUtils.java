package org.education.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.education.models.OrderModel;
import org.education.models.PetModel;

import java.io.IOException;
import java.nio.file.Paths;

public class FileUtils {

    public static PetModel createPet(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(Paths.get(path).toFile(), PetModel.class);
    }

    public static OrderModel createOrder(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(Paths.get(path).toFile(), OrderModel.class);
    }
}
