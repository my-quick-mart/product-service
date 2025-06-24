package com.quickkart.productservice.repository;

import com.quickkart.productservice.TestDataHelper;
import com.quickkart.productservice.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

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
