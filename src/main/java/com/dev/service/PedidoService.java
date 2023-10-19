package com.dev.service;

import com.dev.domain.entity.Pedido;
import com.dev.domain.repository.PedidosRepository;
import com.dev.rest.dto.PedidoDTO;

public interface PedidoService {

    Pedido salvar (PedidoDTO pedidoDTO);
}
