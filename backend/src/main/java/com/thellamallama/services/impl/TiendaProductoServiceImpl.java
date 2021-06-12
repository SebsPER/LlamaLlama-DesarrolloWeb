package com.thellamallama.services.impl;

import com.thellamallama.dtos.CreateTiendaProductoDto;
import com.thellamallama.dtos.TiendaProductoDto;
import com.thellamallama.entities.Producto;
import com.thellamallama.entities.Tienda;
import com.thellamallama.entities.TiendaProducto;
import com.thellamallama.exceptions.BookingException;
import com.thellamallama.exceptions.InternalServerErrorException;
import com.thellamallama.exceptions.NotFoundException;
import com.thellamallama.repositories.ProductoRepository;
import com.thellamallama.repositories.TiendaRepository;
import com.thellamallama.repositories.TiendaProductoRepository;
import com.thellamallama.services.TiendaProductoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TiendaProductoServiceImpl implements TiendaProductoService {



    @Autowired
    private TiendaProductoRepository tienda_productoRepository;
    @Autowired
    private TiendaRepository tiendaReposiroty;
    @Autowired
    private ProductoRepository productoRepository;

    private static final ModelMapper modelMapper = new ModelMapper();


    @Override
    public TiendaProductoDto getTienda_ProductoById(Long tienda_productoid) throws BookingException {
        return modelMapper.map(getTienda_ProductoEntity(tienda_productoid), TiendaProductoDto.class);
    }

    @Override
    public List<TiendaProductoDto> getTtienda_Productos() throws BookingException {
        List<TiendaProducto> tiendaProductoEntity = tienda_productoRepository.findAll();
        return tiendaProductoEntity.stream().map(tienda_producto -> modelMapper.map(tienda_producto, TiendaProductoDto.class)).collect(Collectors.toList());
    }
    @Transactional
    @Override
    public TiendaProductoDto createTienda_Producto(CreateTiendaProductoDto createTienda_productoDto) throws BookingException {
        Tienda tiendaid= tiendaReposiroty.findById(createTienda_productoDto.getTiendaid())
                .orElseThrow(()-> new NotFoundException("NOT-401-1","TIENDA_ID_NOT_FOUND"));

        Producto productoid = productoRepository.findById(createTienda_productoDto.getProductoid())
                .orElseThrow(()-> new NotFoundException("NOT-401-1","TIENDA_ID_NOT_FOUND"));


        TiendaProducto tienda_producto=new TiendaProducto();
        tienda_producto.setCant_tiendas(createTienda_productoDto.getCant_tiendas());
        tienda_producto.setDate(createTienda_productoDto.getDate());
        tienda_producto.setProducto(productoid);
        tienda_producto.setTienda(tiendaid);

        try{
            tienda_producto=tienda_productoRepository.save(tienda_producto);
        }catch (Exception ex){
            throw new InternalServerErrorException("INTERLANL_SERVER_ERROR","INTERNAL_SERVER_ERROR");
        }
        return modelMapper.map(getTienda_ProductoEntity(tienda_producto.getId()), TiendaProductoDto.class);
    }

    private TiendaProducto getTienda_ProductoEntity(Long tienda_productoId)throws BookingException{
        return tienda_productoRepository.findById(tienda_productoId).
                orElseThrow(()-> new NotFoundException("NOTFOUND-404","RESTAURANT_NOTFOUND-404"));
    }
}
