package com.dev.rest.controller;

import com.dev.exception.PedidoNaoEncontradoException;
import com.dev.exception.RegraNegocioException;
import com.dev.rest.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(RegraNegocioException.class)
    @ResponseStatus(BAD_REQUEST)
    public ApiErrors handleRegraNegocioException(RegraNegocioException e) {
        String msgError = e.getMessage();
        return new ApiErrors(msgError);
    }

    @ExceptionHandler(PedidoNaoEncontradoException.class)
    @ResponseStatus(NOT_FOUND)
    public ApiErrors handlePedidoNotFoundException(PedidoNaoEncontradoException e) {
        return new ApiErrors(e.getMessage());
    }
}
