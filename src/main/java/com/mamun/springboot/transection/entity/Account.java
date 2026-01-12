package com.mamun.springboot.transection.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.context.annotation.Lazy;

import java.util.List;

@Entity
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Double balance;

    /*@OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    List<Review> review;*/
}
