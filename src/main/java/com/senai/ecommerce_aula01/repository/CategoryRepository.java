package com.senai.ecommerce_aula01.repository;

import com.senai.ecommerce_aula01.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
