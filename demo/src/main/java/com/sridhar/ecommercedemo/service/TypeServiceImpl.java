package com.sridhar.ecommercedemo.service;

import com.sridhar.ecommercedemo.entity.Type;
import com.sridhar.ecommercedemo.model.TypeResponse;
import com.sridhar.ecommercedemo.repository.BrandRepository;
import com.sridhar.ecommercedemo.repository.TypeRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class TypeServiceImpl implements TypeService {

    private final TypeRepository typeRepository;

    public TypeServiceImpl(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;

    }

    @Override
    public List<TypeResponse> getAllTypes() {
        log.info("Fetching all Types");
        //Fetch Types from DB
        List<Type> typeList = typeRepository.findAll();
        //now use stream operator to map with response
        List<TypeResponse> typeResponses = typeList.stream()
                .map(this::convertToTypeResponse)
                .collect(Collectors.toList());
        log.info("Fetched all Types");
        return typeResponses;
    }

    private TypeResponse convertToTypeResponse(Type type) {
        return TypeResponse.builder()
                .id(type.getId())
                .name(type.getName())
                .build();
    }
}
