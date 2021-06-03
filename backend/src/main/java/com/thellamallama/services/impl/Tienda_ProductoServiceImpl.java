package com.thellamallama.services.impl;

import com.thellamallama.dtos.CreateTienda_ProductoDto;
import com.thellamallama.dtos.Tienda_ProductoDto;
import com.thellamallama.entities.Producto;
import com.thellamallama.entities.Tienda;
import com.thellamallama.entities.Tienda_Producto;
import com.thellamallama.exceptions.BookingException;
import com.thellamallama.exceptions.InternalServerErrorException;
import com.thellamallama.exceptions.NotFoundException;
import com.thellamallama.repositories.ProductoRepository;
import com.thellamallama.repositories.TiendaReposiroty;
import com.thellamallama.repositories.Tienda_ProductoRepository;
import com.thellamallama.services.Tienda_ProductoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class Tienda_ProductoServiceImpl implements Tienda_ProductoService {



    @Autowired
    private Tienda_ProductoRepository tienda_productoRepository;
    @Autowired
    private TiendaReposiroty tiendaReposiroty;
    @Autowired
    private ProductoRepository productoRepository;

    private static final ModelMapper modelMapper = new ModelMapper();


    @Override
    public Tienda_ProductoDto getTienda_ProductoById(Long tienda_productoid) throws BookingException {
        return modelMapper.map(getTienda_ProductoEntity(tienda_productoid),Tienda_ProductoDto.class);
    }

    @Override
    public List<Tienda_ProductoDto> getTtienda_Productos() throws BookingException {
        List<Tienda_Producto> tiendaProductoEntity = tienda_productoRepository.findAll();
        return tiendaProductoEntity.stream().map(tienda_producto -> modelMapper.map(tienda_producto,Tienda_ProductoDto.class)).collect(Collectors.toList());
    }
    @Transactional
    @Override
    public Tienda_ProductoDto createTienda_Producto(CreateTienda_ProductoDto createTienda_productoDto) throws BookingException {
        Tienda tiendaid= tiendaReposiroty.findById(createTienda_productoDto.getTiendaid())
                .orElseThrow(()-> new NotFoundException("NOT-401-1","TIENDA_ID_NOT_FOUND"));

        Producto productoid = productoRepository.findById(createTienda_productoDto.getProductoid())
                .orElseThrow(()-> new NotFoundException("NOT-401-1","TIENDA_ID_NOT_FOUND"));


        Tienda_Producto tienda_producto=new Tienda_Producto();
        tienda_producto.setCant_tiendas(createTienda_productoDto.getCant_tiendas());
        tienda_producto.setDate(createTienda_productoDto.getDate());
        tienda_producto.setProducto(productoid);
        tienda_producto.setTienda(tiendaid);

        try{
            tienda_producto=tienda_productoRepository.save(tienda_producto);
        }catch (Exception ex){
            throw new InternalServerErrorException("INTERLANL_SERVER_ERROR","INTERNAL_SERVER_ERROR");
        }
        return modelMapper.map(getTienda_ProductoEntity(tienda_producto.getId()),Tienda_ProductoDto.class);
    }

    private Tienda_Producto getTienda_ProductoEntity(Long tienda_productoId)throws BookingException{
        return tienda_productoRepository.findById(tienda_productoId).
                orElseThrow(()-> new NotFoundException("NOTFOUND-404","RESTAURANT_NOTFOUND-404"));
    }
}
