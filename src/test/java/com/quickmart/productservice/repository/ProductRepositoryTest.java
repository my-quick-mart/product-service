package com.quickmart.productservice.repository;

import com.quickmart.productservice.model.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
class ProductRepositoryIntegrationTest extends BaseRepositoryTest {

    @Autowired
    private RepositoryTestDataHelper repositoryTestDataHelper;

    @AfterEach
    void tearDown() {
        productRepository.deleteAll();
    }

    @Test
    void shouldSaveProductSuccessfully() {
        // Arrange
        Product product = repositoryTestDataHelper.createProduct();
        product.setName("Test Product");
        product.setDescription("Test Description");
        product.setPrice(BigDecimal.valueOf(999.99));
        // Act
        Product saved = productRepository.save(product);

        // Assert
        assertNotNull(saved.getId(), "Saved product should have an ID");
        Optional<Product> found = productRepository.findById(saved.getId());
        assertTrue(found.isPresent(), "Product should be found in DB");

        Product fetched = found.get();
        assertEquals("Test Product", fetched.getName());
        assertEquals("Test Description", fetched.getDescription());
        assertEquals(BigDecimal.valueOf(999.99), fetched.getPrice());
    }
}