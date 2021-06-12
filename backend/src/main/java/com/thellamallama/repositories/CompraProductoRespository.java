package com.thellamallama.repositories;

import com.thellamallama.entities.CompositeKey;
import com.thellamallama.entities.Compra;
import com.thellamallama.entities.CompraProducto;
import com.thellamallama.entities.Producto;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompraProductoRespository extends JpaRepository<CompraProducto, CompositeKey> {
    //Optional<CompraProducto> findById(Long id);
    Optional<CompraProducto> findByCompraidAndProductoid(Long compraid, Long productoid);
    List<CompraProducto> findByCompraid(Long compraid);
    //Optional<CompraProducto> findByCompra
    //Optional<Compra_Producto> findByIdAndPassword(Long id, String password);
    //Optional<Compra_Producto> findByDni(Integer dni);
    //Optional<Compra_Producto> findByTelefono(Integer telefono);

}
