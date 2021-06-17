package com.thellamallama.exceptions;

import com.thellamallama.dtos.ErrorDto;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.List;

//@ResponseStatus(code = HttpStatus.BAD_REQUEST)
//@ResponseStatus(code = HttpStatus.NOT_FOUND)
@Getter
public class BookingException extends Exception{

    private final String code;
    private final int responseCode;
    private final List<ErrorDto> errorList=new ArrayList<>();

    public BookingException(String code, int responseCode, String message){
        super(message);
        this.code=code;
        this.responseCode=responseCode;
    }
    public BookingException(String code, int responseCode, String message,
                            List<ErrorDto> errorList){
        super(message);
        this.code=code;
        this.responseCode=responseCode;
        this.errorList.addAll(errorList);
    }


}
