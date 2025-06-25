package com.quickmart.productservice.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.quickmart.productservice.repository")
public class BaseRepositoryTest {
    @Autowired
    protected ProductRepository productRepository;
}
