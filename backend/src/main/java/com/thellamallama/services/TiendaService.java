package com.thellamallama.services;

import com.thellamallama.dtos.CreateTiendaDto;
import com.thellamallama.dtos.TiendaDto;
import com.thellamallama.exceptions.BookingException;

import java.util.List;

public interface TiendaService {
    TiendaDto getTiendabyID(Long tiendaid)  throws BookingException;
    TiendaDto getTiendabyNombre(String nombre)  throws BookingException;
    List<TiendaDto> getTiendas() throws BookingException;
    TiendaDto update(TiendaDto tiendaDto) throws BookingException;
    TiendaDto createTienda(CreateTiendaDto createTiendaDto) throws BookingException;
}
