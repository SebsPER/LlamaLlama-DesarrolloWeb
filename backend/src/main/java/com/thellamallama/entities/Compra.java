package com.thellamallama.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
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
    @Column(
            name="fecha",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String fecha;
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
    private Integer monto_total;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name="tipoPagoid",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name="tipopagoCompraFk"
            )
    )
    private Tipo_pago tipo_pago;

    @OneToMany(
            mappedBy = "compra",
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<CompraProducto> compra_producto=new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name="clienteid",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name="clienteCompraFk"
            )
    )
    private Cliente cliente;

}