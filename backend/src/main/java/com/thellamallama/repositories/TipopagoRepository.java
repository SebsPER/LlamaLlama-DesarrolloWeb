package com.thellamallama.repositories;

import com.thellamallama.entities.Tipo_pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipopagoRepository extends JpaRepository<Tipo_pago, Long> {
}
