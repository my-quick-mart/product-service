package com.quickkart.productservice.controller.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductCommandDto {
    private String name;
    private String description;
    private BigDecimal price;
}
