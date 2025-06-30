package com.sridhar.ecommercedemo.service;

import com.sridhar.ecommercedemo.entity.Product;
import com.sridhar.ecommercedemo.model.ProductResponse;
import com.sridhar.ecommercedemo.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
public class ProductServiceImpl  implements
ProductService {


    private ProductRepository productRepository;
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;

    }


    @Override
    public ProductResponse getProductById(Integer productId) {
    log.info("Fetching the product with id: " + productId);
   Product product = productRepository.findById(productId).orElseThrow(()->new RuntimeException("Product not found"));

        ProductResponse productResponse = convertToProductResponse(product);
    log.info("Returning the product with id: " + productId);
     return productResponse;

    }

    private ProductResponse convertToProductResponse(Product product) {

        return  ProductResponse.builder().id(product.getId()).name(product.getName()).price(product.getPrice()).build();
    }


    @Override
    public Page<ProductResponse> getProducts(Pageable pageable) {
        log.info("Fetching products");
        //Retrieve products from DB
        Page<Product> productPage = productRepository.findAll(pageable);
        //Map
        Page<ProductResponse> productResponses = productPage
                .map(this::convertToProductResponse);
        log.info("Fetched all products");
        return productResponses;


    }
}
