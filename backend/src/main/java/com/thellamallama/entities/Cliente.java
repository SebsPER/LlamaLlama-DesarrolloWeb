package com.thellamallama.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        name="cliente",
        uniqueConstraints = {
                @UniqueConstraint(name="cliente_dni_unique",
                        columnNames = "dni")
        }
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cliente {
    @Id
    @SequenceGenerator(
            name="cliente_sequence",
            sequenceName = "cliente_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy= GenerationType.SEQUENCE,
            generator = "cliente_sequence"
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
            name="dni",
            nullable = false
    )
    private Integer dni;
    @Column(
            name="direccion",
            nullable= false,
            columnDefinition = "TEXT"
    )
    private String direccion;
    @Column(
            name="telefono",
            nullable= false
    )
    private Integer telefono;
    @Column(
            name="apellido_paterno",
            nullable= false,
            columnDefinition = "TEXT"
    )
    private String apellido_paterno;
    @Column(
            name="apellido_materno",
            nullable= false,
            columnDefinition = "TEXT"
    )
    private String apellido_materno;
    @Column(
            name="password",
            nullable= false,
            columnDefinition = "TEXT"
    )
    private String password;

    @OneToMany(
            mappedBy = "cliente",
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<Compra> compras=new ArrayList<>();

}
