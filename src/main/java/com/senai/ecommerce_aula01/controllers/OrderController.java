package com.senai.ecommerce_aula01.controllers;

import com.senai.ecommerce_aula01.dtos.OrderDTO;
import com.senai.ecommerce_aula01.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/order")

 public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrder() {
        List<OrderDTO> list = orderService.findAll();
        return ResponseEntity.ok(list);
    }

}



