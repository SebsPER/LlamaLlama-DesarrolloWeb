package com.thellamallama.controllers;


import com.thellamallama.dtos.ClienteDto;
import com.thellamallama.dtos.Compra_ProductoDto;
import com.thellamallama.dtos.CreateCompra_ProductoDto;
import com.thellamallama.exceptions.BookingException;
import com.thellamallama.responses.BookingResponse;
import com.thellamallama.services.Compra_ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( path= "llamallama"+"/v1")
public class Compra_ProductoController {

    @Autowired
    private Compra_ProductoService compra_productoService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/compra_producto/{compra_productoId}")
    public BookingResponse<Compra_ProductoDto> getCompra_ProductoById(@PathVariable Long compra_productoId) throws BookingException{
        return new BookingResponse<>("Succes", String.valueOf(HttpStatus.OK),"OK",
                compra_productoService.getCompra_ProductoById(compra_productoId));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/compra_productos")
    public BookingResponse<List<Compra_ProductoDto>> getCompra_Productos()
            throws BookingException{
        return new BookingResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                compra_productoService.getCompra_Productos());
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/compra_producto")
    public BookingResponse<Compra_ProductoDto> createCompra_Producto(@RequestBody CreateCompra_ProductoDto createCompra_productoDto)
            throws  BookingException
    {
        return new BookingResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                compra_productoService.createCompra_Producto(createCompra_productoDto));
    }
}
