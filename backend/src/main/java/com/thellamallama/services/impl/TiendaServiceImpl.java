package com.thellamallama.services.impl;

import com.thellamallama.dtos.CreateTiendaDto;
import com.thellamallama.dtos.TiendaDto;
import com.thellamallama.entities.Tienda;
import com.thellamallama.exceptions.BookingException;
import com.thellamallama.exceptions.InternalServerErrorException;
import com.thellamallama.exceptions.NotFoundException;
import com.thellamallama.repositories.TiendaReposiroty;
import com.thellamallama.services.TiendaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TiendaServiceImpl implements TiendaService {

    @Autowired
    private TiendaReposiroty tiendaReposiroty;

    //@Autowired
    //private Tienda_ProductoRepository tienda_productoRepository;

    private static final ModelMapper modelMapper= new ModelMapper();

    @Override
    public TiendaDto getTiendabyID(Long tiendaid) throws BookingException {
        return modelMapper.map(getTiendaEntity(tiendaid), TiendaDto.class);
    }

    @Override
    public List<TiendaDto> getTiendas() throws BookingException {
        List<Tienda> tiendasEntity=tiendaReposiroty.findAll();
        return tiendasEntity.stream().map(tienda -> modelMapper.map(tienda,TiendaDto.class))
                .collect(Collectors.toList());
    }
    @Transactional
    @Override
    public TiendaDto createTienda(CreateTiendaDto createTiendaDto) throws BookingException {
       /// List<Tienda_Producto> tienda_productoid= (List<Tienda_Producto>) tienda_productoRepository.findById(createTiendaDto.getTienda_productoid())
       ///         .orElseThrow(()-> new NotFoundException("NOT-404-1","RESTAURANT_NOT_FOUND"));

        Tienda tienda=new Tienda();
        tienda.setNombre(createTiendaDto.getNombre());
        tienda.setDireccion(createTiendaDto.getDireccion());
        tienda.setPassword(createTiendaDto.getPassword());
        tienda.setNombre_encargado(createTiendaDto.getNombre_encargado());
        tienda.setRazon_social(createTiendaDto.getRazon_social());
        tienda.setRUC(createTiendaDto.getRUC());
       /// tienda.setTienda_productos(tienda_productoid);
        try{
            tienda=tiendaReposiroty.save(tienda);
        }catch(Exception ex){
            throw new InternalServerErrorException("iiINTERNAL_SERVER_ERROR","iiINTERNAL_SERVER_ERROR");
        }

        return modelMapper.map(getTiendaEntity(tienda.getId()),TiendaDto.class);
    }

    private Tienda getTiendaEntity(Long tiendaid)throws BookingException {
        return tiendaReposiroty.findById(tiendaid)
                .orElseThrow(()-> new NotFoundException("NOTFOUND-404","TIENDA_NOTFOUND-404"));
    }
}
