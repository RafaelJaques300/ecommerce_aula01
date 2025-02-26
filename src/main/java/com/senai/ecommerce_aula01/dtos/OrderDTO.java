package com.senai.ecommerce_aula01.dtos;

import com.senai.ecommerce_aula01.entities.OrderStatus;
import lombok.Data;

import java.time.Instant;

@Data
public class OrderDTO {
    private Long id;
    private String moment;
    private String status;

    public OrderDTO(Long id, Instant moment, OrderStatus status) {
    }

    public OrderDTO() {

    }
}
