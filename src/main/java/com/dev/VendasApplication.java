package com.dev;

import com.dev.domain.entity.Cliente;
import com.dev.domain.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@SpringBootApplication
@RestController
public class VendasApplication {

    @Bean
    public CommandLineRunner commandLineRunner(@Autowired ClientesRepository clientesRepository) {
        return args -> {
            Cliente c1 = new Cliente(null, "Matheus");
            Cliente c2 = new Cliente(null, "Miguel");
            clientesRepository.saveAll(Arrays.asList(c1, c2));
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);

        System.out.println("Deu certo!");
    }
}
