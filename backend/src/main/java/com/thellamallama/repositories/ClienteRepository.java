package com.thellamallama.repositories;

import com.thellamallama.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findById(Long id);
    Optional<Cliente> findByIdAndPassword(Long id, String password);
    Optional<Cliente> findByDni(Integer dni);
    Optional<Cliente> findByTelefono(Integer telefono);

}
