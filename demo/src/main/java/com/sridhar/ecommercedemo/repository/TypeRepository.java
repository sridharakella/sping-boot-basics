package com.sridhar.ecommercedemo.repository;

import com.sridhar.ecommercedemo.entity.Brand;
import com.sridhar.ecommercedemo.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Type,Integer> {
}
