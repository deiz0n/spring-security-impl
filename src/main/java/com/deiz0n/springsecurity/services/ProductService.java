package com.deiz0n.springsecurity.services;

import com.deiz0n.springsecurity.domain.dtos.ProductDTO;
import com.deiz0n.springsecurity.domain.entities.Product;
import com.deiz0n.springsecurity.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<ProductDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(product -> new ProductDTO(product.getId(), product.getName(), product.getPrice()))
                .toList();
    }

    public ProductDTO create(Product request) {
        var product =  repository.save(request);
        return new ProductDTO(product.getId(), product.getName(), product.getPrice());
    }
}
