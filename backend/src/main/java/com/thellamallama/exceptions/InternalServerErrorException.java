package com.thellamallama.exceptions;

import com.thellamallama.dtos.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Arrays;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
//
public class InternalServerErrorException extends BookingException {
    public InternalServerErrorException(String code, String message) {
        super(code, HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
    }
    public InternalServerErrorException(String code, String message, ErrorDto data) {
        super(code,HttpStatus.INTERNAL_SERVER_ERROR.value(), message, Arrays.asList(data));
    }
}
