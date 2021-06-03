package com.thellamallama.services;

import com.thellamallama.controllers.Compra_ProductoController;
import com.thellamallama.dtos.Compra_ProductoDto;
import com.thellamallama.dtos.CreateCompra_ProductoDto;
import com.thellamallama.exceptions.BookingException;
import com.thellamallama.responses.BookingResponse;

import java.util.List;

public interface Compra_ProductoService {
    Compra_ProductoDto getCompra_ProductoById(Long compra_productoid) throws BookingException;
    List<Compra_ProductoDto> getCompra_Productos() throws BookingException;
    Compra_ProductoDto createCompra_Producto(CreateCompra_ProductoDto createCompra_productoDtO) throws BookingException;
}
