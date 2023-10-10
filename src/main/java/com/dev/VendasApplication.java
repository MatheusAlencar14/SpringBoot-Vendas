package com.dev;

import com.dev.domain.entity.Cliente;
import com.dev.domain.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired ClientesRepository clientes) {
        return args -> {
            //--> Salvando Clientes <--
            System.out.println("Salvando Clientes");
            clientes.save(new Cliente(null, "Matheus Alencar"));
            clientes.save(new Cliente(null, "Miguel Costa"));
            clientes.save(new Cliente(null, "Yellow Grey"));

            //--> Recuperando Clientes <--
            List<Cliente> todosClientes = clientes.findAll();
            todosClientes.forEach(System.out::println);

            //Buscando por nome
            System.out.println("Buscando por nome");
            clientes.findByNomeLike("Cost").forEach(System.out::println);

            //--> Atualizando Clientes <--
            todosClientes.forEach(c -> {
                c.setNome(c.getNome() + " atualizado.");
                clientes.save(c);
            });

            System.out.println("Buscando atualizados");
            todosClientes = clientes.findAll();
            todosClientes.forEach(System.out::println);

            //--> Deletando Clientes <--
            System.out.println("Deletando por id (3)");
            clientes.findAll().forEach(c -> {
                if (c.getId() == 3) {
                    clientes.delete(c);
                }
            });

            System.out.println("Buscando após deleção");
            todosClientes = clientes.findAll();
            todosClientes.forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);

        System.out.println("Deu certo!");
    }
}
