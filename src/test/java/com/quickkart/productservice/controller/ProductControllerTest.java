package com.quickkart.productservice.controller;

import com.quickkart.productservice.dto.ProductCommandDto;
import com.quickkart.productservice.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
@Import(ProjectControllerTestConfig.class)
class ProductControllerTest extends BaseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductService productService;

    @Test
    void shouldReturnCreated_whenCreateProduct() throws Exception {
        ProductCommandDto dto = testDataHelper.buildProjectCommandDto();
        when(productService.create(any())).thenReturn("123");

        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJson(dto))) // ✅ Clean!
                .andExpect(status().isCreated());
    }

    @Test
    void shouldReturnBadRequest_whenNameIsBlank() throws Exception {
        ProductCommandDto dto = ProductCommandDto.builder()
                .name("  ")  // invalid
                .description("Some product")
                .price(BigDecimal.valueOf(10))
                .build();

        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJson(dto)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturnBadRequest_whenDescriptionIsBlank() throws Exception {
        ProductCommandDto dto = ProductCommandDto.builder()
                .name("Some name")
                .description(" ")  // invalid
                .price(BigDecimal.valueOf(10))
                .build();

        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJson(dto)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturnBadRequest_whenPriceIsNull() throws Exception {
        ProductCommandDto dto = ProductCommandDto.builder()
                .name("Product name")
                .description("Something")
                .price(null)  // invalid
                .build();

        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(toJson(dto)))
                .andExpect(status().isBadRequest());
    }
}