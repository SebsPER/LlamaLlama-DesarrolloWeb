package com.thellamallama.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(CompositeKeyCP.class)
@Table(
        name="compraProductos"
        /*uniqueConstraints = {
                @UniqueConstraint(name="compra_producto_codigo_unique",
                        columnNames = "producto_id")
        }*/
)
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompraProducto implements Serializable {

        @Column(
                name="cantproductos",
                nullable = false
        )
        private Long cantProductos;
        /*@Column(
                name="date",
                nullable = false
        )
        private Date date;*/
        @Column(
                name="precioXCant",
                nullable = false
        )
        private float precioXCant;

        @Id
        @Column(name = "compraid")
        private Long compraid;

        //@Id
        @ManyToOne
        @JoinColumn(
                name="compraid",
                nullable = false,
                referencedColumnName = "id",
                insertable = false,
                updatable = false,
                foreignKey = @ForeignKey(
                        name= "compraIdFk"//"compra_compra&producto_fk"
                )
        )
        private Compra compra;

        @Id
        @Column(name = "productoid")
        private Long productoid;

        //@Id
        @ManyToOne
        @JoinColumn(
                name="productoid",
                nullable = false,
                referencedColumnName = "id",
                insertable = false,
                updatable = false,
                foreignKey = @ForeignKey(
                        name= "productoIdFk"//"producto_compra&producto_fk"
                )
        )
        private Producto producto;


}
