package com.thellamallama.exceptions;

import com.thellamallama.dtos.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Arrays;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundException extends BookingException {

    public NotFoundException(String code, String message){
        super(code, HttpStatus.NOT_FOUND.value(), message);
    }
    public NotFoundException(String code, String message, ErrorDto data){
        super(code, HttpStatus.NOT_FOUND.value(), message, Arrays.asList(data));
    }

}
