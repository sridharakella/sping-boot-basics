package com.sridhar.ecommercedemo.repository;

import com.sridhar.ecommercedemo.entity.Brand;
import com.sridhar.ecommercedemo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand,Integer> {
}
