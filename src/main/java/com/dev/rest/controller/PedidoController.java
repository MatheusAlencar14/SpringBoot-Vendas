package com.dev.rest.controller;

import com.dev.domain.entity.Pedido;
import com.dev.rest.dto.PedidoDTO;
import com.dev.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Integer save(@RequestBody PedidoDTO pedidoDTO) {
        Pedido pedido = service.salvar(pedidoDTO);
        return pedido.getId();
    }
}
