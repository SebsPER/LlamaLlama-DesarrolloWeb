package com.thellamallama.controllers;

import com.thellamallama.dtos.CreateTiendaProductoDto;
import com.thellamallama.dtos.TiendaProductoDto;
import com.thellamallama.exceptions.BookingException;
import com.thellamallama.responses.BookingResponse;
import com.thellamallama.services.TiendaProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping( path=  "/llamallama"+"/v1")
public class TiendaProductoController {

    @Autowired
    private TiendaProductoService tienda_productoService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/tienda_producto/{tienda_productoId}")
    public BookingResponse<TiendaProductoDto> getTienda_productoById(@PathVariable Long tienda_productoId)
            throws BookingException {
        return new BookingResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                tienda_productoService.getTienda_ProductoById(tienda_productoId));
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/tienda_producto")
    public BookingResponse<List<TiendaProductoDto>> getTienda_producto()
            throws BookingException{
        return new BookingResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                tienda_productoService.getTtienda_Productos());
    }
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/tienda_producto")
    public BookingResponse<TiendaProductoDto> createTienda_producto(@RequestBody CreateTiendaProductoDto createTienda_productoDto)
            throws BookingException{
        return new BookingResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                tienda_productoService.createTienda_Producto(createTienda_productoDto));
    }
}
