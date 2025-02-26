package com.senai.ecommerce_aula01.services;

import com.senai.ecommerce_aula01.dtos.CategoryDTO;
import com.senai.ecommerce_aula01.entities.Category;
import com.senai.ecommerce_aula01.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;
@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public List<CategoryDTO> findAll() {

        return categoryRepository.findAll().stream().map(category -> new CategoryDTO(category.getId(), category.getName())).toList();
    }

    public interface CategoryRepository extends JpaRepository<Category, Long> {

    }
}
