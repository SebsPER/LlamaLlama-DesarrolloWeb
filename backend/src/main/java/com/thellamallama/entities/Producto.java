package com.thellamallama.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(
            mappedBy = "producto",
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<TiendaProducto> productos_tiendas= new ArrayList<>();

    @OneToMany(
            mappedBy = "producto",
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<CompraProducto> compras_productos=new ArrayList<>();

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

    @Column(
            name="url",
            nullable = false
    )
    private String url;


}

//manytomany @query @insert