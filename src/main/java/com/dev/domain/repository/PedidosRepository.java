package com.dev.domain.repository;

import com.dev.domain.entity.Cliente;
import com.dev.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidosRepository extends JpaRepository <Pedido, Integer> {

    //Obtendo pedidos passando Cliente como parâmetro
    List<Pedido> findByCliente(Cliente cliente);
}
