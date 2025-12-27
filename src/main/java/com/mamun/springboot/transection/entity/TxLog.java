package com.mamun.springboot.transection.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tx_logs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TxLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer from_ac;
    private Integer to_ac;
    private Double balance;
    private String status;
}
