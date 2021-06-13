package com.thellamallama.repositories;

import com.thellamallama.entities.CompositeKeyCP;
import com.thellamallama.entities.CompraProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompraProductoRespository extends JpaRepository<CompraProducto, CompositeKeyCP> {
    //Optional<CompraProducto> findById(Long id);
    Optional<CompraProducto> findByCompraidAndProductoid(Long compraid, Long productoid);
    List<CompraProducto> findByCompraid(Long compraid);
    //Optional<CompraProducto> findByCompra
    //Optional<Compra_Producto> findByIdAndPassword(Long id, String password);
    //Optional<Compra_Producto> findByDni(Integer dni);
    //Optional<Compra_Producto> findByTelefono(Integer telefono);

}
