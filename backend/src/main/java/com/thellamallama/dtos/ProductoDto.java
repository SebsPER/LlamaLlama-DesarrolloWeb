package com.thellamallama.dtos;

import com.thellamallama.entities.Producto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDto {
    private Long id;
    private String nombre;
    //private Long tiendaid;
    private Long categoriaid;
    //private Long compraid;
    private String url;

    public ProductoDto(Producto up) { BeanUtils.copyProperties(up,this); }
}
