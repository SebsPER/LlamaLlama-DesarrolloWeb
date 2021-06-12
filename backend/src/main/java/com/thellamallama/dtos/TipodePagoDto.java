package com.thellamallama.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TipodePagoDto {
    private Long id;
    private String descripcion;
    private String nombre;
    private Float descuento;
}
