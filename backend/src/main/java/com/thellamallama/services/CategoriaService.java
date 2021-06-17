package com.thellamallama.services;

import com.thellamallama.dtos.CategoriaDto;
import com.thellamallama.dtos.CreateCategoriaDto;
import com.thellamallama.dtos.CreateProductoDto;
import com.thellamallama.dtos.ProductoDto;
import com.thellamallama.exceptions.BookingException;

import java.util.List;

public interface CategoriaService {
    CategoriaDto getCategoriaById(Long categoriaid)throws BookingException;
    CategoriaDto createCategoria(CreateCategoriaDto createCategoriaDto)throws BookingException;
    List<CategoriaDto> getCategorias()throws BookingException;
}
