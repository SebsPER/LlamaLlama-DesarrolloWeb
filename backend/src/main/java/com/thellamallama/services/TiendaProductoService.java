package com.thellamallama.services;

import com.thellamallama.dtos.CreateTiendaProductoDto;
import com.thellamallama.dtos.TiendaProductoDto;
import com.thellamallama.exceptions.BookingException;

import java.util.List;

public interface TiendaProductoService {
    TiendaProductoDto getTienda_ProductoById(Long tiendaid, Long productoid) throws BookingException;
    List<TiendaProductoDto> getTiendaById(Long tiendaid) throws BookingException;
    List<TiendaProductoDto> getAll()throws  BookingException;
    TiendaProductoDto createTienda_Producto(CreateTiendaProductoDto createTienda_productoDto)throws BookingException;
}
