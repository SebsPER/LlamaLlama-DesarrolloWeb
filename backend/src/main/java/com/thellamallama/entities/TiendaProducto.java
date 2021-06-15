package com.thellamallama.entities;

import com.thellamallama.entities.Producto;
import com.thellamallama.entities.Tienda;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@IdClass(CompositeKeyTP.class)
@Table(
        name="tiendaProductos"
        /*uniqueConstraints = {
                @UniqueConstraint(name="producto_tienda_codigo_unique",
                        columnNames = "id")
        }*/
)
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TiendaProducto {
    /*@Id
    @SequenceGenerator(
            name="tienda_producto_sequense",
            sequenceName = "tienda_producto_sequense",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tienda_producto_sequense"
    )
    @Column(
            name="id",
            nullable = false
    )
    private Long id;*/

    @Column(
            name="stock",
            nullable = false
    )
    private Integer stock;

    @Column(
            name="precio",
            nullable = false
    )
    private Integer precio;

    @Column(
            name="descuento",
            nullable = false
    )
    private float descuento;

    @Id
    @Column(name = "productoid")
    private Long productoid;

    @ManyToOne
    @JoinColumn(
            name="productoid",
            nullable = false,
            referencedColumnName = "id",
            insertable = false,
            updatable = false,
            foreignKey = @ForeignKey(
                    name="productoIdFk"
            )
    )
    private Producto producto;

    @Id
    @Column(name = "tiendaid")
    private Long tiendaid;

    @ManyToOne
    @JoinColumn(
            name="tiendaid",
            nullable = false,
            referencedColumnName = "id",
            insertable = false,
            updatable = false,
            foreignKey = @ForeignKey(
                    name="tiendaIdFk"
            )
    )
    private Tienda tienda;


}
