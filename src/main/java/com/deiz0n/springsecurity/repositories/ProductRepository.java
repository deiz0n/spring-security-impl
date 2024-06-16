package com.deiz0n.springsecurity.repositories;

import com.deiz0n.springsecurity.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
