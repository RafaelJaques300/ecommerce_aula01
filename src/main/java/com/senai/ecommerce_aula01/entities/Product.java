package com.senai.ecommerce_aula01.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name = "tb_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private double price;

    @Column(name = "img_url_", columnDefinition = "TEXT")
    private String imgUrl;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tb_product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    public Product() {
    }

    public Product(Long id, String name, String description, double price, String imgUrl, Set<Category> categories) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
        this.categories = (categories != null) ? categories : new HashSet<>();
    }

    public void setCategories(Set<Category> categories) {
        this.categories = (categories != null) ? categories : new HashSet<>();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(price, product.price) && Objects.equals(imgUrl, product.imgUrl) && Objects.equals(categories, product.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, imgUrl, categories);
    }
}