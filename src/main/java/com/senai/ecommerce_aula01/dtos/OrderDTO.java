package com.senai.ecommerce_aula01.dtos;

import com.senai.ecommerce_aula01.entities.OrderStatus;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.Instant;
import java.time.LocalDateTime;

@Setter
@Getter
@Data
public class OrderDTO {
    private Long id;
    private LocalDateTime moment;
    private OrderStatus status;

    public OrderDTO(Long id, LocalDateTime moment, OrderStatus status) {
    }

    public OrderDTO() {

    }
}
