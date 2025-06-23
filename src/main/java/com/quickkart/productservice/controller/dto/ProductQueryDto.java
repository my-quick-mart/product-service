package com.quickkart.productservice.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductQueryDto {
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
}

