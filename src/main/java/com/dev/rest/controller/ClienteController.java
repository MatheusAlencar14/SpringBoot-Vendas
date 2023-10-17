package com.dev.rest.controller;

import com.dev.domain.entity.Cliente;
import com.dev.domain.repository.ClientesRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/api/clientes")
public class ClienteController {

    private ClientesRepository clientesRepository;

    public ClienteController(ClientesRepository clientesRepository){
        this.clientesRepository = clientesRepository;
    }

    @GetMapping("/{id}") //É o RequestMapping com o método GET definido
    @ResponseBody
    public ResponseEntity getClienteById(@PathVariable Integer id) {
        Optional<Cliente> cliente = clientesRepository.findById(id);
        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping //Para salvar com informações que não existem no servidor
    @ResponseBody
    public ResponseEntity saveCliente(@RequestBody Cliente cliente) {
        Cliente clienteSalvo = clientesRepository.save(cliente);
        return ResponseEntity.ok(clienteSalvo);
    }
}
//@RequestBody é o que vamos receber
//@ResponseBody é o que vamos retornar (nossa resposta)