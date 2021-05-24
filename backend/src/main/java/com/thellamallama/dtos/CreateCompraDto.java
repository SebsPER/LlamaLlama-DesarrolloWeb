package com.thellamallama.dtos;

import com.thellamallama.entities.Cliente;
import com.thellamallama.entities.Tipo_pago;
import lombok.Getter;
import lombok.Setter;

@Getter
public class CreateCompraDto {
    private Long clienteid;
    private String fecha;
    private String direccion;
    private String ciudad_envio;
    private String distrito_envio;
    private Integer monto_total;
    private Long tipopagoid;
}
