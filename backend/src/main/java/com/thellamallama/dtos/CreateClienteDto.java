package com.thellamallama.dtos;

import lombok.Getter;

@Getter
public class CreateClienteDto {
    private String nombre;
    private Integer dni;
    private String direccion;
    private Integer telefono;
    private String apellido_paterno;
    private String apellido_materno;
    private String password;
}
