package com.dev.service;

import com.dev.domain.entity.Pedido;
import com.dev.domain.repository.PedidosRepository;
import com.dev.rest.dto.PedidoDTO;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.Optional;

public interface PedidoService {

    Pedido salvar (PedidoDTO pedidoDTO);

    Optional<Pedido> obterPedidoCompleto(Integer id);
}
