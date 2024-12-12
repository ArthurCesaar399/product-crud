package com.senac.ads4.product.dto;

import lombok.Data;

@Data
public class ProductDto {
    private Integer id;

    private String nome;

    private String descricao;

    private Double preco;

    private String marca;
}
