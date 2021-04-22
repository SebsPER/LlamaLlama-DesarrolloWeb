package com.thellamallama.services;

import com.thellamallama.dtos.CreateTiendaDto;
import com.thellamallama.dtos.TiendaDto;
import com.thellamallama.entities.Tienda;
import com.thellamallama.exceptions.Exceptions;

import java.util.List;

public interface TiendaService {
    TiendaDto getTiendaById(Long tiendaId)  throws Exceptions;
    List<TiendaDto> getTiendas() throws Exceptions;
    TiendaDto createTienda(CreateTiendaDto createTiendaDto) throws  Exceptions;
}
