package com.dev.domain.repository;

import com.dev.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidosRepository extends JpaRepository <Pedido, Integer> {
}
