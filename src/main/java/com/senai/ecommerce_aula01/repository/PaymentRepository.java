package com.senai.ecommerce_aula01.repository;

import com.senai.ecommerce_aula01.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
