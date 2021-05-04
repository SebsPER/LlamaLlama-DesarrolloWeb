package com.thellamallama.dtos;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class CompraDto {
    private Long id;
    private Long cod_cliente;
    private Date fecha;
    private String direccion;
    private String ciudad_envio;
    private String distrito_envio;
    private Double monto_total;
    private Long tipo_pago;
}