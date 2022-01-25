package com.coderhouse.ClientAop.exceptions;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MissedFieldsExceptionHandler {

    @ResponseBody
    @ExceptionHandler(MissedFieldsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error msgErorHandle(MissedFieldsException ex) {
        return new Error(ex.getMessage());
    }
}
