package com.thellamallama.services.impl;

import com.thellamallama.dtos.CompraProductoDto;
import com.thellamallama.dtos.CreateCompraProductoDto;
import com.thellamallama.entities.Compra;
import com.thellamallama.entities.CompraProducto;
import com.thellamallama.entities.Producto;
import com.thellamallama.exceptions.BookingException;
import com.thellamallama.exceptions.InternalServerErrorException;
import com.thellamallama.exceptions.NotFoundException;
import com.thellamallama.repositories.CompraRepository;
import com.thellamallama.repositories.CompraProductoRespository;
import com.thellamallama.repositories.ProductoRepository;
import com.thellamallama.services.CompraProductoService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompraProductoServiceImpl implements CompraProductoService {

    @Autowired
    private CompraProductoRespository compra_productoRespository;
    @Autowired
    private CompraRepository compraRepository;
    @Autowired
    private ProductoRepository productoRepository;

    private  static final ModelMapper modelMapper= new ModelMapper();
    @Override
    public CompraProductoDto getCompra_ProductoById(Long compraid, Long productoid) throws BookingException {
        return modelMapper.map(getCompra_ProductoEntity(compraid,productoid), CompraProductoDto.class);
    }

    @Override
    public List<CompraProductoDto> getCompraById(Long compraid) throws BookingException {
        List<CompraProducto> compra_productosEntity = compra_productoRespository.findByCompraid(compraid);
        return compra_productosEntity.stream().map(compra_producto -> modelMapper.map(compra_producto, CompraProductoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<CompraProductoDto> getAll() throws BookingException {
        List<CompraProducto> compra_productosEntity = compra_productoRespository.findAll();
        return compra_productosEntity.stream().map(compra_producto -> modelMapper.map(compra_producto, CompraProductoDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public CompraProductoDto createCompra_Producto(CreateCompraProductoDto createCompra_productoDtO) throws BookingException {
        CompraProducto compra_producto=new CompraProducto();

        Compra compraid = compraRepository.findById(createCompra_productoDtO.getCompraId())
                .orElseThrow(()->new NotFoundException("NOT-401-1","COMPRA_NOT_FOUND"));

        Producto productoid = productoRepository.findById(createCompra_productoDtO.getProductoId())
                .orElseThrow(()->new NotFoundException("NOT-401-1","PRODUCT_NOT_FOUND"));

        compra_producto.setCantProductos(createCompra_productoDtO.getCantproductos());
        compra_producto.setPrecioXCant(productoid.getPrecio()*compra_producto.getCantProductos());
        compra_producto.setCompraid(createCompra_productoDtO.getCompraId());
        compra_producto.setProductoid(createCompra_productoDtO.getProductoId());
        compra_producto.setCompra(compraid);
        compra_producto.setProducto(productoid);

        //compra_producto = compra_productoRespository.save(compra_producto);
        try{
            compra_producto = compra_productoRespository.save(compra_producto);
        }catch (Exception ex){
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR","INTERNAL_SERVER_ERROR");
        }

        return modelMapper.map(getCompra_ProductoEntity(compra_producto.getCompra().getId(),
                            compra_producto.getProducto().getId()), CompraProductoDto.class);
        /*return modelMapper.map(getCompra_ProductoEntity(compraid,
                productoid), CompraProductoDto.class);*/
    }

    private CompraProducto getCompra_ProductoEntity(Long compraid, Long productoid) throws BookingException{
        return compra_productoRespository.findByCompraidAndProductoid(compraid,productoid)
                .orElseThrow(()->new NotFoundException("NOT-FOUND-404","NOT-FOUND-404"));
    }
}
