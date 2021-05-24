package com.thellamallama.services.impl;


import com.thellamallama.dtos.CompraDto;
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

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompraServiceImpl implements CompraService {

    @Autowired
    private CompraRepository compraRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private TipopagoRepository tipopagoRepository;

    private static final ModelMapper modelMapper=new ModelMapper();


    @Override
    public CompraDto getCompraById(Long Compraid) throws BookingException {
        return modelMapper.map(getCompraEntity(Compraid), CompraDto.class);
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
        Cliente clienteId = clienteRepository.findById(createCompraDto.getClienteid())
                .orElseThrow(() -> new NotFoundException("NOT-401-1", "CLIENT_NOT_FOUND"));

        Tipo_pago tipoId = tipopagoRepository.findById(createCompraDto.getTipopagoid())
                .orElseThrow(() -> new NotFoundException("NOT-401-1", "PAYMENT_TYPE_NOT_FOUND"));

        Compra compra=new Compra();
        compra.setFecha(createCompraDto.getFecha());
        compra.setDireccion(createCompraDto.getDireccion());
        compra.setCiudad_envio(createCompraDto.getCiudad_envio());
        compra.setDistrito_envio(createCompraDto.getDistrito_envio());
        compra.setMonto_total(createCompraDto.getMonto_total());

        compra.setCliente(clienteId);
        compra.setTipo_pago(tipoId);

        try {
            compra=compraRepository.save(compra);
        }catch (Exception ex){
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR","INTERNAL_SERVER_ERROR");
        }
        return modelMapper.map(getCompraEntity(compra.getId()),CompraDto.class);
    }

    private Compra getCompraEntity(Long compraid)throws BookingException {
        return compraRepository.findById(compraid)
                .orElseThrow(()-> new NotFoundException("NOTFOUND-404","RESTAURANT_NOTFOUND-404"));
    }
}