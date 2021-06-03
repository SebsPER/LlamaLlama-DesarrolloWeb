package com.thellamallama.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        name="tienda",
        uniqueConstraints = {
                @UniqueConstraint(name="tienda_nombre_unique",
                        columnNames = "nombre")
        }
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
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

    @OneToMany(
            mappedBy = "tienda",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<Tienda_Producto> tienda_productos=new ArrayList<>();

}
