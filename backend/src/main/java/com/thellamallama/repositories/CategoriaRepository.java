package com.thellamallama.repositories;

import com.thellamallama.entities.Categoria;
import com.thellamallama.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Optional<Categoria> findById(Long id);

    Optional<Categoria> findByNombre(String nombreCategoria);

    @Query("SELECT Rest FROM Producto Rest")
    List<Categoria> finCategoria();
}
