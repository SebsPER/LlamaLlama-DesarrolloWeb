package com.thellamallama.dtos;
import io.swagger.models.auth.In;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TiendaProductoDto {
    //private Long id;
    private Integer stock;
    private Integer precio;
    private Long tiendaid;
    private Long productoid;
}
