package com.thellamallama.dtos;

import lombok.Getter;

import java.util.Date;

@Getter
public class CreateTiendaProductoDto {
    private Integer stock;
    private Integer precio;
    private Long tiendaid;
    private Long productoid;
    private float descuento;
}
