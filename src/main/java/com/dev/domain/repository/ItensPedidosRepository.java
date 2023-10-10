package com.dev.domain.repository;

import com.dev.domain.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItensPedidosRepository extends JpaRepository <ItemPedido, Integer> {
}
