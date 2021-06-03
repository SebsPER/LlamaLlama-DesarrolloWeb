package com.thellamallama.dtos;

import lombok.Getter;

import java.util.Date;

@Getter
public class CreateTienda_ProductoDto {
    private Integer cant_tiendas;
    private Date date;
    private Long tiendaid;
    private Long productoid;
}
