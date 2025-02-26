package com.senai.ecommerce_aula01.services;

import com.senai.ecommerce_aula01.dtos.PaymentDTO;
import com.senai.ecommerce_aula01.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Transactional(readOnly = true)
    public List<PaymentDTO> findAll() {

        return paymentRepository.findAll().stream().map(payment -> new PaymentDTO(payment.getId(), payment.getMoment())).toList();
    }
}
