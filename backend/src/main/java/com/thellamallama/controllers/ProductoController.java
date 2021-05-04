package com.thellamallama.controllers;


import com.thellamallama.dtos.CreateProductoDto;
import com.thellamallama.dtos.ProductoDto;
import com.thellamallama.entities.Producto;
import com.thellamallama.exceptions.BookingException;
import com.thellamallama.responses.BookingResponse;
import com.thellamallama.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/llamallama"+"/v1")
public class ProductoController {


    @Autowired
    private ProductoService productoService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/product/{productId}")
    public BookingResponse<ProductoDto> getProductById(@PathVariable Long productoId)
            throws BookingException{
        return new BookingResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                productoService.getProductoById(productoId));
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/products")
    public BookingResponse<List<ProductoDto>> getProducts()
            throws BookingException{
        return new BookingResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                productoService.getProductos());
    }
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/products")
    public BookingResponse<ProductoDto> createProducto(@RequestBody CreateProductoDto createProductoDto)
            throws BookingException{
        return new BookingResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                productoService.createProducto(createProductoDto));
    }
}
