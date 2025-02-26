package com.senai.ecommerce_aula01.services;

import com.senai.ecommerce_aula01.dtos.CategoryDTO;
import com.senai.ecommerce_aula01.dtos.ProductDTO;
import com.senai.ecommerce_aula01.entities.Product;
import com.senai.ecommerce_aula01.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<ProductDTO> findAll() {
        return productRepository.findAll().stream().map(product -> new ProductDTO(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getImgUrl())).toList();
    }

    public ProductDTO create(ProductDTO productDTO) {
        Product product = productDTOToProduct(productDTO);
        ProductDTO DTO = productToProductDTO(product);
        return DTO;
    }

    @Transactional
    public ProductDTO update(Long id, ProductDTO productDTO) {
        Product product = productDTOToProduct(productDTO);
        product.setId(id);
        product =productRepository.save(product);
        return productToProductDTO(product);
    }

    @Transactional
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    public ProductDTO productToProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        productDTO.setImgUrl(product.getImgUrl());
        productDTO.setCategories(product.getCategories().stream().map(category -> new CategoryDTO(category.getId(), category.getName())).toList());
        return productDTO;
    }

    public Product productDTOToProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setImgUrl(productDTO.getImgUrl());
        return product;
    }

    public ProductDTO findById(Long id) {
        return productToProductDTO(productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Produto não encontrado")));
    }
}
