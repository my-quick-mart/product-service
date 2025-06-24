package com.quickkart.productservice;

import com.quickkart.productservice.dto.ProductCommandDto;

import java.math.BigDecimal;
import java.util.Objects;

public class TestDataHelper {

    // Must be volatile to avoid broken singleton in multithreaded env
    private static volatile TestDataHelper instance = null;

    private TestDataHelper() {}

    // Thread-safe lazy-loaded singleton using double-checked locking
    public static TestDataHelper getInstance() {
        if (instance != null) {
            return instance;
        }
        synchronized (TestDataHelper.class) {
            if (instance == null) {
                instance = new TestDataHelper();
            }
        }
        return instance;
    }

    public ProductCommandDto buildProjectCommandDto() {
        return ProductCommandDto.builder()
                .name("Samsung")
                .description("Latest model with new features")
                .price(BigDecimal.valueOf(200.99))
                .build();
    }
}
