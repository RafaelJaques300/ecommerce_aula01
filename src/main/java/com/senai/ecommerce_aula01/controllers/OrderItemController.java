package com.senai.ecommerce_aula01.controllers;

import com.senai.ecommerce_aula01.dtos.OrderItemDTO;
import com.senai.ecommerce_aula01.services.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orderItem")

public class OrderItemController {
    @Autowired
    private OrderItemService orderItemService;

    @GetMapping
    public ResponseEntity<List<OrderItemDTO>> getAllOrderItem() {
        List<OrderItemDTO> list = orderItemService.findAll();
        return ResponseEntity.ok(list);
    }

}
