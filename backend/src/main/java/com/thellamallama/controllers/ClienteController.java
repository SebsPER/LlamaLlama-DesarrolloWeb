package com.thellamallama.controllers;

import com.thellamallama.dtos.ClienteDto;
import com.thellamallama.dtos.CreateClienteDto;
import com.thellamallama.exceptions.BookingException;
import com.thellamallama.responses.BookingResponse;
import com.thellamallama.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping( path=  "/llamallama"+"/v1")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/cliente/{clienteId}")
    public BookingResponse<ClienteDto> getClientebyId(@PathVariable Long clienteId) throws BookingException {
        return new BookingResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                clienteService.getClientebyID(clienteId));
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/clientes")
    public BookingResponse<List<ClienteDto>> getClientes()
        throws BookingException{
        return new BookingResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                clienteService.getClientes());
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/clientes")
    public BookingResponse<ClienteDto> createCliente(@RequestBody CreateClienteDto createClienteDto) throws
            BookingException{
        return new BookingResponse<>("Succes", String.valueOf(HttpStatus.OK),"OK",
                clienteService.createCliente(createClienteDto));
    }
}