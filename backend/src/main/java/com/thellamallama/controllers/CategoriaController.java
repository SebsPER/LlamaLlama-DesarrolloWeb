package com.thellamallama.controllers;

import com.thellamallama.dtos.CategoriaDto;
import com.thellamallama.dtos.CreateCategoriaDto;
import com.thellamallama.dtos.CreateProductoDto;
import com.thellamallama.dtos.ProductoDto;
import com.thellamallama.exceptions.BookingException;
import com.thellamallama.responses.BookingResponse;
import com.thellamallama.services.CategoriaService;
import com.thellamallama.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( path=  "/llamallama"+"/v1")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/categoria/{categoriaId}")
    public BookingResponse<CategoriaDto> getCategoriaById(@PathVariable Long categoriaId)
            throws BookingException {
        return new BookingResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                categoriaService.getCategoriaById(categoriaId));
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/categoria")
    public BookingResponse<List<CategoriaDto>> getCategorias()
            throws BookingException{
        return new BookingResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                categoriaService.getCategorias());
    }
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/categoria")
    public BookingResponse<CategoriaDto> createCategoria(@RequestBody CreateCategoriaDto createCategoriaDto)
            throws BookingException{
        return new BookingResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                categoriaService.createCategoria(createCategoriaDto));
    }
}
