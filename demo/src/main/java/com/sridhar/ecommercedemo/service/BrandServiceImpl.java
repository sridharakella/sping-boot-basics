package com.sridhar.ecommercedemo.service;

import com.sridhar.ecommercedemo.entity.Brand;
import com.sridhar.ecommercedemo.model.BrandResponse;
import com.sridhar.ecommercedemo.repository.BrandRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class BrandServiceImpl implements BrandService {

// Implememnting via Autowiring
//   @Autowired
//   private BrandRepository brandRepository;
     //using via dependency Injection


    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }


    @Override
    public List<BrandResponse> getAllBrands() {
        log.info("fetching all brands");
        List<Brand> brandList = brandRepository.findAll();
        List<BrandResponse> brandResponses =  brandList.stream()
                .map(this::convertToBrandResponse)
                .collect(Collectors.toList());

 return brandResponses;

      //  return List.of();
    }
    private BrandResponse convertToBrandResponse(Brand brand){
        return BrandResponse.builder()
                .id(brand.getId())
                .name(brand.getName())
                .build();
    }

}
