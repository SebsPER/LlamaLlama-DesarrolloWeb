package com.thellamallama.services.impl;

import com.thellamallama.dtos.CreateTiendaDto;
import com.thellamallama.dtos.TiendaDto;
import com.thellamallama.entities.Tienda;
import com.thellamallama.exceptions.BookingException;
import com.thellamallama.exceptions.InternalServerErrorException;
import com.thellamallama.exceptions.NotFoundException;
import com.thellamallama.repositories.TiendaRepository;
import com.thellamallama.services.TiendaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TiendaServiceImpl implements TiendaService {

    @Autowired
    private TiendaRepository tiendaRepository;

    //@Autowired
    //private Tienda_ProductoRepository tienda_productoRepository;

    private static final ModelMapper modelMapper= new ModelMapper();

    @Override
    public TiendaDto getTiendabyID(Long tiendaid) throws BookingException {
        return modelMapper.map(getTiendaEntity(tiendaid), TiendaDto.class);
    }

    @Override
    public TiendaDto getTiendabyNombre(String nombre) throws BookingException {
        return modelMapper.map(getTiendaEntity(nombre), TiendaDto.class);
    }

    @Override
    public List<TiendaDto> getTiendas() throws BookingException {
        List<Tienda> tiendasEntity= tiendaRepository.findAll();
        return tiendasEntity.stream().map(tienda -> modelMapper.map(tienda,TiendaDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public TiendaDto update(TiendaDto tiendaDto) throws BookingException {
        Tienda tienda = dtoEntity(tiendaDto);
        Tienda saveT = this.tiendaRepository.save(tienda);
        return new TiendaDto(saveT);
    }

    @Transactional
    @Override
    public TiendaDto createTienda(CreateTiendaDto createTiendaDto) throws BookingException {

        Tienda tienda=new Tienda();
        tienda.setNombre(createTiendaDto.getNombre());
        tienda.setDireccion(createTiendaDto.getDireccion());
        tienda.setPassword(createTiendaDto.getPassword());
        tienda.setNombre_encargado(createTiendaDto.getNombre_encargado());
        tienda.setRazon_social(createTiendaDto.getRazon_social());
        tienda.setRUC(createTiendaDto.getRuc());

        try{
            tienda= tiendaRepository.save(tienda);
        }catch(Exception ex){
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR","INTERNAL_SERVER_ERROR");
        }

        return modelMapper.map(getTiendaEntity(tienda.getId()),TiendaDto.class);
    }

    private Tienda getTiendaEntity(Long tiendaid)throws BookingException {
        return tiendaRepository.findById(tiendaid)
                .orElseThrow(()-> new NotFoundException("NOTFOUND-404","TIENDA_NOTFOUND-404"));
    }
    private Tienda getTiendaEntity(String nombre)throws BookingException {
        return tiendaRepository.findByNombre(nombre)
                .orElseThrow(()-> new NotFoundException("NOTFOUND-404","TIENDA_NOTFOUND-404"));
    }
    private Tienda dtoEntity(TiendaDto tDto){
        Tienda t = new Tienda();
        BeanUtils.copyProperties(tDto, t);
        return t;
    }
}
