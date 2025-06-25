package com.quickmart.productservice.controller;

import com.quickmart.productservice.dto.ProductCommandDto;
import com.quickmart.productservice.dto.ProductQueryDto;
import com.quickmart.productservice.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid ProductCommandDto dto) {
        try {
            log.info("Creating product with payload: {}", dto);
            String id = productService.create(dto);
            log.info("Successfully created product with id {} for payload: {}", id, dto);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            log.error("Error when creating product with payload: {}\nError details: {}", dto, e.getMessage());
            throw e;
        }
    }

    @GetMapping
    public ResponseEntity<List<ProductQueryDto>> getAll() {
        try {
            List<ProductQueryDto> list = productService.getAll();
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            log.error("Error when getting all products. Error details: {}", e.getMessage());
            throw e;
        }

    }
}
