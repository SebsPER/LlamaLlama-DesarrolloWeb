package com.thellamallama.dtos;

import java.util.Date;
import com.thellamallama.entities.Cliente;
import com.thellamallama.entities.Tipo_pago;
import lombok.Getter;
import lombok.Setter;

@Getter
public class CreateCompraDto {

    private String fecha;
    private String direccion;
    private String ciudad_envio;
    private String distrito_envio;
    private Integer monto_total;
    private Long tipopagoid;
    private Long clienteid;
}
