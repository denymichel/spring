package com.consultorio.consultorio;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
@ControllerAdvice

public class NotFoundConsejo_Consul {

    @ResponseBody
    @ExceptionHandler(NotFound_Consul.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String consultorioNotFoundHandler(NotFound_Consul ex)
    { return ex.getMessage();
    }
}

