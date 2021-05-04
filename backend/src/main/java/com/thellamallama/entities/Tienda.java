package com.thellamallama.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;
import java.util.HashSet;

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

    @ManyToMany(mappedBy = "tiendas", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<Producto> productos = new HashSet<>();

}
