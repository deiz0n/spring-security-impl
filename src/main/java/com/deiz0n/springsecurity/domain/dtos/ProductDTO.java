package com.deiz0n.springsecurity.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ProductDTO {

    private String id;
    private String name;
    private BigDecimal price;

}
