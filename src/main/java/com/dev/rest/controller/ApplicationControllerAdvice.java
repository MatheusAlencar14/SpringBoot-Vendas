package com.dev.rest.controller;

import com.dev.exception.RegraNegocioException;
import com.dev.rest.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(RegraNegocioException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleRegraNegocioException(RegraNegocioException e) {
        String msgError = e.getMessage();
        return new ApiErrors(msgError);
    }
}
