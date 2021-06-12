package com.thellamallama.services;

import com.thellamallama.dtos.CreateTiendaProductoDto;
import com.thellamallama.dtos.TiendaProductoDto;
import com.thellamallama.exceptions.BookingException;

import java.util.List;

public interface TiendaProductoService {
    TiendaProductoDto getTienda_ProductoById(Long tienda_productoid) throws BookingException;
    List<TiendaProductoDto> getTtienda_Productos()throws  BookingException;
    TiendaProductoDto createTienda_Producto(CreateTiendaProductoDto createTienda_productoDto)throws BookingException;

}
