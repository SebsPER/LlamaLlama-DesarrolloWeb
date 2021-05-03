package com.thellamallama.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TiendaDto {
    private Long id;
    private String nombre;
    private Integer RUC;
    private String razon_social;
    private String direccion;
    private String nombre_encargado;
}
