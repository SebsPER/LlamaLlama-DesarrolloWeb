package com.thellamallama.repositories;

import com.thellamallama.dtos.TiendaProductoDto;
import com.thellamallama.entities.CompositeKeyCP;
import com.thellamallama.entities.CompraProducto;
import com.thellamallama.entities.TiendaProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompraProductoRespository extends JpaRepository<CompraProducto, CompositeKeyCP> {
    //Optional<CompraProducto> findById(Long id);
    Optional<CompraProducto> findByCompraidAndProductoid(Long compraid, Long productoid);
    List<CompraProducto> findByCompraid(Long compraid);

    @Query("select p from CompraProducto cp join cp.producto.productos_tiendas p " +
            "where p.tienda.nombre = :tiendaNombre and p.productoid = :productoId")
    Optional<TiendaProductoDto> getTiendaId(String tiendaNombre, Long productoId);

    @Query("select p.descuento from CompraProducto cp join cp.producto.productos_tiendas p " +
            "where p.tiendaid = :tiendaid and p.productoid = :productoId")
    float getDesc(Long tiendaid, Long productoId);

    @Query("select p.precio from CompraProducto cp join cp.producto.productos_tiendas p " +
            "where p.tiendaid = :tiendaId and p.productoid = :productoId")
    float getPrecio(Long tiendaId, Long productoId);
    //Optional<CompraProducto> findByCompra
    //Optional<Compra_Producto> findByIdAndPassword(Long id, String password);
    //Optional<Compra_Producto> findByDni(Integer dni);
    //Optional<Compra_Producto> findByTelefono(Integer telefono);

}
