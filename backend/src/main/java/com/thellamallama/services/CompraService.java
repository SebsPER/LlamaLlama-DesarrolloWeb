package com.thellamallama.services;

import com.thellamallama.dtos.CompraDto;
import com.thellamallama.dtos.CreateCompraDto;
import com.thellamallama.exceptions.BookingException;

import java.util.List;

public interface CompraService {
    CompraDto getCompraById(Long CompraId) throws BookingException;
    List<CompraDto> getCompras()throws BookingException;
    CompraDto createCompra(CreateCompraDto createCompraDto)throws BookingException;

}
