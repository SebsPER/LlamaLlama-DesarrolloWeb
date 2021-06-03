package com.thellamallama.services.impl;

import com.thellamallama.dtos.Compra_ProductoDto;
import com.thellamallama.dtos.CreateCompra_ProductoDto;
import com.thellamallama.entities.Compra_Producto;
import com.thellamallama.exceptions.BookingException;
import com.thellamallama.exceptions.InternalServerErrorException;
import com.thellamallama.exceptions.NotFoundException;
import com.thellamallama.repositories.Compra_ProductoRespository;
import com.thellamallama.services.Compra_ProductoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class Compra_ProductoServiceImpl implements Compra_ProductoService {

    @Autowired
    private Compra_ProductoRespository compra_productoRespository;

    private  static final ModelMapper modelMapper= new ModelMapper();
    @Override
    public Compra_ProductoDto getCompra_ProductoById(Long compra_productoid) throws BookingException {
        return modelMapper.map(getCopmra_ProductoEntity(compra_productoid),Compra_ProductoDto.class);
    }

    @Override
    public List<Compra_ProductoDto> getCompra_Productos() throws BookingException {
        List<Compra_Producto> compra_productosEntity = compra_productoRespository.findAll();
        return compra_productosEntity.stream().map(compra_producto -> modelMapper.map(compra_producto,Compra_ProductoDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public Compra_ProductoDto createCompra_Producto(CreateCompra_ProductoDto createCompra_productoDtO) throws BookingException {
        Compra_Producto compra_producto=new Compra_Producto();
        compra_producto.setCant_productos(createCompra_productoDtO.getCant_productos());
        compra_producto.setDate(createCompra_productoDtO.getDate());

        try{
            compra_producto = compra_productoRespository.save(compra_producto);
        }catch (Exception ex){
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR","INTERNAL_SERVER_ERROR");
        }

        return modelMapper.map(getCopmra_ProductoEntity(compra_producto.getId()),Compra_ProductoDto.class);
    }


    private Compra_Producto getCopmra_ProductoEntity(Long compra_productoid) throws BookingException{
        return compra_productoRespository.findById(compra_productoid)
                .orElseThrow(()->new NotFoundException("NOT-FOUND-404","NOT-FOUND-404"));
    }
}
