package com.thellamallama.dtos;

import lombok.Getter;

@Getter
public class CreateProductoDto {
    private String nombre;
    private Float precio;
    private Integer stock;
    private Long tiendaid;
    private Long categoriaid;
    private Long compraid;
}

