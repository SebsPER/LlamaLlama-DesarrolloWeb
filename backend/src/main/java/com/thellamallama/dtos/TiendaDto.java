package com.thellamallama.dtos;

import com.thellamallama.entities.Tienda;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TiendaDto {
    private Long id;
    private String nombre;
    private Long ruc;
    private String razon_social;
    private String direccion;
    private String nombre_encargado;
    private String password;

    public TiendaDto(Tienda up){
        BeanUtils.copyProperties(up, this);
    }
    //private Long tienda_productoid;
}
