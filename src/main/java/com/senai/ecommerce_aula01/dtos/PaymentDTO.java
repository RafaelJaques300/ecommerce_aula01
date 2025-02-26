package com.senai.ecommerce_aula01.dtos;

import lombok.Data;

import java.time.Instant;

@Data
public class PaymentDTO {
    private Long id;
    private String moment;

    public PaymentDTO(Long id, Instant moment) {
    }
}
