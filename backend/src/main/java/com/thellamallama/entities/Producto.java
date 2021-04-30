package com.thellamallama.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(
        name="Producto",
        uniqueConstraints = {
                @UniqueConstraint(name="producto_nombre_unique",
                        columnNames = "nombre")
        }
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Producto {
    @Id
    @SequenceGenerator(
            name="producto_sequence",
            sequenceName="producto_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "producto_sequence"
    )
    @Column(
            name="id",
            nullable = false
    )
    private Long id;
    private String nombre;
    private Float precio;
    private Integer stock;


}
