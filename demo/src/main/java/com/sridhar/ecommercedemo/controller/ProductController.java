package com.sridhar.ecommercedemo.controller;

import com.sridhar.ecommercedemo.model.BrandResponse;
import com.sridhar.ecommercedemo.model.ProductResponse;
import com.sridhar.ecommercedemo.model.TypeResponse;
import com.sridhar.ecommercedemo.service.BrandService;
import com.sridhar.ecommercedemo.service.ProductService;
import com.sridhar.ecommercedemo.service.TypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    private final TypeService typeService;

    private final BrandService brandService ;
    public ProductController(ProductService productService, TypeService typeService, BrandService brandService) {
        this.productService = productService;
        this.typeService = typeService;
        this.brandService = brandService;

    }
    @GetMapping({"/id"})
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("id") Integer productId) {
        ProductResponse productResponse=productService.getProductById(productId);
      return new  ResponseEntity<>(productResponse, HttpStatus.OK);
    }

//    @GetMapping()
//    public ResponseEntity<List<ProductResponse>> getProducts() {
//        List<ProductResponse> productResponses =  productService.;
//        return new  ResponseEntity<>(productResponses, HttpStatus.OK);
//
//    }

    @GetMapping({"/brands"})
    public ResponseEntity<List<BrandResponse>> getBrands()
    {
        List<BrandResponse> brandResponses = brandService.getAllBrands();
        return new ResponseEntity<>(brandResponses,HttpStatus.OK);
}

    @GetMapping({"/types"})
    public ResponseEntity<List<TypeResponse>> getTypes()
    {
        List<TypeResponse> typeResponses = typeService.getAllTypes();
        return new ResponseEntity<>(typeResponses,HttpStatus.OK);
    }

}
