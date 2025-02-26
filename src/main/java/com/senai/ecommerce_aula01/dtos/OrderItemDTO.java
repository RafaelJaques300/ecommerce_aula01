package com.senai.ecommerce_aula01.dtos;

import lombok.Data;

@Data
public class OrderItemDTO {
    private Long id;
    private int quantity;
    private double price;

    public OrderItemDTO(Object id, Object quantity, Object price) {
    }
}
