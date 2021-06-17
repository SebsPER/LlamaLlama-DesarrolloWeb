package com.thellamallama.repositories;

import com.thellamallama.entities.Compra;
import com.thellamallama.entities.Tipo_pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TipopagoRepository extends JpaRepository<Tipo_pago, Long> {
    Optional<Tipo_pago> findById(Long id);
}
