package com.mamun.springboot.transection.repository;

import com.mamun.springboot.transection.entity.Product;
import com.mamun.springboot.transection.entity.ProductStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findByStatus(ProductStatus status, Pageable pageable);
    @EntityGraph(attributePaths = {"reviews","category","brand"})
    List<Product> findAll();

    @Query("select p from Product p")
    @EntityGraph(attributePaths = {"reviews","category","brand"})
    List<Product> getProdcutsWithSingleQuery();
}
