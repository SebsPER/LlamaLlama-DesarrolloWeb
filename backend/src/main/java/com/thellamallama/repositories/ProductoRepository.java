package com.thellamallama.repositories;

import com.thellamallama.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    Optional<Producto> findById(Long id);

    Optional<Producto> findByNombre(String nombre);

    /*@Query("SELECT Producto.nombre, Categoria.nombre FROM Producto " +
            "JOIN Categoria on Categoria.Id = Producto.categoria.Id " +
            "WHERE Categoria.nombre = :nombre ")
    List<String> productosCategoria(String nombre);
    //productos dada una categoria

    @Query("SELECT Producto.nombre, Producto.precio, Producto.stock " +
            "FROM Producto ")
    List<Producto> listaProductos();
    //lista productos con precio y stock

    //Resolver
    @Query("SELECT Producto.nombre, Producto.precio, Tienda.nombre FROM Producto " +
            "JOIN Tienda. tp ON tp.id = Producto.id" +
            "WHERE Tienda.nombre = :nombre and Producto.stock > 0 ")
    List<String> productosStockporTienda(String nombre);
    //dado un nombre de producto, lista las tiendas en las que hay stock*/
}
