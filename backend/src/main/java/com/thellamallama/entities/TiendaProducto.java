package com.thellamallama.entities;

import com.thellamallama.entities.Producto;
import com.thellamallama.entities.Tienda;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(
        name="Producto_Tienda",
        uniqueConstraints = {
                @UniqueConstraint(name="producto_tienda_codigo_unique",
                        columnNames = "id")
        }
)
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TiendaProducto {
    @Id
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
    private Long id;

    @Column(
            name="cant_tiendas",
            nullable = false
    )
    private Integer cant_tiendas;
    @Column(
            name="date",
            nullable = false
    )
    private Date date;
    @ManyToOne
    @JoinColumn(
            name="producto_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name="producto_tiendaYproducto_fk"
            )
    )
    private Producto producto;

    @ManyToOne
    @JoinColumn(
            name="tienda_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name="tienda_productoYtienda_fk"
            )
    )
    private Tienda tienda;


}
