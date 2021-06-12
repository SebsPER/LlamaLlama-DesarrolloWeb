package com.thellamallama.repositories;

import com.thellamallama.entities.TiendaProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TiendaProductoRepository extends JpaRepository<TiendaProducto, Long>  {
    Optional<TiendaProducto> findById(Long id);

    Optional<TiendaProducto> findByDate(String dateTienda_Producto);

    @Query("SELECT Rest FROM Producto Rest")
    List<TiendaProducto> findTienda_Productos();
}
