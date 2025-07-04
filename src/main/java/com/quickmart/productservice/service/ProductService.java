package com.quickmart.productservice.service;

import com.quickmart.productservice.dto.ProductCommandDto;
import com.quickmart.productservice.dto.ProductQueryDto;
import com.quickmart.productservice.model.Product;
import com.quickmart.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public String create(ProductCommandDto dto) {
        Product product = Product.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .build();
        return productRepository.save(product).getId();
    }

    public List<ProductQueryDto> getAll() {
        return productRepository.findAll().stream().map(this::mapToProjectQueryDto).toList();
    }

    private ProductQueryDto mapToProjectQueryDto(Product it) {
        return ProductQueryDto.builder()
                .id(it.getId())
                .name(it.getName())
                .description(it.getDescription())
                .price(it.getPrice())
                .build();
    }
}
