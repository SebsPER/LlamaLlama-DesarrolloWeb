package com.thellamallama.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

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
@Data
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
    @ManyToMany
    @JoinTable(name="tienda_producto",
            joinColumns = @JoinColumn(name="producto_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tienda_id", referencedColumnName = "id"))
    private List<Tienda> tiendas;
    @ManyToMany
    @JoinTable(name="compra_producto",
            joinColumns = @JoinColumn(name="producto_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="compra_id",referencedColumnName = "id"))
    private List<Compra> compras;
    @ManyToOne
    @JoinColumn(
            name= "categoria_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name="categoria_producto_fk"
            )
    )
    private Categoria categoria;


}
