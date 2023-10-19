package com.dev.rest.dto;

import java.math.BigDecimal;
import java.util.List;

public class PedidoDTO { //DTO: Data Transfer Object

    private Integer idCliente;
    private BigDecimal tota;
    private List<ItemPedidoDTO> itens;
}
