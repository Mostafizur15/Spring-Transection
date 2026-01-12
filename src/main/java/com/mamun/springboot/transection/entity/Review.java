package com.mamun.springboot.transection.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString(exclude = "product")
public class Review {
    @Id
    private Integer id;
    private String comment;
    private int rating;
    @JsonIgnore
    @ManyToOne
    private Product product;
}
