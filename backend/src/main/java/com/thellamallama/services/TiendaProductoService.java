package com.thellamallama.services;

import com.thellamallama.dtos.CreateTiendaProductoDto;
import com.thellamallama.dtos.TProdCategoriaDto;
import com.thellamallama.dtos.TiendaProductoDto;
import com.thellamallama.exceptions.BookingException;

import java.util.List;

public interface TiendaProductoService {
    TiendaProductoDto getTienda_ProductoById(Long tiendaid, Long productoid) throws BookingException;
    List<TiendaProductoDto> getTiendaById(Long tiendaid) throws BookingException;
    List<TiendaProductoDto> getTpByCategoria(String categoriaid) throws BookingException;
    List<TiendaProductoDto> getAll()throws  BookingException;
    List<TiendaProductoDto> getTpByNombreProd(String nombre) throws BookingException;
    List<TiendaProductoDto> getTpByNombreTienda(String nombre) throws BookingException;
    TiendaProductoDto update(Long tiendaid, Long productoid, Integer stock, Integer precio, float descuento) throws BookingException;
    TiendaProductoDto createTienda_Producto(CreateTiendaProductoDto createTienda_productoDto)throws BookingException;
    void deleteByTiendaidAndProductoid(Long tiendaid, Long productoid);
}
