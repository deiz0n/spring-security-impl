package com.deiz0n.springsecurity.controllers;

import com.deiz0n.springsecurity.domain.dtos.ProductDTO;
import com.deiz0n.springsecurity.domain.entities.Product;
import com.deiz0n.springsecurity.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getProducts() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody Product request) {
        var product = service.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

}
