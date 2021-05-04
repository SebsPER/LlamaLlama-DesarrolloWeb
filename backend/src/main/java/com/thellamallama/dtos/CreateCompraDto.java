package com.thellamallama.dtos;

import java.util.Date;
import com.thellamallama.entities.Cliente;
import com.thellamallama.entities.Tipo_pago;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCompraDto {
    private Cliente cod_cliente;
    private Date fecha;
    private String direccion;
    private String ciudad_envio;
    private String distrito_envio;
    private Double monto_total;
    private Tipo_pago tipo_pago;
}
