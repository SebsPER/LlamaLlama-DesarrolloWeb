package com.thellamallama.dtos;

import com.thellamallama.entities.Compra;
import com.thellamallama.entities.Producto;
import lombok.Getter;

import java.util.Date;

@Getter
public class CreateCompraProductoDto {
    private Long cantproductos;
    //private Long precioXCant;
    private Long compraId;
    private Long productoId;
    private Long tiendaid;

}
