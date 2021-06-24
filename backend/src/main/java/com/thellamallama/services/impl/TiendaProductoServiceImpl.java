package com.thellamallama.services.impl;

import com.thellamallama.dtos.*;
import com.thellamallama.entities.*;
import com.thellamallama.exceptions.BookingException;
import com.thellamallama.exceptions.InternalServerErrorException;
import com.thellamallama.exceptions.NotFoundException;
import com.thellamallama.repositories.CategoriaRepository;
import com.thellamallama.repositories.ProductoRepository;
import com.thellamallama.repositories.TiendaRepository;
import com.thellamallama.repositories.TiendaProductoRepository;
import com.thellamallama.services.TiendaProductoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TiendaProductoServiceImpl implements TiendaProductoService {

    @Autowired
    private TiendaProductoRepository tienda_productoRepository;
    @Autowired
    private TiendaRepository tiendaRepository;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    private static final ModelMapper modelMapper = new ModelMapper();


    @Override
    public TiendaProductoDto getTienda_ProductoById(Long tiendaid, Long productoid) throws BookingException {
        return modelMapper.map(getTienda_ProductoEntity(tiendaid, productoid), TiendaProductoDto.class);
    }

    @Override
    public List<TiendaProductoDto> getTiendaById(Long tiendaid) throws BookingException {
        List<TiendaProducto> tiendaProductoEntity = tienda_productoRepository.findByTiendaid(tiendaid);
        //return tiendaProductoEntity.stream().map(tienda_producto -> modelMapper.map(tienda_producto, TiendaProductoDto.class)).collect(Collectors.toList());
        Stream<TiendaProductoDto> maps = tiendaProductoEntity.stream()
                .map(tienda_producto -> modelMapper.map(tienda_producto, TiendaProductoDto.class));
        List<TiendaProductoDto> arrayM = maps.collect(Collectors.toList());
        for (TiendaProductoDto m: arrayM){
            //TiendaProducto data = getTienda_ProductoEntity(m.getTiendaid(), m.getProductoid());
            Producto prod = getProductEntity(m.getProductoid());
            m.setProdN(prod.getNombre());
            Tienda tienda = getTiendaEntity(m.getTiendaid());
            m.setTName(tienda.getNombre());
            Categoria cat = getCategoriasEntity(prod.getCategoria().getId());
            m.setCatN(cat.getNombre());
        }
        return arrayM;
    }

    @Override
    public List<TiendaProductoDto> getTpByCategoria(String categoriaid) throws BookingException {
        List<TiendaProducto> tiendaProductoEntity = tienda_productoRepository.findByCategoria(categoriaid);
        //return tiendaProductoEntity.stream().map(tienda_producto -> modelMapper.map(tienda_producto, TiendaProductoDto.class)).collect(Collectors.toList());
        Stream<TiendaProductoDto> maps = tiendaProductoEntity.stream()
                .map(tienda_producto -> modelMapper.map(tienda_producto, TiendaProductoDto.class));
        List<TiendaProductoDto> arrayM = maps.collect(Collectors.toList());
        for (TiendaProductoDto m: arrayM){
            //TiendaProducto data = getTienda_ProductoEntity(m.getTiendaid(), m.getProductoid());
            Producto prod = getProductEntity(m.getProductoid());
            m.setProdN(prod.getNombre());
            Tienda tienda = getTiendaEntity(m.getTiendaid());
            m.setTName(tienda.getNombre());
            Categoria cat = getCategoriasEntity(prod.getCategoria().getId());
            m.setCatN(cat.getNombre());
        }
        return arrayM;
    }

    @Override
    public List<TiendaProductoDto> getAll() throws BookingException {
        List<TiendaProducto> tiendaProductoEntity = tienda_productoRepository.findAll();
        //return tiendaProductoEntity.stream().map(tienda_producto -> modelMapper.map(tienda_producto, TiendaProductoDto.class)).collect(Collectors.toList());
        Stream<TiendaProductoDto> maps = tiendaProductoEntity.stream()
                .map(tienda_producto -> modelMapper.map(tienda_producto, TiendaProductoDto.class));
        List<TiendaProductoDto> arrayM = maps.collect(Collectors.toList());
        for (TiendaProductoDto m: arrayM){
            //TiendaProducto data = getTienda_ProductoEntity(m.getTiendaid(), m.getProductoid());
            Producto prod = getProductEntity(m.getProductoid());
            m.setProdN(prod.getNombre());
            Tienda tienda = getTiendaEntity(m.getTiendaid());
            m.setTName(tienda.getNombre());
            Categoria cat = getCategoriasEntity(prod.getCategoria().getId());
            m.setCatN(cat.getNombre());
        }
        return arrayM;
    }

    @Override
    public List<TiendaProductoDto> getTpByNombreProd(String nombre) throws BookingException {
        List<TiendaProducto> tiendaProductoEntity = tienda_productoRepository.findByName(nombre);
        //return tiendaProductoEntity.stream().map(tienda_producto -> modelMapper.map(tienda_producto, TiendaProductoDto.class)).collect(Collectors.toList());
        Stream<TiendaProductoDto> maps = tiendaProductoEntity.stream()
                .map(tienda_producto -> modelMapper.map(tienda_producto, TiendaProductoDto.class));
        List<TiendaProductoDto> arrayM = maps.collect(Collectors.toList());
        for (TiendaProductoDto m: arrayM){
            //TiendaProducto data = getTienda_ProductoEntity(m.getTiendaid(), m.getProductoid());
            Producto prod = getProductEntity(m.getProductoid());
            m.setProdN(prod.getNombre());
            Tienda tienda = getTiendaEntity(m.getTiendaid());
            m.setTName(tienda.getNombre());
            Categoria cat = getCategoriasEntity(prod.getCategoria().getId());
            m.setCatN(cat.getNombre());
        }
        return arrayM;
    }

    @Override
    public List<TiendaProductoDto> getTpByNombreTienda(String nombre) throws BookingException {
        List<TiendaProducto> tiendaProductoEntity = tienda_productoRepository.findByTName(nombre);
        Stream<TiendaProductoDto> maps = tiendaProductoEntity.stream()
                .map(tiendaProducto -> modelMapper.map(tiendaProducto, TiendaProductoDto.class));
        List<TiendaProductoDto> arrayM = maps.collect(Collectors.toList());
        for (TiendaProductoDto m: arrayM){
            Producto producto = getProductEntity(m.getProductoid());
            m.setProdN(producto.getNombre());
            Tienda tienda = getTiendaEntity(m.getTiendaid());
            m.setTName(tienda.getNombre());
            Categoria cat = getCategoriasEntity(producto.getCategoria().getId());
            m.setCatN(cat.getNombre());
        }
        return arrayM;
    }


    @Override
    public TiendaProductoDto update(Long tiendaid, Long productoid, Integer stock, Integer precio, float descuento) throws BookingException {
        TiendaProducto tiendaProducto = getTienda_ProductoEntity(tiendaid, productoid);
        tiendaProducto.setStock(stock);
        tiendaProducto.setPrecio(precio);
        tiendaProducto.setDescuento(descuento);
        TiendaProducto saveTp = this.tienda_productoRepository.save(tiendaProducto);
        return new TiendaProductoDto(saveTp);
    }

    @Transactional
    @Override
    public TiendaProductoDto createTienda_Producto(CreateTiendaProductoDto createTienda_productoDto) throws BookingException {
        Tienda tienda= tiendaRepository.findById(createTienda_productoDto.getTiendaid())
                .orElseThrow(()-> new NotFoundException("NOT-401-1","TIENDA_ID_NOT_FOUND"));

        Producto producto = productoRepository.findById(createTienda_productoDto.getProductoid())
                .orElseThrow(()-> new NotFoundException("NOT-401-1","PRODUCTO_ID_NOT_FOUND"));

        TiendaProducto tienda_producto=new TiendaProducto();
        tienda_producto.setStock(createTienda_productoDto.getStock());
        tienda_producto.setPrecio(createTienda_productoDto.getPrecio());
        tienda_producto.setTiendaid(createTienda_productoDto.getTiendaid());
        tienda_producto.setProductoid(createTienda_productoDto.getProductoid());
        tienda_producto.setProducto(producto);
        tienda_producto.setTienda(tienda);

        try{
            tienda_producto=tienda_productoRepository.save(tienda_producto);
        }catch (Exception ex){
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR","INTERNAL_SERVER_ERROR");
        }
        /*TiendaProductoDto map = modelMapper.map(getTienda_ProductoEntity(tienda.getId(), producto.getId()), TiendaProductoDto.class);
        map.setCategoria(producto.getId());
        return map;*/
        return modelMapper.map(getTienda_ProductoEntity(tienda.getId(), producto.getId()), TiendaProductoDto.class);
    }

    @Transactional
    @Override
    public void deleteByTiendaidAndProductoid(Long tiendaid, Long productoid) {
        tienda_productoRepository.deleteByTiendaidAndProductoid(tiendaid, productoid);
    }

    private TiendaProducto getTienda_ProductoEntity(Long tiendaid, Long productoid)throws BookingException{
        return tienda_productoRepository.findByTiendaidAndProductoid(tiendaid, productoid).
                orElseThrow(()-> new NotFoundException("NOTFOUND-404","RESTAURANT_NOTFOUND-404"));
    }
    private TiendaProducto dtoEntity(TiendaProductoDto tpDto){
        TiendaProducto tp = new TiendaProducto();
        BeanUtils.copyProperties(tpDto, tp);
        return tp;
    }
    private Producto getProductEntity(Long ProductoId)throws BookingException{
        return productoRepository.findById(ProductoId).
                orElseThrow(()-> new NotFoundException("NOTFOUND-404","RESTAURANT_NOTFOUND-404"));
    }
    private Tienda getTiendaEntity(Long tiendaid)throws BookingException {
        return tiendaRepository.findById(tiendaid)
                .orElseThrow(()-> new NotFoundException("NOTFOUND-404","TIENDA_NOTFOUND-404"));
    }
    private Categoria getCategoriasEntity(Long categoriaid) throws BookingException{
        return categoriaRepository.findById(categoriaid)
                .orElseThrow(()->new NotFoundException("Not_Found-404","Not-Found-404"));
    }
}
