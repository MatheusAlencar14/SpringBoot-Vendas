package com.dev.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/clientes") //indica que esse caminho vai levar a essa classe
public class ClienteController {

    @RequestMapping(value = "/hello/{nome}", method = RequestMethod.GET) //Indica que esse caminho leva a esse método
    @ResponseBody //Indica que a string que vai retornar é o corpo da resposta
    public String helloCLiente(@PathVariable("nome") String nome) {
        return String.format("Hello, %s!", nome);
    }
}
