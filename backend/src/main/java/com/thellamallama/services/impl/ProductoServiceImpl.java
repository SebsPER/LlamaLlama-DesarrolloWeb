package com.thellamallama.services.impl;

import com.thellamallama.dtos.CreateProductoDto;
import com.thellamallama.dtos.ProductoDto;
import com.thellamallama.entities.Categoria;
import com.thellamallama.entities.Producto;
import com.thellamallama.exceptions.BookingException;
import com.thellamallama.exceptions.InternalServerErrorException;
import com.thellamallama.exceptions.NotFoundException;
import com.thellamallama.repositories.CategoriaRepository;
import com.thellamallama.repositories.ProductoRepository;
import com.thellamallama.services.ProductoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class ProductoServiceImpl implements ProductoService {



    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    private static final ModelMapper modelMapper=new ModelMapper();

    @Override
    public ProductoDto getProductoById(Long ProductoId) throws BookingException {
        return modelMapper.map(getProductEntity(ProductoId),ProductoDto.class);
    }

    @Override
    public List<ProductoDto> getProductos() throws BookingException {
        List<Producto> productoEntity = productoRepository.findAll();
        return productoEntity.stream().map(producto -> modelMapper.map(producto,ProductoDto.class)).collect(Collectors.toList());
    }
    @Transactional
    @Override
    public ProductoDto createProducto(CreateProductoDto createProductoDto) throws BookingException {

        Categoria categoriaid = categoriaRepository.findById(createProductoDto.getCategoriaid())
                .orElseThrow(()->new NotFoundException("NOT-401-1","CATEGORIA_NOT_FOUND"));

        Producto producto=new Producto();
        producto.setNombre(createProductoDto.getNombre());
        producto.setPrecio(createProductoDto.getPrecio());
        producto.setStock(createProductoDto.getStock());
        //producto.setTiendas(createProductoDto.getTiendaid());
        //producto.setCompras(createProductoDto.getCompraid());
        producto.setCategoria(categoriaid);

        try{
            producto=productoRepository.save(producto);
        }catch (Exception ex){
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR","INTERNAL_SERVER_ERROR");
        }
        return modelMapper.map(getProductEntity(producto.getId()),ProductoDto.class);
    }

    private Producto getProductEntity(Long ProductoId)throws BookingException{
        return productoRepository.findById(ProductoId).
                orElseThrow(()-> new NotFoundException("NOTFOUND-404","RESTAURANT_NOTFOUND-404"));
    }
}