package com.thellamallama.services;

import com.thellamallama.dtos.CompraProductoDto;
import com.thellamallama.dtos.CreateCompraProductoDto;
import com.thellamallama.exceptions.BookingException;

import java.util.List;

public interface CompraProductoService {
    CompraProductoDto getCompra_ProductoById(Long compraid, Long productoid) throws BookingException;
    List<CompraProductoDto> getCompraById(Long compraid) throws BookingException;
    List<CompraProductoDto> getAll() throws BookingException;
    CompraProductoDto createCompra_Producto(CreateCompraProductoDto createCompra_productoDtO) throws BookingException;
}
