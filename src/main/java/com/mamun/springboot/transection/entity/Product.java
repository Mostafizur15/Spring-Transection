package com.mamun.springboot.transection.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(length = 1000)
    private String description;
    private Double price;
    private Integer stock;
    @Enumerated(EnumType.STRING)
    private ProductStatus status;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties("hibernateLazyInitializer")
    private Category category;
    @ManyToOne(fetch = FetchType.EAGER)
    private Brand brand;
    @OneToMany(mappedBy = "product", fetch=FetchType.LAZY) // By default fetch type is lazy
    private List<Review> reviews;
}
