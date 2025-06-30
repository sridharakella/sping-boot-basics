package com.sridhar.ecommercedemo.repository;

import com.sridhar.ecommercedemo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

// basically interacting with different DB
public interface ProductRepository extends JpaRepository<Product,Integer> {

}
