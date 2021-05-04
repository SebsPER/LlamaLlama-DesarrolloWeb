package com.thellamallama.services.impl;


import com.thellamallama.dtos.CompraDto;
import com.thellamallama.dtos.CreateCompraDto;
import com.thellamallama.entities.Compra;
import com.thellamallama.exceptions.BookingException;
import com.thellamallama.exceptions.InternalServerErrorException;
import com.thellamallama.exceptions.NotFoundException;
import com.thellamallama.repositories.CompraRepository;
import com.thellamallama.services.CompraService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

public class CompraServiceImpl implements CompraService {

    @Autowired
    private CompraRepository compraRepository;

    private static final ModelMapper modelMapper=new ModelMapper();


    @Override
    public CompraDto getCompraById(Long CompraId) throws Exception {
        return modelMapper.map(getCompraEntity(CompraId), CompraDto.class);
    }

    @Override
    public List<CompraDto> getCompras() throws Exception {
        List<Compra> compraEntity=compraRepository.findAll();
        return compraEntity.stream().map(compra->modelMapper.map(compra,CompraDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public CompraDto createCompra(CreateCompraDto createCompraDto) throws Exception {
        Compra compra=new Compra();
        compra.setCliente(createCompraDto.getCod_cliente());
        compra.setFecha(createCompraDto.getFecha());
        compra.setDireccion(createCompraDto.getDireccion());
        compra.setCiudad_envio(createCompraDto.getCiudad_envio());
        compra.setDistrito_envio(createCompraDto.getDistrito_envio());
        compra.setMonto_total(createCompraDto.getMonto_total());
        compra.setTipo_pago(createCompraDto.getTipo_pago());

        try {
            compra=compraRepository.save(compra);
        }catch (Exception ex){
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR","INTERNAL_SERVER_ERROR");
        }
        return modelMapper.map(getCompraEntity(compra.getId()),CompraDto.class);
    }
    private Compra getCompraEntity(Long compraId)throws Exception {
        return compraRepository.findById(compraId)
                .orElseThrow(()-> new NotFoundException("NOTFOUND-404","RESTAURANT_NOTFOUND-404"));
    }
}