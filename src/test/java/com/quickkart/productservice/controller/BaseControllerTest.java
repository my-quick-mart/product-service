package com.quickkart.productservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quickkart.productservice.TestDataHelper;

public class BaseControllerTest {

    protected final ObjectMapper objectMapper = new ObjectMapper();
    protected final TestDataHelper testDataHelper = TestDataHelper.getInstance();

    protected String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert to JSON", e);
        }
    }
}
