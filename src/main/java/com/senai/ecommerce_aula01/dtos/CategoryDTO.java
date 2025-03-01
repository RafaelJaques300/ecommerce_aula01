package com.senai.ecommerce_aula01.dtos;

import com.senai.ecommerce_aula01.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryDTO {
    private Long id;
    private String name;
//    private List<ProductDTO> products;
//
//    public CategoryDTO(Long id, String name) {
//    }
//    public void setProducts(Set<ProductDTO> products) {
//        this.products = products.stream().map(
//                product -> new ProductDTO(product.getId()
//                        , product.getName()
//                        , product.getDescription()
//                        , product.getPrice()
//                        , product.getImgUrl())).toList();
//
//
//    }
}
