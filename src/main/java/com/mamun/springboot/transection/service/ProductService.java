package com.mamun.springboot.transection.service;

import com.mamun.springboot.transection.entity.Product;
import com.mamun.springboot.transection.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product getProductById(Long id){
        Product prd = productRepository.findById(id).orElseThrow(()->new RuntimeException("Product not found by id "+id));
        System.out.println(prd.getReviews());
        return prd;
    }
}
