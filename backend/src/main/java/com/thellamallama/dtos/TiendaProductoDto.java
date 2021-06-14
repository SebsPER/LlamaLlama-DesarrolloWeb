package com.thellamallama.dtos;
import com.thellamallama.entities.TiendaProducto;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TiendaProductoDto {
    //private Long id;
    private Integer stock;
    private Integer precio;
    private Long tiendaid;
    private Long productoid;
    private float descuento;

    public TiendaProductoDto(TiendaProducto up) { BeanUtils.copyProperties(up, this);}
}
