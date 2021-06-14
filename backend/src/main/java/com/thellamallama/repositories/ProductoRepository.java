package com.thellamallama.repositories;

import com.thellamallama.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long> {

    Optional<Producto> findById(Long id);
    Optional<Producto> findByNombre(String nombreProducto);
    Long deleteByNombre(String nombre);

    @Query("SELECT Rest FROM Producto Rest")
    List<Producto> findProductos();
}
