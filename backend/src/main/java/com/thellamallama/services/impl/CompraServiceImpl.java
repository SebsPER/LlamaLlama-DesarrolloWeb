package com.thellamallama.services.impl;


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
import java.util.stream.Stream;

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
        Compra data = getCompraEntity(Compraid);
        CompraDto map = modelMapper.map(getCompraEntity(Compraid), CompraDto.class);
        map.setTipopagoid(data.getTipo_pago().getId());
        map.setClienteid(data.getCliente().getId());
        return map;
        //return modelMapper.map(getCompraEntity(Compraid), CompraDto.class);
    }

    @Override
    public List<CompraDto> getCompraByClienteId(Long clienteId) throws BookingException {
        List<Compra> compraEntity = compraRepository.findByClienteId(clienteId);
        Stream<CompraDto> maps = compraEntity.stream().map(compra->modelMapper.map(compra,CompraDto.class));
        List<CompraDto> arrayM = maps.collect(Collectors.toList());
        for (CompraDto m: arrayM){
            Compra data = getCompraEntity(m.getId());
            m.setTipopagoid(data.getTipo_pago().getId());
            m.setClienteid(data.getCliente().getId());
        }
        return arrayM;
    }

    @Override
    public List<CompraDto> getCompras() throws BookingException {
        List<Compra> compraEntity=compraRepository.findAll();
        Stream<CompraDto> maps = compraEntity.stream().map(compra->modelMapper.map(compra,CompraDto.class));
        //long size = compraEntity.stream().map(compra->modelMapper.map(compra,CompraDto.class)).count();
        List<CompraDto> arrayM = maps.collect(Collectors.toList());
        for (CompraDto m: arrayM){
            Compra data = getCompraEntity(m.getId());
            m.setTipopagoid(data.getTipo_pago().getId());
            m.setClienteid(data.getCliente().getId());
        }
        return arrayM;
    }

    @Transactional
    @Override
    public CompraDto createCompra(CreateCompraDto createCompraDto) throws BookingException {
        Cliente clienteId = clienteRepository.findById(createCompraDto.getClienteid())
                .orElseThrow(() -> new NotFoundException("NOT-401-1", "CLIENTE_NOT_FOUND"));

        Tipo_pago tipoId = tipopagoRepository.findById(createCompraDto.getTipopagoid())
                .orElseThrow(() -> new NotFoundException("NOT-401-1", "TIPOPAGO_NOT_FOUND"));

        Compra compra=new Compra();
        compra.setFecha(createCompraDto.getFecha());
        compra.setDireccion(createCompraDto.getDireccion());
        compra.setCiudad_envio(createCompraDto.getCiudad_envio());
        compra.setDistrito_envio(createCompraDto.getDistrito_envio());
        compra.setMonto_total(createCompraDto.getMonto_total());
        compra.setTipo_pago(tipoId);
        compra.setCliente(clienteId);

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