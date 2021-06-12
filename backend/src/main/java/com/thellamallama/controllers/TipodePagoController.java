package com.thellamallama.controllers;


import com.thellamallama.dtos.CreateTipodePagoDto;
import com.thellamallama.dtos.TipodePagoDto;
import com.thellamallama.exceptions.BookingException;
import com.thellamallama.responses.BookingResponse;
import com.thellamallama.services.TipoPagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping( path=  "/llamallama"+"/v1")
public class TipodePagoController {

    @Autowired
    private TipoPagoService tipodePagoService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/tipodepago/{tipodepagoId}")
    public BookingResponse<TipodePagoDto> getTipodePagobyID(@PathVariable Long tipodepagoId) throws BookingException {
        return new BookingResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                tipodePagoService.getTipodePagobyID(tipodepagoId));
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/tipodepagos")
    public BookingResponse<List<TipodePagoDto>> getTipodePago()
            throws BookingException{
        return new BookingResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                tipodePagoService.getTipodePagos());
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/tipodepagos")
    public BookingResponse<TipodePagoDto> createTipodePago(@RequestBody CreateTipodePagoDto createTipodePagoDto) throws
            BookingException{
        return new BookingResponse<>("Succes", String.valueOf(HttpStatus.OK),"OK",
                tipodePagoService.createTipodePago(createTipodePagoDto));
    }
}
