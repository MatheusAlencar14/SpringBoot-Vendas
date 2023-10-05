package com.dev.service;

import com.dev.model.Cliente;
import com.dev.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientesService {

    public ClientesRepository clientesRepository;

    /*Injeção de dependência: eu instancio um objeto da classe Repository e faço a injeção de
    dependencias via construtor, utilizando a anotation @Autowired. Dessa forma sempre que um
    objeto ClientesService for criado, ele já tem o Repository por instanciação*/
    @Autowired
    public ClientesService(ClientesRepository clientesRepository) {
        this.clientesRepository = clientesRepository;
    }

    public void salvarCliente(Cliente cliente) {
        validarCliente(cliente);
        this.clientesRepository.persistir();

    }

    public void validarCliente(Cliente cliente) {
        //aplica validações
    }
}
