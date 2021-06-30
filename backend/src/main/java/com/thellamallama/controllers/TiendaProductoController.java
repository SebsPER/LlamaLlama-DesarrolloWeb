package com.thellamallama.controllers;

import com.thellamallama.dtos.ClienteDto;
import com.thellamallama.dtos.CreateTiendaProductoDto;
import com.thellamallama.dtos.TiendaProductoDto;
import com.thellamallama.exceptions.BookingException;
import com.thellamallama.responses.BookingResponse;
import com.thellamallama.services.TiendaProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping( path=  "/llamallama"+"/v1")
public class TiendaProductoController {

    @Autowired
    private TiendaProductoService tienda_productoService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/tienda_producto/{tiendaId}/{productoId}")
    public BookingResponse<TiendaProductoDto> getByTiendaIdAndProductoId(@PathVariable Long tiendaId,
                                                                     @PathVariable Long productoId)
            throws BookingException {
        return new BookingResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                tienda_productoService.getTienda_ProductoById(tiendaId, productoId));
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/tienda_productoNames/{tiendaName}/{productoName}")
    public BookingResponse<TiendaProductoDto> getByTiendaNameAndProductoName(@PathVariable String tiendaName,
                                                                         @PathVariable String productoName)
            throws BookingException {
        return new BookingResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                tienda_productoService.getByTiendaNameAndProdName(tiendaName, productoName));
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/tienda_producto/{tiendaId}")
    public BookingResponse<List<TiendaProductoDto>> getByTiendaId(@PathVariable Long tiendaId)
            throws BookingException{
        return new BookingResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                tienda_productoService.getTiendaById(tiendaId));
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/tienda_productoc/{nombreCategoria}")
    public BookingResponse<List<TiendaProductoDto>> getByCategoria(@PathVariable String nombreCategoria)
            throws BookingException{
        return new BookingResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                tienda_productoService.getTpByCategoria(nombreCategoria));
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/tienda_producton/{nombreProd}")
    public BookingResponse<List<TiendaProductoDto>> getByNombreProd(@PathVariable String nombreProd)
            throws BookingException{
        return new BookingResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                tienda_productoService.getTpByNombreProd(nombreProd));
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/tienda_productons/{nombreTienda}")
    public BookingResponse<List<TiendaProductoDto>> getTpByNombreTienda(@PathVariable String nombreTienda)
            throws BookingException{
        return new BookingResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                tienda_productoService.getTpByNombreTienda(nombreTienda));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/tienda_producto")
    public BookingResponse<List<TiendaProductoDto>> getAll()
            throws BookingException{
        return new BookingResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                tienda_productoService.getAll());
    }
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/tpUpdate/{tiendaid}/{productoid}/{stock}/{precio}/{descuento}") //@RequestBody TiendaProductoDto tpDto
    public BookingResponse<TiendaProductoDto> update(@PathVariable Long tiendaid,
                                                     @PathVariable Long productoid,
                                                     @PathVariable Integer stock,
                                                     @PathVariable Integer precio,
                                                     @PathVariable float descuento) throws
            BookingException{
        return new BookingResponse<>("Succes", String.valueOf(HttpStatus.OK),"OK",
                tienda_productoService.update(tiendaid, productoid, stock, precio, descuento));
    }
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/tienda_producto")
    public BookingResponse<TiendaProductoDto> createTienda_producto(@RequestBody CreateTiendaProductoDto createTienda_productoDto)
            throws BookingException{
        return new BookingResponse<>("Succes",String.valueOf(HttpStatus.OK),"OK",
                tienda_productoService.createTienda_Producto(createTienda_productoDto));
    }
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/tiendaProducto/{tiendaid}/{productoid}")
    public void deleteByTiendaidAndProductoid(@PathVariable Long tiendaid, @PathVariable Long productoid){
        this.tienda_productoService.deleteByTiendaidAndProductoid(tiendaid, productoid);
    }
}
