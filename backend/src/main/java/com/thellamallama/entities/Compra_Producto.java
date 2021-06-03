package com.thellamallama.entities;

import com.thellamallama.entities.Compra;
import com.thellamallama.entities.Producto;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(
        name="Compra_Producto",
        uniqueConstraints = {
                @UniqueConstraint(name="compra_producto_codigo_unique",
                        columnNames = "producto_id")
        }
)
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Compra_Producto {
        @Id
        @SequenceGenerator(
                name="compra_producto_sequense",
                sequenceName = "compra_producto_sequense",
                allocationSize = 1
        )
        @Column(
                name="id",
                nullable = false
        )
        private Long id;
        @Column(
                name="cant_productos",
                nullable = false
        )
        private Integer cant_productos;
        @Column(
                name="date",
                nullable = false
        )
        private Date date;

        @ManyToOne
        @JoinColumn(
                name="compra_id",
                nullable = false,
                referencedColumnName = "id",
                foreignKey = @ForeignKey(
                        name="compra_compra&producto_fk"
                )
        )
        private Compra compra;

        @ManyToOne
        @JoinColumn(
                name="producto_id",
                nullable = false,
                referencedColumnName = "id",
                foreignKey = @ForeignKey(
                        name="producto_compra&producto_fk"
                )
        )
        private Producto producto;


}
