package com.mamun.springboot.transection.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String type;

    @ManyToOne
    private Account account;
}
