package com.senai.ecommerce_aula01.controllers;

import com.senai.ecommerce_aula01.dtos.PaymentDTO;
import com.senai.ecommerce_aula01.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api/payment")

public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public ResponseEntity<List<PaymentDTO>> getAllPayment() {
        List<PaymentDTO> list = paymentService.findAll();
        return ResponseEntity.ok(list);
    }


}
