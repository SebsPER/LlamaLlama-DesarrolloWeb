package com.thellamallama.controllers;

import com.thellamallama.dtos.CreateTiendaDto;
import com.thellamallama.dtos.TiendaDto;
import com.thellamallama.entities.Tienda;
import com.thellamallama.exceptions.BookingException;
import com.thellamallama.responses.BookingResponse;
import com.thellamallama.services.TiendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import lombok.Getter;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(path="/llamallama"+"/v1")
public class TiendaController {

    @Autowired
    private TiendaService tiendaService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/tienda/{tiendaId}")
    public BookingResponse<TiendaDto> getTiendabyId(@PathVariable Long tiendaId) throws BookingException
    {
        return new BookingResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                    tiendaService.getTiendabyID(tiendaId));
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/tiendan/{tiendaName}")
    public BookingResponse<TiendaDto> getTiendabyName(@PathVariable String tiendaName) throws BookingException
    {
        return new BookingResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                tiendaService.getTiendabyNombre(tiendaName));

    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/tiend/{tiendapass}/{tiendaruc}")
    public BookingResponse<TiendaDto> getTiendasbyRUCAndPass(@PathVariable Long tiendaruc,@PathVariable String tiendapass) throws BookingException {
        return new BookingResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                tiendaService.getTiendabyRUCAndPass(tiendaruc,tiendapass));

    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/tienda")
    public BookingResponse<List<TiendaDto>> getTiendas()
        throws BookingException{
        return new BookingResponse<>("Sucess",String.valueOf(HttpStatus.OK),"OK",
                tiendaService.getTiendas());
    }
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/tUpdate")
    public BookingResponse<TiendaDto> update(@RequestBody TiendaDto subDto)  throws BookingException{
        return new BookingResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                tiendaService.update(subDto));
    }
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/tienda")
    public BookingResponse<TiendaDto> createTienda(@RequestBody CreateTiendaDto createTiendaDto)
            throws BookingException{
        return new BookingResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                    tiendaService.createTienda(createTiendaDto));
    }
}
