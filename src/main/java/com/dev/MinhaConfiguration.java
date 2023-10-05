package com.dev;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("development") //Isso indica que essa clase só vai funcionar no ambiente development.properties
public class MinhaConfiguration {

    @Bean
    public CommandLineRunner executar() {
        return args -> {
            System.out.println("INICIALIZANDO CONFIG DE DESENVOLVIMENTO");
        };
    }
}
