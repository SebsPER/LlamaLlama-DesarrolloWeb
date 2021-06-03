package com.thellamallama.controllers;

import com.thellamallama.dtos.CategoriaDto;
import com.thellamallama.dtos.CreateCategoriaDto;
import com.thellamallama.dtos.CreateTienda_ProductoDto;
import com.thellamallama.dtos.Tienda_ProductoDto;
import com.thellamallama.exceptions.BookingException;
import com.thellamallama.responses.BookingResponse;
import com.thellamallama.services.CategoriaService;
import com.thellamallama.services.Tienda_ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( path=  "/llamallama"+"/v1")
public class Tienda_ProductoController {

    @Autowired
    private Tienda_ProductoService tienda_productoService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/tienda_producto/{tienda_productoId}")
    public BookingResponse<Tienda_ProductoDto> getTienda_productoById(@PathVariable Long tienda_productoId)
            throws BookingException {
        return new BookingResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                tienda_productoService.getTienda_ProductoById(tienda_productoId));
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/tienda_producto")
    public BookingResponse<List<Tienda_ProductoDto>> getTienda_producto()
            throws BookingException{
        return new BookingResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                tienda_productoService.getTtienda_Productos());
    }
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/tienda_producto")
    public BookingResponse<Tienda_ProductoDto> createTienda_producto(@RequestBody CreateTienda_ProductoDto createTienda_productoDto)
            throws BookingException{
        return new BookingResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                tienda_productoService.createTienda_Producto(createTienda_productoDto));
    }
}
