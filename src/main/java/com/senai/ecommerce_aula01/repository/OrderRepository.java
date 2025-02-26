package com.senai.ecommerce_aula01.repository;

import com.senai.ecommerce_aula01.entities.Order;
import com.senai.ecommerce_aula01.entities.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
