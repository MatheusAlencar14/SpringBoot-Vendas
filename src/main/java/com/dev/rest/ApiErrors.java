package com.dev.rest;

import lombok.Data;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class ApiErrors {

    @Getter
    private List<String> errors;

    public ApiErrors(String msgError) {
        this.errors = Arrays.asList(msgError);
    }
}

