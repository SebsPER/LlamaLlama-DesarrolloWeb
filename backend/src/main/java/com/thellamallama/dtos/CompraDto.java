package com.thellamallama.dtos;

import com.thellamallama.entities.Cliente;
import com.thellamallama.entities.Tipo_pago;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class CompraDto {
    private Long id;
    private String fecha;
    private String direccion;
    private String ciudad_envio;
    private String distrito_envio;
    private Integer monto_total;
    private Long tipopagoid;
    private Long clienteid;

}
