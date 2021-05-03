package com.thellamallama.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoDto {
    private Long id;
    private String nombre;
    private Float precio;
    private Integer stock;
    private Long tiendaid;
    private Long categoriaid;
    private Long compraid;
}
