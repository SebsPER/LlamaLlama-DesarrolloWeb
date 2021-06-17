package com.thellamallama.dtos;

import com.thellamallama.entities.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDto {
    private Long id;
    private String nombre;
    private Integer dni;
    private String direccion;
    private Integer telefono;
    private String apellido_paterno;
    private String apellido_materno;
    private String password;

    public ClienteDto(Cliente up){
        BeanUtils.copyProperties(up, this);
    }
    //private Long tienda_productoid;
}
