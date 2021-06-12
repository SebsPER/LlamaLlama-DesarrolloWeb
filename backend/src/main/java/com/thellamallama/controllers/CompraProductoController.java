package com.thellamallama.controllers;


import com.thellamallama.dtos.CompraProductoDto;
import com.thellamallama.dtos.CreateCompraProductoDto;
import com.thellamallama.exceptions.BookingException;
import com.thellamallama.responses.BookingResponse;
import com.thellamallama.services.CompraProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping( path= "llamallama"+"/v1")
public class CompraProductoController {

    @Autowired
    private CompraProductoService compraproductoService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/compra_producto/{compraid}/{productoid}")
    public BookingResponse<CompraProductoDto> getCompra_ProductoById(@PathVariable Long compraid, @PathVariable Long productoid)
            throws BookingException{
        return new BookingResponse<>("Succes", String.valueOf(HttpStatus.OK),"OK",
                compraproductoService.getCompra_ProductoById(compraid, productoid));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/compra_producto/{compraid}")
    public BookingResponse<List<CompraProductoDto>> getComprasById(@PathVariable Long compraid)
            throws BookingException{
        return new BookingResponse<>("Succes", String.valueOf(HttpStatus.OK),"OK",
                compraproductoService.getCompraById(compraid));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/compra_productos")
    public BookingResponse<List<CompraProductoDto>> getCompra_Productos()
            throws BookingException{
        return new BookingResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                compraproductoService.getCompra_Productos());
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/compra_producto")
    public BookingResponse<CompraProductoDto> createCompra_Producto(@RequestBody CreateCompraProductoDto createCompra_productoDto)
            throws  BookingException
    {
        return new BookingResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                compraproductoService.createCompra_Producto(createCompra_productoDto));
    }
}
