package com.thellamallama.services.impl;

import com.thellamallama.dtos.ClienteDto;
import com.thellamallama.dtos.CreateClienteDto;
import com.thellamallama.entities.Cliente;
import com.thellamallama.entities.Tienda;
import com.thellamallama.exceptions.Exceptions;
import com.thellamallama.exceptions.InternalServerErrorException;
import com.thellamallama.exceptions.NotFoundException;
import com.thellamallama.repositories.ClienteRepository;
import com.thellamallama.services.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    private static final ModelMapper modelMapper= new ModelMapper();
    @Override
    public ClienteDto getClientebyID(Long clienteid) throws Exception {
        return modelMapper.map(getClienteEntity(clienteid),ClienteDto.class) ;
    }

    @Override
    public ClienteDto createCliente(CreateClienteDto createClienteDto) throws Exception {
        Cliente cliente= new Cliente();
        cliente.setNombre(createClienteDto.getNombre());
        cliente.setDni(createClienteDto.getDni());
        cliente.setDireccion(createClienteDto.getDireccion());
        cliente.setTelefono(createClienteDto.getTelefono());
        cliente.setApellido_paterno(createClienteDto.getApellido_paterno());
        cliente.setApellido_materno(createClienteDto.getApellido_materno());
        cliente.setPassword(createClienteDto.getPassword());
        try{
            cliente = clienteRepository.save(cliente);
        }catch (Exception ex){
            throw  new InternalServerErrorException("INTERNAL_SERVER_ERROR","INTERNAL_SERVER_ERROR");
        }
        return modelMapper.map(getClienteEntity(cliente.getId()), ClienteDto.class);

    }
    private Cliente getClienteEntity(Long clienteid) throws Exceptions{
        return clienteRepository.findById(clienteid)
                .orElseThrow(()-> new NotFoundException("NOT-FOUND-404","NOT-FOUND-404"));
    }


}