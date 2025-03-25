package com.senai.ecommerce_aula01.controllers;

import com.senai.ecommerce_aula01.dtos.CategoryDTO;
import com.senai.ecommerce_aula01.entities.Category;
import com.senai.ecommerce_aula01.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api/categorys")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategory() {
        List<CategoryDTO> list = categoryService.findAll();
        return ResponseEntity.ok(list);

    }

}
