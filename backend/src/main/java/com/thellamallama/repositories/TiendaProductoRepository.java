package com.thellamallama.repositories;

import com.thellamallama.entities.CompositeKeyTP;
import com.thellamallama.entities.Producto;
import com.thellamallama.entities.TiendaProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TiendaProductoRepository extends JpaRepository<TiendaProducto, CompositeKeyTP>  {
    Optional<TiendaProducto> findByTiendaidAndProductoid(Long tiendaid, Long productoid);
    List<TiendaProducto> findByTiendaid(Long tiendaid);
    Long deleteByTiendaidAndProductoid(Long tiendaid, Long productoid);

    @Query("select tp from TiendaProducto tp join tp.producto p where p.categoria.nombre = :cname ")
    List<TiendaProducto> findByCategoria(String cname);

    @Query("select tp from TiendaProducto tp join tp.producto p where p.nombre = :pname ")
    List<TiendaProducto> findByName(String pname);

    /*@Query("SELECT Rest FROM Producto Rest")
    List<TiendaProducto> findTienda_Productos();*/
}
