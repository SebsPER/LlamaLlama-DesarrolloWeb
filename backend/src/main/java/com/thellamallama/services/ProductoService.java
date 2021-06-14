package com.thellamallama.services;


import com.thellamallama.dtos.CreateProductoDto;
import com.thellamallama.dtos.ProductoDto;
import com.thellamallama.exceptions.BookingException;

import java.util.List;

public interface ProductoService {
    ProductoDto getProductoById(Long productoId) throws BookingException;
    ProductoDto getProductoByName(String nombre) throws BookingException;
    List<ProductoDto> getProductos()throws BookingException;
    ProductoDto createProducto(CreateProductoDto createProductoDto)throws BookingException;
}
