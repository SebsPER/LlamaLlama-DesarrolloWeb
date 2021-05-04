package com.thellamallama.services;

import com.thellamallama.dtos.CompraDto;
import com.thellamallama.dtos.CreateCompraDto;
import com.thellamallama.exceptions.Exception;

import java.util.List;

public interface CompraService {
    CompraDto getCompraById(Long CompraId) throws Exception;
    List<CompraDto> getCompras()throws java.lang.Exception;
    CompraDto createCompra(CreateCompraDto createCompraDto)throws java.lang.Exception;

}
