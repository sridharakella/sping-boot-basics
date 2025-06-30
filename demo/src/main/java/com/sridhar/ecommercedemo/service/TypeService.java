package com.sridhar.ecommercedemo.service;

import com.sridhar.ecommercedemo.entity.Type;
import com.sridhar.ecommercedemo.model.TypeResponse;

import java.util.List;

public interface TypeService {
    List<TypeResponse> getAllTypes();
}
