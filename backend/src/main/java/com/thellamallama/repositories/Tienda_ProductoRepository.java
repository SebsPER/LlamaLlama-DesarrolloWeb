package com.thellamallama.repositories;

import com.thellamallama.entities.Tienda_Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface Tienda_ProductoRepository extends JpaRepository<Tienda_Producto, Long>  {
    Optional<Tienda_Producto> findById(Long id);

    Optional<Tienda_Producto> findByDate(String dateTienda_Producto);

    @Query("SELECT Rest FROM Producto Rest")
    List<Tienda_Producto> findTienda_Productos();
}
