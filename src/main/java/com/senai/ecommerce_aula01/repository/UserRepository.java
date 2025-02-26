package com.senai.ecommerce_aula01.repository;

import com.senai.ecommerce_aula01.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
