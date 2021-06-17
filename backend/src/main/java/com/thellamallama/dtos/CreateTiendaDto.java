package com.thellamallama.dtos;

import lombok.Getter;

@Getter
public class CreateTiendaDto {

    private String nombre;
    private Long ruc;
    private String razon_social;
    private String direccion;
    private String nombre_encargado;
    private String password;
    //private Long tienda_productoid;
}

