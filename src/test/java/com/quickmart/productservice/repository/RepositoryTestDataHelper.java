package com.quickmart.productservice.repository;

import com.quickmart.productservice.model.Product;
import org.springframework.boot.test.context.TestComponent;

import java.math.BigDecimal;

@TestComponent
public class RepositoryTestDataHelper extends BaseRepositoryTest {

    public Product createProduct() {
        Product product = new Product();
        product.setName("Test Product");
        product.setDescription("Test Description");
        product.setPrice(BigDecimal.valueOf(999.99));
        return productRepository.save(product);
    }
}
