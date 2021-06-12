package com.thellamallama.services.impl;

import com.thellamallama.dtos.CreateTipodePagoDto;
import com.thellamallama.dtos.TipodePagoDto;
import com.thellamallama.entities.Tipo_pago;
import com.thellamallama.exceptions.BookingException;
import com.thellamallama.exceptions.InternalServerErrorException;
import com.thellamallama.exceptions.NotFoundException;
import com.thellamallama.repositories.TipopagoRepository;
import com.thellamallama.services.TipoPagoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipodePagoServiceImpl implements TipoPagoService {
    @Autowired
    private TipopagoRepository tipopagoRepository;

    private static final ModelMapper modelMapper= new ModelMapper();
    @Override
    public TipodePagoDto getTipodePagobyID(Long tipodepagoid) throws BookingException {
        return modelMapper.map(getTipodePagoEntity(tipodepagoid),TipodePagoDto.class) ;
    }

    @Override
    public List<TipodePagoDto> getTipodePagos() throws BookingException {
        List<Tipo_pago> tipodepagoEntity=tipopagoRepository.findAll();
        return tipodepagoEntity.stream().map(tipodepago -> modelMapper.map(tipodepago,TipodePagoDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public TipodePagoDto createTipodePago(CreateTipodePagoDto createTipodePagoDto) throws BookingException {
        Tipo_pago tipodepago= new Tipo_pago();
        tipodepago.setDescripcion(createTipodePagoDto.getDescripcion());
        tipodepago.setNombre(createTipodePagoDto.getNombre());
        tipodepago.setDescuento(createTipodePagoDto.getDescuento());
        try{
            tipodepago = tipopagoRepository.save(tipodepago);
        }catch (Exception ex){
            throw  new InternalServerErrorException("INTERNAL_SERVER_ERROR","INTERNAL_SERVER_ERROR");
        }
        return modelMapper.map(getTipodePagoEntity(tipodepago.getId()), TipodePagoDto.class);

    }
    private Tipo_pago getTipodePagoEntity(Long tipodepagoid) throws BookingException {
        return tipopagoRepository.findById(tipodepagoid)
                .orElseThrow(()-> new NotFoundException("NOT-FOUND-404","NOT-FOUND-404"));
    }

}
