package com.senai.ecommerce_aula01.services;

import com.senai.ecommerce_aula01.dtos.OrderItemDTO;
import com.senai.ecommerce_aula01.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Transactional(readOnly = true)
    public List<OrderItemDTO> findAll() {
        return orderItemRepository.findAll().stream().map(orderItem -> new OrderItemDTO(orderItem.getId(), orderItem.getQuantity(), orderItem.getPrice())).toList();
    }
}
