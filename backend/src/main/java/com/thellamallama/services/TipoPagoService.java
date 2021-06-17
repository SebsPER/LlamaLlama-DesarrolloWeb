package com.thellamallama.services;

import com.thellamallama.dtos.CreateTipodePagoDto;
import com.thellamallama.dtos.TipodePagoDto;
import com.thellamallama.exceptions.BookingException;

import java.util.List;

public interface TipoPagoService {
    TipodePagoDto getTipodePagobyID(Long tipodepagoid) throws BookingException;
    List<TipodePagoDto> getTipodePagos()throws  BookingException;
    TipodePagoDto createTipodePago(CreateTipodePagoDto createTipodePagoDto)throws BookingException;
}
