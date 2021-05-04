/*package com.thellamallama.services.impl;


import com.thellamallama.dtos.CompraDto;
import com.thellamallama.dtos.CreateClienteDto;
import com.thellamallama.dtos.CreateCompraDto;
import com.thellamallama.entities.Cliente;
import com.thellamallama.entities.Compra;
import com.thellamallama.entities.Tipo_pago;
import com.thellamallama.exceptions.BookingException;
import com.thellamallama.exceptions.InternalServerErrorException;
import com.thellamallama.exceptions.NotFoundException;
import com.thellamallama.repositories.ClienteRepository;
import com.thellamallama.repositories.CompraRepository;
import com.thellamallama.repositories.TipopagoRepository;
import com.thellamallama.services.CompraService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Book;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompraServiceImpl implements CompraService {

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    private static final ModelMapper modelMapper=new ModelMapper();

    @Autowired

    private TipopagoRepository tipopagoRepository;


    @Override
    public CompraDto getCompraById(Long CompraId) throws BookingException {
        return modelMapper.map(getCompraEntity(CompraId), CompraDto.class);
    }

    @Override
    public List<CompraDto> getCompras() throws BookingException {
        List<Compra> compraEntity=compraRepository.findAll();
        return compraEntity.stream().map(compra->modelMapper.map(compra,CompraDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public CompraDto createCompra(CreateCompraDto createCompraDto) throws BookingException {
        Cliente clienteID=clienteRepository.findById(createCompraDto.getClienteid())
                .orElseThrow(()-> new NotFoundException("NOT-FOUND","NOT_FOUND"));
        Tipo_pago tipopagoID=tipopagoRepository.findById(createCompraDto.getTipopagoid())
                .orElseThrow(()-> new NotFoundException("NOT-FOUND","NOT_FOUND"));
        if(compraRepository.findByClienteAndTipopago(tipopago.g))
        Compra compra=new Compra();
        compra.setLocator()
        compra.setFecha(createCompraDto.getFecha());
        compra.setDireccion(createCompraDto.getDireccion());
        compra.setCiudad_envio(createCompraDto.getCiudad_envio());
        compra.setDistrito_envio(createCompraDto.getDistrito_envio());
        compra.setMonto_total(createCompraDto.getMonto_total());


        try {
            compra=compraRepository.save(compra);
        }catch (Exception ex){
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR","INTERNAL_SERVER_ERROR");
        }
        return locator;
    }
    private String geneteLocator(Cliente clienteId, CreateCompraDto createCompraDto)
            throws BookingException{
        return clienteId.getNombre()+createCompraDto.getTipopagoid();
    }
    private Compra getCompraEntity(Long compraId)throws BookingException {
        return compraRepository.findById(compraId)
                .orElseThrow(()-> new NotFoundException("NOTFOUND-404","RESTAURANT_NOTFOUND-404"));
    }
}*/