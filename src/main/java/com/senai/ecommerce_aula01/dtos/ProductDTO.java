package com.senai.ecommerce_aula01.dtos;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDTO {
    private Long id;
    @Size(min = 2, max = 100, message = "O Campo nome precisa ter entre 2 e 100 caracteres")
    @NotBlank(message = "O campo nome não pode estar em branco")

    private String name;
    @Size(min = 10, message = "O campo descriçãoprecisa ter entre 2 e 500 caracteres")
    @NotBlank(message = "O campo descrição não pode ser vazio")

    private String description;
    @NotNull(message = "O campo preço não pode ser vazio")
    @Positive(message = "O campo preço deve ser positivo")

    private double price;
    private String imgUrl;
    @NotEmpty(message = "O campo categoria não pode estar vazio")
    private List<CategoryDTO> categories;

    public ProductDTO(Long id, String name, String description, double price, String imgUrl, Set<CategoryDTO> categories) {
}

    public ProductDTO(Long id, String name, String description, double price, String imgUrl) {
    }

    public void setCategories(List<CategoryDTO> categories) {
        this.categories = categories.stream().map(
                category ->
                        new CategoryDTO(category.getId(),
                                category.getName())).toList();
    }
    public @NotEmpty(message = "O campo categoria não pode estar vazio")
    List<CategoryDTO> getCategories() {
        return categories;
    }
}
