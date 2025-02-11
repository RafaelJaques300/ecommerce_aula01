package com.senai.ecommerce_aula01.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Data
@Entity
@Table(name = "tb_payment")

public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private Instant moment;

    @OneToOne
    @MapsId
    private Order order;

}
