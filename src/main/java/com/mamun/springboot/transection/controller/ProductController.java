package com.mamun.springboot.transection.controller;

import com.mamun.springboot.transection.entity.Product;
import com.mamun.springboot.transection.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/api/product/{id}")
    public Product getProduct(@PathVariable("id") Long id){
        Product prd = productService.getProductById(id);
        return prd;
    }
}
