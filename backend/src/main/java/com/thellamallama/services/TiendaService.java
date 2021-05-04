package com.thellamallama.services;

import com.thellamallama.dtos.CreateTiendaDto;
import com.thellamallama.dtos.TiendaDto;
import com.thellamallama.exceptions.BookingException;

import java.util.List;

public interface TiendaService {
    TiendaDto getTiendaById(Long tiendaId)  throws BookingException;
    List<TiendaDto> getTiendas() throws BookingException;
    TiendaDto createTienda(CreateTiendaDto createTiendaDto) throws BookingException;
}
