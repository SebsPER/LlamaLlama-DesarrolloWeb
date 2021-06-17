package com.thellamallama.repositories;


import com.thellamallama.entities.Categoria;
import com.thellamallama.entities.Tienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

//INSERT - DELETE - SELECT - TO DO PARA BASE DE DATOS
@Repository
public interface TiendaRepository extends JpaRepository<Tienda, Long> {
    Optional<Tienda> findById(Long id);

    Optional<Tienda> findByNombre(String nombreTienda);

    /*@Query("SELECT Tienda.nombre, Producto.nombre, Producto.stock FROM Tienda " +
            "JOIN Producto ON Tienda.id = Producto.id")
    List<String> stock_tienda();
    //productos y stock por tienda*/

    /*@Query("SELECT Tienda.nombre, Producto.nombre, Producto.precio FROM Tienda " +
            "JOIN Producto ON Tienda.id = Producto.id")
    List<Tienda> precio_tienda();
    //productos y sus precios*/

    /*@Query("SELECT Tienda.nombre_encargado FROM Tienda WHERE Tienda.nombre=:nombre")
    Optional<String> encargado_tienda(String nombre) throws Exception;
    // encargado de una tienda especifica

    @Query("SELECT Tienda.direccion FROM Tienda WHERE Tienda.nombre=:nombre")
    Optional<String> direccion_tienda(String nombre) throws Exception;
    // direccion de una tienda dado un nombre*/


}
