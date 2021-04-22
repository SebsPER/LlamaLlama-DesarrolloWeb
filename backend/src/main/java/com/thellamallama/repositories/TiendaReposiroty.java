package com.thellamallama.repositories;


import com.thellamallama.entities.Tienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//INSER O DELETE O SELECT TO DO PARA BASE DE DATOS
@Repository
public interface TiendaReposiroty extends JpaRepository<Tienda, Long> {


}
