package com.dev.rest.controller;

import com.dev.domain.entity.Cliente;
import com.dev.domain.repository.ClientesRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private ClientesRepository clientesRepository;

    public ClienteController(ClientesRepository clientesRepository) {
        this.clientesRepository = clientesRepository;
    }

    @GetMapping("/{id}") //É o RequestMapping com o método GET definido
    public Cliente getClienteById(@PathVariable Integer id) {
        return clientesRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Cliente não encontrado!"
                ));
    }

    @PostMapping //Para salvar com informações que não existem no servidor
    @ResponseStatus(HttpStatus.CREATED) //Retorna o status que eu definir. @Valid é pra validar os campos
    public Cliente saveCliente(@RequestBody @Valid Cliente cliente) {
        return clientesRepository.save(cliente);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClienteById(@PathVariable Integer id) {
        clientesRepository.findById(id)
                .map(cliente -> {
                    clientesRepository.delete(cliente);
                    return cliente;
                })
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND
                ));
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCliente(@PathVariable Integer id, @RequestBody @Valid Cliente cliente) {
        clientesRepository
                .findById(id)
                .map(clienteExist -> {
                    cliente.setId(clienteExist.getId());
                    clientesRepository.save(cliente);
                    return clienteExist;
                }).orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Cliente não encontrado!"
                ));
    }

    @GetMapping("/filter")
    public List<Cliente> find(Cliente filtro) {
        ExampleMatcher matcher =
                ExampleMatcher
                        .matching()
                        .withIgnoreCase()
                        .withStringMatcher(
                                ExampleMatcher.StringMatcher.CONTAINING
                        );
        Example example = Example.of(filtro, matcher);
        return clientesRepository.findAll(example);
    }
}
//@RequestBody é o que vamos receber
//@ResponseBody é o que vamos retornar (nossa resposta)
//@PostMapping Para salvar com informações que não existem no servidor
//@GetMapping É o RequestMapping com o método GET definido