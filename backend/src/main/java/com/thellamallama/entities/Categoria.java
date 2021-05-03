package com.thellamallama.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
@Data

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
    @OneToMany(
            mappedBy = "categoria",
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<Producto> productos= new ArrayList<>();
    /*public Categoria(String nombre,String descripcion){
        this.nombre=nombre;
        this.descripcion=descripcion;
    }*/
}
