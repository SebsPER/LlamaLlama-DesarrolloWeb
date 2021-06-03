package com.thellamallama.dtos;
import io.swagger.models.auth.In;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Compra_ProductoDto {
    private Long id;
    private Integer cant_productos;
    private Date date;
}
