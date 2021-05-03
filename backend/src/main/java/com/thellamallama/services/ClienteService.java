package com.thellamallama.services;

import com.thellamallama.dtos.ClienteDto;
import com.thellamallama.dtos.CreateClienteDto;

public interface ClienteService {
    ClienteDto getClientebyID(Long clienteid) throws Exception;
    ClienteDto createCliente(CreateClienteDto createClienteDto) throws Exception;
}
