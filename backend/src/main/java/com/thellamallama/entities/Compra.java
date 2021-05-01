package com.thellamallama.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(
        name="compra",
        uniqueConstraints = {
                @UniqueConstraint(name="compra_codigo_unique",
                        columnNames = "codigo")
        }
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Compra {
    @Id
    @SequenceGenerator(
            name="compra_sequence",
            sequenceName = "compra_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy= GenerationType.SEQUENCE,
            generator = "compra_sequence"
    )
    @Column(
            name="codigo",
            nullable = false
    )
    private Long codigo;
    @ManyToOne
    @JoinColumn(
            name="cliente_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name="cliente_compra_fk"
            )
    )
    private Cliente cliente;
    @Column(
            name="fecha",
            nullable = false,
            columnDefinition = "Date"
    )
    private Date fecha;
    @Column(
            name= "direccion",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String direccion;
    @Column(
            name="ciudad_envio",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String ciudad_envio;
    @Column(
            name="distrito_envio",
            nullable = false,
            columnDefinition = "Text"
    )
    private String distrito_envio;
    @Column(
            name= "monto_total",
            nullable = false
    )
    private Double monto_total;
    @ManyToOne
    @JoinColumn(
            name="tipo_pago_codigo",
            nullable = false,
            referencedColumnName = "codigo",
            foreignKey = @ForeignKey(
                    name="tipopago_compra_fk"
            )
    )
    private Tipo_pago tipo_pago;





}
