package com.thellamallama.dtos;
import com.thellamallama.entities.Compra;
import com.thellamallama.entities.Producto;
import io.swagger.models.auth.In;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CompraProductoDto {
    //private Long id;
    private Long cantproductos;
    private Long precioXCant;
    private Long compraid;
    private Long productoid;
}
