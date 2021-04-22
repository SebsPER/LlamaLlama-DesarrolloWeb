package com.thellamallama.services.impl;

import com.thellamallama.dtos.CreateTiendaDto;
import com.thellamallama.dtos.TiendaDto;
import com.thellamallama.entities.Tienda;
import com.thellamallama.exceptions.Exceptions;
import com.thellamallama.exceptions.InternalServerErrorException;
import com.thellamallama.exceptions.NotFoundException;
import com.thellamallama.repositories.TiendaReposiroty;
import com.thellamallama.services.TiendaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class TiendaServiceImpl implements TiendaService {

    @Autowired
    private TiendaReposiroty tiendaReposiroty;

    private static final ModelMapper modelMapper= new ModelMapper();

    @Override
    public TiendaDto getTiendaById(Long tiendaId) throws Exceptions{
        return modelMapper.map(getTiendaEntity(tiendaId), TiendaDto.class);
    }

    @Override
    public List<TiendaDto> getTiendas() throws Exceptions {
        List<Tienda> tiendasEntity=tiendaReposiroty.findAll();
        return tiendasEntity.stream().map(tienda -> modelMapper.map(tienda,TiendaDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public TiendaDto createTienda(CreateTiendaDto createTiendaDto) throws Exceptions {
        Tienda tienda=new Tienda();
        tienda.setNombre(createTiendaDto.getNombre());
        tienda.setDireccion(createTiendaDto.getDireccion());
        tienda.setPassword(createTiendaDto.getPassword());
        tienda.setNombre_encargado(createTiendaDto.getNombre_encargado());
        tienda.setRazon_social(createTiendaDto.getRazon_social());
        tienda.setRUC(createTiendaDto.getRUC());

        try{
            tienda=tiendaReposiroty.save(tienda);
        }catch(Exception ex){
            throw new InternalServerErrorException("INTERNLA_SERVER_ERROR","INTERNAL_SERVER_ERROR");
        }

        return modelMapper.map(getTiendaEntity(tienda.getId()),TiendaDto.class);
    }

    private Tienda getTiendaEntity(Long tiendaId)throws Exceptions{
        return tiendaReposiroty.findById(tiendaId)
                .orElseThrow(()-> new NotFoundException("NOTFOUND-404","TIENDA_NOTFOUND-404"));
    }
}
