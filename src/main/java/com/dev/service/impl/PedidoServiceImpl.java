package com.dev.service.impl;

import com.dev.domain.repository.PedidosRepository;
import com.dev.service.PedidoService;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {

    private PedidosRepository repository;

    public PedidoServiceImpl(PedidosRepository repository) {
        this.repository = repository;
    }
}
