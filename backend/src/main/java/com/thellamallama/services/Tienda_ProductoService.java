package com.thellamallama.services;

import com.thellamallama.dtos.CreateTienda_ProductoDto;
import com.thellamallama.dtos.CreateTipodePagoDto;
import com.thellamallama.dtos.Tienda_ProductoDto;
import com.thellamallama.dtos.TipodePagoDto;
import com.thellamallama.exceptions.BookingException;

import java.util.List;

public interface Tienda_ProductoService {
    Tienda_ProductoDto getTienda_ProductoById(Long tienda_productoid) throws BookingException;
    List<Tienda_ProductoDto> getTtienda_Productos()throws  BookingException;
    Tienda_ProductoDto createTienda_Producto(CreateTienda_ProductoDto createTienda_productoDto)throws BookingException;

}
