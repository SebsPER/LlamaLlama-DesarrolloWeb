package com.thellamallama.services;

import com.thellamallama.dtos.ClienteDto;
import com.thellamallama.dtos.CreateClienteDto;
import com.thellamallama.dtos.TiendaDto;
import com.thellamallama.entities.Cliente;
import com.thellamallama.exceptions.BookingException;

import java.awt.print.Book;
import java.util.List;

public interface ClienteService {
    ClienteDto getClientebyID(Long clienteid) throws BookingException;
    List<ClienteDto> getClientes() throws BookingException;
    ClienteDto update(ClienteDto clienteDto) throws BookingException;
    ClienteDto createCliente(CreateClienteDto createClienteDto) throws BookingException;
}
