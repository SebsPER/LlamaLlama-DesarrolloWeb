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
@CrossOrigin("http://localhost:4200")
@RequestMapping(path="/llamallama"+"/v1")
public class ProductoController {


    @Autowired
    private ProductoService productoService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/product/{productoId}")
    public BookingResponse<ProductoDto> getProductoById(@PathVariable Long productoId)
            throws BookingException{
        return new BookingResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                productoService.getProductoById(productoId));
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/productn/{nombreProd}")
    public BookingResponse<ProductoDto> getProductoByName(@PathVariable String nombreProd)
            throws BookingException{
        return new BookingResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                productoService.getProductoByName(nombreProd));
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/products")
    public BookingResponse<List<ProductoDto>> getProductos()
            throws BookingException{
        return new BookingResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                productoService.getProductos());
    }
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/products")
    public BookingResponse<ProductoDto> createProducto(@RequestBody CreateProductoDto createProductoDto)
            throws BookingException{
        return new BookingResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                productoService.createProducto(createProductoDto));
    }
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/productdi/{id}")
    public void deleteById(@PathVariable Long id){
        this.productoService.deleteById(id);
    }
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/productdn/{nombre}")
    public void deleteByName(@PathVariable String nombre){
        this.productoService.deleteByNombre(nombre);
    }
}
