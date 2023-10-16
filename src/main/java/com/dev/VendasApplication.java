package com.dev;

import com.dev.domain.entity.Cliente;
import com.dev.domain.entity.Pedido;
import com.dev.domain.repository.ClientesRepository;
import com.dev.domain.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
@RestController
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired ClientesRepository clientes,
                                  @Autowired PedidosRepository pedidos) {
        return args -> {
            //--> Salvando Clientes <--
            System.out.println("Salvando Clientes");
            clientes.save(new Cliente(null, "Matheus Alencar"));
            clientes.save(new Cliente(null, "Miguel Costa"));
            clientes.save(new Cliente(null, "Yellow Grey"));
            Cliente fulano = new Cliente(null, "Fulano");
            clientes.save(fulano);

            Pedido p = new Pedido();
            p.setCliente(fulano);
            p.setDataPedido(LocalDate.now());
            p.setTotal(BigDecimal.valueOf(100));

            pedidos.save(p);

            //Duas formas de obter os pedidos de um cliente
            Cliente cliente = clientes.findClienteFetchPedidos(fulano.getId());
            System.out.println(cliente);
            System.out.println(cliente.getPedidos());

            //Essa forma é mais simples e usual
            pedidos.findByCliente(fulano).forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);

        System.out.println("Deu certo!");
    }
}
