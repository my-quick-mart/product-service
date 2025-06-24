package com.quickkart.productservice.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.quickkart.productservice.repository")
public class BaseRepositoryTest {
    @Autowired
    protected ProductRepository productRepository;
}
