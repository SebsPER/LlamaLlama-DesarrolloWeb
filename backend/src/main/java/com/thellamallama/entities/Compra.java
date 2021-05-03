package com.thellamallama.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(
        name="compra",
        uniqueConstraints = {
                @UniqueConstraint(name="compra_codigo_unique",
                        columnNames = "id")
        }
)
@Getter
@Setter
@Data
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
            name="id",
            nullable = false
    )
    private Long id;
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
            name="tipo_pago_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name="tipopago_compra_fk"
            )
    )
    private Tipo_pago tipo_pago;
    @ManyToMany
    @JoinTable(name="compra_producto",
            joinColumns = @JoinColumn(name="tienda_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "producto_id", referencedColumnName = "id"))
    private List<Producto> productos;

}
