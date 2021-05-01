package com.thellamallama.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(
        name="tiendas",
        uniqueConstraints = {
                @UniqueConstraint(name="tienda_nombre_unique",
                                    columnNames = "nombre")
        }
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tienda {
    @Id
    @SequenceGenerator(
            name="tienda_sequence",
            sequenceName = "tienda_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy= GenerationType.SEQUENCE,
            generator = "tienda_sequence"
    )
    @Column(
            name="id",
            nullable = false
    )
    private Long id;

    @Column(
            name="nombre",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String nombre;

    @Column(
            name="RUC",
            nullable = false

    )
    private Integer RUC;

    @Column(
            name="razon_social",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String razon_social;

    @Column(
            name="direccion",
            nullable = false,
            columnDefinition = "TEXT"
    ) private String direccion;

    @Column(
            name="nombre_encargado",
            nullable = false,
            columnDefinition = "TEXT"
    )  private String nombre_encargado;

    @Column(
            name="password",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String password;

    /*public Tienda(String nombre,Integer RUC,String password, String nombre_encargado,String direccion, String razon_social) {
        this.nombre=nombre;
        this.RUC=RUC;
        this.password=password;
        this.nombre_encargado=nombre_encargado;
        this.direccion=direccion;
        this.razon_social=razon_social;
    }*/

}
