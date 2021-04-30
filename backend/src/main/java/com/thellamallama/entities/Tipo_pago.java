package com.thellamallama.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

    public Tipo_pago(String descripcion,String nombre,Float descuento){
        this.descripcion=descripcion;
        this.nombre=nombre;
        this.descuento=descuento;
    }
}
