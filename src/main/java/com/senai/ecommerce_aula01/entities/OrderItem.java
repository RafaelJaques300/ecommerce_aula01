package com.senai.ecommerce_aula01.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order_item")
public class OrderItem {
    @EmbeddedId
    private OrderItemPK id = new OrderItemPK();

    private int quantity;
    private double price;

    public Object getPrice() {
        return price;
    }

    public Object getQuantity() {
        return quantity;
    }

    public Object getId() {
        return id;
    }
}
