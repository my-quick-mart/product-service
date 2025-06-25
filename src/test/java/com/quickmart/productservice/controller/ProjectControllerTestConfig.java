package com.quickmart.productservice.controller;

import com.quickmart.productservice.service.ProductService;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class ProjectControllerTestConfig {
    @Bean
    public ProductService productService() {
        return Mockito.mock(ProductService.class);
    }
}
