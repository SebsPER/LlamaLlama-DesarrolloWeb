package com.thellamallama.services.impl;

import com.thellamallama.dtos.ClienteDto;
import com.thellamallama.dtos.CreateClienteDto;
import com.thellamallama.entities.Cliente;
import com.thellamallama.exceptions.BookingException;
import com.thellamallama.exceptions.InternalServerErrorException;
import com.thellamallama.exceptions.NotFoundException;
import com.thellamallama.repositories.ClienteRepository;
import com.thellamallama.services.ClienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    private static final ModelMapper modelMapper= new ModelMapper();
    @Override
    public ClienteDto getClientebyID(Long clienteid) throws BookingException {
        return modelMapper.map(getClienteEntity(clienteid),ClienteDto.class) ;
    }

    @Override
    public List<ClienteDto> getClientes() throws BookingException {
        List<Cliente> clientesEntity=clienteRepository.findAll();
        return clientesEntity.stream().map(cliente -> modelMapper.map(cliente,ClienteDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public ClienteDto createCliente(CreateClienteDto createClienteDto) throws BookingException {
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
    private Cliente getClienteEntity(Long clienteid) throws BookingException {
        return clienteRepository.findById(clienteid)
                .orElseThrow(()-> new NotFoundException("NOT-FOUND-404","NOT-FOUND-404"));
    }


}