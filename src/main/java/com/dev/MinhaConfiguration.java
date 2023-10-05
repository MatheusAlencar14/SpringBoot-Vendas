package com.dev;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

/*Posso criar uma anotation e utilizá-la em todas as classes que for necessário, informando seu nome
* Assim, sempre que for necessário modificar algo, será modificando em todas as classes*/
@Development
public class MinhaConfiguration {

    @Bean
    public CommandLineRunner executar() {
        return args -> {
            System.out.println("INICIALIZANDO CONFIG DE DESENVOLVIMENTO");
        };
    }
}
