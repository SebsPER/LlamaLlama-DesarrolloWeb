package com.thellamallama.controllers;

import com.thellamallama.dtos.CompraDto;
import com.thellamallama.dtos.CreateCompraDto;
import com.thellamallama.entities.Compra;
import com.thellamallama.exceptions.BookingException;
import com.thellamallama.responses.BookingResponse;
import com.thellamallama.services.ClienteService;
import com.thellamallama.services.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/llamallama"+"/v1")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/compra/{compraId}")
    public BookingResponse<CompraDto>  getComprabyId(@PathVariable Long compraId)
        throws BookingException{
        return new BookingResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                compraService.getCompraById(compraId));
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("compras")
    public BookingResponse<List<CompraDto>> getCompras()
        throws BookingException{
        return new BookingResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                compraService.getCompras());
    }
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("compras")
    public BookingResponse<CompraDto> createCompra(@RequestBody CreateCompraDto createCompraDto)
            throws BookingException{
        return new BookingResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                compraService.createCompra(createCompraDto));
    }

}
