package com.thellamallama.repositories;

import com.thellamallama.entities.Cliente;
import com.thellamallama.entities.Compra_Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Compra_ProductoRespository extends JpaRepository<Compra_Producto,Long> {
    Optional<Compra_Producto> findById(Long id);
    //Optional<Compra_Producto> findByIdAndPassword(Long id, String password);
    //Optional<Compra_Producto> findByDni(Integer dni);
    //Optional<Compra_Producto> findByTelefono(Integer telefono);

}
