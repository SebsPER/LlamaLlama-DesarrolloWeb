package com.thellamallama.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(
        name="cliente",
        uniqueConstraints = {
                @UniqueConstraint(name="cliente_nombre_unique",
                        columnNames = "nombre")
        }
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

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

   /* public Cliente(String nombre,Integer dni,String direccion,Integer telefono,String apellido_paterno,
                   String apellido_materno,String password){
        this.nombre=nombre;
        this.dni=dni;
        this.direccion=direccion;
        this.telefono=telefono;
        this.apellido_paterno=apellido_paterno;
        this.apellido_materno=apellido_materno;
        this.password=password;

    }*/
    @OneToMany(
            mappedBy = "cliente",
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE},
            fetch = FetchType.LAZY
    )
    private List<Compra> compras=new ArrayList<>();

}
