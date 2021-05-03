package com.thellamallama.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        name="Tipo_pago",
        uniqueConstraints = {
                @UniqueConstraint(name="tipopago_nombre_unique",
                        columnNames = "nombre")
        }
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Tipo_pago {
    @Id
    @SequenceGenerator(
            name="tipopago_sequence",
            sequenceName = "tipopago_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy= GenerationType.SEQUENCE,
            generator = "tipopago_sequence"
    )
    @Column(
            name="id",
            nullable = false
    )
    private Long id;
    @Column(
            name="descripcion",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String descripcion;
    @Column(
            name="nombre",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String nombre;
    @Column(
            name="descuento",
            nullable = false
    )
    private Float descuento;
    @OneToMany(
            mappedBy = "tipo_pago",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<Compra> compras= new ArrayList<>();

    /*public Tipo_pago(String descripcion,String nombre,Float descuento){
        this.descripcion=descripcion;
        this.nombre=nombre;
        this.descuento=descuento;
    }*/
}
