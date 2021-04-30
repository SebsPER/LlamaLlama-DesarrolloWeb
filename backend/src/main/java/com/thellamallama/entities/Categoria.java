package com.thellamallama.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(
        name="categoria",
        uniqueConstraints = {
                @UniqueConstraint(name="categoria_nombre_unique",
                        columnNames = "nombre")
        }
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class Categoria {
    @Id
    @SequenceGenerator(
            name="categoria_sequence",
            sequenceName = "categoria_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy= GenerationType.SEQUENCE,
            generator = "categoria_sequence"
    )
    @Column(
            name="id",
            nullable = false
    )
    private Long Id;
    @Column(
            name="nombre",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String nombre;
    @Column(
            name="descripcion",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String descripcion;
    public Categoria(String nombre,String descripcion){
        this.nombre=nombre;
        this.descripcion=descripcion;
    }
}
