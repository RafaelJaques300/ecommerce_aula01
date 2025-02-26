package com.senai.ecommerce_aula01.services;

import com.senai.ecommerce_aula01.dtos.OrderDTO;
import com.senai.ecommerce_aula01.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Transactional(readOnly = true)
    public List<OrderDTO> findAll() {
        return orderRepository.findAll().stream().map(order -> new OrderDTO(order.getId(), order.getMoment(), order.getStatus())).toList();
    }

}
