package com.senai.ecommerce_aula01.repository;

import com.senai.ecommerce_aula01.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
