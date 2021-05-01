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
    @Column(
            name="nombre",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String nombre;
    @Column(
            name="precio",
            nullable = false
    )
    private Float precio;
    @Column(
            name="stock",
            nullable = false
    )
    private Integer stock;
    /*@ManyToMany
    private Tienda tienda_id;
    @ManyToMany
    private Compra compra_id;*/
    @ManyToOne
    @JoinColumn(
            name= "categoria_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name="categoria_producto_fk"
            )
    )
    private Categoria categoria_id;


}
