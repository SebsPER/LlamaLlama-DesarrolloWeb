package com.thellamallama.services;

import com.thellamallama.dtos.ClienteDto;
import com.thellamallama.dtos.CreateClienteDto;
import com.thellamallama.exceptions.BookingException;

public interface ClienteService {
    ClienteDto getClientebyID(Long clienteid) throws BookingException;
    ClienteDto createCliente(CreateClienteDto createClienteDto) throws BookingException;
}
